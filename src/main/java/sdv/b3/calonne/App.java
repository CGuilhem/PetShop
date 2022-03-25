package sdv.b3.calonne;

import sdv.b3.calonne.bo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

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

        // Insertion d'enregistrements
        PetStore store1 = new PetStore("Animalerie", "Dupont");
        store1.setAddress(new Address("78", "Rue Beauvais", "78120", "Rambouillet", store1));
        store1.addAnimal(new Cat(LocalDate.now(), "rouge", store1, "001"));
        store1.addAnimal(new Cat(LocalDate.now(), "marron", store1, "002"));
        store1.addAnimal(new Fish(LocalDate.now(), "rouge", store1, FishLivEnv.FRESH_WATER));
        Product gel = new Product("code2", "gel", 8.70, ProdType.CLEANING);
        gel.addPetStore(store1);
        Product shampooing = new Product("code1", "shampoing", 7.70, ProdType.CLEANING);
        shampooing.addPetStore(store1);
        store1.addProduit(gel);
        store1.addProduit(shampooing);



        em.persist(store1);

        // Extraire tous les animaux d'une animalerie
        TypedQuery<Animal> queryAnimaux = em.createQuery("select a from Animal a where a.petStore.id=4", Animal.class);
        List<Animal> listeAnimaux = queryAnimaux.getResultList();

        for (Animal item : listeAnimaux) {
            System.out.println(item.toString());
        }

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

        // /PETSHOP
    }
}
