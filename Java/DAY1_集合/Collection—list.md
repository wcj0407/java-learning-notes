# Collection

# 1.List集合的特有方法

因为list是有索引的，所以方法都是用索引来操作的

继承collection中所以方法

```
public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);

    list.add(0,4);
    System.out.println(list);
    list.remove(2);
    System.out.println(list);
    list.set(2,7);
    System.out.println(list);
    list.get(2);
    System.out.println(list);
}
```

因为List也是接口，所以得先创建一个list的集合实例化对象



### list.add()是根据索引来添加指定的元素的。在添加进入元素后，指定元素后的元素会往后移动

### list.remove()是根据索引来删除指定元素

### list.set，是根据指定的索引来返回被修改的元素



```
// 接口类型    变量名  = new 实现类构造器();
   List<String> list  = new ArrayList<>();
```

### 解释：

- **左边 `List`**：是接口（interface），定义了规范
- **右边 `ArrayList`**：是 List 接口的具体实现类
- 这就是典型的 "**接口引用指向实现类对象**"

------

## 二、为什么要这么写？而不是 `ArrayList list = new ArrayList()`？

### ✅ 好处 1：面向接口编程，解耦合



```
// 今天用ArrayList
List<String> list = new ArrayList<>();

// 明天想换成LinkedList，只改右边就行
List<String> list = new LinkedList<>();

// 后天想换成Vector，还是只改右边
List<String> list = new Vector<>();
```

> **左边的代码完全不用改**！因为所有实现类都遵循 List 接口的规范





List集合的遍历方式



迭代器遍历（Iterator）

