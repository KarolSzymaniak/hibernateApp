package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Product;
import pl.karolSzymaniak.hibernate.entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OneToManyApp {

    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        //Pobieranie danych z tabeli Product w JPA
        List<Product> products = entityManager.createQuery("select p from Product p").getResultList();
        for (Product product :products ){
            logger.info(product);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
