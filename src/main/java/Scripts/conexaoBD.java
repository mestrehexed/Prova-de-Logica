package Scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.Spring;







public class conexaoBD {
	
	
	
	private Connection conexao;
	
	
	public conexaoBD(){
		
		
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SISGEP","postgres","123456");
						
					
	 
			 
	} catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
			
	}
	
	
	
	
	public int SQLexecute(String sql) {
		
		try {
			Statement stm = conexao.createStatement();
			int res = stm.executeUpdate(sql);
			//conexao.close();
			return res;
		
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
			
			
		}
		
	}
	
	



	
public ResultSet ExecutaBusca (String sql) {
		
		try {
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			//conexao.close();
			return rs;
		
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
			
			
		}
		
	}

public ResultSet ExecutaBuscaFinal (String sql) {
	
	try {
		Statement stm = conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		conexao.close();
		return rs;
	
	} catch (Exception e) {
		e.printStackTrace();
		return  null;
		
		
	}
	
}
	

}
