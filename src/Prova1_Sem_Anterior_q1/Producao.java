package Prova1_Sem_Anterior_q1;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Producao extends Thread {
	
	private JTextField txtCount;
	private int qt, tempo;
	private JProgressBar progress;
	
	public Producao(JTextField txtCount, int qt, int tempo, JProgressBar progress) {
		this.txtCount = txtCount;
		this.qt = qt;
		this.tempo = tempo;
		this.progress = progress;
		this.progress.setMaximum(qt);
		this.progress.setValue(0);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < qt; i++) {
			progress.setValue(i+1);
			txtCount.setText(i+1+"");
			try {
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
