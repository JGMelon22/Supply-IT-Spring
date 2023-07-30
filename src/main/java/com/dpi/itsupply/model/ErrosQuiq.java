package com.dpi.itsupply.model;

import com.dpi.itsupply.model.enums.StatusAnalise;
import com.dpi.itsupply.model.enums.StatusErro;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ErrosQuiq {
    private Integer id;
    private LocalDate dataPesquisa; // Data 2
    private String mes;
    private Integer ano;
    private LocalDateTime dataPedido;
    private LocalDateTime dataErro;
    private String plataforma;
    private Short empresa; // Pelo que parece, só vai até ~19_999
    private String numeroPedido; // Contem 0 a esquerda, por isso String
    private Integer numeroPdv;
    private Byte codigoStatus;
    private String erro;
    private String motivoErro;
    private String categoriaErro;
    private String responsavelErro;
    private StatusErro statusErro;
    private String observacao;
    private String responsavelAnalise;
    private StatusAnalise statusAnalise;
}
