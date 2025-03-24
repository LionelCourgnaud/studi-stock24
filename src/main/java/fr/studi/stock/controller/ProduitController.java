package fr.studi.stock.controller;

import fr.studi.stock.pojo.Produit;

import fr.studi.stock.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/produit")
@RestController
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public void createProduit(@Valid @RequestBody Produit produit) {
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return this.produitService.getAllProduits();
    }
}
