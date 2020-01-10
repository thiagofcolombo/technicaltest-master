package br.com.solutiontrue;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Cota {
	private final String codigo;
	
	private final Map<String, Fornecedor> fornecedores;

	public Cota(String codigo) {
		this.codigo = codigo;
		this.fornecedores = new HashMap<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public Fornecedor getFornecedor(String fornecedorNome) {
		
		if (this.fornecedores.containsKey(fornecedorNome)) {
			return this.fornecedores.get(fornecedorNome);
		} else {
			Fornecedor fornecedor = new Fornecedor(fornecedorNome);
			this.fornecedores.put(fornecedorNome, fornecedor);
			return fornecedor;
		}
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("####.##");
		df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("en", "US")));
		StringBuilder text = new StringBuilder();
		text.append(codigo).append(":");
		
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedoresOrdenados, new Comparator<Fornecedor>() {

			@Override
			public int compare(Fornecedor o1, Fornecedor o2) {
				int comp =  o1.getTotal().compareTo(o2.getTotal());
				return comp == 0 ? o1.getFornecedor().compareTo(o2.getFornecedor()) : comp;
			}
		});
		
		for(Fornecedor fornecedor : fornecedoresOrdenados) {
			text.append(fornecedor.getFornecedor()).append("=").append(df.format(fornecedor.getTotal()));
			text.append(",");
		}
		
		String resp = text.toString();
		return resp.substring(0, resp.length() -1);
	}
}
