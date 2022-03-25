package sdv.b3.calonne.bo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String name;
    private String managerName;

    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animaux;
    {
        animaux = new HashSet<>();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="PS_PROD", //Nom de la table d'association qui va être créée pour lier les deux id (id_petshop et id_product
            joinColumns= @JoinColumn(name="id_petshop", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="id_product", referencedColumnName="ID"))
    private List<Product> products;
    {
        products = new ArrayList<>();
    }

    @OneToOne
    private Address address;

    public PetStore() {

    }

    public PetStore(String name, String managerName, Set<Animal> animaux, List<Product> products, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.animaux = animaux;
        this.products = products;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAnimal(Animal animal) {
        if(animal != null) {
            animal.setPetStore(this);
        }
    }

    public void addProduit( Product product ) {
        if(product != null) {
            product.addPetStore(this);
        }
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", animaux=" + animaux +
                ", products=" + products +
                '}';
    }
}
