package pl.karolSzymaniak.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.karolSzymaniak.hibernate.entity.Attribute;
import pl.karolSzymaniak.hibernate.entity.Category;
import pl.karolSzymaniak.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddManyToManyApp {
    private static Logger logger = LogManager.getLogger();
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        Product product = entityManager.find(Product.class, 5L);

        //Nie możemy zrobić w ten sposób, ponieważ nadpiszemy atrybuty i te, które już miał produkt zostaną utracone
        //product.setAttribute();

        //wybieramy pierwszy atrybut
        //Attribute attribute = entityManager.find(Attribute.class, 1L);

        //Tworzymy metodę, która doda nam artybuty do już istniejących
       // product.addAttributes(attribute);


        //Tworzymy nowy atrybut
        Attribute attribute= new Attribute();
        attribute.setName("color");
        attribute.setValue("black");

        //Możemy zapisać przez persist, ale możemy zapisać kaskadowo, robiąc zmianę w adnotacji encji Product przy atrybutach

        product.addAttributes(attribute);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
