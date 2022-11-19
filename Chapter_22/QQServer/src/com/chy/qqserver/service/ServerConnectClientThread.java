package com.chy.qqserver.service;

//该类的一个对象和某个客户端保持通信

import com.chy.qqcommon.Message;
import com.chy.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;  //连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {     //这里线程处于run状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用message，根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    /*
                    在线用户列表按照：100 200 至尊宝
                     */
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onLineUser = ManageServerThreads.getOnLineUser();
                    //返回
                    //构建一个Message对象
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onLineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //根据message获取getter id，然后再得到对应线程
                    ServerConnectClientThread serverConnectClientThread = ManageServerThreads.getServerConnectClientThread(message.getGetter());
                    //得到对应socket的对象输出流，将message对象准发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//转发，提示如果客户不在线，可以保存到数据库，可是实现离线留言
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //需要遍历 管理线程的集合，把所有的线程的socket都得到，然后把message进行转发即可
                    HashMap<String, ServerConnectClientThread> hm = ManageServerThreads.getHm();

                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        //取出在线用户id
                        String onLineUserId = iterator.next().toString();

                        if (!onLineUserId.equals(message.getSender())) {   //排除群发消息的这个用户，自己给自己发消息
                            //进行转发
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            //发送
                            oos.writeObject(message);
                        }

                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //根据getter id 获取到对应的线程，将message对象转发
                    ServerConnectClientThread serverConnectClientThread = ManageServerThreads.getServerConnectClientThread(message.getGetter());
                    //创建一个对象流
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    //转发
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {     //客户端要退出了

                    System.out.println(message.getSender() + "退出..");
                    //？为啥这里要休眠1秒呢？
                    Thread.sleep(1000);
                    //将客户端对应的线程从集合中删除
                    ManageServerThreads.removeServerConnectClientThread(message.getSender());
                    //关闭连接
                    socket.close();
                    //退出线程
                    break;
                } else {
                    System.out.println("其他类型的message，暂时不处理..");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
