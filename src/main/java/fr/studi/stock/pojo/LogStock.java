package fr.studi.stock.pojo;

import fr.studi.stock.pojo.state.Action;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="log")
public class LogStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;     //  01/02/2025 12:00:00

    @Enumerated(EnumType.STRING)
    private Action action;

    private Long produit_Id;

    private Integer quantite;

    public LogStock() {
    }
}
