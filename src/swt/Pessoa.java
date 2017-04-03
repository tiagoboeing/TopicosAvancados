package swt;

public class Pessoa {
	
	private String nome, sexo, data;
	private boolean mat, vesp, not;
	
	public String[] toArray(){
		String[] dados = new String[6];
		dados[0] = getNome();
		dados[1] = getData();
		dados[2] = getSexo();
		dados[3] = mat==true?"X":" ";
		dados[4] = vesp==true?"X":" ";
		dados[5] = not==true?"X":" ";
		return dados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isMat() {
		return mat;
	}
	public void setMat(boolean mat) {
		this.mat = mat;
	}
	public boolean isVesp() {
		return vesp;
	}
	public void setVesp(boolean vesp) {
		this.vesp = vesp;
	}
	public boolean isNot() {
		return not;
	}
	public void setNot(boolean not) {
		this.not = not;
	}
	
	
	

}
