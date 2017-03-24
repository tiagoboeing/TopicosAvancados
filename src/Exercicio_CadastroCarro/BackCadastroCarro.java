/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio_CadastroCarro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago Boeing
 */
public class BackCadastroCarro implements ActionListener{
    
        //checa dados do ano
    	@Override
	public void actionPerformed(ActionEvent e) {
        
        double ano = 0;
        
	try{
		 ano = Double.parseDouble(Cadastro.txtAno.getText());
		 if(ano < 1980 )
			 throw new NumberFormatException("Ano deve ser maior que 1980.");
		 
	}catch(NumberFormatException err) {
		JOptionPane.showMessageDialog(Cadastro.txtAno, "N�mero Inv�lido : "+err.getMessage());
	}catch(Exception err){
		JOptionPane.showMessageDialog(Cadastro.txtAno, "Erro desconhecido "+err.toString());
	}
	
        
        //CHECA INFORMAÇÕES DE COR
        String cor = "";
        
        try{
            cor = Cadastro.txtCor.getText();
            if(cor.length() < 4)
                    throw new NumberFormatException("Cor precisa ter mais que 3 caracteres.");
		 
	}catch(NumberFormatException err) {
		JOptionPane.showMessageDialog(Cadastro.txtAno, "Quantidade de caracteres inválida : "+err.getMessage());
	}catch(Exception err){
		JOptionPane.showMessageDialog(Cadastro.txtAno, "Erro desconhecido "+err.toString());
	}
        
        
        //REALIZA CADASTRO
        String cadastrados = "";
        
        cadastrados += Cadastro.txtCor + "_" + Cadastro.txtAno + "\n";
        
        
        
        
	}
        

    
}
