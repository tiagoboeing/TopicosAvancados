package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener {
	
	private JLabel lblN1, lblN2, lblRes;
	private JTextField txtN1, txtN2, txtRes;
	private JButton btSoma, btSub, btMult, btDiv;
	
	public Calculadora(){
		super("Calculadora");
		JPanel painel = new JPanel(new GridLayout(5, 2, 1, 3));
		
		lblN1 = new JLabel("N�mero 1 :");
		lblN2 = new JLabel("N�mero 2 :");
		lblRes = new JLabel("Resultado :");
		lblRes.setFont(new Font("arial", Font.BOLD,30));
		
		
		txtN1 = new JTextField(10);
		txtN2 = new JTextField(10);
		txtRes = new JTextField(10);
		txtRes.setFont(new Font("arial", Font.BOLD,20));
		txtRes.setEditable(false);
		
		
		btSoma = new JButton("Somar");
		btSub = new JButton("Subtrair");
		btMult = new JButton("Multiplicar");
		btDiv = new JButton("Dividir");
		
		btSoma.addActionListener(this);
		btSub.addActionListener(this);
		btMult.addActionListener(this);
		btDiv.addActionListener(this);
		
		
		
		painel.add(lblN1);
		painel.add(txtN1);
		painel.add(lblN2);
		painel.add(txtN2);
		painel.add(btSoma);
		painel.add(btSub);
		painel.add(btMult);
		painel.add(btDiv);
		painel.add(lblRes);
		painel.add(txtRes);
		
		
		//n�o deixa maximizar a tela : setResizable(false);
		//n�o miniza a tela : setAlwaysOnTop(true);
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		//setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculadora();
	}

	//a��es que fizer no mouse tem que programar abaixo
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DecimalFormat df = new DecimalFormat("#0.00");
		double n1 = Double.parseDouble(txtN1.getText());
		double n2 = Double.parseDouble(txtN2.getText());
		double r = 0;
		if(e.getSource() == btSoma)
			r = n1 + n2;
		if(e.getSource() == btSub)
			r = n1 - n2;
		if(e.getSource() == btDiv)
			r = n1 / n2;
		if(e.getSource() == btMult)
			r = n1 * n2;
		
		txtRes.setText(df.format(r));
		//borda vermelha se o resultado for zero
		
		if(r ==0)
			txtRes.setBorder(BorderFactory.createLineBorder(Color.RED,10));
		
	}
}
