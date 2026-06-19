# HashMap源码

## 1.底层创建原理

**HashMap<String,Integer>hm = new HashMap<>()；**

#### hm.put("aaa" , 111);

#### hm.put("bbb" , 222);

#### hm.put ("ccc",333);

#### hm.put ("ddd", 444);

#### hm.put("eee"，555);

##### 当运行HashMap<String,Integer>hm = new HashMap<>()；的时候，底层只会创建为一个加载因子的0.75,并没有创建数组。

##### public HashMap() {

#####     this.loadFactor = DEFAULT_LOAD_FACTOR; // 0.75

##### }

##### 这是new的时候调用构造方法里面的内容

----------------------------

## 二、HashMap 的“真正初始化”

#### 当代码运行到hm.put("aaa" , 111);的时候底层就会进行：运行put的方法：

#### public V put(K key, V value) {

####     return putVal(hash(key), key, value, false, true);

#### }

#### 这个方法中第一步先计算hash

#### hash(key)

#### static final int hash(Object key) {

####     int h;

####     return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

#### }

#### 这个方法重要是当如果 key 为 null，则 hash 为 0，否则计算 key.hashCode()，是空的返回一个0，不是空的就会调用键的hashcode的方法来进行算出结果，然后放入h中，然后再让h和16进行一个异或运算

----------------

## 三.第二步：进入 putVal

#### putVal(hash, key, value, false, true)

### 1.判断 table 是否为空

#### if ((tab = table) == null || (n = tab.length) == 0)

####     n = (tab = resize()).length;

#### 先将table的值赋值给tab，因为是第一次添加值，table的值是空的，所以进入n = (tab = resize()).length;进入resize()方法

-------------

### 2.resize() —— HashMap 真正初始化数组

#### Node<K,V>[] resize()



#### 初始化容量

#### int oldCap = 0;

#### int newCap = DEFAULT_INITIAL_CAPACITY; 

#### 默认为16



#### 创建数组

#### Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];

#### table = newTab;



#### threshold = 当前容量 * 负载因子，当 size 超过 threshold 时触发扩容

#### threshold = newCap * loadFactor;



#### 返回if ((tab = table) == null || (n = tab.length) == 0)

####     n = (tab = resize()).length;



##  计算数组下标

```
index = (n - 1) & hash
```

##  找到桶位置

```
Node<K,V> p = tab[index];
```



## 开始创建 Node（关键结构）

#### tab[index] = new Node<>(hash, key, value, null);

## Node 结构（重点）

```
static class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}
```

### 第一个元素结果：

```
table[某个位置] -> Node(A,1)
```

