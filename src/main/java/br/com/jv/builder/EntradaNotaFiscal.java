package br.com.jv.builder;

import br.com.jv.builder.model.NotaFiscal;

public class EntradaNotaFiscal {

	public static void main(String[] args) {
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
								.comPessoaFisica()
								.comNumero("12323-1")
								.comDataEmissao("20/04/2022")
								.comProduto("Cadeira Gamer", 1, "1800")
								.comProduto("Smartphone Samsung Galaxy M52", 1, 1700.0)
								.construir();
		
		System.out.println(notaFiscal);
		System.out.println("Total: " + notaFiscal.calcularValorTotal());
		System.out.println("Total com Imposto: " + notaFiscal.calcularValorTotalComImposto());
	}
	
}
