package com.chy.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\story.txt";
        //创建一个BufferedReader处理流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;        //按行读取，效率高

        /*
        说明：
        1、bufferedReader.readLine() 是按行读取文件
        2、当返回null时，表示文件读取完毕
         */
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流，这里注意：只需要关闭 BufferedReader，因为底层会自动的去关闭 节点流
        //FileReader
        bufferedReader.close();

        /*
        public void close() throws IOException {
            synchronized (lock) {
                if (in == null)
                    return;
                try {
                    in.close();    //in 就是我们传入的 new FileReader(filePath)，关闭
                } finally {
                    in = null;
                    cb = null;
                }
            }
        }
         */
    }
}
