package com.xyinc.apipoi.rest.controllers;

import com.xyinc.apipoi.rest.dtos.PontoDto;
import com.xyinc.apipoi.services.PoiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/pontos")
public class PontoController {

    @Autowired
    PoiService poiService;

    @PostMapping()
    public ResponseEntity<Object> save(@Valid @RequestBody PontoDto pontoDto) {
        poiService.salvar(pontoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Object> update(@Valid @RequestBody PontoDto pontoDto) {
        return ResponseEntity.status(HttpStatus.OK).body(poiService.atualizar(pontoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne (@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(poiService.obterPorId(id));
    }

    @GetMapping()
    public ResponseEntity<List<PontoDto>> getAll () {
        return ResponseEntity.status(HttpStatus.OK).body(poiService.obterPois());
    }

    @GetMapping("/{x}/{y}/{distanciaMax}")
    public ResponseEntity<List<PontoDto>> getNearby (@PathVariable("x") int x, @PathVariable("y") int y, @PathVariable("distanciaMax") int distanciaMax) {
        return ResponseEntity.status(HttpStatus.OK).body(poiService.obterProximos(x, y, distanciaMax));
    }

}
