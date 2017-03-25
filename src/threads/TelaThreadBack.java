/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tiago Boeing
 */
public class TelaThreadBack implements ActionListener{
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int qtF1 = Integer.parseInt(TelaThread.txtQtF1.getText());
        int qtF2 = Integer.parseInt(TelaThread.txtQtF2.getText());
        int tpF1 = Integer.parseInt(TelaThread.txtTempoF1.getText());
        int tpF2 = Integer.parseInt(TelaThread.txtTempoF2.getText());
        
        Funcionario f1 = new Funcionario(qtF1, tpF1, TelaThread.barF1);
        Funcionario f2 = new Funcionario(qtF2, tpF2, TelaThread.barF2);
        
        //chama método run da thread
        f1.start();
        f2.start();
        
    }
    
}
