package sdv.b3.calonne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        // PETSHOP

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PetShop");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin(); // nécessaire pour l'écriture



        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

        // /PETSHOP
    }
}
