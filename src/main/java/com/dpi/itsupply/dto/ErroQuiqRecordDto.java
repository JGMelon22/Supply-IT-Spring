package com.dpi.itsupply.dto;

import com.dpi.itsupply.model.enums.Mes;
import com.dpi.itsupply.model.enums.Plataforma;
import com.dpi.itsupply.model.enums.StatusAnalise;
import com.dpi.itsupply.model.enums.StatusErro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErroQuiqRecordDto(@NotNull LocalDate dataPadronizada, @NotNull Mes mes, @NotNull Integer ano,
                                @NotNull LocalDateTime dataPedido, @NotNull LocalDateTime dataErro,
                                @NotNull Plataforma plataforma, @NotNull Short empresa, @NotBlank String numeroPedido,
                                @NotNull Integer numeroPdv, @NotNull Byte codigoStatus, @NotBlank String erro,
                                @NotBlank String motivoErro, @NotBlank String responsavelErro,
                                @NotNull StatusErro statusErro, @NotBlank String observacao,
                                @NotBlank String responsavelAnalise, @NotNull StatusAnalise statusAnalise) {
}
