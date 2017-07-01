package aula13_CadastroHobbies;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conn() {
		Connection conn = null;
		try {
			File f = new File("aula2.sqlite");
			if (f.exists()) {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:aula2.sqlite");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
