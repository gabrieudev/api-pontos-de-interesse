package com.xyinc.apipoi.services;

import com.xyinc.apipoi.exception.ObjectNotFoundException;
import com.xyinc.apipoi.models.PontoiModel;
import com.xyinc.apipoi.repositories.PontoRepository;
import com.xyinc.apipoi.rest.dtos.PontoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PoiService {

    @Autowired
    PontoRepository pontoRepository;

    /**
     * salva um ponto de interesse
     *
     * @param pontoDto DTO do ponto de interesse
     */
    public void salvar (PontoDto pontoDto) {
        PontoiModel pontoiModel = new PontoiModel(pontoDto);
        pontoRepository.save(pontoiModel);
    }

    /**
     * atualiza um ponto de interesse existente
     *
     * @param pontoDto DTO do ponto de interesse a ser atualizado
     * @return DTO do ponto de interesse atualizado
     * @throws ObjectNotFoundException caso o ponto de interesse não exista
     */
    public PontoDto atualizar (PontoDto pontoDto) {
        PontoDto pontoDto1 = obterPorId(pontoDto.getId());
        pontoDto1 = pontoDto;
        salvar(pontoDto1);
        return pontoDto1;
    }

    /**
     * obtém um ponto de interesse de acordo com um id
     *
     * @param id id do ponto de interesse
     * @return DTO do ponto de interesse correspondente
     * @throws ObjectNotFoundException caso o ponto de interesse não exista
     */
    public PontoDto obterPorId (UUID id) {
        Optional<PontoiModel> poiModel = pontoRepository.findById(id);
        poiModel.orElseThrow(() -> new ObjectNotFoundException("POI não encontrado"));
        return new PontoDto(poiModel.get());
    }

    /**
     * Obtém todos os pontos de interesse registrados
     *
     * @return List de todos os pontos de interesse
     */
    public List<PontoDto> obterPois () {
        List<PontoiModel> listaPontoiModel = pontoRepository.findAll();
        return listaPontoiModel.stream().map(PontoDto::new).toList();
    }

    /**
     * deleta um ponto de interesse de acordo com o id
     *
     * @param id id do ponto de interesse
     */
    public void deletar (UUID id) {
        Optional<PontoiModel> poiModel = pontoRepository.findById(id);
        poiModel.orElseThrow(() -> new ObjectNotFoundException("Ponto não encontrado"));
        pontoRepository.delete(poiModel.get());
    }

    /**
     * obtém todos os pontos de interesse prómixos
     *
     * @param x coordenada x do ponto de referência
     * @param y coordenada y do ponto de referência
     * @param distanciaMax distância máxima dos pontos de interesse
     * @return List de todos os pontos de interesse correspondentes
     */
    public List<PontoDto> obterProximos (int x, int y, int distanciaMax) {
        if (distanciaMax < 0) {
            throw new DataIntegrityViolationException("");
        }
        List<PontoDto> todosPontos = obterPois();
        return todosPontos.stream()
                .filter(ponto -> {
                    double distancia = Math.sqrt(Math.pow((ponto.getX() - x), 2) + Math.pow((ponto.getY() - y), 2));
                    return distancia < distanciaMax;
                })
                .collect(Collectors.toList());
    }

}
