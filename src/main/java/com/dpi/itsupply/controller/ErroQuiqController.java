package com.dpi.itsupply.controller;

import com.dpi.itsupply.model.ErroQuiq;
import com.dpi.itsupply.service.ErroQuiqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ErroQuiqController {
    @Autowired
    private ErroQuiqService erroQuiqService;

    @GetMapping("/erros-quiq")
    public ResponseEntity<List<ErroQuiq>> getAllErrosQuiq() {

        List<ErroQuiq> errosQuiq = erroQuiqService.listAll();
        return errosQuiq.isEmpty()
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.OK).body(errosQuiq);
    }
}
