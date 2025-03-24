package fr.studi.stock.service.impl;

import fr.studi.stock.pojo.Produit;
import fr.studi.stock.repository.ProduitRepository;
import fr.studi.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

//    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return this.produitRepository.findAll();
    }
}
