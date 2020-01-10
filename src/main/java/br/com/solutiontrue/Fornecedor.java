package br.com.solutiontrue;

import java.math.BigDecimal;

public class Fornecedor {
	private final String fornecedor;
	private BigDecimal total;
	
	public Fornecedor(String fornecedor) {
		super();
		this.fornecedor = fornecedor;
		this.total = BigDecimal.ZERO;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getFornecedor() {
		return fornecedor;
	}
}
