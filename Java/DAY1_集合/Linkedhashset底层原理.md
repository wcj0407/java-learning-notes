# Linkedhashset底层原理

## 有序，不重复，无索引的

## 这里的有序就是存入和取出的元素顺序一样的

![image-20260615161424849](C:\Users\wangchuanjun\AppData\Roaming\Typora\typora-user-images\image-20260615161424849.png)

底层原理是和hashset差不多，但是linkedhashset多了一个双链表来记录添加元素的顺序

当添加第一个元素的时候双链表就会记录第一个元素的地址值，然后当添加第二个元素的时候，第一个元素就会记录第二个元素的地址值，第二个元素也会记录第一个元素的地址值