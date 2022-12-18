import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import Scripts.conexaoBD;

/*No banco de dados, existe uma database chamada SISGEP. Esta database controla
um sistema de gerenciamento de protocolos onde usuários cadastram solicitações,
reclamações, sugestões, elogios e informações da prefeitura de Fortaleza. Com isso,
criar uma consulta que retorne como resultado todos os chamados cadastrados no
período de 10 fevereiro de 2020 a 15 de fevereiro de 2020, exibindo os seguintes
campos: Código do Atendimento, Data de Inclusão do Atendimento, Nome do
Manifestante, Nome do Assunto, Nome da Classificação do Atendimento. Deverá
ordenar por Data de Inclusão do Atendimento Decrescente.
Tabelas envolvidas:
è SC_CAD.TBL_ATN -> Tabela de Atendimento
è SC_CAD.TBL_MNF -> Tabela de Manifestante
è SC_CAD.TBL_APA -> Tabela de Assunto
è SC_CAD.TBL_CLA -> Tabela de Classificação*/

public class Questão_04 {
	public static void main(String[] args) throws ParseException {

		// scanner para receber entrada de dados
		Scanner scan = new Scanner(System.in);
		// conexao com o banco de dados
		conexaoBD conexao = new conexaoBD();

		// inicio
		System.out.println("SISTEMA DE AJUDA AOS USUÁRIOS");

		// --------------------------------------------------------------------------
		// inseriu o nome no banco MNF
		System.out.println("Para iniciar poderia informar seu nome por gentileza?");
		String nome = scan.nextLine();
		nome = "'" + nome + "'";
		String sql = "INSERT INTO sc_cad." + "\"TBL_MNF\"(\"id_MN\",nome_manifestante) " + "values (default," + nome
				+ ");";
		int res = conexao.SQLexecute(sql);

		// --------------------------------------------------------------------------

		System.out.println("QUAL A SUA SOLICITAÇÃO?");
		System.out.println("RECLAMAÇÕES DIGITE 1,  ELOGIOS DIGITE 2,  INFORMAÇÕES DIGITE 3,  SUGESTÕES DIGITE 4");
		int num = scan.nextInt();

		switch (num) {
		case 1:

			String sql81 = "INSERT INTO sc_cad."
					+ "\"TBL_CLA\" (\"id_CLA\",nome_classificacao) values (default,'Reclamações')";
			int res81 = conexao.SQLexecute(sql81);
			break;
		case 2:

			String sql82 = "INSERT INTO sc_cad."
					+ "\"TBL_CLA\" (\"id_CLA\",nome_classificacao) values (default,'Elogios')";
			int res82 = conexao.SQLexecute(sql82);
			break;
		case 3:

			String sql83 = "INSERT INTO sc_cad."
					+ "\"TBL_CLA\" (\"id_CLA\",nome_classificacao) values (default,'Informações')";
			int res83 = conexao.SQLexecute(sql83);
			break;
		case 4:

			String sql84 = "INSERT INTO sc_cad."
					+ "\"TBL_CLA\" (\"id_CLA\",nome_classificacao) values (default,'Sugestões')";
			int res84 = conexao.SQLexecute(sql84);
			break;
		}
	
		// recebendo a data
		// formatando data e hora no momento do cadastro

		System.out.println("DIGITE A DATA DO DIA" + "  " + "Exemplo:" + " " + "00/00/0000");
		Scanner dataler = new Scanner(System.in);
		String data1 = dataler.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(data1);
		Long ms = data.getTime();
		Date psql = new Date(ms);

		// --------------------------------------------------------------------------
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite sua reclamação");
		String reclamacao = ler.nextLine();
		reclamacao = "'" + reclamacao + "'";
		String sql7 = "INSERT INTO sc_cad." + "\"TBL_APA\" (\"id_APA\",assunto_)" + " values (default," + reclamacao
				+ ");";
		int res7 = conexao.SQLexecute(sql7);

		// ------------------------------------------------------------------------------

		// inserindo na table ATN
		// instância um objeto da classe Random usando o construtor padrão
		Random gerador = new Random();
		Long random = null;

		// Gerando Numero aleatório para virar como protocolo
		for (int i = 10000; i < 1000000000; i++) {
			random = Long.valueOf(gerador.nextInt(1000000000));
		}

		// inserindo na tablela ATN.
		String apa2 = "default";
		String idb = "default";

		// data1 = "'" + data1 + "'"
		String sql01 = "INSERT INTO sc_cad."
				+ "\"TBL_ATN\"(\"id_ATN\",codigo_atendimento,\"id_MNF2\",data_inclusao,\"id_APA2\")"
				+ "values (default," + random + "," + idb + ",'" + psql + "'," + apa2 + ");";
		int res01 = conexao.SQLexecute(sql01);

		// busca de iD da tabela pelo nome MNF
		String sqlb33 = "SELECT  sc_cad.\"TBL_ATN\".codigo_atendimento,sc_cad.\"TBL_ATN\".data_inclusao,\n"
				+ "sc_cad.\"TBL_MNF\".nome_manifestante,sc_cad.\"TBL_APA\".assunto_,sc_cad.\"TBL_CLA\".nome_classificacao\n"
				+ "FROM sc_cad.\"TBL_ATN\"\n"
				+ "inner join sc_cad.\"TBL_MNF\" on  sc_cad.\"TBL_ATN\".\"id_ATN\" = sc_cad.\"TBL_MNF\".\"id_MN\"\n"
				+ "inner join sc_cad.\"TBL_APA\" on  sc_cad.\"TBL_ATN\".\"id_ATN\" = sc_cad.\"TBL_APA\".\"id_APA\"\n"
				+ "inner join sc_cad.\"TBL_CLA\" on  sc_cad.\"TBL_ATN\".\"id_ATN\" >= sc_cad.\"TBL_CLA\".\"id_CLA\"\n"
				+ "order by data_inclusao desc";
		ResultSet resb33 = conexao.ExecutaBuscaFinal(sqlb33);

		try {

			System.out.println("Codigo de Atendimento" + "           " + "Data de Inclusão" + "             "
					+ "Manifestante" + "                " + "Assunto" + "                     " + "Classificação");

			while (resb33.next()) {

				int cod = resb33.getInt("codigo_atendimento");
				String cod2 = resb33.getString("data_inclusao");
				String cod3 = resb33.getString("nome_manifestante");
				String cod4 = resb33.getString("assunto_");
				String cod5 = resb33.getString("nome_classificacao");

				System.out.println("      " + cod + "                   " + cod2 + "                   " + cod3
						+ "                  " + cod4 + "                  " + cod5);

				// talvez fazer um for e receber todas as linas em uma string.

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

	}

}
