package TesteMysql;

public class Iniciar {

	public static void main(String[] args) {
		conexao.getConnection();
		System.out.println(conexao.status);
	} 
}
