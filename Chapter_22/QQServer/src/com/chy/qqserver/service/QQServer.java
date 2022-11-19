package com.chy.qqserver.service;

import com.chy.qqcommon.Message;
import com.chy.qqcommon.MessageType;
import com.chy.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

//这是服务器，在监听9999，等待客户端的连接，并保持通信
public class QQServer {
    private ServerSocket serverSocket = null;
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法的
    //这里我们也可以使用 ConcurrentHashMap，可以处理并发的集合，是线程安全的
    //HashMap 没有处理线程安全，因此在多线程中情况下是不安全的
    //ConcurrentHashMap 处理的线程是安全的，即线程是同步处理，在多线程情况下是安全的
    private static ConcurrentHashMap<String, User> validUser = new ConcurrentHashMap<>();

    static {    //在静态代码块，初始化 validUsers

        validUser.put("100", new User("100", "123456"));
        validUser.put("200", new User("200", "123456"));
        validUser.put("300", new User("300", "123456"));
        validUser.put("至尊宝", new User("至尊宝", "123456"));
        validUser.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUser.put("菩提老祖", new User("菩提老祖", "123456"));

    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId, String passwd) {
        User user = validUser.get(userId);
        //过五关斩六将的方式
        if (user == null) {   //说明userId没有存在validUsers 的key中
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {   //userId是正确的，但是密码是错误的
            return false;
        }

        return true;
    }

    public QQServer() {
        //注意端口可以写在一个配置文件中
        try {
            System.out.println("服务端在9999端口监听...");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            serverSocket = new ServerSocket(9999);

            while (true) {    //当和某个客户端连接后，会继续监听，因此while
                Socket socket = serverSocket.accept();

                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                User u = (User) ois.readObject();  //读取客户端发送的对象

                //创建一个Message对象，准备回复客户端
                Message message = new Message();

                //验证用户  方法
                if (checkUser(u.getUserid(), u.getPasswd())) {  //登录成功

                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有一个socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserid());
                    //启动线程
                    serverConnectClientThread.start();
                    //把该线程对象放入到一个集合中，进行管理
                    ManageServerThreads.addClientThread(u.getUserid(), serverConnectClientThread);
                } else {  //登录失败
                    System.out.println("用户  id=" + u.getUserid() + "  pwd = " + u.getPasswd() + "  验证失败...");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务端退出了while循环，说明服务器端不在监听了，因此我们需要关闭ServerScoket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
