package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelCliente;


public class ClienteDAO {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelCliente cliente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into cliente " +
	            "(nome,data_nascimento,cpf,rg,endereco,telefone,salario,profissao)" +
	            " values (?,?,?,?,?,?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores
                stmt.setString(1,cliente.getNome());
	        stmt.setString(2,cliente.getDataNascimento());
                stmt.setString(3,cliente.getCpf());
	        stmt.setString(4,cliente.getRg());
	        stmt.setString(5,cliente.getEndereco());
                stmt.setString(6,cliente.getTelefone());
                stmt.setDouble(7,cliente.getSalario());
                stmt.setString(8,cliente.getProfissao());
	        
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
	public static Boolean excluir(int idCliente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from cliente where id_cliente=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idCliente);
	        
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
		public static boolean alterar(ModelCliente cliente) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update cliente "
					+ "set id_cliente=?, nome=?, data_nascimento=?, cpf=?, rg=?, endereco=?, telefone=?, salario=?, profissao=? "
					+ "where id_cliente=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, cliente.getIdCliente());
		        stmt.setString(2,cliente.getNome());
		        stmt.setString(3,cliente.getDataNascimento());
		        stmt.setString(4,cliente.getCpf());
                        stmt.setString(5,cliente.getRg());
                        stmt.setString(6,cliente.getEndereco());
		        stmt.setString(7, cliente.getTelefone());
                        stmt.setDouble(8, cliente.getSalario());
                        stmt.setString(9, cliente.getProfissao());
                        stmt.setInt(10, cliente.getIdCliente());
		        
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
		public static ModelCliente consultar(int idCliente) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelCliente cliente = null;
			String sql = "select * from cliente";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_cliente").equals(idCliente+"")){
					cliente = new ModelCliente();
					cliente.setIdCliente(Integer.parseInt(rs.getString("id_cliente")));
                                        cliente.setNome((rs.getString("nome")));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setCpf((rs.getString("cpf")));
					cliente.setRg((rs.getString("rg")));
                                        cliente.setEndereco(rs.getString("endereco"));
                                        cliente.setTelefone(rs.getString("telefone"));
                                        cliente.setSalario(rs.getDouble("salario"));
                                        cliente.setProfissao(rs.getString("profissao"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return cliente;
		}
                
                // M�todo para consultar pelo nome do cliente
		public static ModelCliente consultarPeloNome(String nomeCliente) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelCliente cliente = null;
			String sql = "select * from cliente";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("nome").equals(nomeCliente)){
					cliente = new ModelCliente();
					cliente.setIdCliente(Integer.parseInt(rs.getString("id_cliente")));
                                        cliente.setNome((rs.getString("nome")));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setCpf((rs.getString("cpf")));
					cliente.setRg((rs.getString("rg")));
                                        cliente.setEndereco(rs.getString("endereco"));
                                        cliente.setTelefone(rs.getString("telefone"));
                                        cliente.setSalario(rs.getDouble("salario"));
                                        cliente.setProfissao(rs.getString("profissao"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return cliente;
		}
                

	// M�todo para listar um objeto do banco
	public static ArrayList<ModelCliente> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelCliente> clientes = new ArrayList<ModelCliente>();
		String sql = "select * from cliente";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelCliente cliente = new ModelCliente();
			cliente.setIdCliente(rs.getInt("id_cliente"));
                        cliente.setNome(rs.getString("nome"));
			cliente.setDataNascimento(rs.getString("data_nascimento"));
                        cliente.setCpf(rs.getString("cpf"));
			cliente.setRg(rs.getString("rg"));
			cliente.setEndereco(rs.getString("endereco"));
                        cliente.setTelefone(rs.getString("telefone"));
                        cliente.setSalario(rs.getDouble("salario"));
                        cliente.setProfissao(rs.getString("profissao"));
			clientes.add(cliente);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return clientes;
	}

    
    
    
    
}
