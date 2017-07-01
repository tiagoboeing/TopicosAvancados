package aula13_CadastroHobbies;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;

public class TelaAssociarHobbies extends Composite {
	private Table tabelaAssociarHobbies;

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
		
		CCombo comboPessoa = new CCombo(this, SWT.BORDER);
		comboPessoa.setBounds(91, 15, 233, 25);
		
		Label lblHobbies = new Label(this, SWT.NONE);
		lblHobbies.setBounds(10, 59, 70, 20);
		lblHobbies.setText("Hobbies");
		
		CCombo comboHobbie = new CCombo(this, SWT.BORDER);
		comboHobbie.setBounds(91, 54, 233, 25);
		
		Button btnAssociar = new Button(this, SWT.NONE);
		btnAssociar.setBounds(10, 100, 90, 30);
		btnAssociar.setText("Associar");
		
		Label lblHobbiesDe = new Label(this, SWT.NONE);
		lblHobbiesDe.setBounds(10, 151, 233, 20);
		lblHobbiesDe.setText("Hobbies da pessoa selecionada");
		
		tabelaAssociarHobbies = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaAssociarHobbies.setBounds(10, 184, 314, 262);
		tabelaAssociarHobbies.setHeaderVisible(true);
		tabelaAssociarHobbies.setLinesVisible(true);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
