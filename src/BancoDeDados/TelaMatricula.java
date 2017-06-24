package BancoDeDados;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class TelaMatricula extends Composite {
	private Text txtFiltraAluno;
	private Text txtFitraDisciplina;
	private Table tabelaAluno;
	private Table tabelaDisciplina;
	private Label lblDisciplina;
	private Label lblAluno;
	
	
	private Aluno alunoSel;
	private Disciplina disciplinaSel;
	
	
	
	ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
	
	ArrayList<Aluno> listaAlunoFiltrada = new ArrayList<Aluno>();
	
	ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	
	ArrayList<Disciplina> listaDisciplinaFiltrada = new ArrayList<Disciplina>();
	
	private TableColumn tblclmnNome;
	private TableColumn tblclmnCurso;
	private TableColumn tblclmnSemestre;
	private TableColumn tblclmnId;
	private TableColumn tblclmnNascimento;

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
		
		txtFiltraAluno = new Text(this, SWT.BORDER);
		txtFiltraAluno.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
				preencheTabelaFiltradaAluno(txtFiltraAluno.getText());
				
			}
		});
		txtFiltraAluno.setBounds(108, 21, 490, 21);
		
		txtFitraDisciplina = new Text(this, SWT.BORDER);
		txtFitraDisciplina.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
				preencheTabelaFiltradaDisciplina(txtFitraDisciplina.getText());
				
			}
		});
		txtFitraDisciplina.setBounds(121, 235, 477, 21);
		
		Label lblFiltrarDisciplina = new Label(this, SWT.NONE);
		lblFiltrarDisciplina.setText("Filtrar disciplina");
		lblFiltrarDisciplina.setBounds(32, 238, 83, 15);
		
		tabelaAluno = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				alunoSel = listaAluno.get(tabelaAluno.getSelectionIndex());
				lblAluno.setText("ALUNO : " + alunoSel.getNomeAluno());
				
			}
		});
		tabelaAluno.setBounds(32, 62, 566, 156);
		tabelaAluno.setHeaderVisible(true);
		tabelaAluno.setLinesVisible(true);
		
		tblclmnId = new TableColumn(tabelaAluno, SWT.NONE);
		tblclmnId.setWidth(377);
		tblclmnId.setText("Nome");
		
		tblclmnNascimento = new TableColumn(tabelaAluno, SWT.NONE);
		tblclmnNascimento.setWidth(126);
		tblclmnNascimento.setText("Nascimento");
		
		tabelaDisciplina = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaDisciplina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				disciplinaSel = listaDisciplina.get(tabelaDisciplina.getSelectionIndex());
				lblDisciplina.setText("DISCIPLINA : "+disciplinaSel.getNomeDisciplina());
				
			}
		});
		tabelaDisciplina.setLinesVisible(true);
		tabelaDisciplina.setHeaderVisible(true);
		tabelaDisciplina.setBounds(32, 269, 566, 156);
		
		tblclmnNome = new TableColumn(tabelaDisciplina, SWT.NONE);
		tblclmnNome.setWidth(231);
		tblclmnNome.setText("Nome");
		
		tblclmnCurso = new TableColumn(tabelaDisciplina, SWT.NONE);
		tblclmnCurso.setWidth(206);
		tblclmnCurso.setText("Curso");
		
		tblclmnSemestre = new TableColumn(tabelaDisciplina, SWT.NONE);
		tblclmnSemestre.setWidth(100);
		tblclmnSemestre.setText("Semestre");
		
		Group grpConfirmao = new Group(this, SWT.NONE);
		grpConfirmao.setText("Confirma\u00E7\u00E3o");
		grpConfirmao.setBounds(32, 438, 566, 111);
		
		lblAluno = new Label(grpConfirmao, SWT.NONE);
		lblAluno.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblAluno.setBounds(10, 21, 546, 20);
		lblAluno.setText("Aluno");
		
		lblDisciplina = new Label(grpConfirmao, SWT.NONE);
		lblDisciplina.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblDisciplina.setText("Disciplina");
		lblDisciplina.setBounds(10, 55, 546, 20);
		
		Button btnConfirma = new Button(grpConfirmao, SWT.NONE);
		btnConfirma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Matricula m = new Matricula();
				m.setAluno(alunoSel);
				m.setDisciplina(disciplinaSel);
				m.cadastraMatricula();
				
			}
		});
		btnConfirma.setBounds(481, 76, 75, 25);
		btnConfirma.setText("Confirma");
		
		
		preencheTabelaAluno();
		preencheTabelaDisciplina();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	
	private void preencheTabelaAluno(){
		
		listaAluno = Aluno.listaTodos();
		
		//limpa
		tabelaAluno.setItemCount(0);
		
		//preenche novamente
		for (Aluno a : listaAluno) {
			
			TableItem it = new TableItem(tabelaAluno, SWT.NONE);
			//it.setText(0, a.getId()+"");
			it.setText(0, a.getNomeAluno()+"");
			it.setText(1, a.getDtBr());
					
					
		}
		
	}
	
	//Preenche tabela com resultados da busca
	private void preencheTabelaFiltradaAluno(String textoBuscar){
		
		//textoBuscar = charAt(textoBuscar);
		
		listaAlunoFiltrada = Aluno.busca(textoBuscar);
				
		//limpa tabela
		tabelaAluno.setItemCount(0);
				
		for(Aluno alu : listaAlunoFiltrada){
					
				TableItem it = new TableItem(tabelaAluno, SWT.NONE);
					
				//it.setText(0, ab.getId()+"");
				it.setText(0, alu.getNomeAluno());
				it.setText(1, alu.getDtBr());
					
		}
		
	}

	private void preencheTabelaDisciplina(){
		
		listaDisciplina = Disciplina.listaDisciplinas();
		
		//limpa
		tabelaDisciplina.setItemCount(0);
		
		//preenche novamente
		for (Disciplina d : listaDisciplina) {
			
			TableItem it = new TableItem(tabelaDisciplina, SWT.NONE);
			
			it.setText(0, d.getNomeDisciplina());
			it.setText(1, d.getCursoDisciplina());
			it.setText(2, d.getSemestreDisciplina()+"");
					
					
		}
		
	}
	
	//Preenche tabela com resultados da busca
	private void preencheTabelaFiltradaDisciplina(String textoBuscar){
		
		//textoBuscar = charAt(textoBuscar);
		
		listaDisciplina = Disciplina.buscaDisciplina(textoBuscar);
				
		//limpa tabela
		tabelaDisciplina.setItemCount(0);
				
		for(Disciplina d : listaDisciplina){
					
				TableItem it = new TableItem(tabelaDisciplina, SWT.NONE);
					
				it.setText(0, d.getNomeDisciplina());
				it.setText(1, d.getCursoDisciplina());
				it.setText(2, d.getSemestreDisciplina()+"");
					
		}
		
	}
	
	
	
	
}
