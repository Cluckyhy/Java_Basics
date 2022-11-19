package com.chy.map;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /*
        Map 接口实现类的特点，使用实现类HashMap
        1、Map与Collection并列存在，用于保存具有映射关系的数据：key-value (双列元素)
        2、Map 中的 key 和 value 可以是任何类型的数据，会封装到HashMap$Node 对象中
        3、Map 中的 key 不允许重复，原因和HashSet 一样，前面分析过源码
        4、Map 中的 value 是可以重复的
        5、Map 的key 可以为null，value也可以为null，注意 key 为null，只能有一个，value为 null，可以多个
        6、常用的String类作为Map的 key
        7、key 和 value 之间存在单向的一对一关系，即通过指定的 key 总能找到对应的 value
           但是不能通过value找到对应的key
         */
        Map map = new HashMap();
        map.put("NO1", "陈慧亿");
        map.put("NO2", "张三");
        map.put("NO3", "李四");
        map.put("NO1", "哈哈哈");   //当有相同的key时，就等价于替换
        map.put("NO4", "张三");    //成功的
        map.put(null, null);
        map.put(null, "abc");        //替换
        map.put("NO5", null);
        map.put(1, "呵呵");
        map.put(new Object(), "我来了");

        //通过get 方法，传入 key，会返回对应的value
        System.out.println("找到：" + map.get("NO1"));

        System.out.println(map);

        for (Object o : map.values()) {
            System.out.println(o);
        }

    }
}
