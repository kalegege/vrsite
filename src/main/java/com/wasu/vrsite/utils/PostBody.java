package com.wasu.vrsite.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.wasu.vrsite.entity.Response;

public class PostBody {
	
	
	//功能: postBody形式发送数据
	//@param urlPath 对方地址
	//@param json 要传送的数据
	//@return
	//@throws Exception
	public static int postBody(String urlPath, String json) throws Exception {
	try{  
	            // Configure and open a connection to the site you will send the request  
	            URL url = new URL(urlPath);  
	            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();  
	            // 设置doOutput属性为true表示将使用此urlConnection写入数据  
	            urlConnection.setDoOutput(true);  
	            // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型  
	            urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");  
	            // 得到请求的输出流对象  
	            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());  
	            // 把数据写入请求的Body  
	            out.write(json);  
	            out.flush();  
	            out.close(); 
	              
	            // 从服务器读取响应  
	            InputStream inputStream = urlConnection.getInputStream();  
	            String encoding = urlConnection.getContentEncoding();  
	            String body = IOUtils.toString(inputStream, encoding); 
	            
	            
	            Response responses=JSON.parseObject(body, Response.class);
	            if(urlConnection.getResponseCode()==200){
	            return 200;
	            }else{
	            throw new Exception(body);
	            }
	        }catch(IOException e){
	        System.out.println(e.getMessage()+ e);
	        throw e;
	        }
	}
	
	
	
	
	public   static   String   inputStream2String(InputStream   is)   throws   IOException{
        ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
        baos.write(i);
        }
       return   baos.toString();
} 

}
