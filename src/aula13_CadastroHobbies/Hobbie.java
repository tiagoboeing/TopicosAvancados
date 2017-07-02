package aula13_CadastroHobbies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Hobbie {

	private int id;
	private String nome;
	
	ArrayList<Hobbie> listaHobbies = new ArrayList<Hobbie>();

	
	// lista todos
	public static ArrayList<Hobbie> listaTodosHobbies(){
		
		String sql = "SELECT * FROM hobbie ORDER BY nome ASC";
		ArrayList<Hobbie> listaHobbies = new ArrayList<Hobbie>();
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Hobbie h = new Hobbie();
				h.setId(rs.getInt("codigo"));
				h.setNome(rs.getString("nome"));				
				
				listaHobbies.add(h);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaHobbies;
	}
		
		
	
	
	public void cadastra() {
		String sql = "INSERT INTO hobbie (nome) VALUES (?)";
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void alteraHobbie(Hobbie h) {
		
		String sql = "UPDATE hobbie SET nome = ? WHERE codigo = ?";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setString(1, h.getNome());
			ps.setInt(2, h.getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void exclui(Integer idHobbie) {
		
		String sql = "DELETE FROM hobbie WHERE codigo = ?";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setInt(1, idHobbie);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//busca por registros
	public static ArrayList<Hobbie> busca(String textoBuscar){
		
		String sql = "SELECT * FROM hobbie WHERE nome LIKE ? ORDER BY nome ASC";
		ArrayList<Hobbie> listaBusca = new ArrayList<Hobbie>();
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			//pega texto que é pra buscar
			ps.setString(1, "%"+textoBuscar+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Hobbie h = new Hobbie();
				h.setId(rs.getInt("codigo"));
				h.setNome(rs.getString("nome"));
				
				listaBusca.add(h);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaBusca;
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
