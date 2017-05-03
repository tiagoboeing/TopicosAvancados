package Prova1_q2;

public class Competicao {
	
	private String nome, distancia, data, colocacao, melhorColocacao;

	public String[] toArray(){
		String[] dados = new String[6];
		dados[0] = getNome();
		dados[1] = getData();
		dados[2] = getDistancia();
		dados[3] = getColocacao();
		dados[4] = getMelhorColocacao();
		return dados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getColocacao() {
		return colocacao;
	}

	public void setColocacao(String colocacao) {
		this.colocacao = colocacao;
	}
	
	public String getMelhorColocacao() {
		return melhorColocacao;
	}

	public void setMelhorColocacao(String melhorColocacao) {
		this.melhorColocacao = melhorColocacao;
	}
	
	
}
