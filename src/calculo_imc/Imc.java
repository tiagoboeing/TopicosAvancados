package calculo_imc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Imc extends JFrame implements ActionListener{
	
	private JLabel Nome, Sexo, Peso, Altura, Resultado, label1,	pulaLinha, pulaLinha1, pulaLinha2; 
	private JTextField txtNome, txtPeso, txtAltura, txtResultado;
	private JButton btIMC;
	private ButtonGroup grSexo = new ButtonGroup();
	private JRadioButton rdM, rdF;
	
	public Imc(){
		setTitle("Imc");
		//JPanel painel = new JPanel(new GridLayout(11, 2, 5, 10));
		JPanel painel = new JPanel(new GridLayout(8, 2, 5, 10));

		
		label1 = new JLabel("*** IMC ***");
		label1.setForeground(Color.BLACK);
		//label1.setForeground(new Color(0, 174, 235));
		label1.setFont(new Font("arial",Font.BOLD+Font.ITALIC,30));
		
		pulaLinha = new JLabel();
		pulaLinha1 = new JLabel();
		pulaLinha2 = new JLabel();

		Nome = new JLabel("Nome :");
		Sexo = new JLabel("Sexo :");
		Peso = new JLabel("Peso :");		
		Altura = new JLabel("Altura :");
		Resultado = new JLabel("Resultado :");
		Resultado.setFont(new Font("arial", Font.BOLD,30));
		

		txtNome = new JTextField(10);
		txtPeso = new JTextField(10);
		txtAltura = new JTextField(10);
		txtResultado = new JTextField(10);
		txtResultado.setFont(new Font("arial", Font.BOLD,20));
		txtResultado.setEditable(false);
		
		rdM = new JRadioButton("Masculino");
		rdF = new JRadioButton("Feminino");
		rdM.setSelected(true);
		grSexo.add(rdM);
		grSexo.add(rdF);		
		
		
		btIMC = new JButton("Calcular IMC : ");
		
		btIMC.addActionListener(this);		
		
		painel.add(label1);
		painel.add(pulaLinha);
		painel.add(Nome);
		painel.add(txtNome);
		painel.add(Sexo);
		painel.add(pulaLinha1);
		painel.add(rdM);
		painel.add(rdF);
		painel.add(Peso);
		painel.add(txtPeso);
		painel.add(Altura);
		painel.add(txtAltura);
		painel.add(btIMC);
		painel.add(pulaLinha2);
		painel.add(txtResultado);
		
		
		//não deixa maximizar a tela : setResizable(false);
		//não miniza a tela : setAlwaysOnTop(true);
		setContentPane(painel);
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		//setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Imc();
	}

	//ações que fizer no mouse tem que programar abaixo
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DecimalFormat df = new DecimalFormat("##.##");
		double n1 = Double.parseDouble(txtPeso.getText());
		double n2 = Double.parseDouble(txtAltura.getText());
		double r = 0;
		if(e.getSource() == btIMC)
			r = n1 / (n2*n2);
		txtResultado.setText(df.format(r));
		//borda vermelha se o resultado for zero
		
		if(r == 0)
			txtResultado.setBorder(BorderFactory.createLineBorder(Color.RED,10));
		
	}

}
