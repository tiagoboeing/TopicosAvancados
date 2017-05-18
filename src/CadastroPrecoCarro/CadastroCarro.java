package CadastroPrecoCarro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
	private Text txtValorTotal;

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
				
				try {
					FileWriter fw = new FileWriter("carros.car", true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					String linha  = "C" + formataPlaca(txtPlaca.getText()) + 
							completaComEspacos(txtMarca.getText(), 20) + 
							completaComEspacos(txtModelo.getText(), 20) + 
							txtAno.getText() + 
							completaComEspacos(txtCor.getText(), 10) + 
							formataValor(txtValor.getText()) + "\n";
					
					bw.append(linha);
					
					bw.close();
					fw.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
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
		
		Button btnTotalDeMiltas = new Button(grpBuscarTotalDe, SWT.NONE);
		btnTotalDeMiltas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try {
					FileReader fr = new FileReader("carros.car");
					BufferedReader br = new BufferedReader(fr);
					
					String linha = "";
					String totalMulta = "";
					
					while ((linha = br.readLine()) != null) {
						
						String tipo = linha.substring(0, 1);
						String placaCarro = linha.substring(1, 8);
						
						
						if (tipo.equalsIgnoreCase("M")){
							
							System.out.println("passou m");
							
							String valorMulta = linha.substring(8, 16);
							
							System.out.println(valorMulta);
							
							
						}

					}
					
					
					txtValorTotal.setText(totalMulta);
					
					br.close();
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnTotalDeMiltas.setText("Total de multas");
		btnTotalDeMiltas.setBounds(178, 39, 99, 25);
		
		Group grpTotalDeMultas = new Group(this, SWT.NONE);
		grpTotalDeMultas.setText("TOTAL DE MULTAS");
		grpTotalDeMultas.setBounds(337, 146, 291, 258);
		
		txtValorTotal = new Text(grpTotalDeMultas, SWT.BORDER);
		txtValorTotal.setEditable(false);
		txtValorTotal.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txtValorTotal.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		txtValorTotal.setBounds(23, 51, 245, 107);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(671, 478);

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
	
	
}
