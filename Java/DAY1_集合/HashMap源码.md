# HashMap源码

HashMap存的是node<k,v>

'''java

static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}

java'''

node里面存的有

hash是指哈希值

k 是键

v 是值



HashMap里面每一个对象包含以下内容：
1.1链表中的键值对对象
包含：
int hash;
//键的哈希值
final K key;
键
V value;
值
Node<K,V>next;
//下一个节点的地址值
1.2红黑树中的键值对对象
包含：
int hash;
//键的哈希值
final K key;键
V value;//值
TreeNode<K,V>parent;//父节点的地址值
TreeNode<K,V>left;//左子节点的地址值
TreeNode<K,V> right;//右子节点的地址值
boolean red;//节点的颜色
