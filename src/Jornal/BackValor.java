/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jornal;

import Correcao_CadastroCarro.Cadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tiagoboeing
 */
public class BackValor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == Janela.BotaoCadastrar){
            calcula();
        }   
        
        if(e.getSource() == Janela.BotaoLimpar){
            limpaTela();
        }   
        
    } // fecha actionPerformed
    
    
    //calcula os valores
    private void calcula(){
        
        
        //tratamento de erros
        try{
            
            if (Double.parseDouble(Janela.ValorCm.getText()) <= 0){
                throw new NumberFormatException("Valor não pode ser negativo");
            }
            if (Double.parseDouble(Janela.Altura.getText()) <= 0){
                throw new NumberFormatException("Altura não pode ser negativa ou 0");
            }
            if (Double.parseDouble(Janela.QtColunas.getText()) <= 0){
                throw new NumberFormatException("Qtde de colunas precisa ser maior que 0");
            }
            
            
            double resultado = Double.parseDouble(Janela.ValorCm.getText()) * Double.parseDouble(Janela.Altura.getText()) * Double.parseDouble(Janela.QtColunas.getText());
            String mostraTotal = "";
            mostraTotal += resultado;
            Janela.ValorTotal.setText(mostraTotal);
            
            
        } catch (NumberFormatException err){
            JOptionPane.showMessageDialog(Janela.BotaoCadastrar, "Número em formato não aceito" + err.getMessage());
        } catch (Exception err){
            JOptionPane.showMessageDialog(Janela.BotaoCadastrar, "Erro" + err.getMessage());
        }
        
    }
    
    
    private void limpaTela(){
        
        Janela.ValorCm.setText("");
        Janela.Altura.setText("");
        Janela.QtColunas.setText("");
        Janela.ValorTotal.setText("");
        
    }
    
    
}
