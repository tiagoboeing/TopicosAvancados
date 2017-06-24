package BancoDeDados;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import jornalSWT.swt;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//SELECT *
//FROM Aluno, Disciplina
//INNER JOIN Aluno_disciplina on id_aluno = alu_id and id_disciplina = dis_id

public class TelaConsulta extends Composite {
	private Table tabelaListagem;
	private TableColumn tblclmnNewColumn;
	private TableColumn tblclmnCurso;
	private Combo comboFiltro;
	private TableColumn tblclmnSemestre;
	private Button rd4;
	private Button rd3;
	private Button rd2;
	private Button rd1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public TelaConsulta(Composite parent, int style) {
		super(parent, style);

		Button btnPesquisar = new Button(this, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(rd1.getSelection()){
					filtro1();
				}
				
			}
		});
		btnPesquisar.setBounds(297, 167, 97, 30);
		btnPesquisar.setText("Pesquisar");

		comboFiltro = new Combo(this, SWT.NONE);
		comboFiltro.setBounds(73, 169, 200, 28);

		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(10, 172, 57, 20);
		lblFiltro.setText("Filtrar :");
		
		Group grpTipoDeBusca = new Group(this, SWT.NONE);
		grpTipoDeBusca.setText("Tipo de busca");
		grpTipoDeBusca.setBounds(10, 10, 384, 151);
		
		rd1 = new Button(grpTipoDeBusca, SWT.RADIO);
		rd1.setBounds(10, 31, 238, 20);
		rd1.setText("Listar alunos de uma Disciplina");
		
		rd2 = new Button(grpTipoDeBusca, SWT.RADIO);
		rd2.setBounds(10, 58, 238, 20);
		rd2.setText("Listar disciplinas de um Aluno");
		
		rd3 = new Button(grpTipoDeBusca, SWT.RADIO);
		rd3.setBounds(10, 84, 238, 20);
		rd3.setText("Listar alunos por Semestre");
		
		rd4 = new Button(grpTipoDeBusca, SWT.RADIO);
		rd4.setBounds(10, 110, 238, 20);
		rd4.setText("Listar disciplinas por Semestre");
		
		tabelaListagem = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaListagem.setBounds(10, 214, 385, 274);
		tabelaListagem.setHeaderVisible(true);
		tabelaListagem.setLinesVisible(true);
		
		tblclmnSemestre = new TableColumn(tabelaListagem, SWT.NONE);
		tblclmnSemestre.setText("Semestre");
		tblclmnSemestre.setWidth(80);
		
		tblclmnNewColumn = new TableColumn(tabelaListagem, SWT.NONE);
		tblclmnNewColumn.setText("Nome");
		tblclmnNewColumn.setWidth(137);
		
		tblclmnCurso = new TableColumn(tabelaListagem, SWT.NONE);
		tblclmnCurso.setText("Curso");
		tblclmnCurso.setWidth(159);


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	
	private void preencheComSemestre(){
		
		comboFiltro.setItems(new String[]{});
		semestres = Disciplina.listaSemestres();
		
		for(Integer i : semestres){
			comboFiltro.add(i+"");
		}
		
	}
	
	
	private void filtro1(){
		
		int indice = comboFiltro.getSelectionIndex();
		Disciplina sel = rd1.getSelection(indice);
		ArrayList<Aluno> l = BdUtil.listaAlunoPorDisciplina(sel);
		
		for(Aluno a : l){
			TableItem it = new TableItem(tabelaListagem, SWT.NONE);
			it.setText(1, a.getNomeAluno());
			it.setText(a.getDtBr());
		}
		
	}
	
	
}