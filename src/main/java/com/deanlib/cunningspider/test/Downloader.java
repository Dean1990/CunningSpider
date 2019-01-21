package com.deanlib.cunningspider.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

    static int block = 1024*1024*6;

    public static void main(String[] args) {

    }

    public static void download(String path,File saveFile,String fileName){

        try {

            URL url = new URL(path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            connection.setRequestProperty("Accept-Encoding","gzip, deflate");
            connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8");
            connection.setRequestProperty("Connection","keep-alive");
//            connection.setRequestProperty("Host","bestsexgif.com");
            connection.setRequestProperty("Upgrade-Insecure-Requests","1");
            //connection.setRequestProperty("Remote Address","110.76.157.12:80");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(100000);
            connection.connect();

            int code = connection.getResponseCode();
            System.out.println("Download:"+fileName+" httpcode:"+code +" url:"+path);

            saveFile.mkdirs();

            if (code == 200) {
                System.out.println("ResponseCode:"+code + "  start download...");

                InputStream inputStream = connection.getInputStream();

                OutputStream outputStream = new FileOutputStream(new File(saveFile,fileName));

                long length = connection.getContentLengthLong();
                long current = 0;

                byte[] buffer = new byte[block];

                int len;

                while ((len = inputStream.read(buffer))>0){
                    current+=len;
                    outputStream.write(buffer,0,len);
                    System.out.println("Download progress: total:"+ length +"  current:"+ current + "  persent:"+new BigDecimal(((float)current)/((float)length)*100).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();
                System.gc();

            }else {
                System.err.println("ResponseCode:"+code);
            }
        }catch (Exception e){
            System.err.println("Download:"+fileName+" error");
            e.printStackTrace();
        }

    }
}
