package lesson8.home2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Course[] coursesTaken = {};

        Demo demo = new Demo();

        Student student = demo.createHighestParent("Alex", "Kopnin", 1, coursesTaken);
        SpecialStudent specialStudent = demo.createLowestChild("Andrey", "Petrov", 2, coursesTaken, 5464, "example@mail.com");

        System.out.println("createHighestParent result : " + student.firstName + " " + student.lastName);
        System.out.println("createLowestChild result : " + specialStudent.firstName + " " + specialStudent.lastName);
    }

    public Student createHighestParent(String firstName, String lastName, int group, Course[] coursesTaken) {
        return new Student(firstName, lastName, group, coursesTaken);
    }

    public SpecialStudent createLowestChild(String firstName, String lastName, int group, Course[] coursesTaken,
                                            long secretKey, String email) {
        return new SpecialStudent(firstName, lastName, group, coursesTaken, secretKey, email);
    }
}
