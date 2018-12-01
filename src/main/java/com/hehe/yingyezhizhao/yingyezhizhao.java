package com.hehe.yingyezhizhao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.hehe.HttpUtils.HttpUtils;

public class yingyezhizhao {
	// 图片转为base64
	public static String imageToBase64(String path) {
	    byte[] data = null;
	    try {
	        InputStream in = new FileInputStream(path);
	        data = new byte[in.available()];
	        in.read(data);
	        in.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
	// base64转为图片
	public static boolean base64ToImage(String base64, String path) {
	    if (base64 == null){ 
	        return false;
	    }
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	        
	        byte[] bytes = decoder.decodeBuffer(base64);
	        for (int i = 0; i < bytes.length; ++i) {
	            if (bytes[i] < 0) {
	                bytes[i] += 256;
	            }
	        }
	       
	        OutputStream out = new FileOutputStream(path);
	        out.write(bytes);
	        out.flush();
	        out.close();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public static void main(String[] args) {
	    String host = "https://dm-58.data.aliyun.com";
	    String path = "/rest/160601/ocr/ocr_business_license.json";
	    String method = "POST";
	    String appcode = "8cdd7d21036e439bba99fc42ded66a19";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/json; charset=UTF-8");
	    Map<String, String> querys = new HashMap<String, String>();
    	String base64="";
    	String imagePath ="D:/img/timg.jpeg";
		base64 = imageToBase64(imagePath);
	    /*Map<String, String> bodys = new HashMap<String, String>();
	    bodys.put("image", base64);*/
		String bodys = "{\"inputs\": [{\"image\": {\"dataType\": 50, \"dataValue\": \""+base64+"\"},"
                + "\"configure\": {\"dataType\": 50,\"dataValue\": \"{\\\"side\\\":\\\"face\\\"}\"}}]}";  

	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
