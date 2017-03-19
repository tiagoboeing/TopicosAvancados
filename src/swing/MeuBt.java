package swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MeuBt extends JButton {
	
	public MeuBt(String texto){
		super(texto);
		super.setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
	}
	
}
