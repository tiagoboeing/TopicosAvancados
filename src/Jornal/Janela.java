/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jornal;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author tiagoboeing
 */
public class Janela extends JFrame{
    
    private JLabel lblValorCm, lblAltura, lblQtColunas, lblListaValores, lblValorTotal;
    private static JTextArea listaValores;
    static JTextField ValorCm, Altura, QtColunas, ValorTotal;
    static JButton BotaoCadastrar, BotaoLimpar;
    
    private Janela(){
        
        super("Orçamento impresso");
        
        //CRIA PAINEIS
        JPanel painel = new JPanel(new GridLayout(6, 2, 1, 3));
        JPanel painel1 = new JPanel(new GridLayout(2, 1));
        
        //labels
        lblValorCm = new JLabel("Valor CM, R$:");
        lblAltura = new JLabel("Altura, cm:");
        lblQtColunas = new JLabel("Qtde de colunas:");
        lblListaValores = new JLabel("Lista de valores R$");
        lblValorTotal = new JLabel("Valor total R$");
        
        
        //campos de textos
        ValorCm = new JTextField(10);
        Altura = new JTextField(10);
        QtColunas = new JTextField(10);
        ValorTotal = new JTextField(10);
            ValorTotal.setEditable(false);
            
        listaValores = new JTextArea(6, 20);
        JScrollPane br = new JScrollPane(listaValores);
        
        
        
        //chama função de ação
        BackValor back = new BackValor();
        
        
        //botões
        BotaoCadastrar = new JButton("Calcular");
            BotaoCadastrar.addActionListener((ActionListener) back);
        
        BotaoLimpar = new JButton("Limpar");
            BotaoLimpar.addActionListener((ActionListener) back);
        
        
        //LISTA DE VALORES
        String valoresImpresso = "LISTA DE VALORES DO IMPRESSO \n\n";
        valoresImpresso += "             ||    CHEIA        ||    PROMO    ||   ESPECIAL + DE 1   ||   CLASSIFICADOS + DE 1 \n";
        valoresImpresso += " -------------------------------------------------------------------------------------------------------------- \n";
        valoresImpresso += "PB =    ||     R$ 11.70   ||     R$ 5.70   ||          R$ 3.50              ||       R$ 2.00 \n";
        valoresImpresso += " -------------------------------------------------------------------------------------------------------------- \n";
        valoresImpresso += "COR= ||     R$ 18.70   ||     R$ 8.70   ||          R$ 5.90              ||       R$ 3.00 \n";
        
            //adiciona ao textarea
            listaValores.append(valoresImpresso);
            listaValores.setEditable(false);
        
        
        
        //adiciona PAINEIS
        painel.add(lblValorCm);
        painel.add(ValorCm);
        
        painel.add(lblAltura);
        painel.add(Altura);
        
        painel.add(lblQtColunas);
        painel.add(QtColunas);
        
        painel.add(BotaoCadastrar);
        painel.add(BotaoLimpar);
        
        painel.add(lblValorTotal);
        painel.add(ValorTotal);
        
        painel1.add(listaValores);
        painel1.add(painel); 
        
        
                
        //não deixa maximizar a tela : setResizable(false);
        //não miniza a tela : setAlwaysOnTop(true);
        setContentPane(painel1);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        
        
    }
    
    
    public static void main(String[] args) {
        new Janela();
    }
    
}
