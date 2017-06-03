package BancoDeDados;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaCadastroAluno extends Composite {
	private Text text_1;
	private Table tabelaAlunos;
	private DateTime dataNasc;
	
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaCadastroAluno(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 13, 55, 15);
		lblNome.setText("Nome:");
		
		Text txtNomeAluno = new Text(this, SWT.BORDER);
		txtNomeAluno.setBounds(80, 10, 342, 21);
		
		Label lblNascimento = new Label(this, SWT.NONE);
		lblNascimento.setText("Nascimento");
		lblNascimento.setBounds(10, 56, 64, 15);
		
		dataNasc = new DateTime(this, SWT.DROP_DOWN);
		dataNasc.setBounds(80, 47, 114, 24);
		
		Button btnInserir = new Button(this, SWT.NONE);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					Aluno a = new Aluno();
					
					a.setNomeAluno(txtNomeAluno.getText());
					
					String data = dataNasc.getYear() + "-" + (dataNasc.getMonth()+1) + "-" + dataNasc.getDay();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					
					a.setDataNasc(df.parse(data));
					
					a.cadastra();

					preencheTabela();
				
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnInserir.setBounds(10, 106, 75, 25);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.setText("Alterar");
		btnAlterar.setBounds(130, 106, 75, 25);
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(248, 106, 75, 25);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(59, 152, 363, 21);
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setText("Filtro");
		lblFiltro.setBounds(10, 158, 40, 15);
		
		tabelaAlunos = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaAlunos.setBounds(10, 194, 412, 235);
		tabelaAlunos.setHeaderVisible(true);
		tabelaAlunos.setLinesVisible(true);
		
		TableColumn tblclmnCod = new TableColumn(tabelaAlunos, SWT.NONE);
		tblclmnCod.setWidth(53);
		tblclmnCod.setText("Cod");
		
		TableColumn tblclmnNome = new TableColumn(tabelaAlunos, SWT.NONE);
		tblclmnNome.setWidth(241);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnNascimento = new TableColumn(tabelaAlunos, SWT.NONE);
		tblclmnNascimento.setWidth(100);
		tblclmnNascimento.setText("Nascimento");

		preencheTabela();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private void preencheTabela(){
		
		listaAlunos = Aluno.listaTodos();
		tabelaAlunos.setItemCount(0);
		
		for(Aluno a : listaAlunos){
			TableItem it = new TableItem(tabelaAlunos, SWT.NONE);
			
			it.setText(0, a.getIdAluno()+"");
			it.setText(1, a.getNomeAluno());
			it.setText(2, a.getDtBr());
			
		}
		
	}
	
	
}
