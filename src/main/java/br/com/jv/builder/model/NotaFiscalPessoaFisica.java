package br.com.jv.builder.model;

import java.math.BigDecimal;

public class NotaFiscalPessoaFisica extends NotaFiscal {

	@Override
	public BigDecimal calcularValorTotalComImposto() {
		BigDecimal valorTotalComImposto = calcularValorTotal().multiply(new BigDecimal("1.07"));
		
		return valorTotalComImposto;
	}

}
