package swt;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class ExemploSWT extends Shell {
	private Text txtNome;
	private DateTime txtData;
	private Button rdM;
	private Button rdF;
	private Button ckM;
	private Button ckV;
	private Button ckN;
	private Table table;
	
	private ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	private Label lblN;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ExemploSWT shell = new ExemploSWT(display);
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
	public ExemploSWT(Display display) {
		super(display, SWT.SHELL_TRIM);
		//setImage(SWTResourceManager.getImage(ExemploSWT.class, "/img/edit.png"));
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 13, 41, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				lblN.setText(txtNome.getText().toUpperCase());
			}
		});
		txtNome.setBounds(10, 32, 260, 24);
		
		Label lblDataDeNascimento = new Label(this, SWT.NONE);
		lblDataDeNascimento.setBounds(276, 13, 80, 15);
		lblDataDeNascimento.setText("Data de Nasc.");
		
		txtData = new DateTime(this, SWT.DROP_DOWN);
		txtData.setBounds(276, 32, 80, 24);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 59, 229, 64);
		
		rdM = new Button(grpSexo, SWT.RADIO);
		rdM.setBounds(10, 20, 90, 16);
		rdM.setText("Masculino");
		
		rdF = new Button(grpSexo, SWT.RADIO);
		rdF.setBounds(126, 20, 90, 16);
		rdF.setText("Feminino");
		
		Group grpTurno = new Group(this, SWT.NONE);
		grpTurno.setText("Turno");
		grpTurno.setBounds(250, 59, 269, 64);
		
		ckM = new Button(grpTurno, SWT.CHECK);
		ckM.setBounds(10, 26, 70, 16);
		ckM.setText("Matutino");
		
		ckV = new Button(grpTurno, SWT.CHECK);
		ckV.setBounds(86, 26, 76, 16);
		ckV.setText("Vespertino");
		
		ckN = new Button(grpTurno, SWT.CHECK);
		ckN.setBounds(168, 26, 70, 16);
		ckN.setText("Noturno");
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cadastra();
				listar();
			}
		});
		//btnCadastrar.setImage(SWTResourceManager.getImage(ExemploSWT.class, "/img/edit.png"));
		btnCadastrar.setBounds(10, 129, 102, 32);
		btnCadastrar.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					int indice = table.getSelectionIndex();
					lista.remove(indice);
					listar();
				} catch (Exception e2) {
					
				}
			}
		});
		table.setBounds(10, 167, 509, 176);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(91);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnDataNasc = new TableColumn(table, SWT.NONE);
		tblclmnDataNasc.setWidth(79);
		tblclmnDataNasc.setText("Data Nasc.");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(47);
		tblclmnSexo.setText("Sexo");
		
		TableColumn tblclmnMatutino = new TableColumn(table, SWT.NONE);
		tblclmnMatutino.setWidth(65);
		tblclmnMatutino.setText("Matutino");
		
		TableColumn tblclmnVespetino = new TableColumn(table, SWT.NONE);
		tblclmnVespetino.setWidth(100);
		tblclmnVespetino.setText("Vespetino");
		
		TableColumn tblclmnNoturno = new TableColumn(table, SWT.NONE);
		tblclmnNoturno.setWidth(100);
		tblclmnNoturno.setText("Noturno");
		
		lblN = new Label(this, SWT.NONE);
		lblN.setBounds(362, 41, 157, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Exemplo SWT");
		setSize(545, 391);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void cadastra(){
		Pessoa p = new Pessoa();
		p.setNome(txtNome.getText());
		p.setData(txtData.getDay()+"/"+(txtData.getMonth()+1)+"/"+txtData.getYear());
		p.setSexo(rdM.getSelection()?"Masculino":"Feminino");
		p.setMat(ckM.getSelection()?true:false);
		p.setVesp(ckV.getSelection()?true:false);
		p.setNot(ckN.getSelection()?true:false);
		lista.add(p);
	}
	
	private void listar(){
		table.setItemCount(0);
		for (Pessoa p : lista) {
			TableItem it = new TableItem(table, SWT.NONE);
			it.setText(p.toArray());
		}
	}
}
