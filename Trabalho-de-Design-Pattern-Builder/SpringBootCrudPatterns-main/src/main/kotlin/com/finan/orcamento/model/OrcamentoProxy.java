package com.finan.orcamento.model;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class OrcamentoProxy extends OrcamentoModel {

    private BigDecimal descontoOrcamento;

    private OrcamentoModel orcamentoModel;

    private BigDecimal valorOrcamento;

    private Integer qtdItens;

    public OrcamentoProxy(OrcamentoModel orcamentoModel) {
        this.orcamentoModel = orcamentoModel;
    }
    @Override
    public BigDecimal getDescontoOrcamento() {
        if(descontoOrcamento == null){
            this.descontoOrcamento = orcamentoModel.getDescontoOrcamento();
        }
        return this.descontoOrcamento;
    }

    @Override
    public void setDescontoOrcamento(BigDecimal descontoOrcamento) {
        this.descontoOrcamento = descontoOrcamento;
    }

    public OrcamentoModel getOrcamentoModel() {
        return orcamentoModel;
    }

    public void setOrcamentoModel(OrcamentoModel orcamentoModel) {
        this.orcamentoModel = orcamentoModel;
    }

    @NotNull
    @Override
    public BigDecimal getValorOrcamento() {
        if(this.valorOrcamento == null){
            this.valorOrcamento = orcamentoModel.getValorOrcamento();
        }
        return valorOrcamento;
    }

    @Override
    public int getQtdItens() {
        if(this.qtdItens == null){
            this.qtdItens = orcamentoModel.getQtdItens();
        }
        return qtdItens;
    }
}