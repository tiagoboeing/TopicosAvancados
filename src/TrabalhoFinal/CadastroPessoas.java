package TrabalhoFinal;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class CadastroPessoas extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CadastroPessoas(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(22, 21, 55, 15);
		lblNome.setText("Nome:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(83, 15, 289, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(22, 61, 103, 71);
		
		Button btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setBounds(10, 22, 90, 16);
		btnMasculino.setText("Masculino");
		
		Button btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setBounds(10, 44, 90, 16);
		btnFeminino.setText("Feminino");
		
		DateTime dateTime = new DateTime(this, SWT.DROP_DOWN);
		dateTime.setBounds(144, 93, 103, 24);
		
		Label lblDataDeNasc = new Label(this, SWT.NONE);
		lblDataDeNasc.setBounds(144, 72, 67, 15);
		lblDataDeNasc.setText("Data de nasc");
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.setBounds(22, 150, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.setText("Alterar");
		btnAlterar.setBounds(117, 150, 75, 25);
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(213, 149, 75, 25);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 199, 523, 190);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(68);
		tblclmnNewColumn.setText("ID");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(202);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(133);
		tblclmnNewColumn_1.setText("Sexo");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(103);
		tblclmnIdade.setText("Idade");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
