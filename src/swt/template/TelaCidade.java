package swt.template;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TelaCidade extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaCidade(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 55, 15);
		lblNome.setText("Nome");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(70, 7, 241, 21);
		
		Label lblUf = new Label(this, SWT.NONE);
		lblUf.setText("UF");
		lblUf.setBounds(10, 47, 55, 15);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(70, 44, 160, 21);
		
		Button btnSalvar = new Button(this, SWT.NONE);
		btnSalvar.setBounds(236, 40, 75, 25);
		btnSalvar.setText("Salvar");
		
		Button btnInativar = new Button(this, SWT.CHECK);
		btnInativar.setBounds(10, 85, 93, 16);
		btnInativar.setText("Inativar");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setText("Filtro");
		lblFiltro.setBounds(10, 125, 55, 15);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(72, 122, 322, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 162, 412, 196);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(235);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnUf = new TableColumn(table, SWT.NONE);
		tblclmnUf.setWidth(100);
		tblclmnUf.setText("UF");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
