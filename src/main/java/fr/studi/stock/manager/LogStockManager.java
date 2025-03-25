package fr.studi.stock.manager;

import fr.studi.stock.pojo.LogStock;
import fr.studi.stock.pojo.Produit;
import fr.studi.stock.service.LogStockService;
import fr.studi.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogStockManager {

    @Autowired
    private LogStockService logStockService;

    @Autowired
    private ProduitService produitService;

    public void processLogStock(LogStock logStock) {
        // 1. Intégration du log
        this.logStockService.createLogStock(logStock);

        // 2. Mis en place de la modification
        switch (logStock.getAction()) {
            case AJOUT -> {
                this.produitService.createProduit(new Produit());
            }
            case SUPPRESSION -> {
                this.produitService.deleteById(logStock.getId());
            }
            case MODIDIFICATION -> {
                this.produitService.updateProduitQuantity(logStock.getProduit_Id(), logStock.getQuantite());
            }
            default -> throw new IllegalStateException("Unexpected value: " + logStock.getAction());
        }
    }

}
