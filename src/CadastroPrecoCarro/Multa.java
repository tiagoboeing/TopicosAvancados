package CadastroPrecoCarro;

public class Multa {
	
	String placaCarro;
	Double valorMulta;
	
	public Multa(String placaCarro, Double valorMulta){
		
		this.placaCarro = placaCarro;
		this.valorMulta = valorMulta;
		
	}
	
	public String toString(){
		return "Placa carro: " + placaCarro + " - Valor multa: R$ " + valorMulta + "\n";
	}
	
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	public Double getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

}
