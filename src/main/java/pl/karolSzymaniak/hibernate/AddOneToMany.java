package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Attribute;
import pl.karolSzymaniak.hibernate.entity.Product;
import pl.karolSzymaniak.hibernate.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddOneToMany {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        //Tworzymy produkt
        Product product = entityManager.find(Product.class, 5L);

        //Tworzymy opinie
        Review review = new Review();
        review.setContent("Nowa opinia");
        review.setRating(5);

        //żeby połączyć taką opinie z produktem wystarczy, że zrobimy
        review.setProduct(product);


        //Tworzymy dodatkową metodę w produkcie, na wypadek dalszych zmian w opiniach
        product.addReview(review);

        //Zmieniamy adnotacje w enci Product na cascade=persist i ten zapis poniżej jest już niepotrzebny
        //entityManager.persist(review);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
