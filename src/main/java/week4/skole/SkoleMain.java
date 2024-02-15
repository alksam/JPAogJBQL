package week4.skole;

import Config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class SkoleMain {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {
        // entity is in transient state
        Student student = new Student("Michelle", "Schmidt", "schmidt@mail.com");
StudentDAO.createStudent(student);

       List<Student> students = StudentDAO.readAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------------");

        Student student1 = StudentDAO.readStudent(1);




    }
}


