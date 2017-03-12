/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;

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
    
    private String[] ufs = new String[]{"SC","RS","PR","SP"};
    
    private JLabel label1, label2;
    private JTextField txt;
    private JPasswordField pass;
    private JButton button;
    private JToggleButton tbt;
    private ButtonGroup grSexo = new ButtonGroup();
    private JRadioButton rdM, rdF;
    private JCheckBox ckm, ckv, ckn;
    private JComboBox<String> combo;
    private JTextArea area;
    
    public Janela1(){
        setTitle("Janela 1");
        JPanel painel = new JPanel();
        
        label1 = new JLabel("Label texto");
        //label1.setForeground(new Color(0, 174, 235));
        //label1.setFont(new Font("arial", Font.BOLD+Font.ITALIC,18));
        
        
        label2 = new JLabel(new ImageIcon("src/img/image.png"));
        label2.setText("Seleção canarinho");
        label2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        //campos de formulários
        JTextField txt = new JTextField(10);
        txt.setBackground(Color.YELLOW);
        JPasswordField pass = new JPasswordField(10);
        
        //botão
        JButton button = new JButton("Sair");
        tbt = new JToggleButton("Ligar");
        
        rdM = new JRadioButton("Masculino");
        rdF = new JRadioButton("Feminino");
        grSexo.add(rdM);
        grSexo.add(rdF);
        
        ckm = new JCheckBox("Matutino");
        ckv = new JCheckBox("Vespertino");
        ckn = new JCheckBox("Noturno");
        
        combo = new JComboBox<String>(ufs);
        combo.setMaximumRowCount(3);
        combo.setToolTipText("selecione a UF");
        
        area = new JTextArea(10, 5);
        area.setLineWrap(true);

        JScrollPane br = new JScrollPane(area);
        br.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        br.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //cola na janela
        painel.add(label1);
        painel.add(label2);
        painel.add(txt);
        painel.add(pass);
        painel.add(tbt);
        painel.add(rdM);
        painel.add(rdF);
        painel.add(button);
        painel.add(ckm);
        painel.add(ckv);
        painel.add(ckn);
        painel.add(combo);
        painel.add(br);
        
        
        //cria frame
        setContentPane(painel);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Janela1();
    }
    
}
