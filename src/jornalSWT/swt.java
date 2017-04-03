package jornalSWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class swt extends Shell {
	private Table table;
	private Text valorCm;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			swt shell = new swt(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public swt(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(9, 35, 414, 122);
		
		
		Label lblClculoDeCentmetros = new Label(this, SWT.NONE);
		lblClculoDeCentmetros.setBounds(9, 163, 264, 15);
		lblClculoDeCentmetros.setText("C\u00E1lculo de cent\u00EDmetros x colunas");
		
		Label lblTabelaDeValores = new Label(this, SWT.NONE);
		lblTabelaDeValores.setText("TABELA DE VALORES");
		lblTabelaDeValores.setBounds(9, 10, 264, 15);
		
		valorCm = new Text(this, SWT.BORDER);
		valorCm.setBounds(10, 184, 112, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("O Regional Sul");
		setSize(450, 456);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
