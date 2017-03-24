package Correcao_CadastroCarro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BackCadastroCarro implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Cadastro.btCadastrar) {
			cadastra();

		} else {
			LimpaTela();
		}
	}

	private void cadastra() {
		try {

			String combo = Cadastro.combo.getSelectedItem().toString();
			String cor = Cadastro.txtCor.getText();
			int ano = Integer.parseInt(Cadastro.txtAno.getText());

			if (ano < 1980)
				throw new NumberFormatException("Ano deve ser maior que 1980.");

			if (cor.length() < 3)
				throw new Exception("Cor precisa ter mais que 3 caracteres .");

			String conteudo = Cadastro.area.getText();
			String linha = "\n" + combo + " - " + cor + " - " + ano + "\n";
			Cadastro.area.setText(conteudo + linha);

		} catch (NumberFormatException err) {
			JOptionPane.showMessageDialog(Cadastro.btCadastrar, "N�mero Inv�lido : " + err.getMessage());
		} catch (Exception err) {
			JOptionPane.showMessageDialog(Cadastro.btCadastrar, "Erro : " + err.getMessage());
		}
	}

	private void LimpaTela() {
		Cadastro.combo.setSelectedIndex(-1);
		Cadastro.txtAno.setText("");
		Cadastro.txtCor.setText("");
		Cadastro.area.setText("");
	}

	/*double ano = 0;try
	{
		ano = Double.parseDouble(Cadastro.txtAno.getText());
		if (ano < 1980)
			throw new NumberFormatException("Ano deve ser maior que 1980.");

	}catch(
	NumberFormatException err)
	{
		JOptionPane.showMessageDialog(Cadastro.txtAno, "N�mero Inv�lido : " + err.getMessage());
	}catch(
	Exception err)
	{
		JOptionPane.showMessageDialog(Cadastro.txtAno, "Erro desconhecido " + err.toString());
	}

	String cor = "";

	try
	{
		cor = (Cadastro.txtCor.getText());
		if (cor.length() < 3)
			throw new NumberFormatException("Cor precisa ter mais que 3 caracteres .");

	}catch(
	NumberFormatException err)
	{
		JOptionPane.showMessageDialog(Cadastro.txtAno, "N�mero Inv�lido : " + err.getMessage());
	}catch(
	Exception err)
	{
		JOptionPane.showMessageDialog(Cadastro.txtAno, "Erro desconhecido " + err.toString());
	}

}*/
}
