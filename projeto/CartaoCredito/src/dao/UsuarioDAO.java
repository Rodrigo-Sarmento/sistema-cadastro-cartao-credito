package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelUsuario;


public class UsuarioDAO {
        private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelUsuario usuario) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into usuario " +
	            "(fk_funcionario,login,senha)" +
	            " values (?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores

	        stmt.setInt(1,usuario.getFuncionario());
	        stmt.setString(2,usuario.getLogin());
	        stmt.setString(3,usuario.getSenha());
	        
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
	public static Boolean excluir(int idUsuario) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from usuario where id_usuario=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idUsuario);
	        
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
		public static boolean alterar(ModelUsuario usuario) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update usuario "
					+ "set id_usuario=?, fk_funcionario=?, login=?, senha=? "
					+ "where id_usuario=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, usuario.getIdUsuario());
		        stmt.setInt(2,usuario.getFuncionario());
		        stmt.setString(3,usuario.getLogin());
		        stmt.setString(4,usuario.getSenha());
                        stmt.setInt(5, usuario.getIdUsuario());
		        
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
		public static ModelUsuario consultar(int idUsuario) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelUsuario usuario = null;
			String sql = "select * from usuario";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_usuario").equals(idUsuario+"")){
					usuario = new ModelUsuario();
					usuario.setIdUsuario(Integer.parseInt(rs.getString("id_usuario")));
					usuario.setFuncionario(Integer.parseInt(rs.getString("fk_funcionario")));
                                        usuario.setLogin(rs.getString("login"));
                                        usuario.setSenha(rs.getString("senha"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return usuario;
		}
                
                // M�todo para verificar login
		public static ModelUsuario validarUsuario(ModelUsuario modelUsuario) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelUsuario usuario = null;
			String sql = "select * from usuario";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("login").equals(modelUsuario.getLogin()) && rs.getString("senha").equals(modelUsuario.getSenha())){
					usuario = new ModelUsuario();
					usuario.setIdUsuario(Integer.parseInt(rs.getString("id_usuario")));
					usuario.setFuncionario(Integer.parseInt(rs.getString("fk_funcionario")));
                                        usuario.setLogin(rs.getString("login"));
                                        usuario.setSenha(rs.getString("senha"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return usuario;
		}
		
	// M�todo para listar um objeto do banco
	public static ArrayList<ModelUsuario> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelUsuario> usuarios = new ArrayList<ModelUsuario>();
		String sql = "select * from usuario";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelUsuario usuario = new ModelUsuario();
			usuario.setIdUsuario(rs.getInt("id_usuario"));
                        usuario.setFuncionario(rs.getInt("fk_funcionario"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuarios.add(usuario);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return usuarios;
	}
    
}
