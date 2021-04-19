package com.lambda.base;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @name: TestLambda2    适用于函数式接口（接口中只有一个抽象方法）
 * @description: Lambda表达式的基础语法，java8中引入了新的操作符 “->”
 * 该操作符叫箭头操作符，或者是Lambda操作欧服
 * 箭头操作符将Lambda表达式拆分为两部分；
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需要执行的功能，即Lambda体
 *
 * 函数式接口：接口中只有一个抽象方法的接口，称之为函数是接口，可以使用注解@FunctionInterface修饰，该注解可以检查是否是函数式接口
 * @author: zichen
 * @date: 2021/4/18  13:27
 */
public class TestLambda2 {

    /**
     * 语法格式一：无参数无返回值
     *      () -> System.out.println("Hello Lambda!");
     */
    @Test
    public void test1() {
        final int num = 0;//jdk1.8之后可以不加final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable" + num);
            }
        };
        new Thread(r).start();
        System.out.println("==========================");
        Runnable r1 = () -> System.out.println("Hello Lambda" + num);
        new Thread(r1).start();
    }

    /**
     * 语法格式二：有一个参数，无返回值
     *      (x) -> System.out.println(x);
     */
    @Test
    public void test2_1() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("有一个参数，无返回值！");
    }

    /**
     * 语法格式三：若只有一个参数，参数的小括号可以省略不写
     *      x -> System.out.println(x);
     */
    @Test
    public void test2_2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("有一个参数，无返回值！");
    }

    /**
     * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
     *      (x, y) -> {};
     */
    @Test
    public void test3_1() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 语法格式五：若干Lambda体中只有一条语句，return和大括号都可以省略不写
     *      (x, y) -> Integer.compare(x, y);
     */
    @Test
    public void test3_2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上写文推断出参数类型，称之为“类型推断”
     *
     */
    @Test
    public void test4() {
        String[] strs = {"aaa", "bbb", "ccc"};

        List<String> list = new ArrayList<>();

        show(new HashMap<>());
    }

    public void show(Map<String, Integer> map){}

    /**
     * 上联；左右遇一括号省
     * 下联；左侧推断类型省
     *  横批：能省则省
     */


    //对一个数进行运算
    @Test
    public void test5() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 3333.33),
            new Employee("赵六", 17, 6666.66),
            new Employee("田七", 8, 9999.99)
    );

    @Test
    public void test6() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    //计算两个数，参数问Integer，返回值为Integer
    public Integer testNum(Integer num1, Integer num2, NumInteger ni) {
        return ni.numFunc(num1, num2);
    }
    @Test
    public void test7() {
        Integer result = testNum(30, 50, (n1, n2) -> n1 * n2);
        System.out.println(result);
    }




}
