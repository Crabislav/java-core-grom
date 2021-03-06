package gromcode.main.lesson30.homework.entities;

import gromcode.main.lesson30.homework.entities.enums.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;

    private static Date dateHired = new Date();

    private Position position;
    private Department department;

    private Collection<Project> projects;

    public Employee(String firstName, Position position, Department department) {
        this.firstName = firstName;
        this.position = position;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    @Override
    public int compareTo(Employee o) {
        return this.lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return "\n\nEmployee{" +
                "\nfirstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", \nposition=" + position +
                ", \nprojects=" + projects +
                '}';
    }
}
