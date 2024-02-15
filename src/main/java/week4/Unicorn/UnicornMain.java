package week4.Unicorn;

public class UnicornMain
    {
        public static void main(String[] args)
        {
            // Create
            UnicornDAO unicornDAO = new UnicornDAO();

            // Create
            Unicorn newUnicorn = new Unicorn();
            newUnicorn.setName("Sparkle");
            newUnicorn.setAge(5);
            newUnicorn.setPowerStrength(90);
            Unicorn createdUnicorn = unicornDAO.save(newUnicorn);



            // Read
            Unicorn foundUnicorn = unicornDAO.findById(createdUnicorn.getId());
            System.out.println("Found Unicorn: " + foundUnicorn.getName());

            // Update
            foundUnicorn.setAge(6);
            Unicorn updatedUnicorn = unicornDAO.update(foundUnicorn);
            System.out.println("Updated Unicorn Age: " + updatedUnicorn.getAge());

            // Delete
           //unicornDAO.delete(createdUnicorn.getId());

            unicornDAO.close();
        }
    }
