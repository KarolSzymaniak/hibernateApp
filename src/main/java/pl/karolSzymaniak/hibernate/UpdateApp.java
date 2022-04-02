package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class UpdateApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);
        product.setPrice(new BigDecimal("20.99"));

        Product merged = entityManager.merge(product);
        logger.info(merged);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
