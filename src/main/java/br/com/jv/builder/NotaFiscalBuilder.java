package br.com.jv.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.jv.builder.model.NotaFiscal;
import br.com.jv.builder.model.NotaFiscalPessoaFisica;
import br.com.jv.builder.model.NotaFiscalPessoaJuridica;
import br.com.jv.builder.model.Produto;

public class NotaFiscalBuilder {

	private NotaFiscal instancia;

	private final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public NotaFiscalBuilder comPessoaFisica() {
		this.instancia = new NotaFiscalPessoaFisica();

		return this;
	}

	public NotaFiscalBuilder comPessoaJuridica() {
		this.instancia = new NotaFiscalPessoaJuridica();

		return this;
	}

	public NotaFiscalBuilder comNumero(String numero) {
		this.instancia.setNumero(numero);
		return this;
	}

	public NotaFiscalBuilder comDataEmissao(String data) {
		this.instancia.setDataEmissao(LocalDate.parse(data, formatadorData));

		return this;
	}

	public NotaFiscalBuilder comDataEmissao(LocalDate data) {
		this.instancia.setDataEmissao(data);

		return this;
	}

	public NotaFiscalBuilder comProduto(String nome, Integer quantidade, BigDecimal valor) {
		adicionarProduto(nome, quantidade, valor);

		return this;
	}

	public NotaFiscalBuilder comProduto(String nome, Integer quantidade, Double valor) {
		BigDecimal valorConvertido = BigDecimal.valueOf(valor);

		adicionarProduto(nome, quantidade, valorConvertido);

		return this;
	}

	public NotaFiscalBuilder comProduto(String nome, Integer quantidade, String valor) {
		BigDecimal valorConvertido = new BigDecimal(valor);

		adicionarProduto(nome, quantidade, valorConvertido);

		return this;
	}
	
	public NotaFiscal construir() {
		return this.instancia;
	}

	private void adicionarProduto(String nome, Integer quantidade, BigDecimal valor) {
		Produto produto = new Produto();

		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);

		this.instancia.adicionarProduto(produto);
	}

}
