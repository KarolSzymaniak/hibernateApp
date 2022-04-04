package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Product;
import pl.karolSzymaniak.hibernate.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OneToManyBidirectionalApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        //Pobieranie danych z tabeli review w JPA
        List<Review> reviews = entityManager.createQuery("select r from Review r").getResultList();
        for (Review review :reviews ){
            logger.info(review);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
