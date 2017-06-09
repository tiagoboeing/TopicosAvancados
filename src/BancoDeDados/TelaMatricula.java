package BancoDeDados;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class TelaMatricula extends Composite {
	private Text text;
	private Text text_1;
	private Table table;
	private Table table_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaMatricula(Composite parent, int style) {
		super(parent, style);
		
		Label lblFiltrarAluno = new Label(this, SWT.NONE);
		lblFiltrarAluno.setBounds(32, 24, 63, 15);
		lblFiltrarAluno.setText("Filtrar aluno");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(108, 21, 490, 21);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(121, 235, 477, 21);
		
		Label lblFiltrarDisciplina = new Label(this, SWT.NONE);
		lblFiltrarDisciplina.setText("Filtrar disciplina");
		lblFiltrarDisciplina.setBounds(32, 238, 83, 15);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(32, 62, 566, 156);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(377);
		tblclmnId.setText("Nome");
		
		TableColumn tblclmnNascimento = new TableColumn(table, SWT.NONE);
		tblclmnNascimento.setWidth(126);
		tblclmnNascimento.setText("Nascimento");
		
		table_1 = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(32, 269, 566, 156);
		
		TableColumn tblclmnNome = new TableColumn(table_1, SWT.NONE);
		tblclmnNome.setWidth(231);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnCurso = new TableColumn(table_1, SWT.NONE);
		tblclmnCurso.setWidth(206);
		tblclmnCurso.setText("Curso");
		
		TableColumn tblclmnSemestre = new TableColumn(table_1, SWT.NONE);
		tblclmnSemestre.setWidth(100);
		tblclmnSemestre.setText("Semestre");
		
		Group grpConfirmao = new Group(this, SWT.NONE);
		grpConfirmao.setText("Confirma\u00E7\u00E3o");
		grpConfirmao.setBounds(32, 438, 566, 111);
		
		Label lblAluno = new Label(grpConfirmao, SWT.NONE);
		lblAluno.setBounds(10, 29, 55, 15);
		lblAluno.setText("Aluno");
		
		Label lblDisciplina = new Label(grpConfirmao, SWT.NONE);
		lblDisciplina.setText("Disciplina");
		lblDisciplina.setBounds(10, 65, 55, 15);
		
		Button btnConfirma = new Button(grpConfirmao, SWT.NONE);
		btnConfirma.setBounds(481, 76, 75, 25);
		btnConfirma.setText("Confirma");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
