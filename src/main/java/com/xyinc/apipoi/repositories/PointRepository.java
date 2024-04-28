package com.xyinc.apipoi.repositories;

import com.xyinc.apipoi.models.PointModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PointRepository extends JpaRepository<PointModel, UUID> {
    Optional<PointModel> findById(UUID id);
    List<PointModel> findByX(int x);
    List<PointModel> findByY(int y);
}
