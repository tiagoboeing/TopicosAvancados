package Prova1_q1;

import javax.swing.JProgressBar;

public class Atleta extends Thread{
	
	private int distancia, tempo;
	private JProgressBar barra;
	
	public Atleta(int distancia, int tempo, JProgressBar barra){
		
		this.distancia = distancia;
		this.tempo = tempo;
		this.barra = barra;
		
		this.barra.setMaximum(distancia);
		this.barra.setMinimum(0);
		this.barra.setValue(0);
		
	}
	
	//move barra
	public void run(){
		
		//trata erro
        try{
            for(int i=0; i < distancia; i++){
            	//tempo em milisegundos
                Thread.sleep(tempo*1000);
                barra.setValue(i+1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
	}
	

}
