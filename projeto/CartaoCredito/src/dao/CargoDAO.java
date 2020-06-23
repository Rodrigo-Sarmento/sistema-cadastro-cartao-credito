package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelCargo;


public class CargoDAO {
        private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelCargo cargo) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into cargo " +
	            "(nome,salario,tempo_trabalho)" +
	            " values (?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores

	        stmt.setString(1,cargo.getNome());
	        stmt.setDouble(2,cargo.getSalario());
	        stmt.setString(3,cargo.getTempoTrabalho());
	        
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
	public static Boolean excluir(int idCargo) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from cargo where id_cargo=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idCargo);
	        
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
		public static boolean alterar(ModelCargo cargo) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update cargo "
					+ "set id_cargo=?, nome=?, salario=?, tempo_trabalho=? "
					+ "where id_cargo=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, cargo.getIdCargo());
		        stmt.setString(2,cargo.getNome());
		        stmt.setDouble(3,cargo.getSalario());
		        stmt.setString(4,cargo.getTempoTrabalho());
		        stmt.setInt(5, cargo.getIdCargo());
		        
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
		public static ModelCargo consultar(int idCargo) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelCargo cargo = null;
			String sql = "select * from cargo";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_cargo").equals(idCargo+"")){
					cargo = new ModelCargo();
					cargo.setIdCargo(Integer.parseInt(rs.getString("id_cargo")));
					cargo.setNome(rs.getString("nome"));
					cargo.setSalario(Double.parseDouble(rs.getString("salario")));
					cargo.setTempoTrabalho((rs.getString("tempo_trabalho")));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return cargo;
		}
                
                // M�todo para consultar pelo nome
		public static ModelCargo consultarPeloNome(String nomeCargo) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelCargo cargo = null;
			String sql = "select * from cargo";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("nome").equals(nomeCargo)){
					cargo = new ModelCargo();
					cargo.setIdCargo(Integer.parseInt(rs.getString("id_cargo")));
					cargo.setNome(rs.getString("nome"));
					cargo.setSalario(Double.parseDouble(rs.getString("salario")));
					cargo.setTempoTrabalho((rs.getString("tempo_trabalho")));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return cargo;
		}
		
	// M�todo para listar um objeto do banco
	public static ArrayList<ModelCargo> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelCargo> cargos = new ArrayList<ModelCargo>();
		String sql = "select * from cargo";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelCargo cargo = new ModelCargo();
			cargo.setIdCargo(rs.getInt("id_cargo"));
			cargo.setNome(rs.getString("nome"));
			cargo.setSalario(rs.getDouble("salario"));
			cargo.setTempoTrabalho(rs.getString("tempo_trabalho"));
			cargos.add(cargo);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return cargos;
	}

}
