package BancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Aluno {
	
	private int idAluno;
	private String nomeAluno;
	private Date dataNasc;
	
//	
//	public Aluno(String nomeAluno, Date dataNasc){
//		this.nomeAluno = nomeAluno;
//		this.dataNasc = dataNasc;
//	}
	
	
	public String toString(){
		return getIdAluno() + " - " + getNomeAluno() + " - " + getDataNasc();
	}
	
	
	//formata data
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat dfBr = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public static ArrayList<Aluno> listaTodos(){
		
		String sql = "SELECT * FROM aluno ORDER BY alu_nome";
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Aluno a = new Aluno();
				a.setIdAluno(rs.getInt("alu_id"));
				a.setNomeAluno(rs.getString("alu_nome"));
				a.setDataNasc(df.parse(rs.getString("alu_nascimento")));
				
				lista.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	//cadastra aluno no banco
	public void cadastra(){
		
		String sql = "INSERT INTO aluno (alu_nome, alu_nascimento)" + "VALUES (?, ?)";
		
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			
			//joga variáveis
			ps.setString(1, getNomeAluno());
			ps.setString(2, df.format(getDataNasc()));
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//alterar aluno
	public static void altera(Integer idAluno, String nome, String data){
		
		String sql = "UPDATE aluno SET alu_nome = ?, alu_nascimento = ? WHERE alu_id = ?";
					
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			
			ps.setString(1, nome);
			ps.setString(2, data);
			ps.setInt(3, idAluno);
			ps.executeUpdate();
			
			//System.out.println(idAluno);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
	}
	


	//excluir
	public static void exclui(Integer idAluno){
		
		String sql = "DELETE FROM aluno WHERE alu_id = ?";
					
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			
			ps.setInt(1, idAluno);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
	}
	
	
	
	//excluir tudo
	public static void excluiTudo(){
		
		String sql = "DELETE FROM aluno";
					
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
		
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
	}
	
	
	//busca por registros
	public static ArrayList<Aluno> busca(String textoBuscar){
		
		String sql = "SELECT * FROM aluno WHERE alu_nome LIKE ? ORDER BY alu_nome";
		ArrayList<Aluno> listaBusca = new ArrayList<Aluno>();
		
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			
			//pega texto que é pra buscar
			ps.setString(1, "%"+textoBuscar+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Aluno a = new Aluno();
				a.setIdAluno(rs.getInt("alu_id"));
				a.setNomeAluno(rs.getString("alu_nome"));
				a.setDataNasc(df.parse(rs.getString("alu_nascimento")));
				
				listaBusca.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaBusca;
	}
	
	
	
	
	
	public String getDtBr(){
		try {

			return dfBr.format(getDataNasc());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";	
	}
	
	
	
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	

}
