package com.lambda.base;

/**
 * @name: FilterEmployeeBySalary
 * @description:
 * @author: zichen
 * @date: 2021/4/18  13:08
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
