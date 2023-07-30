package com.dpi.itsupply.service;

import com.dpi.itsupply.model.ErroQuiq;
import com.dpi.itsupply.repository.ErroQuiqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErroQuiqService {
    @Autowired
    private ErroQuiqRepository erroQuiqRepository;

    public List<ErroQuiq> listAll() {
        return erroQuiqRepository.findAll();
    }
}
