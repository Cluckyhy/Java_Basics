package com.chy.interface_.interface_poly_parameter;

public class InterfacePolyArr {
    public static void main(String[] args) {

        //多态数组  -->  接口类型数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定...
            //和前面一样。我们仍然需要进行类型的向下转型
            if(usbs[i] instanceof Phone){       //判断它的运行类型是 Phone
                ((Phone) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}
class Phone implements Usb{
    @Override
    public void work() {
        System.out.println("手机工作中");
    }

    public void call(){
        System.out.println("手机可以打电话");
    }
}
class Camera implements Usb{
    @Override
    public void work() {
        System.out.println("相机工作中");
    }
}