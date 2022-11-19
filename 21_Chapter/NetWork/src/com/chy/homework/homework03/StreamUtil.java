package com.chy.homework.homework03;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    public static byte[] streamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //读入数据
        //创建一个字节数组
        byte[] buf = new byte[1024];
        int reaLen = 0;
        while((reaLen = is.read(buf)) != -1){
            bos.write(buf,0,reaLen);
        }
        byte[] array = bos.toByteArray();
        return array;
    }
}
