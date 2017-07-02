package aula13_CadastroHobbies;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaAssociarHobbies extends Composite {
	
	private Table tabelaHobbiesPessoa;
	
	ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	ArrayList<Hobbie> listaHobbies = new ArrayList<Hobbie>();
	
	ArrayList<Hobbie> listaHobbiesPessoa = new ArrayList<Hobbie>();
	
	private CCombo comboPessoa;
	private CCombo comboHobbie;
	private Label lblPessoaSelecionada;

	

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaAssociarHobbies(Composite parent, int style) {
		super(parent, style);
		
		Label lblPessoa = new Label(this, SWT.NONE);
		lblPessoa.setBounds(10, 20, 70, 20);
		lblPessoa.setText("Pessoa");
		
		comboPessoa = new CCombo(this, SWT.BORDER);
		comboPessoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				preenchePessoas();
				
			}
		});
		comboPessoa.setText("SELECIONE UMA PESSOA");
		comboPessoa.setBounds(91, 15, 233, 25);
		
		Label lblHobbies = new Label(this, SWT.NONE);
		lblHobbies.setBounds(10, 59, 70, 20);
		lblHobbies.setText("Hobbies");
		
		comboHobbie = new CCombo(this, SWT.BORDER);
		comboHobbie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				listaHobbies.get(comboHobbie.getSelectionIndex()-1).getId();
				
			}
		});
		comboHobbie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				preencheHobbies();
				
			}
		});
		comboHobbie.setText("SELECIONE UM HOBBIE");
		comboHobbie.setBounds(91, 54, 233, 25);
		
		Button btnAssociar = new Button(this, SWT.NONE);
		btnAssociar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// CHECA SE CORRESPONDE COM AS SELEÇÕES
				if(!comboPessoa.getText().equalsIgnoreCase("SELECIONE UMA PESSOA") && !comboHobbie.getText().equalsIgnoreCase("SELECIONE UM HOBBIE")){
					
					associarHobbie(listaPessoas.get(comboPessoa.getSelectionIndex()-1).getId(), listaHobbies.get(comboHobbie.getSelectionIndex()-1).getId());
					
				} else {
					
					try {
						
						MessageBox dialog = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.OK);
						dialog.setText("Ops... Precisa selecionar um hobbie e uma pessoa");
						dialog.setMessage("Ops... Precisa selecionar um hobbie e uma pessoa");
						
						dialog.open();

						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			}
		});
		btnAssociar.setBounds(10, 100, 90, 30);
		btnAssociar.setText("Associar");
		
		Label lblHobbiesPessoa = new Label(this, SWT.NONE);
		lblHobbiesPessoa.setBounds(10, 151, 66, 15);
		lblHobbiesPessoa.setText("Hobbies de: ");
		
		tabelaHobbiesPessoa = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaHobbiesPessoa.setBounds(10, 184, 314, 262);
		tabelaHobbiesPessoa.setHeaderVisible(true);
		tabelaHobbiesPessoa.setLinesVisible(true);
		
		TableColumn tblclmnHobbie = new TableColumn(tabelaHobbiesPessoa, SWT.NONE);
		tblclmnHobbie.setWidth(308);
		tblclmnHobbie.setText("Hobbie");
		
		lblPessoaSelecionada = new Label(this, SWT.NONE);
		lblPessoaSelecionada.setBounds(82, 151, 290, 15);

		
		preenchePessoas();
		preencheHobbies();
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	
	private void preenchePessoas(){
				
		listaPessoas = Pessoa.listaTodasPessoas();
		
		// atualiza lista, caso seja adicionado nova pessoa
		comboPessoa.removeAll();
		comboPessoa.add("SELECIONE UMA PESSOA", 0);
		comboPessoa.setText("SELECIONE UMA PESSOA");
		
		
		for(Pessoa p : listaPessoas){
			
			String pessoa = "ID " + p.getId() + " | " + p.getNome();
			
			comboPessoa.add(pessoa);

		}	
	}
	
	
	
	private void preencheHobbies(){
		
			
		listaHobbies = Hobbie.listaTodosHobbies();
		
		// atualiza lista, caso seja adicionado nova pessoa
		comboHobbie.removeAll();
		comboHobbie.add("SELECIONE UM HOBBIE", 0);
		comboHobbie.setText("SELECIONE UM HOBBIE");
		
		
		for(Hobbie h : listaHobbies){
			
			String hobbie = "ID " + h.getId() + " | " + h.getNome();
			
			comboHobbie.add(hobbie);

		}	
	}
	
	
	
	private void associarHobbie(Integer idPessoa, Integer idHobbie){
				
		String sql = "INSERT INTO hobbie_pessoa (pessoa, hobbie) VALUES (?, ?)";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setInt(1, idPessoa);
			ps.setInt(2, idHobbie);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//busca por registros
	private static ArrayList<Hobbie> hobbiesPessoa(Integer idPessoa){
		
		String sql = "SELECT h.codigo AS hob_id, h.nome AS hob_nome "
				+ "FROM hobbie h, hobbie_pessoa a, pessoa p"
				+ "WHERE a.pessoa = ? "
				+ "AND h.codigo = a.hobbie "
				+ "AND p.codigo = ?";
		ArrayList<Hobbie> listaAssociacoes = new ArrayList<Hobbie>();
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			//pega id da pessoa
			ps.setInt(1, idPessoa);
			ps.setInt(2, idPessoa);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Hobbie h = new Hobbie();
				h.setId(rs.getInt("hob_id"));
				h.setNome(rs.getString("hob_nome"));
				
				listaAssociacoes.add(h);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAssociacoes;
	}
	
	
	
}
