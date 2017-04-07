package swt.template;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TelaPessoa extends Composite {
	private Text text;
	private Button btnFeminino;
	private Button btnMasculino;
	private Table table;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaPessoa(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 16, 55, 15);
		lblNome.setText("Nome");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(71, 13, 231, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(311, 10, 250, 64);
		
		btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setBounds(10, 29, 90, 16);
		btnMasculino.setText("Masculino");
		
		btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setBounds(127, 29, 90, 16);
		btnFeminino.setText("Feminino");
		
		Label lblCidade = new Label(this, SWT.NONE);
		lblCidade.setBounds(10, 53, 55, 15);
		lblCidade.setText("Cidade");
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(71, 51, 231, 23);
		
		Button btnInativar = new Button(this, SWT.CHECK);
		btnInativar.setBounds(10, 97, 93, 16);
		btnInativar.setText("Inativar");
		
		Button btnSalvar = new Button(this, SWT.NONE);
		btnSalvar.setBounds(10, 130, 75, 25);
		btnSalvar.setText("Salvar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 203, 551, 171);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(100);
		tblclmnSexo.setText("Sexo");
		
		TableColumn tblclmnCidade = new TableColumn(table, SWT.NONE);
		tblclmnCidade.setWidth(100);
		tblclmnCidade.setText("Cidade");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setText("Filtro");
		lblFiltro.setBounds(10, 179, 55, 15);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(71, 176, 490, 21);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
