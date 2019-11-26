package br.com.solutiontrue;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefinidorDeVencedorTest {

    @org.junit.jupiter.api.Test
    void testeCasoExemplo() {
        List<String> cotacoes = getLines("/test_exemplo_cotacoes.txt");
        List<String> atualizacoes = getLines("/test_exemplo_atualiza.txt");

        final List<String> resultado = new DefinidorDeVencedor().definirVencedores(cotacoes, atualizacoes);

        assertNotNull(resultado);

        assertThat(resultado)
                .containsExactlyInAnyOrder(
                        "COTA:FORN2=590,FORN1=650,FORN3=710",
                        "COTB:FORN1=200,FORN2=250"
                );
    }

    @org.junit.jupiter.api.Test
    void testeOutroCaso () {
        List<String> cotacoes = getLines("/test1_cotacoes.txt");
        List<String> atualizacoes = getLines("/test1_atualiza.txt");

        final List<String> resultado = new DefinidorDeVencedor().definirVencedores(cotacoes, atualizacoes);
        assertNotNull(resultado);

        assertThat(resultado)
                .containsExactlyInAnyOrder(
                        "COT1:FORN_C=6384,FORN_B=7044,FORN_A=9630",
                        "COT2:FORN_B=1400,FORN_A=1500,FORN_C=1600",
                        "COT3:FORN_A=7500,FORN_B=7800,FORN_C=9600"
                );
    }

    @org.junit.jupiter.api.Test
    void testeCasoMaisComplexo () {
        List<String> cotacoes = getLines("/test2_cotacoes.csv");
        List<String> atualizacoes = getLines("/test2_atualizacoes.csv");

        final List<String> resultado = new DefinidorDeVencedor().definirVencedores(cotacoes, atualizacoes);
        assertNotNull(resultado);

        assertThat(resultado)
                .containsExactlyInAnyOrder(
                        "C0001:FORN0144=850,FORN0145=850,FORN0022=4966.5",
                        "C0002:FORN0333=945,FORN0144=2352,FORN0145=2352,FORN0022=15594.81",
                        "C0004:FORN0333=68,FORN0144=625,FORN0022=3277.89",
                        "C0055:FORN0144=295,FORN0145=295,FORN0333=398,FORN0022=3277.89",
                        "C0056:FORN0144=350,FORN0145=350,FORN0333=700,FORN0022=4966.5",
                        "C0057:FORN0144=782,FORN0145=782,FORN0333=2515,FORN0022=15594.81",
                        "C0058:FORN0144=7779.3,FORN0145=7779.3,FORN0333=62262,FORN0022=331295.35",
                        "C9999:FORN0333=28909,FORN0144=41132.3,FORN0145=41132.3,FORN0022=331295.35"
                );
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