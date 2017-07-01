package aula13_CadastroHobbies;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TelaCadHobbies extends Composite {
	private Text txtNomeHobbie;
	private Text txtFiltro;
	private Table tabelaListaHobbies;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaCadHobbies(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 21, 70, 20);
		lblNome.setText("Nome");
		
		txtNomeHobbie = new Text(this, SWT.BORDER);
		txtNomeHobbie.setBounds(86, 15, 272, 26);
		
		Button btnInserir = new Button(this, SWT.NONE);
		btnInserir.setBounds(10, 71, 90, 30);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.setBounds(146, 71, 90, 30);
		btnAlterar.setText("Alterar");
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.setBounds(268, 71, 90, 30);
		btnExcluir.setText("Excluir");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(10, 136, 70, 20);
		lblFiltro.setText("Filtro");
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.setBounds(86, 136, 272, 26);
		
		tabelaListaHobbies = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaListaHobbies.setBounds(10, 189, 348, 242);
		tabelaListaHobbies.setHeaderVisible(true);
		tabelaListaHobbies.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(tabelaListaHobbies, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("C\u00F3digo");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(tabelaListaHobbies, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Nome");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
