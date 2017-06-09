package BancoDeDados;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
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
	private Button btnAlterar;
	private Button btnSalvarAlteracoes;
	
	
	private Integer editandoId;
	public String guardaIndice;
	
	
	private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	private Button btnExcluirTudo;
	

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
		
		btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				btnSalvarAlteracoes.setEnabled(true);
				
				try {
										
					/*
					// pega lista selecionada
					int indiceTabela = tabelaListaAluno.getSelectionIndex();
					guardaIndice = indiceTabela + "";
					txtNome.setText((listaAluno.get(indiceTabela).));
					txtMarca.setText((listaCarros.get(indiceTabela).txtMarca));
					*/
					
					int indiceTabela = tabelaAlunos.getSelectionIndex();
					Integer idAluno = listaAlunos.get(indiceTabela).getIdAluno();
					String nome = listaAlunos.get(indiceTabela).getNomeAluno();
					String data = listaAlunos.get(indiceTabela).getDtBr();
					
					String[] dados = data.split("/");
					Integer dia = Integer.parseInt(dados[0]);
					Integer mes = Integer.parseInt(dados[1]);
					Integer ano = Integer.parseInt(dados[2]);
					

					editandoId = idAluno;
							
					txtNomeAluno.setText(nome);
					dataNasc.setDay(dia);
					dataNasc.setMonth(mes-1);
					dataNasc.setYear(ano);
					
					//falta setar a data, pois não esta puxando a correta
					
					preencheTabela();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnAlterar.setText("Alterar");
		btnAlterar.setBounds(130, 106, 75, 25);
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					int idSelecionado = listaAlunos.get(tabelaAlunos.getSelectionIndex()).getIdAluno();
					Aluno.exclui(idSelecionado);
					
					preencheTabela();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
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
		
		btnSalvarAlteracoes = new Button(this, SWT.NONE);
		btnSalvarAlteracoes.setEnabled(false);
		btnSalvarAlteracoes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String novaData = dataNasc.getYear()+"-"+(dataNasc.getMonth()+1)+"-"+dataNasc.getDay();
				
				
				Aluno.altera(editandoId, txtNomeAluno.getText(), novaData);
				
				//System.out.println(editandoId);
				
				preencheTabela();
				
			}
		});
		btnSalvarAlteracoes.setBounds(219, 46, 104, 25);
		btnSalvarAlteracoes.setText("Salvar altera\u00E7\u00F5es");
		
		btnExcluirTudo = new Button(this, SWT.NONE);
		btnExcluirTudo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					// create a dialog with ok and cancel buttons and a question icon
					MessageBox dialog = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
					dialog.setText("Confirme a ação");
					dialog.setMessage("Esta ação apagará tudo, continuar?");
					

					// open dialog and await user selection
					int buttonID = dialog.open();
					switch(buttonID) {
			          
						//se clicar ok
						case SWT.OK:
							Aluno.excluiTudo();
							preencheTabela();
							break;
							
						//se o botão clicado for o cancelar	
				        case SWT.CANCEL:
			        	
			        }
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}	
				
			}
		});
		btnExcluirTudo.setBounds(347, 435, 75, 25);
		btnExcluirTudo.setText("Excluir tudo");

		preencheTabela();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private void preencheTabela(){
		
		listaAlunos = Aluno.listaTodos();
		
		//limpa tabela
		tabelaAlunos.setItemCount(0);
		
		for(Aluno a : listaAlunos){
			TableItem it = new TableItem(tabelaAlunos, SWT.NONE);
			
			it.setText(0, a.getIdAluno()+"");
			it.setText(1, a.getNomeAluno());
			it.setText(2, a.getDtBr());
			
		}
		
	}
}
