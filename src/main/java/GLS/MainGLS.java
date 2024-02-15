package GLS;

import Config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;

public class MainGLS {

    public static void main(String[] args) {
        // TODO code application logic here

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        var em = emf.createEntityManager();
        em.getTransaction().begin();

        PackageDAO packageDAO = new PackageDAO();
        PackageGLS p = new PackageGLS();

        p.setTrackingNumber("ABC123");
        p.setSenderName("Sender");
        p.setReceiverName("Receiver");
        p.setDeliveryStatus(PackageGLS.DeliveryStatus.PENDING);
        p.getLastUpdated();

        em.persist(p);


        System.out.println("Package created: " + p);
        System.out.println("---------------------------------------------------------------");
        PackageGLS p2 =new PackageGLS();
        p2.setTrackingNumber("DEF456");
        p2.setSenderName("Sender2");
        p2.setReceiverName("Receiver2");
        p2.setDeliveryStatus(PackageGLS.DeliveryStatus.IN_TRANSIT);
        p2.getLastUpdated();

        em.persist(p2);



        System.out.println("Package created: " + p2);
        System.out.println("find page by tracking number: " + packageDAO.readByTrackingNumber("DEF456"));
        System.out.println("---------------------------------------------------------------");
        em.getTransaction().commit();
        em.close();


    }


}
