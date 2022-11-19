package com.chy.qqclient.view;

import com.chy.qqclient.service.FileClientService;
import com.chy.qqclient.service.MessageClientService;
import com.chy.qqclient.service.UserClientService;
import com.chy.qqclient.utils.Utility;

@SuppressWarnings({"all"})
//客户端的菜单界面
public class QQView {

    private boolean loop = true;    //控制是否显示菜单
    private String key = "";        //接收用户的键盘输入
    private UserClientService ucs = new UserClientService();    //对象是用于登录服务器/注册用户
    private MessageClientService messageClientService = new MessageClientService(); //对象用户私聊/群聊..
    private FileClientService fileClientService = new FileClientService();  //该对象用于传送文件

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }

    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("--------------欢迎登录网络通讯系统---------------");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            //根据用户的输入，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    //这里就比较麻烦了，需要到服务端去验证该用户是否合法
                    //这里我们有很多代码，我们通过编写一个类UserClientServeice[用户登录/注册]
                    if (ucs.checkUser(userId, pwd)) {
                        System.out.println("--------------欢迎 (用户 " + userId + " )登录成功---------------");
                        while (loop) {
                            System.out.println("\n--------------网络通信系统二级菜单(用户 " + userId + " )---------------");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入您的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //这里准备写一个方法，来获取在线用户列表
                                    ucs.onlineFriendList();
                                    //System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("请输入想和大家说的话：");
                                    String s = Utility.readString(100);
                                    //调用一个方法，将消息封装成message对象，发送给服务端
                                    messageClientService.sendMessageToAll(s, userId);
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户号(在线)：");
                                    String getterId = Utility.readString(50);
                                    System.out.println("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    //编写一个方法，将消息发送给服务端
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("请输入你想把文件发送给的用户(在线)：");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入发送文件的路径(形式如 d:\\xx.jpg)");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入把文件发送到对应的路径(形式如 d:\\uu.jpg)");
                                    String dest = Utility.readString(100);
                                    //调用方法
                                    fileClientService.sendFileOne(src, dest, userId, getterId);
                                    break;
                                case "9":
                                    //调用一个方法，给服务器发送一个退出系统的message
                                    ucs.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {    //提示登录失败
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
