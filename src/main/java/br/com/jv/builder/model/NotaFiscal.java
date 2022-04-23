package br.com.jv.builder.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class NotaFiscal {

	protected String numero;
	protected LocalDate dataEmissao;
	protected List<Produto> produtos = new ArrayList<>();

	public abstract BigDecimal calcularValorTotalComImposto();

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public boolean adicionarProduto(Produto produto) {
		return this.produtos.add(produto);
	}

	public BigDecimal calcularValorTotal() {
		return this.produtos.stream().map(p -> p.getValor().multiply(new BigDecimal(p.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public String toString() {
		return "NotaFiscal [numero=" + numero + ", dataEmissao=" + dataEmissao + ", produtos=" + produtos + "]";
	}

}
