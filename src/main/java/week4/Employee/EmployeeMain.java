package week4.Employee;



import jakarta.persistence.EntityManagerFactory;
import Config.HibernateConfig;

public class EmployeeMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        var em = emf.createEntityManager();



        em.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        // Write a JPQL query to select employees with a salary greater than a certain value.
        em.createQuery("SELECT e FROM Employee e WHERE e.salary > 1000", Employee.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        em.createQuery("SELECT e FROM Employee e WHERE e.department = 'IT'", Employee.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        em.createQuery("SELECT e FROM Employee e WHERE e.firstname = 'John'", Employee.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        em.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                .getResultList()
                .forEach(System.out::println);







    }
}
