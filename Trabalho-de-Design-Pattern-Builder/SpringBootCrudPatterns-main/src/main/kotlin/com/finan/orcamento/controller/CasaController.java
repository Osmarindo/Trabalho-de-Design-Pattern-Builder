package com.finan.orcamento.controller;

import com.finan.orcamento.model.CasaModel;
import com.finan.orcamento.repositories.CasaRepository;
import com.finan.orcamento.repositories.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/casas")
public class CasaController {
    @Autowired
    private CasaService casaService;
    @Autowired
    private CasaRepository casaRepository;

    @GetMapping
    public ResponseEntity<List<CasaModel>> buscaTodasCasas(){
        return ResponseEntity.ok(casaService.buscarCadastro());
    }
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<CasaModel>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(casaService.buscaId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CasaModel>cadastrarCasa(@RequestBody CasaModel casaModel){
        return ResponseEntity.ok(casaService.cadastrarCasa(casaModel));
    }
    @PostMapping(path="/put/{id}")
    public ResponseEntity<CasaModel>atualizaCasa(@RequestBody CasaModel casaModel, @PathVariable Long id){
        CasaModel casaNewObj= casaService.atualizaCadastro(casaModel, id);
        return ResponseEntity.ok().body(casaNewObj);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deletecasa(@PathVariable Long id){
        casaService.deleteCasa(id);
    }
}
