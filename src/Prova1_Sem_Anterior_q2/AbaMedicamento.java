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

public class AbaMedicamento extends Composite {
	private Text txtNome;
	private Text txtValor;
	private Text txtQtd;
	private Table table;
	private Button rbUnidade;
	private Button rbMl;
	private ArrayList<Medicamento> medicamentoList = new ArrayList<Medicamento>();
	private ArrayList<Medicamento> temp = new ArrayList<Medicamento>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AbaMedicamento(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 22, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 50, 252, 21);
		
		Label lblValorCaixa = new Label(this, SWT.NONE);
		lblValorCaixa.setBounds(282, 22, 67, 15);
		lblValorCaixa.setText("Valor Caixa");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(282, 50, 76, 21);
		
		Label lblQtdadeCaixa = new Label(this, SWT.NONE);
		lblQtdadeCaixa.setBounds(10, 82, 83, 15);
		lblQtdadeCaixa.setText("Qtdade Caixa");
		
		txtQtd = new Text(this, SWT.BORDER);
		txtQtd.setBounds(10, 103, 83, 21);
		
		Group grpApresentao = new Group(this, SWT.NONE);
		grpApresentao.setText("Apresenta\u00E7\u00E3o");
		grpApresentao.setBounds(118, 82, 217, 41);
		
		rbUnidade = new Button(grpApresentao, SWT.RADIO);
		rbUnidade.setSelection(true);
		rbUnidade.setBounds(10, 19, 90, 16);
		rbUnidade.setText("Unidade");
		
		rbMl = new Button(grpApresentao, SWT.RADIO);
		rbMl.setBounds(161, 19, 51, 16);
		rbMl.setText("ml");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Medicamento medicamento = lerDados(true);
				if (medicamento != null) {
					medicamentoList.add(medicamento);
				}
				limpaDados();
				adicionaDadosTable(null);
			}
		});
		btnNewButton.setBounds(365, 93, 75, 31);
		btnNewButton.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				Medicamento medicamento = lerDados(false);
				if (medicamento != null) {
					medicamentoList.remove(table.getSelectionIndex());
				}
				limpaDados();
				table.remove(table.getSelectionIndices());

			}
		});
		table.setBounds(10, 137, 430, 153);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(139);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnValorCaixa = new TableColumn(table, SWT.NONE);
		tblclmnValorCaixa.setWidth(100);
		tblclmnValorCaixa.setText("Valor Caixa");
		
		TableColumn tblclmnQtdade = new TableColumn(table, SWT.NONE);
		tblclmnQtdade.setWidth(68);
		tblclmnQtdade.setText("Qtdade");
		
		TableColumn tblclmnValorUnidade = new TableColumn(table, SWT.NONE);
		tblclmnValorUnidade.setWidth(100);
		tblclmnValorUnidade.setText("Valor Unidade");

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
	
	private Medicamento lerDados(boolean add) {
		Medicamento medicamento = new Medicamento();
		try {
			medicamento.setNome(txtNome.getText());
			if (add) {
				medicamento.setValor(Double.parseDouble(txtValor.getText()));
				medicamento.setQtdCaixa(Integer.parseInt(txtQtd.getText()));
				medicamento.setValorUnidade(calculaValorUnidade(medicamento.getValor(),medicamento.getQtdCaixa()));
			}
			medicamento.setMedidas(rbUnidade.getSelection() ? 'U' : 'M');
		} catch (NumberFormatException e) {
			mensagem("Dados inválidos", "Valor e quantidade devem ser númericos");
			return null;
		} catch (Exception e) {
			mensagem("Erro desconhecido", "Concte o suporte");
			return null;
		}
		return medicamento;
	}
	
	private double calculaValorUnidade(double valor, int qtd) {
		return (valor/qtd);
	}
	
	private void limpaDados() {
		txtNome.setText("");
		txtValor.setText("");
		txtQtd.setText("");
		rbUnidade.setSelection(true);
		rbMl.setSelection(false);
	}
	
	private void adicionaDadosTable(String filtro) {
		table.setItemCount(0);
		temp.clear();
		for (Medicamento medicamento : medicamentoList) {
			if (filtro == null) {
				temp.add(medicamento);
			} else {
				if (medicamento.getNome().startsWith(filtro)) {
					temp.add(medicamento);
				}
			}
		}
		
		for (Medicamento medicamento : temp) {
			TableItem itemTabela = new TableItem(table, SWT.NONE);
			itemTabela.setText(medicamento.toArray());
		}
	}

}

