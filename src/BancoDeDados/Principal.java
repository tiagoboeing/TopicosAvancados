package BancoDeDados;

import java.sql.Connection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

public class Principal extends Shell {
	
	
	public static Connection conn = Conexao.conn();
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Principal shell = new Principal(display);
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
	public Principal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(10, 10, 687, 596);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Cadastro aluno");
		
		Composite composite = new TelaCadastroAluno(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		
		CTabItem tbtmMatrcula = new CTabItem(tabFolder, SWT.NONE);
		tbtmMatrcula.setText("Matr\u00EDcula");
		
		Composite TelaMatricula = new TelaMatricula(tabFolder, SWT.NONE);
		tbtmMatrcula.setControl(TelaMatricula);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(723, 655);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
