/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correcao_CadastroCarro;

import java.awt.GridLayout;
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

	public static JComboBox<String> combo;
	public static JTextArea area;
	public static JTextField txtAno, txtCor;
	public static JButton btCadastrar, btLimpar;
	
	public Cadastro() {
		super("Cadastro Carro : ");		
		
		JPanel painel = new JPanel(new GridLayout(2, 1));			
		
		JPanel painel1 = new JPanel(new GridLayout(4, 2));
		JLabel lblMarca = new JLabel("Marca : ");
		JLabel lblAno = new JLabel("Ano : ");
		JLabel lblCor = new JLabel("Cor : ");
		
		txtAno = new JTextField(4);
		txtCor = new JTextField(10);
		
		combo = new JComboBox<String>(marcas);
		combo.setMaximumRowCount(2);
		combo.setToolTipText("Marca :");		
		
		area = new JTextArea(10,10);		
		
		JScrollPane br = new JScrollPane(area);
		//area.append(" - txtCor " );
		br.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		BackCadastroCarro back = new BackCadastroCarro(); 
		
		btCadastrar = new JButton("Cadastrar ");
		btCadastrar.addActionListener(back);
		
		btLimpar = new JButton("Limpar Tela ");
		btLimpar.addActionListener(back);
		
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
