package com.xyinc.apipoi.models;

import com.xyinc.apipoi.rest.dtos.PointDto;
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
@Table(name = "tb_point")
public class PointModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_point")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y", nullable = false)
    private int y;

    public PointModel(PointDto pointDto) {
        BeanUtils.copyProperties(pointDto, this);
    }

    public void toDto (PointDto pointDto) {
        BeanUtils.copyProperties(pointDto, this);
    }

}
