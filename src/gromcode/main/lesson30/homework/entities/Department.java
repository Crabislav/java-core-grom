package gromcode.main.lesson30.homework.entities;

import gromcode.main.lesson30.homework.entities.enums.DepartmentType;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
    private DepartmentType type;
    private Collection<Employee> employees;

    public Department(DepartmentType type) {
        this.type = type;
        this.employees = new ArrayList<>();
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "\n\nDepartment\n{" +
                "type=" + type +
                ", \nemployees=" + employees +
                '}';
    }
}
