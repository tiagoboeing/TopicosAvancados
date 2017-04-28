package Prova1_Sem_Anterior_q2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Principal extends Shell {
	private CTabFolder tabFolder;

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
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmArquivo_1 = new MenuItem(menu, SWT.CASCADE);
		mntmArquivo_1.setText("Arquivo");
		
		Menu menu_1 = new Menu(mntmArquivo_1);
		mntmArquivo_1.setMenu(menu_1);
		
		MenuItem mntmPaciente = new MenuItem(menu_1, SWT.NONE);
		mntmPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmPaciente = isOpen("Aba Paciente");
				if (tbtmPaciente == null) {
					tbtmPaciente = new CTabItem(tabFolder, SWT.NONE);
					tbtmPaciente.setShowClose(true);
					tbtmPaciente.setText("Aba Paciente");
				
					Composite composite = new AbaPaciente(tabFolder, SWT.NONE);
					tbtmPaciente.setControl(composite);
				}
				tabFolder.setSelection(tbtmPaciente);
			}
		});
		mntmPaciente.setText("Paciente");
		
		MenuItem mntmMedicamento = new MenuItem(menu_1, SWT.NONE);
		mntmMedicamento.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmMedicamento = isOpen("Aba Medicamento");
				if (tbtmMedicamento == null) {
					tbtmMedicamento = new CTabItem(tabFolder, SWT.NONE);
					tbtmMedicamento.setShowClose(true);
					tbtmMedicamento.setText("Aba Medicamento");
				
					Composite composite = new AbaMedicamento(tabFolder, SWT.NONE);
					tbtmMedicamento.setControl(composite);
				}
				tabFolder.setSelection(tbtmMedicamento);
			}
		});
		mntmMedicamento.setText("Medicamento");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmSair = new MenuItem(menu_1, SWT.NONE);
		mntmSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		mntmSair.setText("Sair");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 0, 550, 329);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(566, 388);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private CTabItem isOpen(String janela) {
		for (CTabItem item : tabFolder.getItems()) {
			if (item.getText().equals(janela)) {
				return item;
			}
		}
		return null;
	}

}
