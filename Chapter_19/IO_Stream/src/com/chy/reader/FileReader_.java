package com.chy.reader;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void FileReader01() {
        //1、创建FileReader 对象
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new FileReader(filePath);
            //读取文件肯定需要利用循环读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    //使用字符数组来读取文件
    public void FileReader02() {
        //1、创建FileReader 对象
        String filePath = "D:\\JUFE_Second\\Java_Study\\IOTest\\story.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(filePath);
            //读取文件肯定需要利用循环读取，使用read(buf)，返回实际读取到的字符数
            //如果返回-1，说明到文件的结尾了
            while ((readLen = fileReader.read(buf)) != -1) {
                //注意使用下面的方式，如果文件有9个字符，把前8个读进来后，最后剩1个，但是，这里你又把8个字符的数据读进去
                //其余的7个字符是上一次读取的对应位置的字符
                /*例如：文件中的数据是 jackRoseY
                        读取到的数据是 jackRoseYackRose
                */
                //System.out.print(new String(buf));

                //正确的写法是，采用下面的方法，虽然传进去的是一个有8个字符的数组，
                //到时最后我只从数组中抽离出我读取到长度，在读出来。这样就不会出现上面的现象，而是正常的文件数据
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
