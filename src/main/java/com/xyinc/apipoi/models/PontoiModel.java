package com.xyinc.apipoi.models;

import com.xyinc.apipoi.rest.dtos.PontoDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_poi")
public class PontoiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_poi")
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y", nullable = false)
    private int y;

    public PontoiModel(PontoDto pontoDto) {
        BeanUtils.copyProperties(pontoDto, this);
    }

    public void toDto (PontoDto pontoDto) {
        BeanUtils.copyProperties(pontoDto, this);
    }

}
