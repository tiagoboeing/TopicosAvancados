package TrabalhoFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

public class Principal extends Shell {

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
		tabFolder.setBounds(10, 10, 537, 422);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmCadastroDePessoas = new CTabItem(tabFolder, SWT.NONE);
		tbtmCadastroDePessoas.setText("Cadastro de pessoas");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCadastroDePessoas.setControl(composite);
		
		CTabItem tbtmCadastroDeHobbies = new CTabItem(tabFolder, SWT.NONE);
		tbtmCadastroDeHobbies.setText("Cadastro de hobbies");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmCadastroDeHobbies.setControl(composite_1);
		createContents();
		
		
		getPegaDataAtual();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(573, 481);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private String checaSexo(String masc, String fem){
		
		if(masc.equals("Masculino")){
			return "M";
		} else {
			return "F";
		}
		
	}
	
	
/*	private String retorna(String sexo){
		
		if(masc.equals("M")){
			return "Masculino";
		} else {
			return "Feminino";
		}
		
	}
	*/
	

	public String getPegaDataAtual() {
		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy"); 
		System.out.print(formatarDate.format(data));
		
		return formatarDate.format(data);
	}
	
	
	

	
	
	//checaSexo(btnMasculino.getText(), btnFeminino.getText());
	
}
