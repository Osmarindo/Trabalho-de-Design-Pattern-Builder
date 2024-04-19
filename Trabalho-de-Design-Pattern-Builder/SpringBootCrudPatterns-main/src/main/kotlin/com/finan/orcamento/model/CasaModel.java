package com.finan.orcamento.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="casa")
public class CasaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="quartos")
    private int quartos;
    @Column(name="banheiros")
    private int banheiros;
    @Column(name="churrasqueira")
    private boolean churrasqueira;

    public CasaModel(int quartos, int banheiros, boolean churrasqueira) {
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.churrasqueira = churrasqueira;
    }

    public long getId() { return id; }
    public int getQuartos() {
        return quartos;
    }
    public int getBanheiros() {
        return banheiros;
    }
    public boolean isChurrasqueira() {return churrasqueira;}
}
