## 并发工具

-----------------

#### 1、Condition
- wait/notify 是用来实现线程之间通信的，要想使用 wait/notify 一定通过synchronized加锁
- Condition 是和 wait/notify 是等价的。  是多线程协调通信的工具类，可以让某个线程一起等到某个条件可以满足的时候才可以被唤醒。