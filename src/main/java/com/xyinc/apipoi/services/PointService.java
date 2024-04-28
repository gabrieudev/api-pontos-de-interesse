package com.xyinc.apipoi.services;

import com.xyinc.apipoi.exception.ObjectNotFoundException;
import com.xyinc.apipoi.models.PointModel;
import com.xyinc.apipoi.repositories.PointRepository;
import com.xyinc.apipoi.rest.dtos.PointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PointService {

    @Autowired
    PointRepository pointRepository;

    /**
     * save a POI
     *
     * @param pointDto POI's DTO
     */
    public void save(PointDto pointDto) {
        PointModel pointModel = new PointModel(pointDto);
        pointRepository.save(pointModel);
    }

    /**
     * update an existing POI
     *
     * @param pointDto DTO of the POI to be updated
     * @return DTO of the POI updated
     * @throws ObjectNotFoundException if the POI does not exist
     */
    public PointDto update(PointDto pointDto) {
        PointDto pointDto1 = getById(pointDto.getId());
        pointDto1 = pointDto;
        save(pointDto1);
        return pointDto1;
    }

    /**
     * get a POI according to an id
     *
     * @param id POI's id
     * @return DTO of the corresponding POI
     * @throws ObjectNotFoundException if the POI does not exist
     */
    public PointDto getById(UUID id) {
        Optional<PointModel> pointModel = pointRepository.findById(id);
        pointModel.orElseThrow(() -> new ObjectNotFoundException("Point not found"));
        return new PointDto(pointModel.get());
    }

    /**
     * get all registered POIs.
     *
     * @return List of all POIs
     */
    public List<PointDto> getAll() {
        List<PointModel> pointModelList = pointRepository.findAll();
        return pointModelList.stream().map(PointDto::new).toList();
    }

    /**
     * delete a POI according to an id
     *
     * @param id POI's id
     */
    public void delete(UUID id) {
        Optional<PointModel> pointModel = pointRepository.findById(id);
        pointModel.orElseThrow(() -> new ObjectNotFoundException("Point not found"));
        pointRepository.delete(pointModel.get());
    }

    /**
     * get all nearby POIs
     *
     * @param x X coordinate of the reference point
     * @param y y coordinate of the reference point
     * @param dMax max distance (in meters) of the POIs
     * @return List of all corresponding POIs
     */
    public List<PointDto> getNearby(int x, int y, int dMax) {
        if (dMax < 0) {
            throw new DataIntegrityViolationException("");
        }
        List<PointDto> allPoints = getAll();
        return allPoints.stream()
                .filter(point -> {
                    double distance = Math.sqrt(Math.pow((point.getX() - x), 2) + Math.pow((point.getY() - y), 2));
                    return distance < dMax;
                })
                .collect(Collectors.toList());
    }

}
