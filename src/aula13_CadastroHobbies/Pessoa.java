package aula13_CadastroHobbies;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Pessoa {

	private int id;
	private String nome;
	private String sexo;
	private String nascimento;
	private int idade;
	
	//private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//private static DateFormat dfBr = new SimpleDateFormat("dd/MM/yyyy");
	
	ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	
	public void cadastra() {
		
		String sql = "INSERT INTO pessoa (nome, sexo, dtnasc) VALUES (?, ?, ?)";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setString(1, getNome());
			ps.setString(2, getSexo());
			ps.setString(3, getNascimento());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void altera() {
		
		String sql = "UPDATE pessoa SET nome = ?, dtnasc = ?, sexo = ? WHERE codigo = ?";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setString(1, getNome());
			ps.setString(2, getNascimento());
			ps.setString(3, getSexo());
			ps.setInt(4, getId());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void excluiPessoa(Integer idPessoa) {
		
		String sql = "DELETE FROM pessoa WHERE codigo = ?";
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			
			ps.setInt(1, idPessoa);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// lista todos
	public static ArrayList<Pessoa> listaTodasPessoas(){
		
		String sql = "SELECT codigo, nome, sexo, dtnasc, CURRENT_TIMESTAMP - dtnasc AS idade FROM pessoa ORDER BY nome ASC";
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		try {
			
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("codigo"));
				p.setNome(rs.getString("nome"));				
				p.setNascimento(rs.getString("dtnasc"));
				p.setSexo(rs.getString("sexo"));
				p.setIdade(rs.getInt("idade"));
				
				listaPessoas.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPessoas;
	}
	


	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

}
