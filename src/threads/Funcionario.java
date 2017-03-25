/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import javax.swing.JProgressBar;

/**
 *
 * @author Tiago Boeing
 */
public class Funcionario extends Thread{
    
    private int qt, tempo;
    private JProgressBar barra;
    
    public Funcionario(int qt, int tempo, JProgressBar barra) {
        this.qt = qt;
        this.tempo = tempo;
        this.barra = barra;
        
        this.barra.setMaximum(qt);
        this.barra.setMinimum(0);
        this.barra.setValue(0);
        
    }
    
    
    //faz barra de progresso se mover
    @Override
    public void run(){
        
        //trata erro apenas para não parar execução
        try{
            for(int i=0; i < qt; i++){
                Thread.sleep(tempo);
                barra.setValue(i+1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }   
        
    }
    
        
}
    