package pl.karolSzymaniak.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType productType;

//    @OneToMany
//    @JoinColumn(name = "product_id")
//    private List<Review> reviews;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Review> reviews = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = { @JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn( name = "attribute_id")})
    private List<Attribute> attributes = new ArrayList<>();


    public void addAttributes(Attribute attribute) {
    attributes.add(attribute);

    //po drugiej stronie relacji także dodajemy ten atrybut
        attribute.getProducts().add(this);
    }


    public void addReview(Review review) {
        reviews.add(review);
        //Teraz musimy dodać do produktu
        review.setProduct(this);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Attribute> getAttribute() {
        return attributes;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attributes = attribute;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", price=" + price +
                ", productType=" + productType +
//                ", reviews=" + reviews +
                '}';
    }

}
