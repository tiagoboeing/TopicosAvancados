package swt.template;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

public class TelaPrincipal extends Shell {
	private CTabFolder tabFolder;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			TelaPrincipal shell = new TelaPrincipal(display);
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
	public TelaPrincipal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmCadastros_1 = new MenuItem(menu, SWT.CASCADE);
		mntmCadastros_1.setText("Cadastros");
		
		Menu menu_1 = new Menu(mntmCadastros_1);
		mntmCadastros_1.setMenu(menu_1);
		
		MenuItem mntmCidade = new MenuItem(menu_1, SWT.NONE);
		mntmCidade.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Composite c = new TelaCidade(tabFolder, SWT.NONE);
				abreAba(c, "Cadastro de cidades");
			}
		});
		mntmCidade.setText("Cidade");
		
		MenuItem mntmPessoa = new MenuItem(menu_1, SWT.NONE);
		mntmPessoa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Composite c = new TelaPessoa(tabFolder, SWT.NONE);
				abreAba(c, "Cadastro de pessoas");
			}
		});
		mntmPessoa.setText("Pessoa");
		
		MenuItem mntmRelatrios_1 = new MenuItem(menu_1, SWT.CASCADE);
		mntmRelatrios_1.setText("Relat\u00F3rios");
		
		Menu menu_2 = new Menu(mntmRelatrios_1);
		mntmRelatrios_1.setMenu(menu_2);
		
		MenuItem mntmCidade_1 = new MenuItem(menu_2, SWT.NONE);
		mntmCidade_1.setText("Cidade");
		
		MenuItem mntmPessoa_1 = new MenuItem(menu_2, SWT.NONE);
		mntmPessoa_1.setText("Pessoa");
		
		MenuItem mntmSair = new MenuItem(menu_1, SWT.NONE);
		mntmSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		mntmSair.setText("Sair");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(10, 10, 612, 426);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		

	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(648, 517);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void abreAba(Composite c, String titulo){
		
		CTabItem teste1 = new CTabItem(tabFolder, SWT.NONE);
		teste1.setShowClose(true);
		teste1.setText("Teste 1");
		teste1.setText(titulo);
		teste1.setControl(c);
		tabFolder.setSelection(teste1);
		
		
	}
	
}
