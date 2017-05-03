package Prova1_q1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class TelaAtleta extends JFrame{
	
	//private JLabel lblAtleta1, lblAtleta2, lblDistanciaAtleta1, lblDistanciaAtleta2, lblTempoAtleta1, lblTempoAtleta2;
	public static JTextField txtDistanciaAtleta1, txtDistanciaAtleta2, txtTempoAtleta1, txtTempoAtleta2;
	public static JButton btnLargada, btnSair;
	public static JProgressBar barraAtleta1, barraAtleta2;
	
	public TelaAtleta(){
		
		super("Principal");
		JPanel painel = new JPanel(new GridLayout(4, 2, 1, 3));
		JPanel painelEsquerda = new JPanel(new GridLayout(2, 2));
		JPanel painelDireita = new JPanel(new GridLayout(2, 2));
		
		JLabel lblAtleta1 = new JLabel("Atleta 1");
		JLabel lblAtleta2 = new JLabel("Atleta 2");
		JLabel lblDistanciaAtleta1 = new JLabel("Distância (km)");
		JLabel lblDistanciaAtleta2 = new JLabel("Distância (km)");
		JLabel lblTempoAtleta1 = new JLabel("Tempo (1km)");
		JLabel lblTempoAtleta2 = new JLabel("Tempo (1km)");
		
		//text fields
		txtDistanciaAtleta1 = new JTextField(10);
		txtDistanciaAtleta2 = new JTextField(10);
		txtTempoAtleta1 = new JTextField(10);
		txtTempoAtleta2 = new JTextField(10);
		
		//barras
		barraAtleta1 = new JProgressBar();
		barraAtleta2 = new JProgressBar();
		
		//mostra porcentagem de barras
		barraAtleta1.setStringPainted(true);
		barraAtleta2.setStringPainted(true);
		
		//botões
		btnLargada = new JButton("LARGADA");
		btnSair = new JButton("SAIR");
		
		
		//adiciona ao painel
		painel.add(lblAtleta1);
		painel.add(lblAtleta2);
		
			//paineis individuais
			painelEsquerda.add(lblDistanciaAtleta1);		
			painelEsquerda.add(txtDistanciaAtleta1);
			painelEsquerda.add(lblTempoAtleta1);
			painelEsquerda.add(txtTempoAtleta1);
			
			painelDireita.add(lblDistanciaAtleta2);		
			painelDireita.add(txtDistanciaAtleta2);
			painelDireita.add(lblTempoAtleta2);
			painelDireita.add(txtTempoAtleta2);
			
		painel.add(painelEsquerda);
		painel.add(painelDireita);	
		
		painel.add(barraAtleta1);
		painel.add(barraAtleta2);
		
		painel.add(btnLargada);
		painel.add(btnSair);
		
		//define listeners
		TelaAtletaBack back = new TelaAtletaBack();
		btnLargada.addActionListener(back);
			
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
 				
		
		//inicializa
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TelaAtleta();
	}
	
}
