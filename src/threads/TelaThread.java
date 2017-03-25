package threads;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class TelaThread extends JFrame{
	
	public static JTextField txtQtF1,txtQtF2, txtTempoF1, txtTempoF2;
	public static JProgressBar barF1, barF2;
	public static JButton btIniciar;
	
	public TelaThread() {
		super("Threads");
				
		JPanel painel = new JPanel(new GridLayout(2 , 2));
		
		JLabel lblQt = new JLabel("QT");
		JLabel lblTempo = new JLabel("Tempo");
		JLabel lblQt1 = new JLabel("QT");
		JLabel lblTempo1 = new JLabel("Tempo");
		JLabel lblF1 = new JLabel("Funcionario 1");
		JLabel lblF2 = new JLabel("Funcionario 2");
		lblF1.setHorizontalAlignment(JLabel.CENTER);
		lblF2.setHorizontalAlignment(JLabel.CENTER);
		
		txtQtF1 = new JTextField(10);
		txtQtF2 = new JTextField(10);
		txtTempoF1 = new JTextField(10);
		txtTempoF2 = new JTextField(10);
		
		barF1 = new JProgressBar();
		barF2 = new JProgressBar();
		
		btIniciar = new JButton("Iniciar");
		
		JPanel pnlF1 = new JPanel(new GridLayout(3, 1));
		JPanel pnlF2 = new JPanel(new GridLayout(3, 1));
		JPanel pnldadosF1 = new JPanel(new GridLayout(2, 2));
		JPanel pnldadosF2 = new JPanel(new GridLayout(2, 2));
		
		pnlF1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlF2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		pnldadosF1.add(lblQt);
		pnldadosF1.add(txtQtF1);
		pnldadosF1.add(lblTempo);
		pnldadosF1.add(txtTempoF1);
		
		pnldadosF2.add(lblQt1);
		pnldadosF2.add(txtQtF2);
		pnldadosF2.add(lblTempo1);
		pnldadosF2.add(txtTempoF2);
		
		pnlF1.add(lblF1);
		pnlF1.add(pnldadosF1);
		pnlF1.add(barF1);

		pnlF2.add(lblF2);
		pnlF2.add(pnldadosF2);
		pnlF2.add(barF2);
		
		painel.add(pnlF1);
		painel.add(pnlF2);
		
		TelaThreadBack back = new TelaThreadBack();
 		painel.add(btIniciar);
 		btIniciar.addActionListener(back);
		
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaThread();
	}

}
