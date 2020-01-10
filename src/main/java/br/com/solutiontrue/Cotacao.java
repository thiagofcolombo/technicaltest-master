package br.com.solutiontrue;

import java.math.BigDecimal;

public class Cotacao {
	private final String codigo;
	private final String item;
	private final BigDecimal quantidade;
	
	
	public Cotacao(final String codigo, final String item, final BigDecimal quantidade) {
		super();
		this.codigo = codigo;
		this.item = item;
		this.quantidade = quantidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getItem() {
		return item;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}	
}
