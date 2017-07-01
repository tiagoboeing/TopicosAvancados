package aula13_CadastroHobbies;

import org.eclipse.swt.widgets.Composite;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import BancoDeDados.Aluno;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TelaCadPessoa extends Composite {
	private Text txtNomePessoa;
	private Text txtFiltro;
	private Table tabelaListaPessoas;
	private Button btnMasculino;
	private Button btnFeminino;
	private DateTime dataNasc;
	
	ArrayList<Pessoa> listaFiltrada = new ArrayList<Pessoa>();
	ArrayList<Pessoa> listaTodasPessoas = new ArrayList<Pessoa>();


	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public TelaCadPessoa(Composite parent, int style) {
		super(parent, style);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(10, 10, 488, 549);

		Label lblNome = new Label(composite, SWT.NONE);
		lblNome.setBounds(10, 22, 70, 20);
		lblNome.setText("Nome");

		txtNomePessoa = new Text(composite, SWT.BORDER);
		txtNomePessoa.setBounds(86, 16, 254, 26);

		Label lblSexo = new Label(composite, SWT.NONE);
		lblSexo.setBounds(10, 65, 70, 20);
		lblSexo.setText("Sexo");

		btnMasculino = new Button(composite, SWT.RADIO);
		btnMasculino.setSelection(true);
		btnMasculino.setBounds(86, 65, 111, 20);
		btnMasculino.setText("Masculino");

		btnFeminino = new Button(composite, SWT.RADIO);
		btnFeminino.setBounds(229, 65, 111, 20);
		btnFeminino.setText("Feminino");

		Label lblDataNasc = new Label(composite, SWT.NONE);
		lblDataNasc.setBounds(10, 111, 140, 20);
		lblDataNasc.setText("Data de nascimento");

		Button btnInserir = new Button(composite, SWT.NONE);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try{
					
					String sexoBotao = checaSexo(btnMasculino.getSelection(), btnFeminino.getSelection());
					
					Pessoa p = new Pessoa();
					p.setNome(txtNomePessoa.getText());
					p.setSexo(sexoBotao);
					
					String data = dataNasc.getYear() + "-" + (dataNasc.getMonth()+1) + "-" + dataNasc.getDay();
					//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					
					p.setNascimento(data);
					
					p.cadastra();
					
					preencheTela();
					
				} catch (Exception c) {
					c.printStackTrace();
				}
				
			}
		});
		btnInserir.setBounds(10, 155, 90, 30);
		btnInserir.setText("Inserir");

		Button btnAlterar = new Button(composite, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
			}
		});
		btnAlterar.setBounds(133, 155, 90, 30);
		btnAlterar.setText("Alterar");

		Button btnExcluir = new Button(composite, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Pessoa.excluiPessoa(listaTodasPessoas.get(tabelaListaPessoas.getSelectionIndex()).getId());
				preencheTela();
				
			}
		});
		btnExcluir.setBounds(250, 155, 90, 30);
		btnExcluir.setText("Excluir");
		

		Label lblFiltro = new Label(composite, SWT.NONE);
		lblFiltro.setBounds(10, 214, 70, 20);
		lblFiltro.setText("Filtro");

		txtFiltro = new Text(composite, SWT.BORDER);
		txtFiltro.setBounds(86, 208, 254, 26);

		tabelaListaPessoas = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaListaPessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				
				String sexoRetornado = retornarSexo((listaTodasPessoas.get(tabelaListaPessoas.getSelectionIndex()).getSexo()));
				
				if(sexoRetornado.equals("Masculino")){
					
					btnMasculino.setSelection(true);
					btnFeminino.setSelection(false);
					
				} else if(sexoRetornado.equals("Feminino")) {
					
					btnFeminino.setSelection(true);
					btnMasculino.setSelection(false);
					
				}
				
				txtNomePessoa.setText(listaTodasPessoas.get(tabelaListaPessoas.getSelectionIndex()).getNome());
				
				Date data = formataData(listaTodasPessoas.get(tabelaListaPessoas.getSelectionIndex()).getNascimento());
				
				
				//Pessoa.excluiPessoa(listaTodasPessoas.get(tabelaListaPessoas.getSelectionIndex()).getId());
				preencheTela();
				
				
			}
		});
		tabelaListaPessoas.setBounds(10, 250, 468, 289);
		tabelaListaPessoas.setHeaderVisible(true);
		tabelaListaPessoas.setLinesVisible(true);

		TableColumn tblclmnID = new TableColumn(tabelaListaPessoas, SWT.NONE);
		tblclmnID.setWidth(100);
		tblclmnID.setText("C\u00F3digo");

		TableColumn tblclmnNome = new TableColumn(tabelaListaPessoas, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");

		TableColumn tblclmnSexo = new TableColumn(tabelaListaPessoas, SWT.NONE);
		tblclmnSexo.setWidth(100);
		tblclmnSexo.setText("Sexo");

		TableColumn tblclmnIdade = new TableColumn(tabelaListaPessoas, SWT.NONE);
		tblclmnIdade.setWidth(100);
		tblclmnIdade.setText("Idade");

		dataNasc = new DateTime(composite, SWT.DROP_DOWN);
		dataNasc.setBounds(166, 103, 102, 28);
		
		
		
		preencheTela();

	}

	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private String checaSexo(Boolean masc, Boolean fem) {
		
		if (masc == true) {
			return "M";
		} else {
			return "F";
		}
		
	}

	private String retornarSexo(String sexo) {
		if (sexo.equals("M")) {
			return "Masculino";
		} else {
			return "Feminino";
		}
	}

	// Preenche tabela com resultados da busca
	private void preencheTabelaFiltrando(String textoBuscar) {

		// textoBuscar = charAt(textoBuscar);

		//listaFiltrada = Pessoa.busca(textoBuscar);

		// limpa tabela
		tabelaListaPessoas.setItemCount(0);

		for (Pessoa p : listaFiltrada) {

			TableItem it = new TableItem(tabelaListaPessoas, SWT.NONE);

			it.setText(0, p.getId() + "");
			it.setText(1, p.getNome());
			//it.setText(2, p.getdataBrasil());

		}

	}
	
	
	
	private void preencheTela(){
		
		listaTodasPessoas = Pessoa.listaTodasPessoas();
		
		//limpa tabela
		tabelaListaPessoas.setItemCount(0);
		
		for(Pessoa p : listaTodasPessoas){
			
			TableItem it = new TableItem(tabelaListaPessoas, SWT.NONE);
			
			it.setText(0, p.getId()+"");
			it.setText(1, p.getNome());
			it.setText(2, retornarSexo(p.getSexo()));
			
			String idade = p.getIdade() + "";
			if(p.getIdade() == 0){
				idade = "";
			} else if(p.getIdade() == 1){
				idade = p.getIdade() + " ano";
			} else if (p.getIdade() < 0){
				idade = "-";
			} else{
				idade = p.getIdade() + " anos";
			}
			
			it.setText(3, idade);
			
		}	
	}
	
	
	
	private Date formataData(String data){
		
		Date date = new Date();
		
		try {

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        
			date = (Date)df.parse(data);
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		return date;
		
	}
	
	
	public String getPegaDataAtual() {
		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy"); 
		System.out.print(formatarDate.format(data));
		
		return formatarDate.format(data);
	}
	


}
