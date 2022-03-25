package sdv.b3.calonne.bo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private LocalDate birth;
    private String couleur;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PETSTORE")
    private PetStore petStore;

    public Animal() {

    }

    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        if(this.petStore != null) {
            this.petStore.getAnimaux().remove(this);
        }
        this.petStore = petStore;
        if(this.petStore != null) {
            this.petStore.getAnimaux().add(this);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "birth=" + birth +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
