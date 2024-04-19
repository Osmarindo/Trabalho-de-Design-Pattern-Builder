package com.finan.orcamento.repositories.service;

import com.finan.orcamento.model.CasaModel;
import com.finan.orcamento.repositories.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CasaService {
    @Autowired
    private CasaRepository casaRepository;

    public List<CasaModel> buscarCadastro() { return casaRepository.findAll(); }
    public CasaModel buscaId(Long id){
        Optional<CasaModel>obj= casaRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new RuntimeException("Casa não encontrada");
        }
    }
    public CasaModel cadastrarCasa(CasaModel casaModel){

        casaModel.getQuartos();
        casaModel.getBanheiros();
        casaModel.isChurrasqueira();
        return casaRepository.save(casaModel);
    }

    public CasaModel atualizaCadastro(CasaModel casaModel, Long id){
        CasaModel newCasamodel = buscaId(id);
        newCasamodel.getBanheiros();
        newCasamodel.getQuartos();
        newCasamodel.isChurrasqueira();
        return casaRepository.save(newCasamodel);
    }
    public void deleteCasa(Long id){
        casaRepository.deleteById(id);
    }
}
