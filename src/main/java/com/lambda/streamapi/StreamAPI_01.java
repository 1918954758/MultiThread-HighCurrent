package com.lambda.streamapi;

import com.lambda.base.Employee;
import com.lambda.base.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI_01 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.BUSY),
            new Employee("李四", 38, 5555.99, Status.VOCATION),
            new Employee("王五", 50, 3333.33, Status.BUSY),
            new Employee("赵六", 17, 6666.66, Status.FREE),
            new Employee("田七", 8, 9999.99, Status.VOCATION)
    );
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

        employees.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("=================================");
        Employee[] emps = new Employee[5];
        emps[0] = new Employee("a", 25, 99999.99, Status.VOCATION);
        emps[1] = new Employee("b", 22, 66666.66, Status.FREE);
        emps[2] = new Employee("c", 23, 88888.88, Status.BUSY);
        emps[3] = new Employee("d", 4, 33333333.85, Status.BUSY);
        emps[4] = new Employee("e", 10, 666555.77, Status.VOCATION);
        Arrays.stream(emps).map(n -> n.getName()).map(m -> m.toUpperCase()).forEach(System.out::println);
        System.out.println("===================================");
        Stream.of(emps).map(n -> n.getName()).map(m -> m.toUpperCase()).forEach(System.out::println);
    }
}
