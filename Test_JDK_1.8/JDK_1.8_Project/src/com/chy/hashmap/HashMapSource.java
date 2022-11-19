package com.chy.hashmap;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);     //OK
        map.put("php", 10);      //OK
        map.put("java", 20);     //替换vuale

        System.out.println("map = " + map);

        //解读HashMap的源码：
        /*
        1、执行构造器，new HashMap()
             初始化加载因子，loadfactor = 0.75
             HashMap$Node[] table = null
         */
        /*
        2、执行put

        public V put(K key, V value) {      // K = "java"  value = 10
            return putVal(hash(key), key, value, false, true);
        }

        3、  调用 hash 方法，计算 key 的 hash 值 (h = key.hashCode()) ^ (h >>> 16);

            static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }

        4、执行 putVal()
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;                     //辅助变量
        //如果底层的table 数组为null，或者 length = 0，就扩容到 16
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //取出hash值对应的table的索引位置的Node，如果为null，就直接把加入的k-v
        //创建成一个Node，加入到该位置即可
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;                                       //辅助变量
            (如果table的索引位置的key的hash和新的key的hash值相同)，并且满足&&
            (现有的结点的key和准备添加的key是同一个对象  ||  equals返回真)
            就认为不能加入到新的k-v
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            如果当前的table的已有的Node，是红黑树，就按照红黑树的方式处理
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            如果找到的结点，后面是链表，就循环比较
                for (int binCount = 0; ; ++binCount) {          //死循环
                    if ((e = p.next) == null) {                 //如果整个链表，没有和他相同,就加到该链表的最后
                        p.next = newNode(hash, key, value, null);
                        加入后，判断当前链表个数，是否已经到8个，到8个后，就调用treeifyBin方法进行红黑树的转换
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    如果在循环比较过程中，发现相同的，就break，就只是替换value
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;        //替换，key对应的value
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;                 //每增加一个Node，就++size
        if (++size > threshold)     //[12-24-48] 如果size > 临界值，就扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    5、关于树化
    如果table 为 null，或者大小还没有到 64，暂时不树化，而是进行扩容。
    否则才会真正的树化   --> 剪枝
     final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
         */


    }
}
