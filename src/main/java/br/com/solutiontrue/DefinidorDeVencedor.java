package br.com.solutiontrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefinidorDeVencedor {

    public List<String> definirVencedores(List<String> cotacoes, List<String> atualizacoes) {
    	final Map<String, Cotacao> cotacoesCache = new HashMap<>();
    	final List<Atualizacao> atualizacoesCache = new ArrayList<>();
    	
    	cotacoes.forEach(c -> {
    		final String[] campos = c.split(",");
    		BigDecimal valor = new BigDecimal(campos[2]);
    		valor.setScale(2, RoundingMode.HALF_UP);
    		final Cotacao cotacao = new Cotacao(campos[0], campos[1], valor);
    		final String chave = cotacao.getCodigo() + "_" + cotacao.getItem();
    		cotacoesCache.put(chave, cotacao);
    	});
    	
    	atualizacoes.forEach(a -> {
    		final String[] campos = a.split(",");
    		BigDecimal valor = new BigDecimal(campos[3]);
    		valor.setScale(2, RoundingMode.HALF_UP);
    		final Atualizacao atualizacao = new Atualizacao(campos[0], campos[1], campos[2], valor);
    		atualizacoesCache.add(atualizacao);
    	});
    	
    	Map<String, Cota> cotas = new HashMap<>();
    	for(Atualizacao atualizacao : atualizacoesCache) {
    		
    		Cota cota = new Cota(atualizacao.getCodigo());
    		if (cotas.containsKey(atualizacao.getCodigo())) {
    			cota = cotas.get(atualizacao.getCodigo());
    		} else {
    			cotas.put(atualizacao.getCodigo(), cota);
    		}
    		
    		Fornecedor forncedor = cota.getFornecedor(atualizacao.getFornecedor());
    		String chaveItem = atualizacao.getCodigo() + "_" + atualizacao.getItem();
    		BigDecimal quantidadeItem = cotacoesCache.containsKey(chaveItem) ? cotacoesCache.get(chaveItem).getQuantidade() : BigDecimal.ZERO;
    		BigDecimal valor = atualizacao.getPreco().multiply(quantidadeItem);
    		valor.setScale(2, RoundingMode.HALF_UP);
    		forncedor.setTotal(forncedor.getTotal().add(valor));
    	}
    	
        List<Cota> cotasOrdenadas = new ArrayList<>(cotas.values());
        Collections.sort(cotasOrdenadas, new Comparator<Cota>() {

			@Override
			public int compare(Cota o1, Cota o2) {
				return o1.getCodigo().compareTo(o2.getCodigo());
			}
        	
		});
        
        final List<String> respostas = new ArrayList<>();
        cotasOrdenadas.forEach(c -> respostas.add(c.toString()));
        return respostas;
    }


}
