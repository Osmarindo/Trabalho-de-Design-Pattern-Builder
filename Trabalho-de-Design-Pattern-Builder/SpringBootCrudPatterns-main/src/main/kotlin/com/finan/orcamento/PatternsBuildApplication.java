package com.finan.orcamento;

import com.finan.orcamento.model.CasaModel;
import com.finan.orcamento.model.casa.Casa2Quartos2BanheiroChurrasqueira;
import com.finan.orcamento.model.casa.Casa2Quartos;
import com.finan.orcamento.model.casa.IBuilderCasa;
import com.finan.orcamento.repositories.service.CasaService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class PatternsBuildApplication {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(PatternsBuildApplication.class, args);
        CasaService casaService = context.getBean(CasaService.class);

        IBuilderCasa builderCasa1 = new Casa2Quartos();
        builderCasa1.buildQuartos();
        builderCasa1.buildBanheiros();
        builderCasa1.buildChurrasqueira();
        CasaModel casaModel1 = builderCasa1.getCasa();
        casaService.cadastrarCasa(casaModel1);

        System.out.println("Casa 1:");
        System.out.println("Quartos: " + casaModel1.getQuartos());
        System.out.println("Banheiros: " + casaModel1.getBanheiros());
        System.out.println("Churrasqueira: " + casaModel1.isChurrasqueira());

        System.out.println("__________________________");

        IBuilderCasa builderCasa2 = new Casa2Quartos2BanheiroChurrasqueira();
        builderCasa2.buildQuartos();
        builderCasa2.buildBanheiros();
        builderCasa2.buildChurrasqueira();
        CasaModel casaModel2 = builderCasa2.getCasa();
        casaService.cadastrarCasa(casaModel2);

        System.out.println("casa 2:");
        System.out.println("Quartos: " + casaModel2.getQuartos());
        System.out.println("Banheiros: " + casaModel2.getBanheiros());
        System.out.println("Churrasqueira: " + casaModel2.isChurrasqueira());


    }
}
