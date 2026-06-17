# LinkedHashMap的学习

特点
有序、不重复、无索引

有序是因为底层还是哈希表，只是每一个键值对元素又额外的多了一个双链表的机制记录存储顺序

存入方式和HashMap没啥区别，只是当存入第一个元素的时候会有一个双链表的头结点就是对第一个元素的地址值进行记录，然后当存入第二个元素之后，第一个元素里面也会记录第二个元素的地址值，当然同理第二个元素也会记录第一个元素的地址值，以此类推，当存完之后一个元素之后，就会记录最后一个元素的地址值当作双链表的尾部结点

代码运行

```
public class LinkedHashMap1 {
    public static void main(String[] args) {
           LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
           lhm.put("ZHANGSAN",18);
           lhm.put("lisi",19);
           lhm.put("wangwu",20);
           lhm.put("ZHANGSAN",21);
           lhm.put("ZHANGSAN",22);

        Iterator<String> it = lhm.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            Integer value = lhm.get(key);
            System.out.println(key+":"+value);
        }
        
    }
    
}
```