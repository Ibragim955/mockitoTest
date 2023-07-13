package hmw213.service;


import hmw213.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface DepartmentService {
    Employee findMaxSalary(Integer deportment);
    Employee findMinSalary(Integer deportment);
    Collection<Employee> findAllByDepartmentId(Integer deportment);

    Map<Integer, List<Employee>> getGroupById();
}
