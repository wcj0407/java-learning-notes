# TreeMap

**TreeMap跟TreeSet底层原理一样，都是红黑树结构的。**
**由键决定特性：不重复、无索引、可排序**
**可排序：对键进行排序。**
**注意：默认按照键的从小到大进行排序，也可以自己规定键的排序规则**
**代码书写两种排序规则**
**Comparable接口，指定比较规则。**
**创建集合时Comparator较器对象，指定比较规则。**

```
TreeMap<Integer,String> map = new TreeMap<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
});
map.put(1,"高端无线降噪耳机");
map.put(2,"智能运动手表");
map.put(4,"原装进口阿拉比卡咖啡豆");
map.put(3,"轻奢防水尼龙双肩背包");

map.forEach((k, v) -> {
    System.out.println(k + "=" + v);
});
```

### 利用comparator的比较方法来直接指定比较规则

```
public static void main(String[] args) {
    TreeMapStudent s1=new TreeMapStudent("张三",18);
    TreeMapStudent s2 =new TreeMapStudent("李四",19);
    TreeMapStudent s3 =new TreeMapStudent("王五",20);
    TreeMapStudent s4=new TreeMapStudent("赵六",18);
    TreeMapStudent s5=new TreeMapStudent("赵六",18);

    TreeMap<TreeMapStudent,String> tm = new TreeMap<>();
    tm.put(s1,"广西");
    tm.put(s2,"湖南");
    tm.put(s3,"广东");
    tm.put(s4,"江西");
    tm.put(s5,"北京");

    for (Map.Entry<TreeMapStudent, String> entry : tm.entrySet()) {
        System.out.println(entry.getKey() + "=" + entry.getValue());
    }




}
```

## 利用map集合进行统计

### 如果题目中没有要求对结果进行排序，默认使用HashMap

### 如果题目中要求对结果排序，用TreeMap

```
public class TreeMap1 {
    //字符串“aababcabcdabcde"
    //请统计字符串中每一个字符出现的次数，并按照以下格式输出
    //输出结果：
    //a (5) b (4) C (3) D (2) e (1)
    public static void main(String[] args) {
        String s ="aababcabcdabcde";

        TreeMap<Character,Integer> tm = new TreeMap<>();
        for(int i =0;i<s.length();i++) {
            char c =s.charAt(i);
            if(tm.containsKey(c)) {
                //tm.get(c)是通过key来获得value的值
               int count = tm.get(c);
                  count++;
                  tm.put(c,count);
            }else {
                tm.put(c,1);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:tm.entrySet()) {
            sb.append(entry.getKey()+"("+entry.getValue()+")");
        }
        System.out.println(sb);


    }
```