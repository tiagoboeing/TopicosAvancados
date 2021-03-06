package CadastroPrecoCarro;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CadastroCarro extends Shell {
	private Text txtPlaca;
	private Text txtMarca;
	private Text txtModelo;
	private Text txtAno;
	private Text txtCor;
	private Text txtValor;
	private Text txtPlacaMulta;
	private Text txtValorMulta;
	private Text txtBuscaMultas;
	private Text txtValorMultasSomadas;
	
	public String guardaIndice;
	
	static ArrayList<Multa> listaMultas = new ArrayList<Multa>();
	static ArrayList<Carro> listaCarros = new ArrayList<Carro>();
	
	private Table tabelaCarros;
	private Button btnAlterar;
	private Table tabelaListaMultas;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			CadastroCarro shell = new CadastroCarro(display);
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
	public CadastroCarro(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Group grpCadastrarNovo = new Group(this, SWT.NONE);
		grpCadastrarNovo.setText("Cadastrar novo");
		grpCadastrarNovo.setBounds(10, 20, 304, 243);
		
		Label lblPlaca = new Label(grpCadastrarNovo, SWT.NONE);
		lblPlaca.setBounds(10, 32, 28, 15);
		lblPlaca.setText("Placa");
		
		Label lblMarca = new Label(grpCadastrarNovo, SWT.NONE);
		lblMarca.setText("Marca");
		lblMarca.setBounds(10, 64, 33, 15);
		
		Label lblModelo = new Label(grpCadastrarNovo, SWT.NONE);
		lblModelo.setText("Modelo");
		lblModelo.setBounds(10, 96, 41, 15);
		
		Label lblAno = new Label(grpCadastrarNovo, SWT.NONE);
		lblAno.setText("Ano");
		lblAno.setBounds(10, 129, 22, 15);
		
		Label lblCor = new Label(grpCadastrarNovo, SWT.NONE);
		lblCor.setText("Cor");
		lblCor.setBounds(10, 161, 19, 15);
		
		Label lblValor = new Label(grpCadastrarNovo, SWT.NONE);
		lblValor.setText("Valor");
		lblValor.setBounds(10, 197, 26, 15);
		
		txtPlaca = new Text(grpCadastrarNovo, SWT.BORDER);
		txtPlaca.setBounds(59, 29, 113, 21);
		
		txtMarca = new Text(grpCadastrarNovo, SWT.BORDER);
		txtMarca.setBounds(59, 58, 113, 21);
		
		txtModelo = new Text(grpCadastrarNovo, SWT.BORDER);
		txtModelo.setBounds(59, 90, 113, 21);
		
		txtAno = new Text(grpCadastrarNovo, SWT.BORDER);
		txtAno.setBounds(59, 123, 113, 21);
		
		txtCor = new Text(grpCadastrarNovo, SWT.BORDER);
		txtCor.setBounds(59, 155, 113, 21);
		
		txtValor = new Text(grpCadastrarNovo, SWT.BORDER);
		txtValor.setBounds(59, 191, 113, 21);
		
		Button btnBuscar = new Button(grpCadastrarNovo, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try {
					FileReader fr = new FileReader("carros.car");
					BufferedReader br = new BufferedReader(fr);
					
					String linha = "";
					while((linha = br.readLine()) != null){
						
						if(linha.substring(1,8).equals(txtPlaca.getText())){
							txtMarca.setText(linha.substring(8,28).trim());
							txtModelo.setText(linha.substring(28,48).trim());
							txtAno.setText(linha.substring(48,52).trim());
							txtCor.setText(linha.substring(52,62).trim());
							txtValor.setText(reverteValor(linha.substring(62).trim()));
						}
						
					}
					
					
					br.close();
					fr.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				
				
			}
		});
		btnBuscar.setBounds(186, 27, 75, 25);
		btnBuscar.setText("Buscar");
		
		Button btnSalvar = new Button(grpCadastrarNovo, SWT.NONE);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if(guardaIndice != null){
					//remove campo a editar
					listaCarros.remove(Integer.parseInt(guardaIndice));
					
					//remove da tabela
					tabelaCarros.remove(Integer.parseInt(guardaIndice));
				}

				
				
				try {
					FileWriter fw = new FileWriter("carros.car", true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					String linha  = "C" + formataPlaca(txtPlaca.getText()) + 
							completaComEspacos(txtMarca.getText(), 20) + 
							completaComEspacos(txtModelo.getText(), 20) + 
							txtAno.getText() + 
							completaComEspacos(txtCor.getText(), 10) + 
							formataValor(txtValor.getText()) + "\n";
					
					
					TableItem it = new TableItem(tabelaCarros, SWT.NONE);
					
					//PLACA
					it.setText(0, formataPlaca(txtPlaca.getText()));
					
					//marca
					it.setText(1, txtMarca.getText());
					
					//modelo
					it.setText(2, txtModelo.getText());
					
					//ano
					it.setText(3, txtAno.getText());
					
					//cor
					it.setText(4, txtCor.getText());
					
					//valor
					it.setText(5, reverteValor(formataValor(txtValor.getText())));
					
					
						//adiciona o que for salvo ou editado ao array
						Carro c = new Carro(formataPlaca(txtPlaca.getText()), txtMarca.getText(), txtModelo.getText(), txtAno.getText(), txtCor.getText(), reverteValor(formataValor(txtValor.getText())));
						listaCarros.add(c);
					
					
					bw.append(linha);
					
					bw.close();
					fw.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
//				System.out.println("segundo passo \n ---------- \n");
//				System.out.println(listaCarros.toString());
				
				
				varreArrayeJogaParaArquivo();
				
				
			}
		});
		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(186, 189, 75, 25);
		
		Group grpMulta = new Group(this, SWT.NONE);
		grpMulta.setText("Multa");
		grpMulta.setBounds(10, 277, 304, 127);
		
		Label label = new Label(grpMulta, SWT.NONE);
		label.setText("Placa");
		label.setBounds(20, 42, 28, 15);
		
		txtPlacaMulta = new Text(grpMulta, SWT.BORDER);
		txtPlacaMulta.setBounds(69, 39, 113, 21);
		
		Label lblValor_1 = new Label(grpMulta, SWT.NONE);
		lblValor_1.setText("Valor");
		lblValor_1.setBounds(20, 74, 33, 15);
		
		txtValorMulta = new Text(grpMulta, SWT.BORDER);
		txtValorMulta.setBounds(69, 68, 113, 21);
		
		Button btnSalvarMulta = new Button(grpMulta, SWT.NONE);
		btnSalvarMulta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {

					FileWriter fw = new FileWriter("carros.car", true);
					BufferedWriter bw = new BufferedWriter(fw);

					String linha = "M" + formataPlaca(txtPlacaMulta.getText()) + formataValor(txtValorMulta.getText()) + "\n";

					bw.append(linha);
					
					
						// joga para o Arraylist sempre que houver novo cadastro
						Multa m = new Multa(formataPlaca(txtPlacaMulta.getText()), Double.parseDouble(txtValorMulta.getText()));
						listaMultas.add(m);
						

					bw.close();
					fw.close();

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnSalvarMulta.setBounds(201, 66, 75, 25);
		btnSalvarMulta.setText("Salvar");
		
		Group grpBuscarTotalDe = new Group(this, SWT.NONE);
		grpBuscarTotalDe.setText("Buscar total de multas");
		grpBuscarTotalDe.setBounds(337, 20, 291, 104);
		
		Label label_1 = new Label(grpBuscarTotalDe, SWT.NONE);
		label_1.setText("Placa");
		label_1.setBounds(10, 44, 28, 15);
		
		txtBuscaMultas = new Text(grpBuscarTotalDe, SWT.BORDER);
		txtBuscaMultas.setBounds(57, 41, 113, 21);
		
		Button btnTotalDeMultas = new Button(grpBuscarTotalDe, SWT.NONE);
		btnTotalDeMultas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				tabelaListaMultas.setItemCount(0);
				
				//checa se h� alguma linha selecionada
				if(guardaIndice != null){
					
					String placaCarroSelecionado = listaCarros.get(Integer.parseInt(guardaIndice)).getTxtPlaca();
					preencheArrayComMultas(placaCarroSelecionado);
					
					//mostra total de multas para usu�rio
					txtValorMultasSomadas.setText("R$ "+calculaTotalMultas(placaCarroSelecionado));
					txtBuscaMultas.setText(placaCarroSelecionado);
					
					Integer i = 0;
					
						//LISTA MULTAS INDIVIDUAIS
						for(Multa m : listaMultas){
							
							//verifica a placa novamente, apenas por seguran�a
							if(m.getPlacaCarro().equalsIgnoreCase(placaCarroSelecionado)){				
								
								i += i + 1;
								TableItem it = new TableItem(tabelaListaMultas, SWT.NONE);

								//placa
								it.setText(0, "Multa ID=" + i + " no valor de R$: " + m.getValorMulta()+"");
							}
						}
					

				} else {
					
					//executa opera��o por busca de placa - DIGITADO PELO USU�RIO
					if(txtBuscaMultas != null)
					preencheArrayComMultas(txtBuscaMultas.getText());
						
					//grava na tela
					txtValorMultasSomadas.setText("R$ "+calculaTotalMultas(txtBuscaMultas.getText()));
					
					Integer i = 0;
					
						//LISTA MULTAS INDIVIDUAIS
						for(Multa m : listaMultas){
							
							//verifica a placa novamente, apenas por seguran�a
							if(m.getPlacaCarro().equalsIgnoreCase(txtBuscaMultas.getText())){				
								
								i += i + 1;
								TableItem it = new TableItem(tabelaListaMultas, SWT.NONE);

								//placa
								it.setText(0, "Multa ID=" + i + " no valor de R$: " + m.getValorMulta()+"");
							}
						}
					
					
				}
				
				
			}
		});
		btnTotalDeMultas.setText("Total de multas");
		btnTotalDeMultas.setBounds(178, 39, 99, 25);
		
		Group grpTotalDeMultas = new Group(this, SWT.NONE);
		grpTotalDeMultas.setText("TOTAL DE MULTAS");
		grpTotalDeMultas.setBounds(337, 146, 291, 358);
		
		txtValorMultasSomadas = new Text(grpTotalDeMultas, SWT.BORDER | SWT.CENTER);
		txtValorMultasSomadas.setEditable(false);
		txtValorMultasSomadas.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txtValorMultasSomadas.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		txtValorMultasSomadas.setBounds(23, 51, 245, 71);
		
		Label lblValorTotalDe = new Label(grpTotalDeMultas, SWT.NONE);
		lblValorTotalDe.setBounds(24, 31, 174, 15);
		lblValorTotalDe.setText("Valor total de multas para o carro");
		
		tabelaListaMultas = new Table(grpTotalDeMultas, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaListaMultas.setLinesVisible(true);
		tabelaListaMultas.setHeaderVisible(true);
		tabelaListaMultas.setBounds(26, 143, 242, 188);
		
		TableColumn tblclmnMulta = new TableColumn(tabelaListaMultas, SWT.NONE);
		tblclmnMulta.setResizable(false);
		tblclmnMulta.setWidth(237);
		tblclmnMulta.setText("Valor R$");
		
		tabelaCarros = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaCarros.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// ao selecionar qualquer linha
				
				//pega lista selecionada
				int indiceTabela = tabelaCarros.getSelectionIndex();
				guardaIndice = indiceTabela+"";
				
			}
		});
		tabelaCarros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				Integer linhaTabela = tabelaCarros.getSelectionIndex();
				
				//remove linha do array
				listaCarros.remove(Integer.parseInt(linhaTabela+""));
				
				//remove da tabela
				tabelaCarros.remove(linhaTabela);
				
				varreArrayeJogaParaArquivo();
				
			}
		});
		tabelaCarros.setBounds(650, 21, 598, 383);
		tabelaCarros.setHeaderVisible(true);
		tabelaCarros.setLinesVisible(true);
		
		TableColumn tblclmnPlaca = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnPlaca.setWidth(100);
		tblclmnPlaca.setText("Placa");
		
		TableColumn tblclmnMarca = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnMarca.setWidth(100);
		tblclmnMarca.setText("Marca");
		
		TableColumn tblclmnModelo = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnModelo.setWidth(100);
		tblclmnModelo.setText("Modelo");
		
		TableColumn tblclmnAno = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnAno.setWidth(71);
		tblclmnAno.setText("Ano");
		
		TableColumn tblclmnCor = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnCor.setWidth(100);
		tblclmnCor.setText("Cor");
		
		TableColumn tblclmnValor = new TableColumn(tabelaCarros, SWT.NONE);
		tblclmnValor.setWidth(100);
		tblclmnValor.setText("Valor");
		
		btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//pega lista selecionada
				int indiceTabela = tabelaCarros.getSelectionIndex();
				guardaIndice = indiceTabela+"";

				
				txtPlaca.setText((listaCarros.get(indiceTabela).txtPlaca));
				txtMarca.setText((listaCarros.get(indiceTabela).txtMarca));
				txtModelo.setText((listaCarros.get(indiceTabela).txtModelo));
				txtAno.setText((listaCarros.get(indiceTabela).txtAno));
				txtCor.setText((listaCarros.get(indiceTabela).txtCor));
				txtValor.setText((listaCarros.get(indiceTabela).txtValor));
	
				
			}
		});
		btnAlterar.setBounds(650, 410, 75, 25);
		btnAlterar.setText("Alterar");
		createContents();
		
		
		preencheArrayComCarroseMultas();
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(1288, 564);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private String formataValor(String s){
		s = s.replace(".", "");
		s = s.replace(",", "");
		s = completaComZeros(s, 8);
		return s;
	}
	
	
	private String reverteValor(String s){
		String s1 = s.substring(0,6);
		String s2 = s.substring(6);
		
		while(s1.charAt(0) == '0'){
			s1 = s1.substring(1);
		}
		
		return s1+","+s2;
	}
	
	
	private String reverteValorSemFormatacao(String s){
		String s1 = s.substring(0,6);
		String s2 = s.substring(6);
		
		while(s1.charAt(0) == '0'){
			s1 = s1.substring(1);
		}
		
		return s1+s2;
	}
	
	
	private String formataPlaca(String s){
//		s = s.replace(".", "");
//		s = s.replace(",", "");		
//		s = completaComZeros(s, 8);
		
		s = s.replace("-", "");
		
		return s;
	}
	
	
	
	private String completaComZeros(String s, int tam){
		if(s.length() < tam){
			int qt = tam-s.length();
			for(int i = 0; i < qt; i++){
				s = "0" + s;
			}
		}
		return s;
	}
	

	
	private String completaComEspacos(String s, int tam) {

		if (s.length() < tam) {

			int qt = tam - s.length();

			for (int i = 0; i < qt; i++)
				s += " ";

		}
		return s;
	}
	
