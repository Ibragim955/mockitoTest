package hmw213.service;


import hmw213.Employee;
import hmw213.exeptions.UnexpectedCharacterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collection;

public class EmployeeServiceImplTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployeeWhenDoesNotExist() throws UnexpectedCharacterException {
        Employee employee = new Employee("Андрей", "Комаров", 12000, 1);
        employeeService.add(employee);

        Employee testEmployee = employeeService.findEmployee("Андрей", "Комаров");
        Assertions.assertEquals(employee, testEmployee);

    }


    @Test
    public void shouldRemoveEmployeeWhenDoesNotExist() throws UnexpectedCharacterException {
        employeeService.add(generateEmployee());
        Employee testAndrey = employeeService.findEmployee("Андрей", "Комаров");

        employeeService.remove(testAndrey.getFirstName(), testAndrey.getLastName());

        Assertions.assertThrows(UnexpectedCharacterException.class, () -> {
            employeeService.findEmployee("Андрей", "Комаров");
        });

    }
    /*                                      готово                                            */
    @Test
    public void shouldFindEmployeeWhenDoesNotExist() throws UnexpectedCharacterException {
        Employee employee = new Employee("Андрей", "Комаров", 12000, 1);
        employeeService.add(employee);

        Employee testEmployee = employeeService.findEmployee("Андрей", "Комаров");
        Assertions.assertEquals(employee, testEmployee);

    }

    public Employee generateEmployee() {
        return new Employee("Андрей", "Комаров", 12000, 1);
    }

}
