package com.xyinc.apipoi.rest.dtos;

import com.xyinc.apipoi.models.PointModel;
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
public class PointDto {

    private UUID id;

    @NotBlank(message = "Name mandatory")
    private String name;

    @NotNull(message = "X mandatory")
    @Positive(message = "X negative")
    private int x;

    @NotNull(message = "Y mandatory")
    @Positive(message = "Y negative")
    private int y;

    public PointDto(PointModel pointModel) {
        BeanUtils.copyProperties(pointModel, this);
    }

    public void toModel (PointModel pointModel) {
        BeanUtils.copyProperties(pointModel, this);
    }

}
