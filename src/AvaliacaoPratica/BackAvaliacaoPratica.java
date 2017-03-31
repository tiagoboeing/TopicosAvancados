/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvaliacaoPratica;

import static AvaliacaoPratica.TelaAvaliacaoPratica.Maq1_TempoMax;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tiagoboeing
 */
public class BackAvaliacaoPratica implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
       //Tempo máximo de uso (horas)
       Double Maq1_tempoMax = Double.parseDouble(TelaAvaliacaoPratica.Maq1_TempoMax.getText());
       Double Maq2_tempoMax = Double.parseDouble(TelaAvaliacaoPratica.Maq2_TempoMax.getText());
       
       //Peças por minuto (inteiro)
       Integer Maq1_pecasMin = Integer.parseInt(TelaAvaliacaoPratica.Maq1_PecasMin.getText());
       Integer Maq2_pecasMin = Integer.parseInt(TelaAvaliacaoPratica.Maq2_PecasMin.getText());
       
       //Tempo de trabalho (minutos)
       Integer Maq1_tempoTrabalho = Integer.parseInt(TelaAvaliacaoPratica.Maq1_TempoTrabalho.getText());
       Integer Maq2_tempoTrabalho = Integer.parseInt(TelaAvaliacaoPratica.Maq2_TempoTrabalho.getText());
       
       
    }
    
}
