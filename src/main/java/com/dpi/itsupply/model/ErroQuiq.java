package com.dpi.itsupply.model;

import com.dpi.itsupply.model.enums.Mes;
import com.dpi.itsupply.model.enums.Plataforma;
import com.dpi.itsupply.model.enums.StatusAnalise;
import com.dpi.itsupply.model.enums.StatusErro;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "erros_quiq", indexes = @Index(name = "idx_erros_quiq_id", columnList = "id"))
public class ErroQuiq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_padronizada", columnDefinition = "DATE", nullable = false)
    private LocalDate dataPadronizada; // Data 2

    @Column(name = "mes", columnDefinition = "ENUM", nullable = false)
    @Enumerated(EnumType.STRING)
    private Mes mes;

    @Column(name = "ano", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    private Integer ano;

    @Column(name = "data_pedido", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "data_erro", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime dataErro;

    @Column(name = "plataforma", columnDefinition = "ENUM", nullable = false)
    @Enumerated(EnumType.STRING)
    private Plataforma plataforma;

    @Column(name = "codigo_empresa", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    private Short empresa; // Pelo que parece, só vai até ~19_999

    @Column(name = "numero_pedido", columnDefinition = "VARCHAR(10)", nullable = false)
    private String numeroPedido; // Contem 0 a esquerda, por isso String

    @Column(name = "numero_pdv", columnDefinition = "INT", nullable = false)
    private Integer numeroPdv;

    @Column(name = "codigo_status", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    private Byte codigoStatus;

    @Column(name = "nome_erro", columnDefinition = "VARCHAR(100)", nullable = false)// Talvez mudar para um Enum
    private String erro;

    @Column(name = "motivo_erro", columnDefinition = "VARCHAR(100) DEFAULT 'EM_ANALISE'", nullable = false)
    private String motivoErro;

    @Column(name = "categoria_erro", columnDefinition = "VARCHAR(100) DEFAULT 'EM_ANALISE'", nullable = false)
    private String categoriaErro;

    @Column(name = "responsavel_erro", columnDefinition = "VARCHAR(20) DEFAULT 'Em Análise'", nullable = false)
    private String responsavelErro;

    @Column(name = "status_erro", columnDefinition = "ENUM DEFAULT 'EM_ANALISE'")
    @Enumerated(EnumType.STRING)
    private StatusErro statusErro;

    @Column(name = "observacao", columnDefinition = "VARCHAR(255)", nullable = false)
    private String observacao;

    @Column(name = "responsavel_analise", columnDefinition = "VARCHAR(20)", nullable = true)
    private String responsavelAnalise;

    @Column(name = "status_analise", columnDefinition = "ENUM DEFAULT 'EM_ANALISE'")
    @Enumerated(EnumType.STRING)
    private StatusAnalise statusAnalise;
}
