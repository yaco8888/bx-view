package com.bx.portrait.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.util.UUID;

/**
 *	 文件上传帮助类
 */
public class UploadUtils {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	/**
	 * 	上传到文件服务器
	 */
	public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		Client client = new Client();
		WebResource resource = client.resource(filePath + fileName);
		resource.put(String.class, file);
		return filePath + fileName;
	}
	
}
