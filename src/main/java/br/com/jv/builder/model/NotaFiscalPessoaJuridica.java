package br.com.jv.builder.model;

import java.math.BigDecimal;

public class NotaFiscalPessoaJuridica extends NotaFiscal {

	@Override
	public BigDecimal calcularValorTotalComImposto() {
		BigDecimal valorTotalComImposto = calcularValorTotal().multiply(new BigDecimal("1.04"));

		return valorTotalComImposto;
	}

}
