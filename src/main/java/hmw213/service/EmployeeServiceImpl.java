package hmw213.service;


import hmw213.Employee;
import hmw213.exeptions.UnexpectedCharacterException;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    Map<String, Employee> storage = new HashMap<>(Map.of());


    @Override
    public void add(Employee employee) throws UnexpectedCharacterException {
        validate(employee.getFirstName(), employee.getLastName());
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName()));

        if (storage.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new RuntimeException();
        }
        storage.put(employee.getFirstName() + employee.getLastName(), employee);
    }

    @Override
    public void remove(String firstName, String lastName) {
        if (!storage.containsKey(firstName + lastName)) {
            throw new RuntimeException();
        }
        storage.remove(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws UnexpectedCharacterException {
        if (!storage.containsKey(firstName + lastName)) {
            throw new UnexpectedCharacterException("Сотрудник не найден");
        }
        return storage.get(firstName + lastName);
    }


    @Override
    public Collection<Employee> getAllEmployees() {
        return storage.values();
    }

    @Override
    public String printAll(String firstName) {
        return storage.get(firstName).toString();
    }

    private void validate(String... values) throws UnexpectedCharacterException {
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
                throw new UnexpectedCharacterException("Не соответсвуещие символы" + value);
            }
        }
    }

}
