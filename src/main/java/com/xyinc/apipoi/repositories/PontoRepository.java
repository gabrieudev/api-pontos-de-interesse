package com.xyinc.apipoi.repositories;

import com.xyinc.apipoi.models.PontoiModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PontoRepository extends JpaRepository<PontoiModel, UUID> {
    Optional<PontoiModel> findById(UUID id);
    List<PontoiModel> findByX(int x);
    List<PontoiModel> findByY(int y);
}
