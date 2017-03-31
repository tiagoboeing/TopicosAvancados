/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvaliacaoPratica;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author tiagoboeing
 */
public class TelaAvaliacaoPratica extends JFrame{
        
    //máquina 1
    public static JTextField Maq1_TempoMax, Maq1_PecasMin, Maq1_TempoTrabalho;
    
    //máquina 2
    public static JTextField Maq2_TempoMax, Maq2_PecasMin, Maq2_TempoTrabalho;
    
    //componentes da interface
    public static JButton btIniciarProducao, btLimpar;
    public static JProgressBar Maq1_barra, Maq2_barra, Maq1_producao_barra, Maq2_producao_barra;
    
    
    public TelaAvaliacaoPratica(){
        
        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));
        
        //define conteúdo de labels
        JLabel Maq1_lbl_TempoMax = new JLabel("Tempo máximo uso (horas)");
        JLabel Maq2_lbl_TempoMax = new JLabel("Tempo máximo uso (horas)");
        
        JLabel Maq1_lbl_PecasMin = new JLabel("Peças por minuto");
        JLabel Maq2_lbl_PecasMin = new JLabel("Peças por minuto");
        
        JLabel Maq1_lbl_TempoTrabalho = new JLabel("Tempo de trabalho (em minutos)");
        JLabel Maq2_lbl_TempoTrabalho = new JLabel("Tempo de trabalho (em minutos)");
        
        JLabel lbl_restricoes_maq1 = new JLabel("Restrições Diárias da Máquina 1");
        JLabel lbl_restricoes_maq2 = new JLabel("Restrições Diárias da Máquina 2");
        
        JLabel lbl_producao_maq1 = new JLabel("Produção");
        JLabel lbl_producao_maq2 = new JLabel("Produção");
        
        
        Maq1_TempoMax = new JTextField(10);
        Maq2_TempoMax = new JTextField(10);
        
        Maq1_PecasMin = new JTextField(10);
        Maq2_PecasMin = new JTextField(10);
        
        Maq1_TempoTrabalho = new JTextField(10);
        Maq2_TempoTrabalho = new JTextField(10);
        
        Maq1_barra = new JProgressBar();
        Maq1_producao_barra = new JProgressBar();
        
        Maq2_barra = new JProgressBar();
        Maq2_producao_barra = new JProgressBar();
        
        btIniciarProducao = new JButton("Iniciar a produção");
        btLimpar = new JButton("Limpar campos");
        
        JPanel painel_Maq1_restricoes = new JPanel(new GridLayout(3,2));
        JPanel painel_Maq2_restricoes = new JPanel(new GridLayout(3,2));
        
        JPanel painel_Maq1_producao = new JPanel(new GridLayout(1, 2));
        JPanel painel_Maq2_producao = new JPanel(new GridLayout(1, 2));
        
        //painel restrições MÁQUINA 1
        painel_Maq1_restricoes.add(Maq1_lbl_TempoMax);
        painel_Maq1_restricoes.add(Maq1_TempoMax);
        painel_Maq1_restricoes.add(Maq1_lbl_PecasMin);
        painel_Maq1_restricoes.add(Maq1_PecasMin);
        
        //painel produção MÁQUINA 1
        painel_Maq1_producao.add(Maq1_lbl_TempoTrabalho);
        painel_Maq1_producao.add(Maq1_TempoTrabalho);
        
        
        //painel restrições MÁQUINA 2
        painel_Maq2_restricoes.add(Maq2_lbl_TempoMax);
        painel_Maq2_restricoes.add(Maq2_TempoMax);
        painel_Maq2_restricoes.add(Maq2_lbl_PecasMin);
        painel_Maq2_restricoes.add(Maq2_PecasMin);
        
        //painel produção MÁQUINA 2
        painel_Maq2_producao.add(Maq2_lbl_TempoTrabalho);
        painel_Maq2_producao.add(Maq2_TempoTrabalho);
        
        
        //PAINEL PRINCIPAL
        painel.add(lbl_restricoes_maq1);
        painel.add(lbl_restricoes_maq2);
        
        painel.add(painel_Maq1_restricoes);
        painel.add(painel_Maq2_restricoes);
        
        painel.add(Maq1_barra);
        painel.add(Maq2_barra);
        
        painel.add(lbl_producao_maq1);
        painel.add(lbl_producao_maq2);
        
        painel.add(painel_Maq1_producao);
        painel.add(painel_Maq2_producao);
        
        painel.add(Maq1_producao_barra);
        painel.add(Maq2_producao_barra);
        
        painel.add(btLimpar);
        painel.add(btIniciarProducao);
        
        
        //arquivo back funções
        
        setContentPane(painel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        
    }
    
    
    public static void main(String[] args) {
        new TelaAvaliacaoPratica();
    }
    
    
            
}
