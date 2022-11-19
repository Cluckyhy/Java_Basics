package com.chy.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //2、根据指定主机名，获取 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-T76U66A");
        System.out.println(host1);

        //3、根据域名返回 InetAddress 对象，比如 www.baidu.com 对应
        //通过域名获取远程服务器的IP
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //4、通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2对应的ip = " + hostAddress);

        //5、通过InetAddress 对象，获取对应的主机名/或者是域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}
