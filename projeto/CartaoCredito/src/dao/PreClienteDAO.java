
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelPreCliente;


public class PreClienteDAO {
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelPreCliente precliente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into precadastro " +
	            "(nome,data_nascimento,cpf,rg,endereco,telefone,salario,profissao)" +
	            " values (?,?,?,?,?,?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores
                stmt.setString(1,precliente.getNome());
	        stmt.setString(2,precliente.getDataNascimento());
                stmt.setString(3,precliente.getCpf());
	        stmt.setString(4,precliente.getRg());
	        stmt.setString(5,precliente.getEndereco());
                stmt.setString(6,precliente.getTelefone());
                stmt.setDouble(7,precliente.getSalario());
                stmt.setString(8,precliente.getProfissao());
	        
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
	public static Boolean excluir(int idPreCliente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from precadastro where id_precliente=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idPreCliente);
	        
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
		public static boolean alterar(ModelPreCliente precliente) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update preccadastro "
					+ "set id_precliente=?, nome=?, data_nascimento=?, cpf=?, rg=?, endereco=?, telefone=?, salario=?, profissao=? "
					+ "where id_precliente=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, precliente.getIdPreCliente());
		        stmt.setString(2,precliente.getNome());
		        stmt.setString(3,precliente.getDataNascimento());
		        stmt.setString(4,precliente.getCpf());
                        stmt.setString(5,precliente.getRg());
                        stmt.setString(6,precliente.getEndereco());
		        stmt.setString(7, precliente.getTelefone());
                        stmt.setDouble(8, precliente.getSalario());
                        stmt.setString(9, precliente.getProfissao());
                        stmt.setInt(10, precliente.getIdPreCliente());
		        
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
		public static ModelPreCliente consultar(int idPreCliente) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelPreCliente precliente = null;
			String sql = "select * from precadastro";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_precliente").equals(idPreCliente+"")){
					precliente = new ModelPreCliente();
					precliente.setIdPreCliente(Integer.parseInt(rs.getString("id_precliente")));
                                        precliente.setNome((rs.getString("nome")));
					precliente.setDataNascimento(rs.getString("data_nascimento"));
					precliente.setCpf((rs.getString("cpf")));
					precliente.setRg((rs.getString("rg")));
                                        precliente.setEndereco(rs.getString("endereco"));
                                        precliente.setTelefone(rs.getString("telefone"));
                                        precliente.setSalario(rs.getDouble("salario"));
                                        precliente.setProfissao(rs.getString("profissao"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return precliente;
		}
                
                

	// M�todo para listar um objeto do banco
	public static ArrayList<ModelPreCliente> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelPreCliente> preclientes = new ArrayList<ModelPreCliente>();
		String sql = "select * from precadastro";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelPreCliente precliente = new ModelPreCliente();
			precliente.setIdPreCliente(rs.getInt("id_precliente"));
                        precliente.setNome(rs.getString("nome"));
			precliente.setDataNascimento(rs.getString("data_nascimento"));
                        precliente.setCpf(rs.getString("cpf"));
			precliente.setRg(rs.getString("rg"));
			precliente.setEndereco(rs.getString("endereco"));
                        precliente.setTelefone(rs.getString("telefone"));
                        precliente.setSalario(rs.getDouble("salario"));
                        precliente.setProfissao(rs.getString("profissao"));
			preclientes.add(precliente);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return preclientes;
	}

    
}
