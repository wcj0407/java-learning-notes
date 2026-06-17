

# TreeSet

## 不重复，无索引，可排序

## treeset底层是根据红黑树的数据结果的实现排序

```
public static void main(String[] args) {
    TreeSet<Integer> ts = new TreeSet<>();
    ts.add(6);
    ts.add(7);
    ts.add(8);
    ts.add(4);
    ts.add(1);
    ts.add(17);
    ts.add(12);
    ts.add(13);


    System.out.println(ts);
}
```

[1, 4, 6, 7, 8, 12, 13, 17]



## 迭代器遍历

```
Iterator<Integer> it = ts.iterator();
while(it.hasNext()) {
    int i = it.next();
    System.out.println(i);
    
}
```

```
加强for遍历
```

```
 for (Integer t : ts) {
        System.out.println(t);
    }
}
```



Limbda遍历

```
ts.forEach(t -> System.out.println(t)
    
);
```





![image-20260615163341199](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615163341199.png)

先第一个字母进行比较，然后要是第一个字母一样的话就比第二个字母（按照ascii表中的升序的，大的排后面）



## 当我们用自己定义的对象的时候，我们要定义比较规则，要不然就会报错



![image-20260615170022998](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615170022998.png)



我们要添加一个比较接口

## 第一种比较规则

### 1.默认排序/自然排序：JavaBean类实现comparable接口比较规则

### 先在student类中加入一个implements Comparable <student>接口

### 然后重写comparable的方法

```
@Override
public int compareTo(Student o) {
    return this.getAge() - o.getAge();
}
```

### this表示要加入进入的元素，o表示已经存在的元素

### 用this的年龄减去已经存在的元素的年龄有三种情况

### ：1.正数:表示添加进去的元素比存在的元素大

### 2.负数：表示添加进去的元素比存在的元素大

### 3.0：表示已经存在，舍弃







### 然后添加进去的元素还要根据红黑树规则来放置









### 第二种比较规则

```
TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        int i =o1.length()-o2.length();
        i =i==0?o1.compareTo(o2):i;
        return i;
    }
```

利用重构comparaator的方法来写比较规则