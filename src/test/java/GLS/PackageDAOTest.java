package GLS;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PackageDAOTest {
    private static EntityManager entityManager;
    private static PackageDAO packageDAO;

    @BeforeAll
    public static void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gls-persistence-unit");
        entityManager = emf.createEntityManager();
        packageDAO = new PackageDAO();
    }

    @AfterAll
    public static void tearDown() {
        entityManager.close();
    }

    @Test
    public void testPersistPackage() {
        PackageGLS pkg = new PackageGLS();
        pkg.setTrackingNumber("ABC123");
        pkg.setSenderName("Sender");
        pkg.setReceiverName("Receiver");
        pkg.setDeliveryStatus(PackageGLS.DeliveryStatus.PENDING);

        packageDAO.persistPackage(pkg);

        // Retrieve the package from the database and assert its existence
        Package retrievedPackage = entityManager.find(Package.class, pkg.getId());
        assertNotNull(retrievedPackage);
        assertEquals("ABC123", retrievedPackage.getImplementationTitle());
    }
}