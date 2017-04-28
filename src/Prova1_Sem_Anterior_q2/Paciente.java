package Prova1_Sem_Anterior_q2;


public class Paciente {

	private String nome;
	private int idade;
	private char sexo;

	public String[] toArray() {
		String vetor[] = new String[3];
		vetor[0] = getNome();
		vetor[1] = getIdade() + "";
		vetor[2] = getSexo() == 'M' ? "Masculino" : "Feminino";
		return vetor;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(final int idade) {
		this.idade = idade;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(final char sexo) {
		this.sexo = sexo;
	}
	
}
