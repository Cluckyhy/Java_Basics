package com.chy.enum_;

public class Homework01 {
    public static void main(String[] args) {
        //Color[] values = Color.values();
        Color color = Color.GREEN;
        switch (color){
            case RED:
                System.out.println("匹配到红色了");
                break;
            case BLUE:
                System.out.println("匹配到蓝色了");
                break;
            case BLACK:
                System.out.println("匹配到黑色了");
                break;
            default:
                System.out.println("没匹配值");
        }
    }
}

//Color枚举类
enum Color implements printMessage {
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,0);

    private int redValue;
    private int greenVale;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenVale = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("red:" + redValue + "\tgreen" + greenVale + "\tblue" + blueValue);
    }
}

//接口
interface printMessage {
    void show();
}
