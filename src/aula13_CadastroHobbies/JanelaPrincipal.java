package aula13_CadastroHobbies;

import java.sql.Connection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import org.eclipse.swt.widgets.Composite;

public class JanelaPrincipal extends Shell {
	
	public static Connection conn = Conexao.conn();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaPrincipal shell = new JanelaPrincipal(display);
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
	public JanelaPrincipal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 10, 616, 582);
		
		TabItem tbtmCadastroDePessoas = new TabItem(tabFolder, SWT.NONE);
		tbtmCadastroDePessoas.setText("cadastro de Pessoas");
		
		Composite composite = new TelaCadPessoa(tabFolder, SWT.NONE);
		tbtmCadastroDePessoas.setControl(composite);
		
		TabItem tbtmCadastroDeHobbies = new TabItem(tabFolder, SWT.NONE);
		tbtmCadastroDeHobbies.setText("cadastro de Hobbies");
		
		Composite composite_1 = new TelaCadHobbies(tabFolder, SWT.NONE);
		tbtmCadastroDeHobbies.setControl(composite_1);
		
		TabItem tbtmAssociarHobbies = new TabItem(tabFolder, SWT.NONE);
		tbtmAssociarHobbies.setText("Associar Hobbies");
		
		Composite composite_2 = new TelaAssociarHobbies(tabFolder, SWT.NONE);
		tbtmAssociarHobbies.setControl(composite_2);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(654, 649);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
