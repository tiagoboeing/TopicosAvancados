package arquivos;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ExemploFile extends Shell {
	
	private Text txtCaminho;
	private Table listaArquivos;
	
	//vetor de File
	private File[] arquivos;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ExemploFile shell = new ExemploFile(display);
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
	public ExemploFile(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblCaminho = new Label(this, SWT.NONE);
		lblCaminho.setBounds(10, 13, 55, 15);
		lblCaminho.setText("Caminho");
		
		txtCaminho = new Text(this, SWT.BORDER);
		txtCaminho.setBounds(71, 10, 272, 21);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				carregaArquivos();
				
				//se o usuário digitar diretório válido sem arquivo ou nulo
				if(arquivos != null && arquivos.length > 0){
					preencheTable();
				}
			}
		});
		btnOk.setBounds(353, 8, 55, 25);
		btnOk.setText("OK");
		
		listaArquivos = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		listaArquivos.setBounds(10, 50, 401, 311);
		listaArquivos.setHeaderVisible(true);
		listaArquivos.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(listaArquivos, SWT.NONE);
		tblclmnNome.setWidth(144);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnTamanho = new TableColumn(listaArquivos, SWT.NONE);
		tblclmnTamanho.setWidth(100);
		tblclmnTamanho.setText("Tamanho");
		
		TableColumn tblclmnDataModificao = new TableColumn(listaArquivos, SWT.NONE);
		tblclmnDataModificao.setWidth(123);
		tblclmnDataModificao.setText("Data modifica\u00E7\u00E3o");
		
		Button btnApagaSelecionado = new Button(this, SWT.NONE);
		btnApagaSelecionado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int indice = listaArquivos.getSelectionIndex();
				File x = arquivos[indice];
				x.delete();
				carregaArquivos();
				if(arquivos != null && arquivos.length > 0){
					preencheTable();
				}
				
			}
		});
		btnApagaSelecionado.setBounds(10, 373, 159, 25);
		btnApagaSelecionado.setText("Apaga selecionado");
		
		Button btnApagaTodos = new Button(this, SWT.NONE);
		btnApagaTodos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (File f : arquivos) {
					f.delete();
				}
				listaArquivos.setItemCount(0);
			}
		});
		btnApagaTodos.setBounds(315, 373, 93, 25);
		btnApagaTodos.setText("Apaga todos");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(437, 529);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	//carrega arquivos
	private void carregaArquivos(){
		
		File d = new File(txtCaminho.getText());
		
		//se for caminho válido
		if(d.isDirectory()){
			arquivos = d.listFiles();
		} else {
			JOptionPane.showMessageDialog(null, "Não é diretório!");
		}
		
	}
	
	
	//preenche tabela com lista de arquivos
	private void preencheTable(){
		
		listaArquivos.setItemCount(0);
		
		for(File f : arquivos){
			TableItem it = new TableItem(listaArquivos, SWT.NONE);
			it.setText(0, f.getName());
			it.setText(1, formataDouble(f.length()));
			it.setText(2, formataData(f.lastModified()));
		}
		
	}
	
	
	//seta layout da Data
	private String formataData(long dt){
		Date d = new Date(dt);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(d);
	}
	
	
	//formata tipo double para máscara
	private String formataDouble(double d){
		
		//converte pra KB
		//d = (double)d/1024;
		
		//converte pra MB
		d = (double)d/1048576;
		DecimalFormat df = new DecimalFormat("##0.00");
		return df.format(d) + " MB";
		
	}
	
}
