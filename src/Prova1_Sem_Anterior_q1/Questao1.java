package Prova1_Sem_Anterior_q1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Questao1 extends JFrame implements ActionListener{
	
	private JLabel lbTempo, lbQtd;
	private JTextField txtTempo, txtQtd, txtCount;
	private JButton btIniciar;
	private JProgressBar pbProduzido;
	
	public Questao1() {
		super("Questão 1");
		
		JPanel panelBase = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new GridLayout(3,2,8,8));
		JPanel panelBottom = new JPanel(new GridLayout(2,1,8,8));
		
		lbQtd = new JLabel("Quantidade");
		lbTempo = new JLabel("Tempo(segundos)");
		
		txtQtd = new JTextField(5);
		txtTempo = new JTextField(5);
		txtCount = new JTextField(5);
		
		btIniciar = new JButton("Iniciar");
		btIniciar.addActionListener(this);
		
		pbProduzido = new JProgressBar();
		
		panel.add(lbQtd);
		panel.add(txtQtd);
		panel.add(lbTempo);
		panel.add(txtTempo);
		panel.add(btIniciar);
		panelBottom.add(pbProduzido);
		panelBottom.add(txtCount);
		panelBase.add(panel, BorderLayout.NORTH);
		panelBase.add(panelBottom, BorderLayout.SOUTH);

		setContentPane(panelBase);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Questao1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int qtd = Integer.parseInt(txtQtd.getText());
		int tempo = Integer.parseInt(txtTempo.getText());
		int tempoSegundos = tempo*1000;
		
		
		Producao producao = new Producao(txtCount, qtd, tempoSegundos, pbProduzido);
		
		if (e.getSource() == btIniciar) {
			producao.start();
		}
	}

}
