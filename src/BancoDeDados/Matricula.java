package BancoDeDados;

import java.sql.PreparedStatement;

public class Matricula {

	private Integer idMatricula;
	Aluno aluno;
	Disciplina disciplina;
	
	
	
	public void cadastraMatricula(){

			String sql = "INSERT INTO aluno_disciplina (adisc_alu_id, adisc_disc_id)" + "VALUES (?, ?)";
			
			try {
				
				PreparedStatement ps = Principal.conn.prepareStatement(sql);
				
				//joga variáveis
				ps.setInt(1, aluno.getIdAluno());
				ps.setInt(2, disciplina.getIdDisciplina());
				
				ps.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	public Integer getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
