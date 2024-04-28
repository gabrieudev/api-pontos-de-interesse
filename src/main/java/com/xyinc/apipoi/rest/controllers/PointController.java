package com.xyinc.apipoi.rest.controllers;

import com.xyinc.apipoi.rest.dtos.PointDto;
import com.xyinc.apipoi.services.PointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/points")
public class PointController {

    @Autowired
    PointService pointService;

    @PostMapping()
    public ResponseEntity<Object> save(@Valid @RequestBody PointDto pointDto) {
        pointService.save(pointDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Object> update(@Valid @RequestBody PointDto pointDto) {
        return ResponseEntity.status(HttpStatus.OK).body(pointService.update(pointDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne (@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(pointService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PointDto>> getAll () {
        return ResponseEntity.status(HttpStatus.OK).body(pointService.getAll());
    }

    @GetMapping("/{x}/{y}/{dMax}")
    public ResponseEntity<List<PointDto>> getNearby (@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("dMax") int dMax) {
        return ResponseEntity.status(HttpStatus.OK).body(pointService.getNearby(x, y, dMax));
    }

}
