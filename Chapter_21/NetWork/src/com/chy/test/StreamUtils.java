package com.chy.test;

import java.io.*;

public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        //创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //创建一个字节数组
        byte[] b = new byte[1024];
        int len = 0;
        //循环读取
        while((len = is.read(b)) != -1){
            //把读取到的数据，写入bos
            bos.write(b,0,len);
        }
        //然后将bos 转换成字节数组
        byte[] array = bos.toByteArray();

        bos.close();
        return array;
    }

    public static String streamToString(InputStream is) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = read.readLine())!=null){
            builder.append(line+"\n");
        }
        return builder.toString();
    }
}
