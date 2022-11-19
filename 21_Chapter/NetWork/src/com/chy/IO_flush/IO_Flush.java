package com.chy.IO_flush;

public class IO_Flush {
    public static void main(String[] args) {
        /*
        java默认的缓冲大小为8k(8192个字节)，当没有超过这个值时，里面的内容就不会自动写入文件当中；
        而当超过这个值时，里面的内容就会自动写入文件当中。
         */

        /*
        源码：
        /*     If the request length exceeds the size of the output buffer,
               flush the output buffer and then write the data directly.
               In this way buffered streams will cascade harmlessly.
        */


        /*
        很多人可能一直比较纠结为什么有的带有缓冲功能的流在socket.shutdownOutput方法之前要先调用flush()方法,
        我们先大概说一下带缓冲功能的流的原理:  如果是需要频繁的对文件进行读或写,
        普通流的速度会比较慢,而缓冲流是在普通流的基础上多了一个缓冲区,
        当读或写的数据达到一定量,再自动往文件里进行读写,如果没有装满缓冲区文件就已经读(写)完毕 ,
        那么这个时候已经读写到缓冲区的数据需要手动使其朝目标文件进行读写.
        这个手动的过程,就是我们这里提到的flush()方法
        换句话说,如果是文件读写完的同时缓冲区刚好装满,那么缓冲区会把里面的数据朝目标文件自动进行读或写,
        这种时候你直接调用close()方法不会出现问题,但是如果文件在读写完成时,缓冲区没有装满,
        就直接调用socket.shutdownOutput方法
        这个时候装在缓冲区的数据就不会自动的朝目标文件进行读或写,从而造成缓冲区中的这部分数据丢失
        所以这个是时候就需要在socket.shutdownOutput之前先调用flush()方法，手动使缓冲区数据读写到目标文件
        举个例子:  如果一个文件大小是20kb，我们的缓冲区大小是15kb，如果socket.shutdownOutput方法之前没有先调用flush()方法 ，
        那么这个时候剩余的5kb数据就会丢失
         */

        /*
        我终于懂了。为什么在socket.shutdownOutput();前用了flush后，再close()不会报错，而没写flush()
        在socket.shutdownOutput();后面使用close()会报错，因为，close()里面有flush()方法，
        flush()方法他会去把缓冲区剩下的部分继续发送，而在这之前，你已经socket.shutdownOutput()，关闭了socket通道
        这时候，就会报错， Cannot send after socket shutdown: socket write error
        而如果在socket.shutdownOutput()，方法前使用flush()后，就表明，你在关闭socket通道前就已经把缓冲区中的数据
        全部发送过去了，然后在socket.shutdownOutput()后close()也不会报错，因为这时候调用flush()也不用再使用
        socket通道，继续发送数据。所以不会报错
         */

        /*
        使用转换流
        针对于所有具有缓冲功能的处理流
        我们都需要手动刷新数据，不然会造成数据没发送出去，或则数据有损失的情况
        flush()很重要！！
        private static int defaultCharBufferSize = 8192;
        所以，一般情况下都是需要手动刷新缓冲区里面的数据，不然，数据会留在缓冲区中，不会发送出去
        这个flush就好比我们哪一个棍子从没满的管子中桶出里面的数据，
        但是如果你的数据满了8192，系统会自动发送出8192个字符，但是我们要养成flush的习惯
        因为谁也保证不了你的数据字符数就刚好会使8192个，无论是少于8192还是多于8192个字符
        缓冲区中的数据都会有剩余的数据，需要我们手动的刷新
         */
    }
}
