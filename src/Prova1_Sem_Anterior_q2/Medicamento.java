package Prova1_Sem_Anterior_q2;


public class Medicamento {
	
	private String nome;
	private double valor;
	private int qtdCaixa;
	private char medidas;
	private double valorUnidade;
	
	public String[] toArray() {
		String vetor[] = new String[4];
		vetor[0] = getNome();
		vetor[1] = getValor() + "";
		vetor[2] = getQtdCaixa() + "";
		vetor[3] = getValorUnidade() + "";
		return vetor;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(final double valor) {
		this.valor = valor;
	}
	
	public int getQtdCaixa() {
		return qtdCaixa;
	}
	
	public void setQtdCaixa(final int qtdCaixa) {
		this.qtdCaixa = qtdCaixa;
	}
	
	public char getMedidas() {
		return medidas;
	}
	
	public void setMedidas(final char medidas) {
		this.medidas = medidas;
	}
	
	public double getValorUnidade() {
		return valorUnidade;
	}
	
	public void setValorUnidade(final double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	
}
