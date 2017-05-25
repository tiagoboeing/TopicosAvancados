package CadastroPrecoCarro;

public class Carro {
	
	String txtPlaca, txtMarca, txtModelo, txtAno, txtCor, txtValor;
	
	
	public Carro(String txtPlaca, String txtMarca, String txtModelo, String txtAno, String txtCor, String txtValor){
		this.txtPlaca = txtPlaca;
		this.txtMarca = txtMarca;
		this.txtModelo = txtModelo;
		this.txtAno = txtAno;
		this.txtCor = txtCor;
		this.txtValor = txtValor;
		
	}
	
	
	public String toString(){
		return getTxtPlaca() + " - " + getTxtMarca() + " - " + getTxtModelo() + " - " + getTxtAno() + " - " + getTxtCor() + " - " + getTxtValor() + "\n";
	}


	public String getTxtPlaca() {
		return txtPlaca;
	}


	public void setTxtPlaca(String txtPlaca) {
		this.txtPlaca = txtPlaca;
	}


	public String getTxtMarca() {
		return txtMarca;
	}


	public void setTxtMarca(String txtMarca) {
		this.txtMarca = txtMarca;
	}


	public String getTxtModelo() {
		return txtModelo;
	}


	public void setTxtModelo(String txtModelo) {
		this.txtModelo = txtModelo;
	}


	public String getTxtAno() {
		return txtAno;
	}


	public void setTxtAno(String txtAno) {
		this.txtAno = txtAno;
	}


	public String getTxtCor() {
		return txtCor;
	}


	public void setTxtCor(String txtCor) {
		this.txtCor = txtCor;
	}


	public String getTxtValor() {
		return txtValor;
	}


	public void setTxtValor(String txtValor) {
		this.txtValor = txtValor;
	}
	
}
