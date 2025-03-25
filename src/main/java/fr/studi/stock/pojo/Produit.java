package fr.studi.stock.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produit_Id;

    @Size(min = 5, max = 50, message = "La taille doit être au minimum de 5 caractères")
    private String nom;
    private String description;
    private float prix;
    private Integer quantite;

    public Produit(String nom, String description, float prix, Integer quantite) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit() {

    }
}
