package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


@SuppressWarnings("serial")
public class Janela1 extends JFrame{
	
	private String[] ufs = new String[]{"SC", "RS", "PR", "SP"};
	
	private JLabel label1, label2;
	private JTextField txt;
	private JPasswordField pass;
	private JButton bt;
	private JToggleButton gbt;
	private ButtonGroup grSexo = new ButtonGroup();
	private JRadioButton rdM, rdF;
	private MeuBt bt2;
	private JCheckBox ckm,ckv,ckn;
	private JComboBox<String> combo;
	private JTextArea area;
	
		public Janela1(){
		setTitle("Janela 1");
		JPanel painel = new JPanel();
		
		label1 = new JLabel("Label texto");
		label1.setForeground(Color.BLUE);
		//label1.setForeground(new Color(0, 174, 235));
		label1.setFont(new Font("arial",Font.BOLD+Font.ITALIC,30));
		
		
		label2 = new JLabel(new ImageIcon("src/img/índice.jpg"));
		label2.setText("Curtir");
		label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
		
		
		txt = new JTextField(20);
		txt.setBackground(Color.GREEN);
		
		
		pass = new JPasswordField(10);
		
		
		bt = new JButton("SAIR");
		bt.setIcon(new ImageIcon("src/img/ssss.jpg"));
		
		
		gbt = new JToggleButton("Ligar");
		
		
		rdM = new JRadioButton("Masculino");
		rdF = new JRadioButton("Feminino");
		rdM.setSelected(true);
		grSexo.add(rdM);
		grSexo.add(rdF);
		
				
		bt2 = new MeuBt("xxx");
		
		
		ckm = new JCheckBox("Matutino");
		ckv = new JCheckBox("Vespertino");
		ckn = new JCheckBox("Noturno");
		
		
		combo = new JComboBox<String>(ufs);
		combo.setMaximumRowCount(2);
		combo.setToolTipText("Selecione a UF :");
		
		
		area = new JTextArea(10,5);
		//area.setLineWrap(true);
		
		JScrollPane br = new JScrollPane(area);
		
		//nunca estar visivel : é só utilizar o area.setLineWrap(true); 
		
		//ate chegar no limite aparecer
		br.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//estar sempre visivel
		br.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		painel.add(label1);
		painel.add(label2);
		painel.add(txt);
		painel.add(pass);
		painel.add(bt);
		painel.add(gbt);
		painel.add(rdM);
		painel.add(rdF);
		painel.add(bt2);
		painel.add(ckm);
		painel.add(ckv);
		painel.add(ckn);
		painel.add(combo);
		painel.add(br);
		
		
		setContentPane(painel);
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	public static void main(String[] args){
		new Janela1();
		
	}

}
