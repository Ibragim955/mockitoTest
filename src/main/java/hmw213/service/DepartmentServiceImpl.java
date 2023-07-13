package hmw213.service;


import hmw213.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalary(Integer deportment) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDeportamentId(), deportment))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee"));
    }

    @Override
    public Employee findMinSalary(Integer deportment) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> Objects.equals(e.getDeportamentId(), deportment))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee"));
    }

    @Override
    public Collection<Employee> findAllByDepartmentId(Integer deportment) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> Objects.equals(e.getDeportamentId(), deportment))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getGroupById() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(e -> e.getDeportamentId(), Collectors.toList()));
    }
}