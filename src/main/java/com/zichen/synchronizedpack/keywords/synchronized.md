###synchronized
- synchronized 加到静态方法上和锁定xxx.class上，都是给Class类上锁
- synchronized 加到实例方法上是给对象实例上锁

1. static synchronized void count(){...}  - 这个方法所属类的Class对象
2. synchronized void count(){...} - 对象
3. synchronized (AAA.class){...} - AAA类对象
4. synchronized (new Object){...} - 虚拟对象
5. Unsafe

ReentrantLock  java
synchronized   C++


==================
**class - Java
klass - C++**
- 加载一个对象，jvm会生成两个klass,
    一个是instance，在方法区，元信息
    另一个是mirror，在堆中
- 可以通过Klass Pointer找到对象的元信息

==================

**对象头**： 
- Mark Word（标记字段） 64byte
- Klass Pointer（类型指针） 4byte - 对象所属的类，在方法区的内存地址
- 数组对象（数组长度）

**实例数据**： 
- 类的非静态属性
- 对象的实际数据

**填充数据**：
- 补足8byte

**普通对象结构**：
~~~
OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      对象头：
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4         (object header)                           18 0a c1 16 (00011000 00001010 11000001 00010110) (381749784)
      Data -实例数据：
      12     4     int TestClass.i                               0
      16     4   float TestClass.f                               0.0
      填充数据:
      20     4         (loss due to the next object alignment)
~~~     
**类型实例未被压缩显示信息**:
~~~
 OFFSET  SIZE    TYPE DESCRIPTION                               VALUE
      对象头：
      Mark Word 8byete
      0     4         (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
      4     4         (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      Klass Pointer 8byte
      8     4         (object header)                           58 35 ec 16 (01011000 00110101 11101100 00010110) (384578904)
     12     4         (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     Data -实例数据：
     16     4     int TestClass.i                               0
     20     4   float TestClass.f                               0.0
     24     8   int[] TestClass.arr                             [1, 2, 3, 4, 3, 6, 5, 5, 6, 7]
     填充数据:
     ...
~~~     
**数组对象结构**：
~~~
class Demo{
    main(String [] args){
        int[] i = new int[5];
        i[0] = 1;
        i[1] = 2;
        i[2] = 3;
    }
}
output ==>
[1, 2, 3, 0, 0]
[I object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     头对象：
      Mark Word
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      Klass Pointer
      8     4        (object header)                           68 0b d1 16 (01101000 00001011 11010001 00010110) (382798696)
     数组长度
     12     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
     实例数据：
     16    20    int [I.<elements>                             N/A
     数据填充：
     36     4        (loss due to the next object alignment)
Instance size: 40 bytes
~~~

------------------------------------------------------------------------------------------------------------------------


###锁的状态
####无锁
####延迟偏向锁
####偏向锁
####轻量级锁
####重量级锁

####Unsafe    与上面的5中不同，他没有锁膨胀，他是重量级锁


###证明存在
####这几种锁如何膨胀的？
####hashcode
####轻量级锁
~~~
 0 new #2 <java/lang/Object>
  3 dup
  4 invokespecial #1 <java/lang/Object.<init>>
  7 astore_1
  8 aload_1
  9 dup
 10 astore_2
 11 monitorenter  ######################
 12 getstatic #3 <java/lang/System.out>
 15 aload_1
 16 invokestatic #4 <org/openjdk/jol/info/ClassLayout.parseInstance>
 19 invokevirtual #5 <org/openjdk/jol/info/ClassLayout.toPrintable>
 22 invokevirtual #6 <java/io/PrintStream.println>
 25 aload_2
 26 monitorexit  ######################
 27 goto 35 (+8)
 30 astore_3
 31 aload_2
 32 monitorexit  ######################
 33 aload_3
 34 athrow
 35 return
~~~
####重量级锁  底层实现
~~~
 0 new #2 <java/lang/Object>
 3 dup
 4 invokespecial #1 <java/lang/Object.<init>>
 7 astore_1
 8 aload_1
 9 dup
10 astore_2
11 monitorenter  ######################
12 aload_1
13 invokevirtual #3 <java/lang/Object.hashCode>
16 pop
17 getstatic #4 <java/lang/System.out>
20 aload_1
21 invokestatic #5 <org/openjdk/jol/info/ClassLayout.parseInstance>
24 invokevirtual #6 <org/openjdk/jol/info/ClassLayout.toPrintable>
27 invokevirtual #7 <java/io/PrintStream.println>
30 aload_2
31 monitorexit  ######################
32 goto 40 (+8)
35 astore_3
36 aload_2
37 monitorexit  ######################
38 aload_3
39 athrow
40 return
~~~

























