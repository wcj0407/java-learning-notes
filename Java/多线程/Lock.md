# Lock

Lock锁可以让我手动控制什么时候上锁，什么时候释放锁。相比于Synchronized的方式更加灵活。

Lock是一个接口，我们需要实例化他的实现类ReentrantLock我能才能调用lock

lock有两个方法

一个是lock.lock();这个主要是给代码上锁的，

一个是lock.unlock();这是释放锁资源的，



Lock "灵活"在哪里？

  synchronized 最大的问题是：拿不到锁时，线程会无限期地等，你没法控制。

  // synchronized：拿不到锁就死等，你什么都做不了
  synchronized (obj) {
      // ...
  }

  Lock 让你能做到三件 synchronized 做不到的事：

  ┌───────────────────────────┬───────────────────────────────────┬────────────────────────────┐
  │           能力            │               代码                │            场景            │
  ├───────────────────────────┼───────────────────────────────────┼────────────────────────────┤
  │ 尝试获取，拿不到就走      │ lock.tryLock()                    │ "我就试试，有人在用就算了" │
  ├───────────────────────────┼───────────────────────────────────┼────────────────────────────┤
  │ 尝试获取，等1秒拿不到就走 │ lock.tryLock(1, TimeUnit.SECONDS) │ "等你1秒，再不来我不等了"  │
  ├───────────────────────────┼───────────────────────────────────┼────────────────────────────┤
  │ 中断正在等待的线程        │ lock.lockInterruptibly()          │ 用户点了取消，别等了       │
  └───────────────────────────┴───────────────────────────────────┴────────────────────────────┘

  // 例子：tryLock — 不傻等
  if (lock.tryLock()) {
      try {
          // 拿到锁了，干活
      } finally {
          lock.unlock();
      }
  } else {
      System.out.println("有人在用，我走了");
      // 去做别的事，而不是傻等
  }

  这就是灵活的本质：你可以决定"拿不到怎么办"。

---
  第二问：unlock 必须放 finally

  你刚才看到的代码有一个致命问题：

  lock.lock();
  doSomething();  // ← 如果这里抛异常，下面永远不执行
  lock.unlock();  // ← 锁永远不会释放！其他线程全部饿死！

  正确写法：

  lock.lock();
  try {
      doSomething();
  } finally {
      lock.unlock();  // 无论是否抛异常，一定会执行
  }

  这是写 Lock 的铁律，漏了就出大问题。

---
  第三问："Reentrant（可重入）" 是什么意思？

  先看一段代码：

  public synchronized void methodA() {
      System.out.println("A");
      methodB();  // A 里调用 B
  }

  public synchronized void methodB() {
      System.out.println("B");
  }

  一个线程调用 methodA()，methodA 拿到锁后又调用 methodB()，methodB 也需要同一把锁。

  如果是不可重入锁：线程已经持有锁了，再请求同一把锁 → 死锁（自己等自己释放）。

  如果是可重入锁：JVM 记录"哦，是你啊，进来吧"，计数器+1。出去时-1，减到0才真正释放。

  synchronized 和 ReentrantLock 都是可重入的。 所以你可以放心地在同步方法里调用另一个同步方法。

---
   总结：synchronized vs Lock

  ┌──────────┬───────────────────┬──────────────────────┐
  │          │   synchronized    │         Lock         │
  ├──────────┼───────────────────┼──────────────────────┤
  │ 拿不到锁 │ 死等              │ 可以放弃/超时/中断   │
  ├──────────┼───────────────────┼──────────────────────┤
  │ 释放锁   │ 自动（出代码块）  │ 手动（必须 finally） │
  ├──────────┼───────────────────┼──────────────────────┤
  │ 公平性   │ 不公平            │ 可设为公平锁         │
  ├──────────┼───────────────────┼──────────────────────┤
  │ 可重入   │               │                 │
  ├──────────┼───────────────────┼──────────────────────┤
  │ 性能     │ Java 6 后差别不大 │                      │
  └──────────┴───────────────────┴──────────────────────┘



## 死锁

```
package DeadLockDemo;

public class DeadLock extends Thread{
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    @Override
    public void run() {
       while (true){
           if ("线程1".equals(getName())) {
               synchronized (lock1) {
                   System.out.println("现在在拿lock1，等待lock2");
                   synchronized (lock2) {
                       System.out.println("si");
                   }
               }

           } else if ("线程2".equals(getName())) {
               if ("线程2".equals(getName())) {
                   synchronized (lock2) {
                       System.out.println("si");
                       synchronized (lock1) {
                           System.out.println("shuai");
                       }
                   }

               }


           }
       }


    }
}
```

`现在在拿lock1，等待lock2`
`si`

## 死锁的四个必要条件

1. ### 互斥：资源只能被一个线程占用

  同一时刻，一把锁只能被一个线程持有。
  线程1拿了lockA，线程2就只能等着。

 能破坏吗？不能，这就是锁的本质



### 2.持有并等待：拿着手里的，等别人的

  线程1拿着lockA，同时等着lockB
  线程2拿着lockB，同时等着lockA

能破坏吗？能 — 一次性申请所有资源，拿不到就全不放。或者用 tryLock 拿不到就放弃手中的。



### 3.

 不可抢占：别人不放手，你抢不过来

  线程1不主动释放lockA，线程2就不能强行拿走

能破坏吗？能 — lock.lockInterruptibly() 可以中断等待的线程。



4. ### 循环等待：你等我，我等你，形成闭环

  线程1 → 等lockB → 被线程2占着
  线程2 → 等lockA → 被线程1占着

能破坏吗？能 — 所有线程按相同顺序拿锁（都先拿A再拿B，就不会死锁）。