package fr.studi.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.studi.stock.controller.ProduitController;
import fr.studi.stock.pojo.Produit;
import fr.studi.stock.service.ProduitService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProduitController.class)
class StudiStock24ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProduitService produitService;

    @Test
    public void testGetProduits() throws Exception {
        mockMvc.perform(get("/api/produit"))
                .andExpect(status().isOk());
    }

    @Test
    public void createProduit() throws Exception {
        Produit produit = new Produit("épée courte", "épée créée par des Elfes. Son nom est Edwillyn", 20,1);
        mockMvc.perform(post("/api/produit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produit)))
                .andExpect(status().isOk());
    }
}