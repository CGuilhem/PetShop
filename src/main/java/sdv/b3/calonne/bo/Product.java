package sdv.b3.calonne.bo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String code;
    private String label;
    private Double price;
    private ProdType type;

    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;
    {
        petStores = new HashSet<>();
    }

    public Product() {

    }

    public Product(String code, String label, Double price, ProdType type) {
        this.code = code;
        this.label = label;
        this.price = price;
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    public void addPetStore(PetStore petStore) {
        if(petStore != null) {
            petStores.add(petStore);
            petStore.getProducts().add(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", petStores=" + petStores +
                '}';
    }
}
