package Prova2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Principal extends Shell {
	private Text txtNomeCantor;
	private Table tabelaCantores;
	private Button btnMasculino;
	private Button btnFeminino;
	
	static ArrayList<Cantor> listaCantores = new ArrayList<Cantor>();
	static ArrayList<Cantor> listaFiltroPorEstilo = new ArrayList<Cantor>();
	
	private CCombo comboFiltroEstilo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Principal shell = new Principal(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Principal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Group grpCadastroDeCantores = new Group(this, SWT.NONE);
		grpCadastroDeCantores.setText("Cadastro de cantores");
		grpCadastroDeCantores.setBounds(10, 10, 579, 167);
		
		Label lblNome = new Label(grpCadastroDeCantores, SWT.NONE);
		lblNome.setBounds(10, 34, 55, 15);
		lblNome.setText("Nome");
		
		Label lblEstilo = new Label(grpCadastroDeCantores, SWT.NONE);
		lblEstilo.setText("Estilo");
		lblEstilo.setBounds(10, 70, 55, 15);
		
		CCombo comboEstilo = new CCombo(grpCadastroDeCantores, SWT.BORDER);
		comboEstilo.setText("Sertanejo");
		comboEstilo.add("Sertanejo");
		comboEstilo.add("Rock");
		comboEstilo.add("Pop");
		comboEstilo.add("MPB");
		comboEstilo.setBounds(71, 70, 176, 21);
		
		
		txtNomeCantor = new Text(grpCadastroDeCantores, SWT.BORDER);
		txtNomeCantor.setBounds(68, 34, 206, 21);
		
		Group grpSexo = new Group(grpCadastroDeCantores, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(341, 27, 206, 124);
		
		btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setBounds(28, 33, 90, 16);
		btnMasculino.setText("Masculino");
		
		btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setBounds(28, 77, 90, 16);
		btnFeminino.setText("Feminino");
		
		
		
		Button btnCadastrar = new Button(grpCadastroDeCantores, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String sexoSelecionado = checaSexo(btnFeminino.getSelection(), btnMasculino.getSelection());
				cadastraCantor(txtNomeCantor.getText(), comboEstilo.getText(), sexoSelecionado);
				
				//caso tenha cadastrado algo com a tela aberta, joga pra tabela
				varreArquivoePreencheArray("cantores.txt");
				preencheTabela();
				
				
			}
		});
		btnCadastrar.setBounds(10, 126, 306, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnFiltrar = new Button(this, SWT.NONE);
		btnFiltrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String filtroSelecionado = comboFiltroEstilo.getText();
				
				filtraEstilo(filtroSelecionado);
				
				
			}
		});
		btnFiltrar.setText("Filtrar");
		btnFiltrar.setBounds(466, 194, 108, 25);
		
		comboFiltroEstilo = new CCombo(this, SWT.BORDER);
		comboFiltroEstilo.setText("Filtrar por estilo musical");
		comboFiltroEstilo.add("TODOS");
		comboFiltroEstilo.add("Sertanejo");
		comboFiltroEstilo.add("Rock");
		comboFiltroEstilo.add("Pop");
		comboFiltroEstilo.add("MPB");
		
		comboFiltroEstilo.setBounds(10, 199, 432, 21);
		
		tabelaCantores = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaCantores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				Integer linhaClicada = tabelaCantores.getSelectionIndex();
				
				//remove do array
				listaCantores.remove(Integer.parseInt(linhaClicada+""));
				
				//exclui arquivo atual
				excluiArquivo("cantores.txt");	
				
				//varre array e grava dados restantes no arquivo
				varreArrayGravanoArquivo("cantores.txt");
				
				//chama métodos de preenchimento de tela
				varreArquivoePreencheArray("cantores.txt");
				preencheTabela();
				
			}
		});
		tabelaCantores.setBounds(7, 240, 582, 187);
		tabelaCantores.setHeaderVisible(true);
		tabelaCantores.setLinesVisible(true);
		
		TableColumn tblclmnCantor = new TableColumn(tabelaCantores, SWT.NONE);
		tblclmnCantor.setWidth(218);
		tblclmnCantor.setText("Cantor");
		
		TableColumn tblclmnEstiloMusical = new TableColumn(tabelaCantores, SWT.NONE);
		tblclmnEstiloMusical.setWidth(234);
		tblclmnEstiloMusical.setText("Estilo musical");
		
		TableColumn tblclmnSexo = new TableColumn(tabelaCantores, SWT.NONE);
		tblclmnSexo.setWidth(114);
		tblclmnSexo.setText("Sexo");
		createContents();
		
		
		varreArquivoePreencheArray("cantores.txt");
		preencheTabela();
		
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(615, 489);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private void cadastraCantor(String nomeCantor, String estiloMusical, String sexoCantor){
			
		try {
			
			//não precisa ser extensão válida
			FileWriter fw = new FileWriter("cantores.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linha = nomeCantor+"," + estiloMusical + "," + sexoCantor + "\n";
			
			bw.append(linha);
			
			//é necessário fechar na sequencia que foram abertos FileWriter e BufferedWriter
			bw.close();
			fw.close();
			
			
			//instância novo objeto e joga para arraylist (array apenas para trabalhar melhor)
			Cantor c = new Cantor(nomeCantor, estiloMusical, sexoCantor);
			listaCantores.add(c);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//VARRE TUDO O QUE HÁ NO ARRAYLIST E GRAVA EM UM ARQUIVO
	private void varreArrayGravanoArquivo(String nomeArquivo){
		
		String linha = "";
		
		try {
			
			//não precisa ser extensão válida
			FileWriter fw = new FileWriter(nomeArquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//varre arraylist
			for(Cantor c : listaCantores){
				linha += c.getNomeCantor()+"," + c.getEstiloMusical() + "," + c.getSexoCantor() + "\n";
			}
			
			
			bw.append(linha);
			
			//é necessário fechar na sequencia que foram abertos FileWriter e BufferedWriter
			bw.close();
			fw.close();
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private void preencheTabela(){
		
		//limpa tabela por segurança
		tabelaCantores.setItemCount(0);
		
		for(Cantor c : listaCantores){
		
			TableItem it = new TableItem(tabelaCantores, SWT.NONE);
			
			//nome
			it.setText(0, c.getNomeCantor());
			
			//estilo
			it.setText(1, c.getEstiloMusical());
			
			//sexo
			it.setText(2, sexoPorExtenso(c.getSexoCantor()));
			
			
		}
		
	}
	
	private void varreArquivoePreencheArray(String nomeArquivo){
		
		//limpa array por segurança
		listaCantores.clear();
		
		try {
			FileReader fr = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linha = "";
			while((linha = br.readLine()) != null){
				
				
				String[] dados = linha.split(",");
				
				Cantor c = new Cantor(dados[0], dados[1], dados[2]);
				listaCantores.add(c);
				
			}
			
			
			br.close();
			fr.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	//RECEBE PARAMETROS DE FILTRO
	private void filtraEstilo(String estiloMusical){
				
		//esvazia arraylist filtrado
		listaFiltroPorEstilo.clear();
		
		for(Cantor c : listaCantores){
			//se estilo for igual, joga pra arraylist filtrado
			if(c.getEstiloMusical().equalsIgnoreCase(estiloMusical)){				
				listaFiltroPorEstilo.add(c);
			}
		}
		
		//se a lista de filtro não for vazia
		if(!listaFiltroPorEstilo.isEmpty()){
		
			//limpa tabela
			tabelaCantores.setItemCount(0);
			
			//varre lista filtrada
			for(Cantor cf : listaFiltroPorEstilo){
				
				
				TableItem it = new TableItem(tabelaCantores, SWT.NONE);
	
				//nome
				it.setText(0, cf.getNomeCantor());
				
				//estilo
				it.setText(1, cf.getEstiloMusical());
				
				//sexo
				it.setText(2, sexoPorExtenso(cf.getSexoCantor()));
			}			
		}
		
		
		if(comboFiltroEstilo.getText().equalsIgnoreCase("TODOS")){
			preencheTabela();
		}
		
		
	}
	
	
	
	//EXCLUI UM ARQUIVO QUALQUER
	private static void excluiArquivo(String nomeArquivo){
		
		File arquivo = new File(nomeArquivo);
		//se arquivo for válido
		if(arquivo.isFile()){
			arquivo.delete();
		}
		
	}
	
	
	//recebe os dois botões e define sexo
	private String checaSexo(Boolean botaoFeminino, Boolean botaoMasculino){
		
		if(botaoFeminino == true){
			return "F";
		} else if(botaoMasculino == true){
			return "M";
		} else {
			return "Indeterminado";
		}
			
	}
	
	
	//recebe os dois botões e define sexo
	private String sexoPorExtenso(String sexoAtual){
		
		if(sexoAtual.equalsIgnoreCase("F")){
			return "Feminino";
		} else if(sexoAtual.equalsIgnoreCase("M")){
			return "Masculino";
		} else {
			return "Indeterminado";
		}
			
	}
	
	
	
	
}
