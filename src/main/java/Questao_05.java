import java.sql.ResultSet;
import java.util.Scanner;

import Scripts.conexaoBD;
/*Utilizando a mesma database acima, SISGEP, criar uma consulta que retorne como
resultado todos os atendimentos cadastrados no período de junho de 2020,
agrupados por assunto, classificação, exibindo os seguintes campos: Nome do
Assunto, Nome da Classificação e Quantidade. Deverá ordenar por Nome
Classificação e Assunto Crescente.*/
public class Questao_05 {
	public static void main(String[] args) {
	
		conexaoBD conexao = new conexaoBD();
		Scanner scan = new Scanner(System.in);
		
		
		
		
		String sqlb34 = "SELECT COUNT(*) FROM sc_cad.\"TBL_ATN\"\n"
				+ "where data_inclusao between '2020-06-01' and '2020-06-30';";
		ResultSet resb34 = conexao.ExecutaBusca(sqlb34);
		
		
		
		int cod = 0;
		try {

			System.out.println("Quantidade");

			while (resb34.next()) {
				
				
				 cod = resb34.getInt("count");
		
				

			

				

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
		
		
		
		// busca de iD da tabela pelo nome MNF
		String sqlb33 = "SELECT  sc_cad.\"TBL_APA\".assunto_,sc_cad.\"TBL_CLA\".nome_classificacao\n"
				+ "			FROM sc_cad.\"TBL_ATN\"			\n"
				+ "			inner join sc_cad.\"TBL_APA\" on  sc_cad.\"TBL_ATN\".\"id_ATN\" = sc_cad.\"TBL_APA\".\"id_APA\"\n"
				+ "			inner join sc_cad.\"TBL_CLA\" on  sc_cad.\"TBL_ATN\".\"id_ATN\" >= sc_cad.\"TBL_CLA\".\"id_CLA\"\n"
				+ "			where data_inclusao between '2020-06-01' and '2020-06-30'\n"
				+ "			order by nome_classificacao,assunto_  asc ";
		ResultSet resb33 = conexao.ExecutaBusca(sqlb33);
		
	
		
		
		try {

			System.out.println("Assunto"+"  "+"Classificação"+"  "+"Quantidade"+" = "+"("+cod+")");
			

			while (resb33.next()) {
				
				
				String cod4 = resb33.getString("assunto_");
				String cod5 = resb33.getString("nome_classificacao");
				

				System.out.println(cod4 + "   " + cod5);

				// talvez fazer um for e receber todas as linas em uma string.

			}
			

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
		
		 
	
	
	
	
	
	
}
}
