#java8
~~~
java8 内置的四大核心函数式接口：
1. Consumer<T> - 消费型
    - void accept(T t);
2. Supplier<T>  - 供给型
    - T get();
3. Function<T, R>  - 函数型
    - R apply()T;
4. Predicate<T>  - 断言型
    - boolean test(T);
~~~

##Consumer  - 消费型
##Function  - 函数型
##Prodicate - 段言型
##Supplier  - 供给型

#其他函数式接口
###BiFunction<T, U, R>
- 参数类型 T, U
- 返回类型 R
- 对类型为 T, U 参数应用操作，返回 R 类型的结果，包含方法为 R apply(T t, U u);
###UnaryOperator<T>  implements Function
- 参数类型 T
- 返回类型 T
- 对类型为 T 的对象进行一元运算，并返回 T 类型的结果，包含方法为 T apply(T t);
###BiConsumer<T, U>
- 参数类型 T， U
- 返回类型  void
- 对类型为 T, U 参数应用操作，包含方法为 void accept(T t, U u);
###ToIntFunction<T>
###ToLongFunction<T>
###ToDoubleFunction<T>
- 参数类型 T
- 返回值 int long double
- 分别计算 int、long、double 值得函数
###IntFunction<R>
###LongFunction<R>
###DoubleFunction<R>
- 参数类型 int、long、double
- 返回值 R
- 参数分别为 int、long、double 类型的函数