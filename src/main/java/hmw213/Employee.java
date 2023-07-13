package hmw213;


import java.util.Objects;
import java.util.stream.IntStream;

public class Employee {
    private static int correntId = 1;
    private String firstName;
    private String lastName;
    private int salary;
    private int id;
    private int deportamentId;



    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getDeportamentId() {
        return deportamentId;
    }

    public int getCorrentId() {
        return correntId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDeportamentId(int deportamentId) {
        this.deportamentId = deportamentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee(String firstName, String lastName, int salary, int deportamentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.deportamentId = deportamentId;
        this.id = correntId++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && deportamentId == employee.deportamentId && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, deportamentId);
    }
}
