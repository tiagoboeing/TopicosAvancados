package Prova1_q2;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import swt.Pessoa;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TelaCompeticao extends Shell {
	private Text txtNome;
	private Text txtColocacao;
	private Text txtDistancia;
	private Table tabelaCompeticoes;
	private DateTime txtData;
	
	private ArrayList<Competicao> lista = new ArrayList<Competicao>();
	private Text txtMelhorColocacao;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			TelaCompeticao shell = new TelaCompeticao(display);
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
	public TelaCompeticao(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Group grpCadastroDeCompeties = new Group(this, SWT.NONE);
		grpCadastroDeCompeties.setText("Cadastro de competi\u00E7\u00F5es");
		grpCadastroDeCompeties.setBounds(10, 10, 546, 143);
		
		Label lblNome = new Label(grpCadastroDeCompeties, SWT.NONE);
		lblNome.setBounds(10, 27, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(grpCadastroDeCompeties, SWT.BORDER);
		txtNome.setBounds(10, 48, 320, 21);
		
		Label lblData = new Label(grpCadastroDeCompeties, SWT.NONE);
		lblData.setText("Data");
		lblData.setBounds(355, 27, 55, 15);
		
		txtData = new DateTime(grpCadastroDeCompeties, SWT.DROP_DOWN);
		txtData.setBounds(355, 48, 80, 24);
		
		Label lblColocapo = new Label(grpCadastroDeCompeties, SWT.NONE);
		lblColocapo.setText("Coloca\u00E7\u00E3o");
		lblColocapo.setBounds(355, 84, 55, 15);
		
		txtColocacao = new Text(grpCadastroDeCompeties, SWT.BORDER);
		txtColocacao.setBounds(355, 105, 76, 21);
		
		Button btnIncluir = new Button(grpCadastroDeCompeties, SWT.NONE);
		btnIncluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cadastra();
				listar();
			}
		});
		btnIncluir.setBounds(449, 101, 75, 25);
		btnIncluir.setText("Incluir");
		
		Label lblDistncia = new Label(grpCadastroDeCompeties, SWT.NONE);
		lblDistncia.setText("Dist\u00E2ncia");
		lblDistncia.setBounds(10, 84, 55, 15);
		
		txtDistancia = new Text(grpCadastroDeCompeties, SWT.BORDER);
		txtDistancia.setBounds(10, 105, 80, 21);
		
		tabelaCompeticoes = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaCompeticoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try {
					int indice = tabelaCompeticoes.getSelectionIndex();
					lista.remove(indice);
					listar();
				} catch (Exception e2) {
					
				}
			}
		});
		tabelaCompeticoes.setBounds(10, 159, 544, 285);
		tabelaCompeticoes.setHeaderVisible(true);
		tabelaCompeticoes.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(tabelaCompeticoes, SWT.NONE);
		tblclmnNome.setWidth(219);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnData = new TableColumn(tabelaCompeticoes, SWT.NONE);
		tblclmnData.setWidth(113);
		tblclmnData.setText("Data");
		
		TableColumn tblclmnDistncia = new TableColumn(tabelaCompeticoes, SWT.NONE);
		tblclmnDistncia.setWidth(94);
		tblclmnDistncia.setText("Dist\u00E2ncia");
		
		TableColumn tblclmnColocao = new TableColumn(tabelaCompeticoes, SWT.NONE);
		tblclmnColocao.setWidth(100);
		tblclmnColocao.setText("Coloca\u00E7\u00E3o");
		
		Label lblMelhorColocao = new Label(this, SWT.NONE);
		lblMelhorColocao.setBounds(366, 453, 95, 15);
		lblMelhorColocao.setText("Melhor coloca\u00E7\u00E3o");
		
		txtMelhorColocacao = new Text(this, SWT.BORDER);
		txtMelhorColocacao.setEditable(false);
		txtMelhorColocacao.setBounds(478, 450, 76, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(580, 522);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	private void cadastra(){
		Competicao c = new Competicao();
		c.setNome(txtNome.getText());
		c.setData(txtData.getDay()+"/"+(txtData.getMonth()+1)+"/"+txtData.getYear());
		c.setDistancia(txtDistancia.getText());
		c.setColocacao(txtColocacao.getText());
		c.setMelhorColocacao(txtColocacao.getText());
		
		
		c.setMelhorColocacao(checaMelhor(Integer.parseInt(c.getMelhorColocacao()), Integer.parseInt(txtColocacao.getText())));
	
		
		/*
		Integer melhorLugar = Integer.parseInt(txtColocacao.getText());
		Integer guardaMelhorAnterior = melhorLugar;
		
		if(Integer.parseInt(c.getMelhorColocacao()) <= Integer.parseInt(c.getMelhorColocacao())){
			
			txtMelhorColocacao.setText(c.getMelhorColocacao());
			System.out.println(melhorLugar);
			
		}*/
		
		
		
		lista.add(c);
	}
	
	
	private void listar(){
		tabelaCompeticoes.setItemCount(0);
		for (Competicao c : lista) {
			TableItem it = new TableItem(tabelaCompeticoes, SWT.NONE);
			it.setText(c.toArray());	
			
			txtMelhorColocacao.setText(c.getMelhorColocacao());
			
		}
	}
	
	public String checaMelhor(int atual, int digitado){
		
		if(atual <= digitado){
			return atual+"º";
		} else {
			return digitado+"º";
		}
		
	}
	
	
	
}
