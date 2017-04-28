package Prova1_Sem_Anterior_q2;


import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AbaPaciente extends Composite {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	private Button rbMasculino;
	private Button rbFeminino;
	private ArrayList<Paciente> pacienteList = new ArrayList<Paciente>();
	private ArrayList<Paciente> temp = new ArrayList<Paciente>();


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AbaPaciente(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 31, 254, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(299, 10, 55, 15);
		lblIdade.setText("Idade");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(299, 31, 92, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 71, 287, 51);
		
		rbMasculino = new Button(grpSexo, SWT.RADIO);
		rbMasculino.setSelection(true);
		rbMasculino.setBounds(10, 25, 90, 16);
		rbMasculino.setText("Masculino");
		
		rbFeminino = new Button(grpSexo, SWT.RADIO);
		rbFeminino.setBounds(163, 25, 90, 16);
		rbFeminino.setText("Feminino");
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Paciente paciente = lerDados(true);
				if (paciente != null) {
					pacienteList.add(paciente);
				}
				limpaDados();
				adicionaDadosTable(null);

			}
		});
		btnCadastrar.setBounds(352, 91, 75, 31);
		btnCadastrar.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				Paciente paciente = lerDados(false);
				if (paciente != null) {
					pacienteList.remove(table.getSelectionIndex());
				}
				limpaDados();
				table.remove(table.getSelectionIndices());
			}
		});
		table.setBounds(10, 141, 417, 149);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(178);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(100);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(135);
		tblclmnSexo.setText("Sexo");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void mensagem(String titulo, String texto) {
		MessageBox messageBox = new MessageBox(this.getShell(), SWT.ICON_WARNING);
		messageBox.setText(titulo);
		messageBox.setMessage(texto);
		messageBox.open();
	}
	
	private Paciente lerDados(boolean add) {
		Paciente paciente = new Paciente();
		try {
			paciente.setNome(txtNome.getText());
			if (add) {
				paciente.setIdade(Integer.parseInt(txtIdade.getText()));
			}
			paciente.setSexo(rbMasculino.getSelection() ? 'M' : 'F');
		} catch (NumberFormatException e) {
			mensagem("Dados inválidos", "Idade deve ser númerico");
			return null;
		} catch (Exception e) {
			mensagem("Erro desconhecido", "Concte o suporte");
			return null;
		}
		return paciente;
	}
	
	private void limpaDados() {
		txtNome.setText("");
		txtIdade.setText("");
		rbMasculino.setSelection(true);
		rbFeminino.setSelection(false);
	}
	
	private void adicionaDadosTable(String filtro) {
		table.setItemCount(0);
		temp.clear();
		for (Paciente paciente : pacienteList) {
			if (filtro == null) {
				temp.add(paciente);
			} else {
				if (paciente.getNome().startsWith(filtro)) {
					temp.add(paciente);
				}
			}
		}
		
		for (Paciente paciente : temp) {
			TableItem itemTabela = new TableItem(table, SWT.NONE);
			itemTabela.setText(paciente.toArray());
		}
	}

}
