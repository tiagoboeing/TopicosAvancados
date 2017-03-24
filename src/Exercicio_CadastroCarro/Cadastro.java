/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio_CadastroCarro;


import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Tiago Boeing
 */
public class Cadastro extends JFrame {
    
   private String[] marcas = new String[]{"Chevrolet", "Fiat", "Ford",  "Toyota"};

	private JComboBox<String> combo;
	private JTextArea area;
	public static JTextField txtAno, txtCor, txtDados;
	private JButton btCadastrar, btLimpar;
	
	public Cadastro() {
		super("Cadastro Carro : ");		

		BackCadastroCarro back = new BackCadastroCarro();	
		
		JPanel painel = new JPanel(new GridLayout(2, 1));			
		
		JPanel painel1 = new JPanel(new GridLayout(5, 2));
		JLabel lblMarca = new JLabel("Marca : ");
		JLabel lblAno = new JLabel("Ano : ");
		JLabel lblCor = new JLabel("Cor : ");
		
		txtAno = new JTextField(4);
		txtCor = new JTextField(10);
		
		combo = new JComboBox<String>(marcas);
		combo.setMaximumRowCount(2);
		combo.setToolTipText("Marca :");		
		
		btCadastrar = new JButton("Cadastrar ");
		btCadastrar.addActionListener(back);
		
		btLimpar = new JButton("Limpar Tela ");
		btLimpar.addActionListener(back);
		
		area = new JTextArea(2,10);

		JScrollPane br = new JScrollPane(area);
                
                
                String cadastrados = "\n";
                cadastrados += cadastrados + txtCor.getText() + "_" + txtAno.getText() + "_" + combo.getName();
                
                //txtDados = new JTextField(10);
                //txtDados.setText(cadastrados);
                
                //passa valores textarea
                
                
                area.append(cadastrados);
                if(btCadastrar.action(null, br)){
                area.repaint();
                }
                
                
                area.setEditable(false);
		br.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);       
		
		
		painel1.add(lblMarca);
		painel1.add(combo);
		painel1.add(lblAno);
		painel1.add(txtAno);
		painel1.add(lblCor);
		painel1.add(txtCor);
		painel1.add(btCadastrar);
		painel1.add(btLimpar);
		
		painel.add(painel1);
		painel.add(br);
                
		
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		new Cadastro();
	}
    
}
