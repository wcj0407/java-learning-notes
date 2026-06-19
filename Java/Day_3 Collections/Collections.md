# Collections

## 是一个集合工具类

![image-20260619141721896](D:\zhuomian\java-learning-notes\Java\Day_3\images\image-20260619141721896.png)

## 只能处理单列集合



1.addAll添加元素

```
ArrayList<Integer> list = new ArrayList<>();
Collections.addAll(list, 1, 2, 3, 4, 5);
System.out.println(list);
```



```
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    Collections.addAll(list, 1, 2, 3, 4, 5);
    System.out.println(list);
    Collections.shuffle(list);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list, (a,b)->b-a);
    System.out.println(list);
    int max= Collections.max(list);
    System.out.println(max);
  int min =  Collections.min(list);
    System.out.println(min);
    Collections.sort(list);
    System.out.println("升序: " + list);
    int index = Collections.binarySearch(list, 3);
    System.out.println("3 的下标: " + index);
    Collections.fill(list, 3);
    System.out.println(list);



}
```

### 结果

[1, 2, 3, 4, 5]
[4, 1, 5, 2, 3]
[1, 2, 3, 4, 5]
[5, 4, 3, 2, 1]
5
1
升序: [1, 2, 3, 4, 5]
3 的下标: 2
[3, 3, 3, 3, 3]