package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelCartao;


public class CartaoDAO {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelCartao cartao) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into cartao " +
	            "(fk_cliente,nome,data_validade,cod_seguranca,num_cartao)" +
	            " values (?,?,?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores
                stmt.setInt(1,cartao.getCliente());
	        stmt.setString(2,cartao.getNome());
                stmt.setString(3,cartao.getDataValidade());
	        stmt.setString(4,cartao.getCodSeguranca());
	        stmt.setString(5,cartao.getNumCartao());
	        
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
	public static Boolean excluir(int idCartao) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from cartao where id_cartao=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idCartao);
	        
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
		public static boolean alterar(ModelCartao cartao) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update cartao "
					+ "set id_cartao=?, fk_cliente=?, nome=?, data_validade=?, cod_seguranca=?, num_cartao=? "
					+ "where id_cartao=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, cartao.getIdCartao());
		        stmt.setInt(2,cartao.getCliente());
		        stmt.setString(3,cartao.getNome());
		        stmt.setString(4,cartao.getDataValidade());
                        stmt.setString(5,cartao.getCodSeguranca());
                        stmt.setString(6,cartao.getNumCartao());
		        stmt.setInt(7, cartao.getIdCartao());
		        
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
		public static ModelCartao consultar(int idCartao) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelCartao cartao = null;
			String sql = "select * from cartao";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_cartao").equals(idCartao+"")){
					cartao = new ModelCartao();
					cartao.setIdCartao(Integer.parseInt(rs.getString("id_cartao")));
                                        cartao.setCliente(Integer.parseInt(rs.getString("fk_cliente")));
					cartao.setNome(rs.getString("nome"));
					cartao.setDataValidade((rs.getString("data_validade")));
					cartao.setCodSeguranca((rs.getString("cod_seguranca")));
                                        cartao.setNumCartao(rs.getString("num_cartao"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return cartao;
		}
                

	// M�todo para listar um objeto do banco
	public static ArrayList<ModelCartao> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelCartao> cartoes = new ArrayList<ModelCartao>();
		String sql = "select * from cartao";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelCartao cartao = new ModelCartao();
			cartao.setIdCartao(rs.getInt("id_cartao"));
                        cartao.setCliente(rs.getInt("fk_cliente"));
			cartao.setNome(rs.getString("nome"));
                        cartao.setDataValidade(rs.getString("data_validade"));
			cartao.setCodSeguranca(rs.getString("cod_seguranca"));
			cartao.setNumCartao(rs.getString("num_cartao"));
			cartoes.add(cartao);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return cartoes;
	}

    
    
}