//	private String completaComEspacos(String s, int tam){
//		if(s.length() < tam){
//			for(int i=0; i<tam-s.length(); i++){
//				s += " ";
//			}
//		}
//		return s;
//	}
	
	
	private void preencheArrayComMultas(String placa){
		
		//limpa array caso hajam dados anteriores
		listaMultas.clear();
		
		try {
			
			FileReader fr = new FileReader("carros.car");
			BufferedReader br = new BufferedReader(fr);
			
			String linha = "";
			String placaBuscar = formataPlaca(placa);
			
			
			while ((linha = br.readLine()) != null) {
				
				String tipo = linha.substring(0, 1);
				String placaCarro = linha.substring(1, 8).trim();
				
				//confere se � tipo MULTA e PLACA do carro buscada
				if (tipo.equalsIgnoreCase("M") && placaCarro.equalsIgnoreCase(placaBuscar)){
		
					// se passar no if(), pega os valores da multa
					Double valorMulta = Double.parseDouble(linha.substring(8, 16).trim());
					
						//joga pra arraylist depois de varrer arquivo
						Multa m = new Multa(placaBuscar, valorMulta);
						listaMultas.add(m);
						
						
					
				}
				
			} // fecha while
			
			
			
			br.close();
			fr.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		
//		System.out.println(listaMultas.toString());
		
	}
	
	
	

	private void preencheArrayComCarroseMultas(){
		
		//limpa array caso hajam dados anteriores
		listaCarros.clear();
		
		
		try {
			FileReader fr = new FileReader("carros.car");
			BufferedReader br = new BufferedReader(fr);
			
			String linha = "";
			while((linha = br.readLine()) != null){
				
				
				// BUSCA TIPO C = CARRO
				if(linha.substring(0, 1).equalsIgnoreCase("C")){
					
					String placa = linha.substring(1, 8).trim();
					String marca = linha.substring(8,28).trim();
					String modelo = linha.substring(28,48).trim();
					String ano = linha.substring(48,52).trim();
					String cor = linha.substring(52,62).trim();
					String valor = reverteValor(linha.substring(62).trim());
					
					
					Carro c = new Carro(placa, marca, modelo, ano, cor, valor);
					listaCarros.add(c);
					
//					System.out.println(listaCarros);	
				}
				
				
				if(linha.substring(0, 1).equalsIgnoreCase("M")){
					
					String placaCarroMulta = linha.substring(1, 8).trim();
					String valorMulta = (linha.substring(8, 16).trim());

					Multa m = new Multa(placaCarroMulta, Double.parseDouble(valorMulta));
					listaMultas.add(m);					
					
				}
				
				
			}
			
			
			br.close();
			fr.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		//limpa tabela caso haja algo
		tabelaCarros.setItemCount(0);
		
		//passando valores do array para a tabela
		for(Carro c : listaCarros){
			
			TableItem it = new TableItem(tabelaCarros, SWT.NONE);
			
			//placa
			it.setText(0, c.txtPlaca);
			
			//marca
			it.setText(1, c.txtMarca);
			
			//modelo
			it.setText(2, c.txtModelo);
			
			//ano
			it.setText(3, c.txtAno);
			
			//cor
			it.setText(4, c.txtCor);
			
			//valor
			it.setText(5, c.txtValor);
			
		}

		
	}
	
	
	
	
	private Double calculaTotalMultas(String placa){
		
		String placaBuscar = formataPlaca(placa);
		Double saldoDevedor = 0.0;
		
		//varre arraylist
		for(Multa m : listaMultas){
			
			//verifica a placa novamente, apenas por seguran�a
			if(m.getPlacaCarro().equalsIgnoreCase(placaBuscar)){				
				//assim funciona - gambiarra
				saldoDevedor += (m.getValorMulta() + m.getValorMulta())/2;
			}
			
		}
		
//		System.out.println(listaMultas.toString());
//		System.out.println(saldoDevedor);
		
		return saldoDevedor;
	
		
	}
	
	
	
	private void varreArrayeJogaParaArquivo(){
		
		//remove arquivo antes de qualquer coisa
		excluiArquivo("carros.car");
		
		//limpa tabela por seguran�a
//		tabelaCarros.setItemCount(0);
		
		
		String linha1 = "";
		//pega multas tamb�m
		for(Multa m : listaMultas){
			linha1 += "M" + formataPlaca(m.getPlacaCarro()) + formataValor(m.getValorMulta()+"") + "\n";
		}
		
		System.out.println(listaMultas.toString());
		
		//varre o arraylist
		for(Carro c : listaCarros){			
			
			//escreve dados para o arquivo
			try {
				
				FileWriter fw = new FileWriter("carros.car", true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				String linha  = "C" + formataPlaca(c.txtPlaca) + 
						completaComEspacos(c.txtMarca, 20) + 
						completaComEspacos(c.txtModelo, 20) + 
						c.txtAno + 
						completaComEspacos(c.txtCor, 10) + 
						formataValor(c.txtValor) + "\n";
				
				
				bw.append(linha);
				bw.append(linha1);
				
				
				bw.close();
				fw.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
				
		} // fecha for do arraylist
		
		
	}
	
	
	
	//EXCLUI UM ARQUIVO QUALQUER
	private static void excluiArquivo(String nomeArquivo){
		
		File arquivo = new File(nomeArquivo);
		//se arquivo for v�lido
		if(arquivo.isFile()){
			arquivo.delete();
			
//			System.out.println("excluiu arquivo!");
		}
		
	}
}
