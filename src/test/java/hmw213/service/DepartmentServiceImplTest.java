package hmw213.service;

import hmw213.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;

    @Test
    public void ShouldReturnEmployeeWithMinSalary() {
        when(employeeService.getAllEmployees()).thenReturn(generateEmployee());
        Employee result = departmentServiceImpl.findMinSalary(1);

        Assertions.assertEquals("Alex", result.getFirstName());
    }
    @Test
    public void ShouldReturnEmployeeWithMaxSalary() {
        when(employeeService.getAllEmployees()).thenReturn(generateEmployee());
        Employee result = departmentServiceImpl.findMaxSalary(2);

        Assertions.assertEquals("Maga", result.getFirstName());
    }
    @Test
    public void shouldReturnEmployeesGroupedByDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(generateEmployee());

        Map<Integer, List<Employee>> result = departmentServiceImpl.getGroupById();

        Assertions.assertEquals(1, result.get(1).size());
        Assertions.assertEquals(2, result.get(2).size());
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.getAllEmployees()).thenReturn(generateEmployee());

        Collection<Employee> expected = departmentServiceImpl.findAllByDepartmentId(2);

        Collection<Employee> actual = new ArrayList<>(List.of(
                new Employee("Ivan", "Ivanov", 3000, 2),
                new Employee("Maga", "Magagov", 2000, 2)
        ));

        Boolean result = expected.containsAll(actual);

        Assertions.assertTrue(result);
    }


    public List<Employee> generateEmployee() {
        return List.of(
                new Employee("Alex", "ku", 2132, 1),
            new Employee("frenk", "bu", 3000, 2),
            new Employee("Maga", "DeDak", 4000, 2)
        );
    }
}
