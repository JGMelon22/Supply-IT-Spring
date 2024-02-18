package com.dpi.itsupply.service;

import com.dpi.itsupply.dto.ErroQuiqRecordDto;
import com.dpi.itsupply.model.ErroQuiq;
import com.dpi.itsupply.repository.ErroQuiqRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ErroQuiqService {
    private final ErroQuiqRepository erroQuiqRepository;

    public ErroQuiqService(ErroQuiqRepository erroQuiqRepository) {
        this.erroQuiqRepository = erroQuiqRepository;
    }

    public List<ErroQuiq> listAll() {
        return erroQuiqRepository.findAll();
    }

    public ErroQuiq findById(int id) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if (erroQuiq0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Erro do QUIQ com id \"%d\" não encontrado!", id));
        return erroQuiq0.get();
    }

    public void save(ErroQuiqRecordDto erroQuiqRecordDto) {
        ErroQuiq erroQuiq = new ErroQuiq();
        BeanUtils.copyProperties(erroQuiqRecordDto, erroQuiq);

        erroQuiqRepository.save(erroQuiq);
    }

    public ErroQuiq update(Integer id, ErroQuiqRecordDto erroQuiqRecordDto) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if (erroQuiq0.isPresent()) {
            ErroQuiq erroQuiq = erroQuiq0.get();
            BeanUtils.copyProperties(erroQuiqRecordDto, erroQuiq);
            return erroQuiqRepository.save(erroQuiq);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Erro do QUIQ com id \"%d\" não encontrado!", id));
    }

    public void delete(int id) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if (erroQuiq0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Erro do QUIQ com id \"%d\" não encontrado!", id));

        erroQuiqRepository.delete(erroQuiq0.get());
    }
}
