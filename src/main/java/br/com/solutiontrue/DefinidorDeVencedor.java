package br.com.solutiontrue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DefinidorDeVencedor {


    public List<ResultadoCotacao> definirVencedores(List<ItemCotacao> cotacoes, List<Atualizacao> atualizacoes) {

        /*
            TODO - implementar
             o programador que implementou essa rotina não é preguiçoso o suficiente, pois ele só resolveu
             o caso de exemplo
             por favor, implemente a solução definitiva para qualquer conjunto de dados

             após postar o algorítmo final, ele será testado em outros conjuntos de dados que não estão nesse repositório
         */

        //TODO implementar resposta aqui

        return Arrays.asList(
                new ResultadoCotacao("COTA", Arrays.asList(
                        new Fornecedor("FORN2",new BigDecimal(590)),
                        new Fornecedor("FORN1",new BigDecimal(650)),
                        new Fornecedor("FORN3",new BigDecimal(710))
                )),
                new ResultadoCotacao("COTB", Arrays.asList(
                        new Fornecedor("FORN1",new BigDecimal(200)),
                        new Fornecedor("FORN2",new BigDecimal(250))
                ))
        );
    }

    @Data
    @AllArgsConstructor
    public static class ItemCotacao {
        private String codigo;
        private String item;
        private BigDecimal quantidade;
    }

    @Data
    @AllArgsConstructor
    public static class Atualizacao {
        private String codigoCotacao;
        private String fornecedor;
        private String item;
        private BigDecimal valor;
    }

    @Data
    @AllArgsConstructor
    public static class ResultadoCotacao {
        private String codigo;
        private List<Fornecedor> fornecedores;
    }

    @Data
    @AllArgsConstructor
    public static class Fornecedor {
        private String fornecedor;
        private BigDecimal total;
    }

}
