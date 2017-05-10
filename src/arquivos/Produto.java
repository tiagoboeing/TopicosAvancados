package arquivos;

public class Produto {
	
	private String txtNome, txtQtde, txtValor;
	
	public Produto(String txtNome, String txtQtde, String txtValor){
		
		this.txtNome = txtNome;
		this.txtQtde = txtQtde;
		this.txtValor = txtValor;
		
	}
	
	
	//saída texto
/*	public String[] toArray(){
	
		return new String[] { getTxtNome() + " - " + getTxtQtde() + " - " + getTxtValor() };
		
	}*/
	
	public String toString(){
		return "Nome: " + getTxtNome() + " - Qtde: " + getTxtQtde() + " - Valor: R$ " + getTxtValor();
	}
	
	

	public String getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(String txtNome) {
		this.txtNome = txtNome;
	}

	public String getTxtQtde() {
		return txtQtde;
	}

	public void setTxtQtde(String txtQtde) {
		this.txtQtde = txtQtde;
	}

	public String getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(String txtValor) {
		this.txtValor = txtValor;
	}
	

}
