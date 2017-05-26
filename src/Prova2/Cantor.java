package Prova2;

public class Cantor {
	
	private String nomeCantor, estiloMusical, sexoCantor;
	
	
	public Cantor(String nomeCantor, String estiloMusical, String sexoCantor){
		this.nomeCantor = nomeCantor;
		this.estiloMusical = estiloMusical;
		this.sexoCantor = sexoCantor;	
	}
	
	
	public String toString(){
		return "Nome: " + getNomeCantor() + " - Estilo: " + getEstiloMusical() + " - Sexo: " + getSexoCantor() + "\n";
	}
	
	

	public String getNomeCantor() {
		return nomeCantor;
	}

	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	public String getSexoCantor() {
		return sexoCantor;
	}

	public void setSexoCantor(String sexoCantor) {
		this.sexoCantor = sexoCantor;
	}

}
