package com.lambda.streamapi;

import com.lambda.base.Employee;
import com.lambda.base.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SortedTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.BUSY),
            new Employee("李四", 38, 5555.99, Status.FREE),
            new Employee("王五", 50, 3333.33, Status.VOCATION),
            new Employee("赵六", 17, 6666.66, Status.FREE),
            new Employee("田七", 8, 7777.77, Status.VOCATION),
            new Employee("田七", 8, 1111.11, Status.BUSY),
            new Employee("解八", 8, 4444.44, Status.FREE),
            new Employee("庞九", 8, 2222.22, Status.VOCATION),
            new Employee("母十", 8, 8888.88, Status.BUSY));

    /**
     * 自然排序   Comparable
     */
    @Test
    public void test1() {
        List<String> list = Arrays.asList("GGG", "DDD", "DDD", "EEE", "YYY", "WWW");
        list.stream().sorted().forEach(System.out::println);
    }


    /**
     * 自然排序   Comparator
     */
    @Test
    public void test2() {
        Stream<Employee> stream = employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == (e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge() - e2.getAge();
            }
        });
        stream.forEach(System.out::println);
    }

    /**
     *   - allMatch - 检查是否匹配所有元素
     *   - anyMatch - 检查是否至少匹配一个元素
     *   - noneMatch - 检查是否没有匹配所有元素
     *   - findFirst - 返回第一个元素
     *   - findAny - 返回当前流中的任意元素
     *   - count - 返回流中元素的总个数
     *   - max - 返回流中最大值
     *   - min - 返回流中最小值
     */
    @Test
    public void test3() {
        boolean b = employees.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b);
        System.out.println("==========================");
        boolean b1 = employees.stream().anyMatch((e) -> e.getStatus().equals(Status.FREE));
        System.out.println(b1);
        System.out.println("==========================");
        boolean b2 = employees.stream().noneMatch((e) -> e.getAge() == 30);
        System.out.println(b2);
        System.out.println("==========================");
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println("按照工资排序 ： " + first.get());
        System.out.println("==========================");
        Optional<Employee> any = employees.parallelStream().filter((e) -> e.getStatus().equals(Status.FREE)).findAny();
        System.out.println(any.get());
        System.out.println("==========================");
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println("==========================");
        long count1 = employees.stream().count();
        System.out.println(count1);
        System.out.println("==========================");
        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
        System.out.println("==========================");

        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get().getSalary());
        Optional<Double> min1 = employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min1.get());
    }
}
