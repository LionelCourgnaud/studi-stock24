package fr.studi.stock.service;

import fr.studi.stock.pojo.Produit;
import jakarta.validation.Valid;

import java.util.List;

public interface ProduitService {
    public List<Produit> getAllProduits();

    void createProduit(@Valid Produit produit);

    void updateProduit(Long id, Produit produit);

    Produit getProduitById(Long id);

    void deleteById(Long id);

    void updateProduitQuantity(Long produitId, Integer quantite);
}
