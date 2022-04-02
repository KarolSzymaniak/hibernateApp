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

public class CreateApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = new Product();
        product.setName("Rower01");
        product.setDescription("Opis produktu 01");
        product.setCreated(LocalDateTime.now());
        product.setCreated(LocalDateTime.now());
        product.setPrice(new BigDecimal("19.99"));
        product.setProductType(ProductType.REAL);


        entityManager.persist(product);

        logger.info(product);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
