package com.dpi.itsupply.controller;

import com.dpi.itsupply.dto.ErroQuiqRecordDto;
import com.dpi.itsupply.model.ErroQuiq;
import com.dpi.itsupply.service.ErroQuiqService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/erros-quiq/{id}")
    public ResponseEntity<ErroQuiq> getOneErroQuiqById(@PathVariable(value = "id") Integer id) {
        ErroQuiq erroQuiq = erroQuiqService.findById(id);
        return erroQuiq != null
                ? ResponseEntity.status(HttpStatus.OK).body(erroQuiq)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/erros-quiq/")
    public ResponseEntity<ErroQuiq> saveErroQuiq(@RequestBody @Valid ErroQuiqRecordDto erroQuiqRecordDto) {
        erroQuiqService.save(erroQuiqRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/erro-quiq/{id}")
    public ResponseEntity<ErroQuiq> updateErroQuiq(@PathVariable(value = "id") Integer id,
                                                   @RequestBody @Valid ErroQuiqRecordDto erroQuiqRecordDto) {
        ErroQuiq erroQuiq = erroQuiqService.findById(id);
        return erroQuiq != null
                ? ResponseEntity.status(HttpStatus.OK).body(erroQuiqService.update(id, erroQuiqRecordDto))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/erros-quiq/{id}")
    public ResponseEntity<ErroQuiq> deleteErroQuiq(@PathVariable(value = "id") Integer id) {
        if (id == null || id <= 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        erroQuiqService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
