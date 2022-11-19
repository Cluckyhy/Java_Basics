package com.chy.qqclient.service;

import com.chy.qqcommon.Message;
import com.chy.qqcommon.MessageType;
import com.chy.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//该类完成用户登录验证和用户注册等功能
public class UserClientService {

    //因为我们可能在其他地方要使用user信息，因此做成一个成员属性
    private User u = new User();
    //因为Socket在其他地方也可能使用，因此也作为属性
    private Socket socket;

    //根据userId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd) {
        boolean b = false;
        //设置User信息
        u.setUserid(userId);
        u.setPasswd(pwd);
        //连接到服务端，发送u对象

        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送对象给服务端
            oos.writeObject(u);

            //读取从服务端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){  //登录OK

                //创建一个和服务器端保持通信的线程 -->  创建一个类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动线程
                clientConnectServerThread.start();
                //这里为了后面客户端的扩展，我们将线程放入到一个线程集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b = true;
            }else{
                //如果登录失败，我们就不能启动和服务器通信的线程，关闭Socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;

    }

    //向服务端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserid());

        //发送给服务器
        //应该得到当前线程的Socket 对应的 ObjectOutputStream对象
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserid()).getSocket().getOutputStream());
            //发送一个Message对象，向服务端要求在线用户列表
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法，退出客户端，并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserid());   //一定要指定我是哪个客户端

        //发送message
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserid()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserid()+"退出系统..");
            System.exit(0); //结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
