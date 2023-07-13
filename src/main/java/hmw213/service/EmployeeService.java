package hmw213.service;


import hmw213.Employee;
import hmw213.exeptions.UnexpectedCharacterException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmployeeService {
    public void add(Employee employee) throws UnexpectedCharacterException;
    public void remove(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName) throws UnexpectedCharacterException;

    Collection<Employee> getAllEmployees();


    String printAll(String firstName);
}
