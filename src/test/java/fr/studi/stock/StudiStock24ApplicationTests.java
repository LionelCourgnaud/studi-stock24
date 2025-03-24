package fr.studi.stock;

import fr.studi.stock.controller.ProduitController;
import fr.studi.stock.service.ProduitService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.graalvm.nativeimage.RuntimeOptions.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProduitController.class)
class StudiStock24ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProduitService produitService;

    @Test
    public void testGetProduits() throws Exception {
        mockMvc.perform(get("/api/produit"))
                .andExpect(status().isOk());
    }
}
