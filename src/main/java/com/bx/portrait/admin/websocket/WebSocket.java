package com.bx.portrait.admin.websocket;

import ai.onnxruntime.OrtException;
import com.bx.portrait.admin.demo.OnnxLoad;
import com.bx.portrait.room.entity.ClassRoom;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint(value = "/ws/{id}")
public class WebSocket {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    /**
     * 用户ID
     */
    private Integer id;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
    //  注：底下WebSocket是当前类名
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    // 用来存在线连接用户信息
    private static ConcurrentHashMap<Integer,Session> sessionPool = new ConcurrentHashMap<Integer,Session>();
    /**
     * 链接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("id")Integer id) {
        try {
            this.session = session;
            this.id = id;
            webSockets.add(this);
            sessionPool.put(id, session);
            log.info("【websocket消息】有新的连接，总数为:"+webSockets.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.id);
            log.info("【websocket消息】连接断开，总数为:"+webSockets.size());
        } catch (Exception e) {
        }
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     * @param
     */
    @OnMessage
    public void onMessage(String message) {
        // 获取到ID，然后查询ID对应的视频
        ClassRoom classRoom = new ClassRoom().selectById(message);
        if (null != classRoom) {
            // 拿到视频地址
            String courseUrl = classRoom.getCourseUrl();
            // 获取视频流
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(courseUrl);
            Java2DFrameConverter converter = new Java2DFrameConverter();
            try {
                frameGrabber.start();
                // 拿到图片
                while (true) {
                    BufferedImage image = converter.convert(frameGrabber.grab());
                    if (image == null) {
                        break;
                    }
                    // 识别，返回一个map
                    Map<String, byte[]> recognize =
                            OnnxLoad.recognize(convertImageToByteArray(image));
                    // 将图片数据发给前端
                    sendOneMessage(Integer.parseInt(message),
                            recognize.toString());
                }
                frameGrabber.stop();
            } catch (FFmpegFrameGrabber.Exception e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (OrtException e) {
                throw new RuntimeException(e);
            }
            System.out.println(message);
        }

        log.info("【websocket消息】收到客户端消息:"+message);
    }

    /** 发送错误时的处理
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误,原因:"+error.getMessage());
        error.printStackTrace();
    }


    // 此为广播消息
    public void sendAllMessage(String message) {
        log.info("【websocket消息】广播消息:"+message);
        for(WebSocket webSocket : webSockets) {
            try {
                if(webSocket.session.isOpen()) {
                    webSocket.session.getAsyncRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(Integer id, String message) {
        Session session = sessionPool.get(id);
        if (session != null&&session.isOpen()) {
            try {
                log.info("【websocket消息】 单点消息:"+message);
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息(多人)
    public void sendMoreMessage(String[] ids, String message) {
        for(String id:ids) {
            Session session = sessionPool.get(id);
            if (session != null&&session.isOpen()) {
                try {
                    log.info("【websocket消息】 单点消息:"+message);
                    session.getAsyncRemote().sendText(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private static byte[] convertImageToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

}