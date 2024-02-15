package week4.GLS;

import Config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PackageDAO {
    private EntityManager entityManager;

    public PackageDAO() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        entityManager = emf.createEntityManager();
    }

    public PackageGLS create (PackageGLS p ) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        return p;
    }

    public PackageGLS read (int id) {
        return entityManager.find(PackageGLS.class, id);
    }

    public PackageGLS readByTrackingNumber (String trackingNumber) {
        return entityManager.createQuery("SELECT p FROM PackageGLS p WHERE p.trackingNumber = :trackingNumber", PackageGLS.class)
                .setParameter("trackingNumber", trackingNumber)
                .getSingleResult();
    }
    public PackageGLS update (PackageGLS p) {
        entityManager.getTransaction().begin();
        PackageGLS updatedPackage = entityManager.merge(p);
        entityManager.getTransaction().commit();
        return updatedPackage;
    }

    public void delete (int id) {
        entityManager.getTransaction().begin();
        PackageGLS p = read(id);
        if (p != null) {
            entityManager.remove(p);
        }
        entityManager.getTransaction().commit();
    }

    public void persistPackage(PackageGLS p) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }
}
