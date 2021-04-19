package com.lambda.base;

import org.junit.Test;

import java.util.*;

/**
 * @name: TestLambda
 * @description:
 * @author: zichen
 * @date: 2021/4/18  12:27
 */
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 3333.33),
            new Employee("赵六", 17, 6666.66),
            new Employee("田七", 8, 9999.99)
    );

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }
    //获取当前公司中员工年龄大于35的员工信息
    @Test
    public void test3() {
        List<Employee> emps = filterEmployees(employees);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    //获取当前公司员工工资大于500的员工信息
    public List<Employee> filteEmployee2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //优化方式一： 策略模式
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }

        return emps;
    }

    @Test
    public void test4() {
        List<Employee> emps1 = filterEmployee(this.employees, new FilterEmployeeByAge());

        for (Employee emp : emps1) {
            System.out.println(emp);
        }

        System.out.println("=======================");

        List<Employee> emps2 = filterEmployee(this.employees, new FilterEmployeeBySalary());
        for (Employee emp : emps2) {
            System.out.println(emp);
        }
    }

    //优化方式二： 匿名内部类
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三： Lambda表达式
    @Test
    public void test6() {
        List<Employee> list = filterEmployee(this.employees, (e) -> e.getSalary() <= 5000);

        list.forEach(System.out::println);
    }

    //优化方式四：
    @Test
    public void test7() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("========================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
