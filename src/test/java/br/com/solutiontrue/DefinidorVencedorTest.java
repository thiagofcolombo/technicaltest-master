package br.com.solutiontrue;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefinidorVencedorTest {

    @org.junit.jupiter.api.Test
    void testeCasoExemplo() {
        List<DefinidorVencedor.ItemCotacao> cotacoes = lerCotacoes("/test_exemplo_cotacoes.txt");
        List<DefinidorVencedor.Atualizacao> atualizacoes = lerAtualizacoes("/test_exemplo_atualiza.txt");

        final List<DefinidorVencedor.ResultadoCotacao> resultado = new DefinidorVencedor().definirVencedores(cotacoes, atualizacoes);

        assertNotNull(resultado);

        final List<String> toTest = convertToAssert(resultado);

        assertThat(toTest)
                .containsExactly(
                        "COTA:FORN2=590,FORN1=650,FORN3=710",
                        "COTB:FORN1=200,FORN2=250"
                );
    }

    @org.junit.jupiter.api.Test
    void testeOutroCaso () {
        List<DefinidorVencedor.ItemCotacao> cotacoes = lerCotacoes("/test1_cotacoes.txt");
        List<DefinidorVencedor.Atualizacao> atualizacoes = lerAtualizacoes("/test1_atualiza.txt");

        final List<DefinidorVencedor.ResultadoCotacao> resultado = new DefinidorVencedor().definirVencedores(cotacoes, atualizacoes);
        assertNotNull(resultado);
        final List<String> toTest = convertToAssert(resultado);

        assertThat(toTest)
                .containsExactly(
                        "COT1:FORN_C=6384,FORN_B=7044,FORN_A=9630",
                        "COT2:FORN_B=1400,FORN_A=1500,FORN_C=1600",
                        "COT3:FORN_A=7500,FORN_B=7800,FORN_C=9600"
                );
    }


    private List<String> convertToAssert(List<DefinidorVencedor.ResultadoCotacao> resultado) {
        return resultado.stream().map((res) -> String.format("%s:%s", res.getCodigo(),
                    res.getFornecedores()
                            .stream()
                            .map(forn -> String.format("%s=%s", forn.getFornecedor(), forn.getTotal()))
                            .collect(Collectors.joining(","))
            )).collect(Collectors.toList());
    }

    private List<DefinidorVencedor.Atualizacao> lerAtualizacoes(String resourcePathAtualiza) {
        final List<String> lines = getLines(resourcePathAtualiza);

        ArrayList<DefinidorVencedor.Atualizacao> list = new ArrayList<>(lines.size());
        for (String line: lines) {
            final String[] split = line.split("[,]");
            list.add(new DefinidorVencedor.Atualizacao(
                    split[0],
                    split[1],
                    split[2],
                    new BigDecimal(split[3])
            ));
        }
        return list;
    }

    private List<DefinidorVencedor.ItemCotacao> lerCotacoes(String resourcePathCotacoes) {
        final List<String> lines = getLines(resourcePathCotacoes);

        ArrayList<DefinidorVencedor.ItemCotacao> list = new ArrayList<>(lines.size());
        for (String line: lines) {
            final String[] split = line.split("[,]");
            list.add(new DefinidorVencedor.ItemCotacao(
                    split[0],
                    split[1],
                    new BigDecimal(split[2])
            ));
        }
        return list;
    }

    private List<String> getLines(String resourcePath)  {
        final URL resource = this.getClass().getResource(resourcePath);


        final File file = new File(resource.getFile());
        LinkedList<String> lines = new LinkedList<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}