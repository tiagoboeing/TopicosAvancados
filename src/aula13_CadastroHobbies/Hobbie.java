package aula13_CadastroHobbies;

import java.sql.PreparedStatement;

public class Hobbie {

	private int id;
	private String nome;

	public void Cadastra() {
		String sql = "INSERT INTO Hobbie(hob_nome) VALUES (?)";
		try {
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Altera() {
		String sql = "UPDATE Hobbie SET hob_nome=? WHERE hob_id=?";
		try {
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Exclui() {
		String sql = "DELETE FROM Hobbie WHERE hob_id=?";
		try {
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ps.setInt(1, getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
