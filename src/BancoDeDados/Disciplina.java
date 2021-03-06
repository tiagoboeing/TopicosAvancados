package BancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Disciplina {
	
	
	private Integer idDisciplina, semestreDisciplina;
	private String nomeDisciplina, cursoDisciplina;
	
	
	
	public static ArrayList<Disciplina> listaDisciplinas(){
		
		String sql = "SELECT * FROM disciplina ORDER BY disc_nome";
		ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Disciplina d = new Disciplina();
				d.setIdDisciplina(rs.getInt("disc_id"));
				d.setNomeDisciplina(rs.getString("disc_nome"));
				d.setSemestreDisciplina(rs.getInt("disc_semestre"));
				d.setCursoDisciplina(rs.getString("disc_curso"));
				
				listaDisciplinas.add(d);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaDisciplinas;
	}
	
	
	
	
	//busca por registros
	
	public static ArrayList<Disciplina> buscaDisciplina(String textoBuscar){
		
		String sql = "select * from disciplina where disc_nome like ? order by disc_nome";
		ArrayList<Disciplina> listaBusca = new ArrayList<Disciplina>();
		
		try {
			
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			
			//pega texto e faz buscar
			ps.setString(1, "%"+textoBuscar+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Disciplina d = new Disciplina();
				
				d.setIdDisciplina(rs.getInt("disc_id"));
				d.setSemestreDisciplina(rs.getInt("disc_semestre"));
				d.setNomeDisciplina(rs.getString("disc_nome"));
				d.setCursoDisciplina(rs.getString("disc_curso"));
				
				listaBusca.add(d);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaBusca;
	}
			
	
	
	
	public Integer getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public Integer getSemestreDisciplina() {
		return semestreDisciplina;
	}
	public void setSemestreDisciplina(Integer semestreDisciplina) {
		this.semestreDisciplina = semestreDisciplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getCursoDisciplina() {
		return cursoDisciplina;
	}
	public void setCursoDisciplina(String cursoDisciplina) {
		this.cursoDisciplina = cursoDisciplina;
	} 
	

}
