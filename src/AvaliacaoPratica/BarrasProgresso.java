/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvaliacaoPratica;

import javax.swing.JProgressBar;

/**
 *
 * @author tiagoboeing
 */
public class BarrasProgresso extends Thread{
    
    private Double tempoMax, porcentagem;
    private int pecas_minuto;
    private JProgressBar barra;
    
    public BarrasProgresso(Double tempoMax, int pecas_minuto, JProgressBar barra){
        
        this.tempoMax = tempoMax;
        this.pecas_minuto = pecas_minuto;
        this.barra = barra;
        
        //calcula intervalo em segundo de cada peça
        Integer intervaloPecas = pecas_minuto/60;
        
        //converte tempo máximo (horas) para segundos
        Double HorasEmSegundos = tempoMax*3600;
        
        //Double porcentagem = Double.parseDouble(intervaloPecas/(HorasEmSegundos*100));
        
        this.barra.setMinimum(0);
        this.barra.setMaximum(100);
//        this.barra.setValue(porcentagem);
//        this.barra.setString(porcentagem+"%");
        
    }
    
    // atualiza barra em intervalo de segundos
    public void run(){
        
        for(int i=0; i < 100; i++){
            barra.setValue(i);
            barra.setValue(i);
            //sleep(1000);
        }
       
        
    }
    
}
