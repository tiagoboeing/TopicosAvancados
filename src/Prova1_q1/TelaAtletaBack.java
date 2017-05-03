package Prova1_q1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAtletaBack implements ActionListener{
	
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	
        int DistanciaAtleta1 = Integer.parseInt(TelaAtleta.txtDistanciaAtleta1.getText());
        int DistanciaAtleta2 = Integer.parseInt(TelaAtleta.txtDistanciaAtleta2.getText());
        int TempoAtleta1 = Integer.parseInt(TelaAtleta.txtTempoAtleta1.getText());
        int TempoAtleta2 = Integer.parseInt(TelaAtleta.txtTempoAtleta2.getText());
        
        Atleta a1 = new Atleta(DistanciaAtleta1, TempoAtleta1, TelaAtleta.barraAtleta1);
        Atleta a2 = new Atleta(DistanciaAtleta2, TempoAtleta2, TelaAtleta.barraAtleta2);
        
        
        //chama método run
        a1.start();
        a2.start();
        
    }

}
