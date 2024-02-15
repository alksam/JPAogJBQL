package skole;

import Config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class StudentDAO {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();


    public static void createStudent(Student student) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            // entity is in managed state (after persist)
            em.persist(student);
            // entity is in detached state after the transaction is committed
            em.getTransaction().commit();
        }
    }

    public static Student readStudent(int id){
        try(EntityManager em = emf.createEntityManager()) {
            return em.find(Student.class, id);
        }
    }


    public static Student updateStudent(Student up){
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student student = em.find(Student.class, up.getId());
            student.setName(up.getName());
            student.setDescription(up.getDescription());
            student.setEmail(up.getEmail());
            em.getTransaction().commit();
            return student;
        }
    }

    public static List<Student> readAllStudents(){
        try(EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        }
    }

    public static void deleteStudent(int id){
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            em.remove(student);
            em.getTransaction().commit();
        }
    }



}
