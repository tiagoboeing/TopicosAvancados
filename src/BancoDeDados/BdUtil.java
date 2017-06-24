package BancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BdUtil {
	
	
	public static ArrayList<Aluno> listaAlunoPorDisciplina(){
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM aluno a, disciplina d, aluno_disciplina ad WHERE d.disc_id = ? "
				+ "AND a.alu_id = ad.adisc_alu_id = a.alu_id "
				+ "AND ad.adisc_disc_id = d.disc_id "
				+ "ORDER BY a.alu_nome ASC";
		
		
		try {
		
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setInt(1, d.getInt());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Aluno a = new Aluno();
				a.setIdAluno(rs.getInt("alu_id"));
				a.setNomeAluno(rs.getString("alu_nome"));
				a.setDataNasc(Aluno.dfBr.parse(rs.getString("alu_nascimento")));
				
				lista.add(a);
				
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	

}
