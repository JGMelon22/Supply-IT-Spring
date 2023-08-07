package com.dpi.itsupply.service;

import com.dpi.itsupply.dto.ErroQuiqRecordDto;
import com.dpi.itsupply.dto.UpdateErroQuiqRecordDto;
import com.dpi.itsupply.model.ErroQuiq;
import com.dpi.itsupply.repository.ErroQuiqRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Beans;
import java.util.List;
import java.util.Optional;

@Service
public class ErroQuiqService {
    @Autowired
    private ErroQuiqRepository erroQuiqRepository;

    public List<ErroQuiq> listAll() {
        return erroQuiqRepository.findAll();
    }

    public ErroQuiq findById(int id) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if (erroQuiq0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro do QUIQ não encontrado!");
        return erroQuiq0.get();
    }

    public void save(ErroQuiqRecordDto erroQuiqRecordDto) {
        ErroQuiq erroQuiq = new ErroQuiq();
        BeanUtils.copyProperties(erroQuiq, erroQuiqRecordDto);
        save(erroQuiqRecordDto);
    }

    public ErroQuiq update(Integer id, UpdateErroQuiqRecordDto updateErroQuiqRecordDto) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if(erroQuiq0.isPresent())
            erroQuiq0.get();

        ErroQuiq erroQuiq = erroQuiq0.get();
        BeanUtils.copyProperties(updateErroQuiqRecordDto, erroQuiq);

        return erroQuiqRepository.save(erroQuiq);
    }

    public void delete(int id) {
        Optional<ErroQuiq> erroQuiq0 = erroQuiqRepository.findById(id);
        if (erroQuiq0.isPresent())
            erroQuiq0.get();
    }
}
