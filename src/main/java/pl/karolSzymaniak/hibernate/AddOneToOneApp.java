package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Category;
import pl.karolSzymaniak.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddOneToOneApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
//Zmiana kategori na 2 dla produktu 3
//        Product product = entityManager.find(Product.class, 3L);
//        Category category = entityManager.find(Category.class, 2L);
//        product.setCategory(category);

        //dodajemy nową kategorię i sprawdzamy
        Product product = entityManager.find(Product.class, 3L);
        Category category = new Category();
        category.setName("Nowa kategoria");
        category.setDescription("Opis");
        //najpierw zapisujemy kategorię
        entityManager.persist(category);
        //potem dodajemy do produktu
        product.setCategory(category);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
