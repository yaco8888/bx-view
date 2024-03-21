前端模板地址：https://sc.chinaz.com/mobandemo.aspx?downloadid=182018121023360

部署：
   1.nginx 文件服务器
        http{
            client_max_body_size 1024M; # 设置允许上传的最大文件大小
            # 编码
            charset utf-8;
        }
        server {
            listen       1688;
            server_name  localhost;
            location /upload {
                alias   F:\up-download;
                allow all;
                autoindex on;
                dav_methods PUT;
            }
        }
        *需修改 application.yml 的文件上传路径
   2.jdk 17
   3.mysql 8
访问：
    http://127.0.0.1 客户端首页
    http://127.0.0.1/admin  管理端首页
日志配置:
    logback-spring.xml  第5行可修改保存地址