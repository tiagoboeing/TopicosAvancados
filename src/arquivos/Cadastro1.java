package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Cadastro1 extends Shell {
	
	private Text txtNome;
	private Text txtQtde;
	private Text txtValor;
	private Table tabelaLista;
	private Text txtValorTotal;
	
	static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Cadastro1 shell = new Cadastro1(display);
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
	public Cadastro1(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.RESIZE | SWT.TITLE);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 24, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(73, 21, 351, 21);
		
		Label lblQtde = new Label(this, SWT.NONE);
		lblQtde.setText("Qtde");
		lblQtde.setBounds(10, 62, 55, 15);
		
		txtQtde = new Text(this, SWT.BORDER);
		txtQtde.setBounds(73, 59, 55, 21);
		
		Label lblValor = new Label(this, SWT.NONE);
		lblValor.setText("Valor");
		lblValor.setBounds(10, 104, 55, 15);
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(73, 101, 112, 21);
		
		Button btnInserir = new Button(this, SWT.NONE);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
				insereLinha();
				leArquivo();
			}
		});
		btnInserir.setBounds(207, 99, 75, 25);
		btnInserir.setText("Inserir");
		
		tabelaLista = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {

					
					int indiceTabela = tabelaLista.getSelectionIndex();
					listaProdutos.remove(indiceTabela);
					
					
					arrayParaArquivo();
					leArquivo();
					
					System.out.println(listaProdutos);

				
			}
		});
		tabelaLista.setBounds(10, 148, 469, 212);
		tabelaLista.setHeaderVisible(true);
		tabelaLista.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(tabelaLista, SWT.NONE);
		tblclmnNome.setWidth(181);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnQtde = new TableColumn(tabelaLista, SWT.NONE);
		tblclmnQtde.setWidth(59);
		tblclmnQtde.setText("Qtde");
		
		TableColumn tblclmnValor = new TableColumn(tabelaLista, SWT.NONE);
		tblclmnValor.setWidth(108);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnSubTotal = new TableColumn(tabelaLista, SWT.NONE);
		tblclmnSubTotal.setWidth(100);
		tblclmnSubTotal.setText("Sub Total");
		
		Label lblTotal = new Label(this, SWT.NONE);
		lblTotal.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblTotal.setBounds(299, 388, 45, 20);
		lblTotal.setText("TOTAL");
		
		txtValorTotal = new Text(this, SWT.RIGHT);
		txtValorTotal.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		txtValorTotal.setEditable(false);
		txtValorTotal.setFont(SWTResourceManager.getFont("Arial Narrow", 12, SWT.BOLD));
		txtValorTotal.setBounds(350, 377, 129, 34);
		
		Label lblUnidades = new Label(this, SWT.NONE);
		lblUnidades.setText("unidades");
		lblUnidades.setBounds(134, 62, 55, 15);
		createContents();
		
		
		copiaArrayList();
		arrayParaArquivo();
		leArquivo();
		
		
		
		/*for(Produto produto : listaProdutos){
			
			System.out.println(produto.toString());
			
		}*/
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Cadastro 1");
		setSize(505, 473);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	//insere linhas em arquivo para guardar dados
	private void insereLinha(){
		try {
			
			//n�o precisa ser extens�o v�lida
			FileWriter fw = new FileWriter("produtos.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linha = txtNome.getText()+","+txtQtde.getText() + "," + txtValor.getText() + "\n";
			
			bw.append(linha);
			
			//� necess�rio fechar na sequencia que foram abertos FileWriter e BufferedWriter
			bw.close();
			fw.close();
			
			
		Produto produto = new Produto(txtNome.getText(), txtQtde.getText(), txtValor.getText());
		listaProdutos.add(produto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//l� arquivos
	private void leArquivo(){
		
		tabelaLista.setItemCount(0);
		
		
		try {
			
			FileReader fr = new FileReader("produtos.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String linha;
			double total = 0;
			
			
			//linha recebe br.readLine, e enquanto for diferente de nulo...
			while((linha = br.readLine()) != null){
			
				//split gera um vetor de string de acordo com separado, parecido com explode, implode no PHP
				String[] dados = linha.split(",");
				
				//valor * qtde
				double subTotal = Double.parseDouble(dados[1]) * Double.parseDouble(dados[2]);
				
				total += subTotal;
				TableItem it = new TableItem(tabelaLista, SWT.NONE);

				//NOME DO PRODUTO
				it.setText(0, dados[0]);
				
				//QTDE
				it.setText(1, dados[1]);
				
				//VALOR
				it.setText(2, dados[2]);
				
				//SUBTOTAL
				it.setText(3, subTotal + "");
					
						
			} //fecha while
			
			
			
			txtValorTotal.setText(total + "");
			
			br.close();
			fr.close();
			
			
			
			
			// se for pra atualizar o arquivo
//			if(atualiza == true && indice != null){
//				
//				tabelaLista.setItemCount(0);
//				
//				//excluiArquivo("produtos.txt");
////				copiaArrayList();
//				
//				listaProdutos.remove(indice);
//				
//				System.out.println(listaArray());

				// m�todo de cria��o de novo arquivo
//				try {
//					
//					//n�o precisa ser extens�o v�lida
//					FileWriter fw = new FileWriter("produtos.txt", true);
//					BufferedWriter bw = new BufferedWriter(fw);
//					
//					listaProdutos.remove(indice);
//					

//					
//						
//					bw.append(linha1);
//					
//					//� necess�rio fechar na sequencia que foram abertos FileWriter e BufferedWriter
//					bw.close();
//					fw.close();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
				
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void excluiArquivo(String nomeArquivo){
		
		File arquivo = new File(nomeArquivo);
		//se arquivo for v�lido
		if(arquivo.isFile()){
			arquivo.delete();
			
//			System.out.println("excluiu arquivo!");
		}
		
	}
	
	
	//passa valores do arquivo para arraylist
	private void copiaArrayList(){
			
		try {
		
			FileReader fr = new FileReader("produtos.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String linha;
			
			
			//linha recebe br.readLine, e enquanto for diferente de nulo...
			while((linha = br.readLine()) != null){
				
				//split gera um vetor de string de acordo com separado, parecido com explode, implode no PHP
				String[] dados = linha.split(",");
				
				Produto produto = new Produto(dados[0], dados[1], dados[2]);
				listaProdutos.add(produto);	
				
			}
				
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	//apenas para debug
	static String listaArray(){
        
		String ret  = "Lista \n\n";
                
		for (Produto l : listaProdutos) {
			ret += "Nome: "+l.getTxtNome()+" | Qtde: "+l.getTxtQtde()+" | Valor: "+l.getTxtValor()+"\n";
		}
                
		return ret;
	}
	
	
	static void arrayParaArquivo(){
		
		excluiArquivo("produtos.txt");
		
		String ret  = "";
		
		try {
			
			
			//n�o precisa ser extens�o v�lida
			FileWriter fw = new FileWriter("produtos.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
		
        
			for (Produto l : listaProdutos) {
				ret += l.getTxtNome()+","+l.getTxtQtde()+","+l.getTxtValor()+"\n";
			}
			
			bw.append(ret);
			
			
			//� necess�rio fechar na sequencia que foram abertos FileWriter e BufferedWriter
			bw.close();
			fw.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
