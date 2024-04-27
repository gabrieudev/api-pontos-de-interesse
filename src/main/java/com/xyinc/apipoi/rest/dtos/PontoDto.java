package com.xyinc.apipoi.rest.dtos;

import com.xyinc.apipoi.models.PontoiModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PontoDto {

    private UUID id;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "X obrigatório")
    @Positive(message = "X negativo")
    private int x;

    @NotNull(message = "Y obrigatório")
    @Positive(message = "Y negativo")
    private int y;

    public PontoDto(PontoiModel pontoiModel) {
        BeanUtils.copyProperties(pontoiModel, this);
    }

    public void toModel (PontoiModel pontoiModel) {
        BeanUtils.copyProperties(pontoiModel, this);
    }

}
