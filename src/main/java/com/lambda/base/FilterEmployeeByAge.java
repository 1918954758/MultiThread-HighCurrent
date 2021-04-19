package com.lambda.base;

/**
 * @name: FilterEmployeeByAge
 * @description:
 * @author: zichen
 * @date: 2021/4/18  13:03
 */
public class FilterEmployeeByAge implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
