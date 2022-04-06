package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Attribute;
import pl.karolSzymaniak.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        logger.info(product);

        logger.info(product.getAttribute());

        logger.info("########################");
        Attribute attribute = entityManager.find(Attribute.class, 1L);
        logger.info(attribute);
        logger.info(attribute.getProducts());

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
