# Set系列集合

<img src="C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615153521612.png" alt="image-20260615153521612" style="zoom:50%;" />

hashcode的理解

![image-20260615154333159](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615154333159.png)

## 这个时候的hashcode能被任何调用，现在是没有重写的hashcode方法，是object类的里面分方法，是根据地址值来算的哈希值，所以即使里面的值是一样的，但是地址值不一样，所以算出来的结果也是不一样的



```
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age && Objects.equals(name, student.name);
}

@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```



这个时候在类里面重写了hashcode的值，这个时候是通过判断值是否一样来算哈希值的

![image-20260615154705883](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615154705883.png)

# Hashset底层原理

hashset集合石底层采用哈希表存储数据的

哈希表是一种对于增删改查数据性能都较好的结构



哈希表的组成

数组+链表+红黑树



![image-20260615155359984](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615155359984.png)

![image-20260615155453152](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615155453152.png)

hashset底层原理：
当你运用的时候就会创建一个数组长度为16的加载因子为0.75，的数组

然后根据要存的数据hashcode方法来算出的哈希表和数组的长度来算要存的位置

然后先判断这个位置有没有元素，没有元素就直接存入

要是有元素了，就调用equal方法来判断这两个元素是否一样，要是一样的话就舍弃不要，要是不一样的，jdk8以后都是把新元素直接挂在旧的元素下面，

当挂的元素超过了8并且数组的长度也超过了64，就自动转换为红黑树，

如果是我们自己写的自定义对象，那我们必须要重写hashcode和eqail方法

要不然就是判断的时候是调用object的方法，就是比较的是地址值，不是根据里面的数据来比较的，

然后int，string类型的数据，不用我们自己重写方法，因为java已经帮我写完了