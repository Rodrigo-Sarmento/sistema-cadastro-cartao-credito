package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelFuncionario;


public class FuncionarioDAO {
        private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelFuncionario funcionario) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into funcionario " +
	            "(fk_cargo,nome,cpf,salario)" +
	            " values (?,?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores

	        stmt.setInt(1,funcionario.getCargo());
	        stmt.setString(2,funcionario.getNome());
	        stmt.setString(3,funcionario.getCpf());
                stmt.setDouble(4, funcionario.getSalario());
	        
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
	public static Boolean excluir(int idFuncionario) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from funcionario where id_funcionario=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idFuncionario);
	        
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
		public static boolean alterar(ModelFuncionario funcionario) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update funcionario "
					+ "set id_funcionario=?, fk_cargo=?, nome=?, cpf=?, salario=? "
					+ "where id_funcionario=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, funcionario.getIdFuncionario());
		        stmt.setInt(2,funcionario.getCargo());
		        stmt.setString(3,funcionario.getNome());
		        stmt.setString(4,funcionario.getCpf());
		        stmt.setDouble(5, funcionario.getSalario());
                        stmt.setInt(6, funcionario.getIdFuncionario());
		        
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
		public static ModelFuncionario consultar(int idFuncionario) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelFuncionario funcionario = null;
			String sql = "select * from funcionario";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_funcionario").equals(idFuncionario+"")){
					funcionario = new ModelFuncionario();
					funcionario.setIdFuncionario(Integer.parseInt(rs.getString("id_funcionario")));
					funcionario.setCargo(Integer.parseInt(rs.getString("fk_cargo")));
                                        funcionario.setNome(rs.getString("nome"));
                                        funcionario.setCpf(rs.getString("cpf"));
					funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return funcionario;
		}
                
                // M�todo para consultar pelo id e pelo cargo
		public static ModelFuncionario consultarPeloIdeCargo(int idFuncionario, int cargo) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelFuncionario funcionario = null;
			String sql = "select * from funcionario";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_funcionario").equals(idFuncionario+"")&&rs.getString("fk_cargo").equals(cargo+"")){
					funcionario = new ModelFuncionario();
					funcionario.setIdFuncionario(Integer.parseInt(rs.getString("id_funcionario")));
					funcionario.setCargo(Integer.parseInt(rs.getString("fk_cargo")));
                                        funcionario.setNome(rs.getString("nome"));
                                        funcionario.setCpf(rs.getString("cpf"));
					funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return funcionario;
		}
                
                // M�todo para consultar pelo nome
		public static ModelFuncionario consultarPeloNome(String nomeFuncionario) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelFuncionario funcionario = null;
			String sql = "select * from funcionario";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("nome").equals(nomeFuncionario)){
					funcionario = new ModelFuncionario();
					funcionario.setIdFuncionario(Integer.parseInt(rs.getString("id_funcionario")));
					funcionario.setCargo(Integer.parseInt(rs.getString("fk_cargo")));
                                        funcionario.setNome(rs.getString("nome"));
                                        funcionario.setCpf(rs.getString("cpf"));
					funcionario.setSalario(Double.parseDouble(rs.getString("salario")));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return funcionario;
		}
		
	// M�todo para listar um objeto do banco
	public static ArrayList<ModelFuncionario> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelFuncionario> funcionarios = new ArrayList<ModelFuncionario>();
		String sql = "select * from funcionario";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelFuncionario funcionario = new ModelFuncionario();
			funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                        funcionario.setCargo(rs.getInt("fk_cargo"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setSalario(rs.getDouble("salario"));
			funcionario.setCpf(rs.getString("cpf"));
			funcionarios.add(funcionario);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return funcionarios;
	}

}
