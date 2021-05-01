package com.lambda.streamapi;

import com.lambda.base.Employee;
import com.lambda.base.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @name: CollectTest
 * @description:
 * @author: zichen
 * @date: 2021/5/1  13:32
 */
public class CollectTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.BUSY),
            new Employee("李四", 38, 5555.99, Status.FREE),
            new Employee("王五", 50, 3333.33, Status.VOCATION),
            new Employee("赵六", 17, 6666.66, Status.FREE),
            new Employee("田七", 8, 7777.77, Status.VOCATION),
            new Employee("田七", 8, 1111.11, Status.BUSY),
            new Employee("解八", 8, 4444.44, Status.FREE),
            new Employee("庞九", 8, 2222.22, Status.VOCATION),
            new Employee("母十", 8, 8888.88, Status.BUSY)
    );

    @Test
    public void test1() {
        // 将集合收集到list中
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("================");
        //collect.forEach(System.out::println);
        // 将集合收集到set中
        Set<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(collect1);
        System.out.println("================");
        // 将结果收集到特殊的集合中的操作
        LinkedHashSet<String> collect2 = employees.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect2);
    }

    /**
     * 组函数
     */
    @Test
    public void test2() {
        // 总数
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println("总数counting() ：" + count);
        System.out.println("==================================");

        // 平均值
        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("平均值averagingDouble() ：" + avg);
        System.out.println("==================================");

        // 总和
        DoubleSummaryStatistics sum = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("总和summarizingDouble() ：" + sum.getSum());
        System.out.println("==================================");

        // 最大值
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        Optional<Double> max2 = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println("最大值maxBy() ： " + max.get().getSalary());
        System.out.println("最大值maxBy() ： " + max2.get());
        System.out.println("==================================");

        // 最小值
        Optional<Employee> min = employees.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        Optional<Double> min2 = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println("最小值minBy() ：" + min.get().getSalary());
        System.out.println("最小值minBy() ：" + min2.get());
        System.out.println("==================================");
    }

    /**
     * 分组
     */
    @Test
    public void test3() {
        Map<Status, List<Employee>> groupByStatus = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("根据状态分组：" + groupByStatus);

    }

    /**
     * 多列分组
     */
    @Test
    public void test4() {
        Map<Status, Map<String, List<Employee>>> groutByStatusByAge = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() <= 35) {
                return "青年";
            } else if (((Employee) e).getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(groutByStatusByAge);
    }

    /**
     * 分区
     */
    @Test
    public void test5() {
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect);
    }

    /**
     * joining
     */
    @Test
    public void test6() {
        String joining = employees.stream().map(Employee::getName).collect(Collectors.joining(" || "));
        System.out.println(joining);
    }
}
