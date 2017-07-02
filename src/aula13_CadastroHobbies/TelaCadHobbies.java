package aula13_CadastroHobbies;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class TelaCadHobbies extends Composite {
	private Text txtNomeHobbie;
	private Table tabelaListaHobbies;
	
	private Integer idEditar;
	private Text txtFiltro;
	
	ArrayList<Hobbie> listaTodosHobbies = new ArrayList<Hobbie>();
	ArrayList<Hobbie> listaHobbiesFiltrados = new ArrayList<Hobbie>();
		

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaCadHobbies(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 21, 70, 20);
		lblNome.setText("Nome");
		
		txtNomeHobbie = new Text(this, SWT.BORDER);
		txtNomeHobbie.setBounds(86, 15, 272, 26);
		
		Button btnInserir = new Button(this, SWT.NONE);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try{
					
					Hobbie h = new Hobbie();
					h.setNome(txtNomeHobbie.getText());
					
					h.cadastra();
					
					preencheTela();
					limpaTela();
					
					
				} catch (Exception c) {
					c.printStackTrace();
				}
					
			}
		});
		btnInserir.setBounds(10, 71, 90, 30);
		btnInserir.setText("Inserir");
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// apenas como alternativa, previne erro do programa caso não haja id
				if(idEditar != null){
					
					// passa dados alterados
					Hobbie h = new Hobbie();
					
					h.setId(idEditar);
					
					h.setNome(txtNomeHobbie.getText());
									
					// passa objeto pessoa
					h.alteraHobbie(h);
					
					preencheTela();
					limpaTela();
					
				}
				
			}
		});
		btnAlterar.setBounds(146, 71, 90, 30);
		btnAlterar.setText("Alterar");
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(tabelaListaHobbies.getSelectionIndex() != -1){
					Hobbie.exclui(listaTodosHobbies.get(tabelaListaHobbies.getSelectionIndex()).getId());
					preencheTela();
				}
				
				
			}
		});
		btnExcluir.setBounds(268, 71, 90, 30);
		btnExcluir.setText("Excluir");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(10, 136, 70, 20);
		lblFiltro.setText("Filtro");
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				
				listaHobbiesFiltrados = Hobbie.busca(txtFiltro.getText());
				
				//limpa tabela
				tabelaListaHobbies.setItemCount(0);
				
				for(Hobbie h : listaHobbiesFiltrados){
					
					TableItem it = new TableItem(tabelaListaHobbies, SWT.NONE);
					
					it.setText(0, h.getId()+"");
					it.setText(1, h.getNome());
				}

				
			}
		});
		txtFiltro.setBounds(86, 136, 272, 26);
		
		tabelaListaHobbies = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaListaHobbies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				txtNomeHobbie.setText(listaTodosHobbies.get(tabelaListaHobbies.getSelectionIndex()).getNome());
				
				// passa id para variável
				idEditar = listaTodosHobbies.get(tabelaListaHobbies.getSelectionIndex()).getId();
				
				preencheTela();
				
			}
		});
		tabelaListaHobbies.setBounds(10, 189, 348, 242);
		tabelaListaHobbies.setHeaderVisible(true);
		tabelaListaHobbies.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(tabelaListaHobbies, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("C\u00F3digo");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(tabelaListaHobbies, SWT.NONE);
		tblclmnNewColumn_1.setWidth(232);
		tblclmnNewColumn_1.setText("Nome");
		
		
		preencheTela();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	
	
	
	private void preencheTela(){
		
		 listaTodosHobbies = Hobbie.listaTodosHobbies();
		
		//limpa tabela
		tabelaListaHobbies.setItemCount(0);
		
		for(Hobbie h : listaTodosHobbies){
			
			TableItem it = new TableItem(tabelaListaHobbies, SWT.NONE);
			
			it.setText(0, h.getId()+"");
			it.setText(1, h.getNome());
			
		}	
	}
	
	
	
	private void limpaTela(){
		txtNomeHobbie.setText("");
	}
	

	
	
	
}
