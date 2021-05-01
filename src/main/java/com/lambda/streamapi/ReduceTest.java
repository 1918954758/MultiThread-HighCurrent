package com.lambda.streamapi;

import com.lambda.base.Employee;
import com.lambda.base.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @name: ReduceTest
 * @description:
 * @author: zichen
 * @date: 2021/5/1  13:09
 */
public class ReduceTest {

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
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(1, (x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("=========================");

        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
    }

}
