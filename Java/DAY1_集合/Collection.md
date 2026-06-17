# Collection

### collection是单列点的顶层接口，所有的方法都被list和set集合共享

常见成员方法：
add、clear、remove、contains、isEmpty、size
三种通用的遍历方式：
迭代器：在遍历的过程中需要删除元素，请使用迭代器。
增强for、Lambda：
仅仅想遍历，那么使用增强for或Lambda表达式。

## 1.迭代器遍历

1.

```
Collection<String> coll = new ArrayList<String>();
coll.add("aaa");
coll.add("bbb");
coll.add("ccc");
coll.add("ddd");
coll.add("eee");
Iterator<String> it = coll.iterator();
while(it.hasNext()){
    String str = it.next();
    System.out.println(str);
}
```

先创建一个集合并添加进入元素

collection<String> coll = new ArrayList<String>()

因为collection是一个接口，得先创建一个子类集合的实例化对象

collction的子类有ArrayList和sethast

coll.add是添加进入元素，添加进入元素之后就要调用Iterator了

coll.Iterator就会创建一个Iterator的对象，然后

it.hasNext的作用是判断这个集合中现在的指针上有没有元素。有元素就返回一个true,没有就返回一个False。

it.next()的作用是获取当前的元素，并往后移动一个指针

![image-20260612233015710](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260612233015710.png)

迭代器遍历完之后，指针不会归位，还是会在结束的位置







## 2.增强for遍历

1.增强for的底层就是迭代器，为了简化迭代器的代码书写的。
2.它是JDK5之后出现的，其内部原理就是一个Iterator迭代器
3.所有的单列集合数组才能用增强for进行遍历

![image-20260612235139161](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260612235139161.png)

![image-20260612235242229](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260612235242229.png)

```
Collection<String> coll =new ArrayList<>();
coll.add("zhangsan");
coll.add("lisi");
coll.add("wangwu");


  for (String s : coll) {
      System.out.println(s);
  }


  }
```

s是一个第三方的变量，修改s的时候不会改变coll里面原本的元素



## 3.Lambda表达式遍历

```
 Collection<String> coll =new ArrayList<>();
         coll.add("zhangsan");
         coll.add("lisi");
         coll.add("wangwu");

//         coll.forEach(new Consumer<String>() {
//             @Override
//             public void accept(String s) {
//                 System.out.println(s);
//             }
//         });

        coll.forEach (s -> System.out.println(s)

        );
```

forEach的底层原理是自己也会遍历集合，一次得到每一个元素，把得到的元素传递给下面的accept方法，