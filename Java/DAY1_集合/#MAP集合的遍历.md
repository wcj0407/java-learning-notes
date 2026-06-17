# #MAP集合的遍历

## ##1.键找值

##  ##总结

  ###这段代码就是：往 HashMap 里放 3 组键值对，然后遍历打印出来。

‘’‘java

```
public class mapTraversal {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("zhangsan","lisi");
        map.put("lisi","wangwu");
        map.put("wangwu","zhaoliu");

        Set<String> key =map.keySet();
        for(String key1:key){
            String value = map.get(key1);
            System.out.println(key1+":"+value);
        }  





     }
```

'''

这里只要是一个HashMap的基本使用和遍历，

1.先创建一个HashMap的集合，因为Map是一个接口，所以要有一个具体的实现类

HashMap,Map是一个父类，底下的具体实现类有HashMap,LinkedHashMap,TreeMap

## HashMap的底层：

数组+链表+红黑树

键无序的，存取顺序不一定



## LinkedHashMap

底层和hashMap差不多，都是数组+链表+红黑树

继承 HashMap，额外维护双向链表

有序的，因为有双链表记录插入的上一个的地址值和记录下一个要插入的地址值；



## TreeMap

底层是红黑树

按键自动排序

当插入数据的时候会进行比较，当新插入的数据和已经在表里的数据对比的时候，要是比集合中的数据小的时候就放在左边，大于放右边



------------------------------------------------------------------------------------------------------------------

## 代码解释

HashMap当存数据的时候可以一次存两个数据（key,value）

这个是Map的特性

map.put("zhangsan","lisi");
        map.put("lisi","wangwu");
        map.put("wangwu","zhaoliu");

是往集合里面添加数据利用put的方法

 这里模拟了一个人名链：

张三 → 李四 

李四 → 王五 

王五 → 赵六

每个人的"值"指向下一个人

----------------------------------------------

 Set<String> key = map.keySet();    
  for(String key1 : key){          
      String value = map.get(key1);
      System.out.println(key1 + ":" + value); 
  }

然后利用keySet的方法来获取map里面的key的值

然后利用加强for循环遍历出来



## ##Map的键值对遍历

作用是：遍历 HashMap 中的所有键值对，并逐一打印“外号=姓名”的映射关系。

‘’‘java

```
public static void main(String[] args) {

    Map<String,String > map = new HashMap<>();
    map.put("及时雨","宋江");
    map.put("豹子头","林冲");
    map.put("黑旋风","李逵");

    Set<Map.Entry<String, String>> entries = map.entrySet();
    for (Map.Entry<String, String> entry : entries) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key+"="+value);
    }



}
```

'''

entrySet()就是把map变成可以遍历的键值对集合

然后用一个Set<Map.Entry<K,V>> 的对象来接受entrySet()遍历出来的对象

每一个entry就是一个键值对

然后利用加强for循环来遍历出

利用entry.getkey（）和entry。getvalue()来获取每一个键和值

----------------



## ##Lambda表达式遍历

’‘’java

```
public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("及时雨","宋江");
    map.put("豹子头","林冲");
    map.put("黑旋风","李逵");

    map.forEach((String s, String s1)-> {
            System.out.println(s + " " + s1);

    });
}
```

'''

### ###总结

这段代码是 用 Java 8 的 Lambda + forEach 遍历 HashMap 并打印所有键值对。

这个Linbda表达式遍历其实就是for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " " + entry.getValue());
}

第二个键值对遍历的调用，forEach(Map) 本质是：

自动把 Map 转成 Entry然后逐个遍历lambda 负责处理每一条数据

而且这个其实代码更加便捷

没有那么多代码