package br.com.solutiontrue;

import java.math.BigDecimal;

public class Atualizacao {
	private final String codigo;
	private final String fornecedor;
	private final String item;
	private final BigDecimal preco;
	
	public Atualizacao(final String codigo, final String fornecedor, final String item, final BigDecimal preco) {
		super();
		this.codigo = codigo;
		this.fornecedor = fornecedor;
		this.item = item;
		this.preco = preco;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public String getItem() {
		return item;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	
	
}
