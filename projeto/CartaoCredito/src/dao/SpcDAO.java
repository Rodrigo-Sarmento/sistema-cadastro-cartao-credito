package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelSpc;

public class SpcDAO {
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
    
    // M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelSpc spc) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into spc " +
	            "(nome,cpf)" +
	            " values (?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,spc.getNome());
	        stmt.setString(2,spc.getCpf());
	        
	        // executa
	        stmt.execute();
	        
	        // fecha
	        stmt.close();
	        conn.close();
	        
	        return true;
	        
	    }catch(Exception e){
	    	System.out.println(e);
	    }finally{
	    	conn.close();
	    }
	    
	    return false;

	}
	
	//M�todo para excluir um objeto do banco
	public static Boolean excluir(int idPessoa) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from spc where id_pessoa=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idPessoa);
	        
	        // executa
	        stmt.execute();
	        
	        // fecha
	        stmt.close();
	        conn.close();
	        
	        // retorna true, excluiu
	        return true;
	        
	    }catch(Exception e){
	    	System.out.println(e);
	    }finally{
	    	conn.close();
	    }
	    
	    // retorna falso (n�o excluiu)
	    return false;
	}
	
	
	//M�todo para alterar um objeto do banco
		public static boolean alterar(ModelSpc spc) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update spc "
					+ "set id_pessoa=?, nome=?, cpf=? "
					+ "where id_pessoa=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, spc.getIdPessoa());
		        stmt.setString(2,spc.getNome());
		        stmt.setString(3,spc.getCpf());
		        stmt.setInt(4,spc.getIdPessoa());
		        
		        // executa
		        stmt.execute();
		        
		        // fecha
		        stmt.close();
		        conn.close();
                        return true;
		        
		    }catch(SQLException e){
		    	System.out.println(e);
		    }finally{
		    	conn.close();
		    }
                    return false;
		}
	
		// M�todo para consultar um objeto do banco
		public static ModelSpc consultar(int idPessoa) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelSpc spc = null;
			String sql = "select * from spc";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_pessoa").equals(idPessoa+"")){
					spc = new ModelSpc();
					spc.setIdPessoa(Integer.parseInt(rs.getString("id_pessoa")));
					spc.setNome(rs.getString("nome"));
					spc.setCpf(rs.getString("cpf"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return spc;
		}
                
                // M�todo para consultar uma pessoa pelo nome na lista do spc
		public static ModelSpc consultarPeloNome(String nomePessoa) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelSpc spc = null;
			String sql = "select * from spc";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("nome").equals(nomePessoa)){
					spc = new ModelSpc();
					spc.setIdPessoa(Integer.parseInt(rs.getString("id_pessoa")));
					spc.setNome(rs.getString("nome"));
					spc.setCpf(rs.getString("cpf"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return spc;
		}
		
	// M�todo para listar um objeto do banco
	public static ArrayList<ModelSpc> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelSpc> spcs = new ArrayList<ModelSpc>();
		String sql = "select * from spc";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelSpc spc = new ModelSpc();
			spc.setIdPessoa(rs.getInt("id_pessoa"));
			spc.setNome(rs.getString("nome"));
			spc.setCpf(rs.getString("cpf"));
			spcs.add(spc);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return spcs;
	}
    
}
