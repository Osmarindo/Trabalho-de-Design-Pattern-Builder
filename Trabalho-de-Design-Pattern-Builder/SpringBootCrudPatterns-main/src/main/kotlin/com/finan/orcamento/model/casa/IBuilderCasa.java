package com.finan.orcamento.model.casa;

import com.finan.orcamento.model.CasaModel;

public interface IBuilderCasa {
    void buildQuartos();
    void buildBanheiros();
    void buildChurrasqueira();
    CasaModel getCasa();
}
