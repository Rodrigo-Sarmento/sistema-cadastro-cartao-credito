
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;

import model.ModelDependente;

public class DependenteDAO {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    private static ResultSet rs;
	
	
	// M�todo para inserir um objeto no banco
	public static Boolean inserir(ModelDependente dependente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "insert into dependente " +
	            "(fk_cliente,nome,data_nascimento,cpf,rg,endereco,telefone,salario,profissao)" +
	            " values (?,?,?,?,?,?,?,?,?)";

	    try {
	        // prepared statement para inser��o
	        stmt = conn.prepareStatement(sql);

	        // seta os valores
                stmt.setInt(1, dependente.getCliente());
                stmt.setString(2,dependente.getNome());
	        stmt.setString(3,dependente.getDataNascimento());
                stmt.setString(4,dependente.getCpf());
	        stmt.setString(5,dependente.getRg());
	        stmt.setString(6,dependente.getEndereco());
                stmt.setString(7,dependente.getTelefone());
                stmt.setDouble(8,dependente.getSalario());
                stmt.setString(9,dependente.getProfissao());
	        
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
	public static Boolean excluir(int idDependente) throws SQLException{
		conn = (Connection) new ConnectionFactory().abrir();
		String sql = "delete from dependente where id_dependente=?";

	    try {
	        // prepared statement para exclus�o
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setInt(1, idDependente);
	        
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
		public static boolean alterar(ModelDependente dependente) throws SQLException{
			conn = (Connection) new ConnectionFactory().abrir();
			String sql = "update dependente "
					+ "set id_dependente=?, fk_cliente=?, nome=?, data_nascimento=?, cpf=?, rg=?, endereco=?, telefone=?, salario=?, profissao=? "
					+ "where id_dependente=?";

		    try {
		        // prepared statement para altera��o
		    	stmt = conn.prepareStatement(sql);

		    	// seta os valores
		    	stmt.setInt(1, dependente.getIdDependente());
                        stmt.setInt(2, dependente.getCliente());
		        stmt.setString(3,dependente.getNome());
		        stmt.setString(4,dependente.getDataNascimento());
		        stmt.setString(5,dependente.getCpf());
                        stmt.setString(6,dependente.getRg());
                        stmt.setString(7,dependente.getEndereco());
		        stmt.setString(8, dependente.getTelefone());
                        stmt.setDouble(9, dependente.getSalario());
                        stmt.setString(10, dependente.getProfissao());
                        stmt.setInt(11, dependente.getIdDependente());
		        
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
		public static ModelDependente consultar(int idDependente) throws SQLException{
			// pega a conex�o e o Statement
			conn = (Connection) new ConnectionFactory().abrir();
			ModelDependente dependente = null;
			String sql = "select * from dependente";

			stmt = conn.prepareStatement(sql);

			// executa um select
			rs = stmt.executeQuery();

			// itera no ResultSet
			while (rs.next()) {
				if(rs.getString("id_dependente").equals(idDependente+"")){
					dependente = new ModelDependente();
                                        dependente.setIdDependente(Integer.parseInt(rs.getString("id_dependente")));
					dependente.setCliente(Integer.parseInt(rs.getString("fk_cliente")));
                                        dependente.setNome((rs.getString("nome")));
					dependente.setDataNascimento(rs.getString("data_nascimento"));
					dependente.setCpf((rs.getString("cpf")));
					dependente.setRg((rs.getString("rg")));
                                        dependente.setEndereco(rs.getString("endereco"));
                                        dependente.setTelefone(rs.getString("telefone"));
                                        dependente.setSalario(rs.getDouble("salario"));
                                        dependente.setProfissao(rs.getString("profissao"));
				}
			}
			
			//Fecha todas as conex�es
			rs.close();
			stmt.close();
			conn.close();
			
			return dependente;
		}
                
                

	// M�todo para listar um objeto do banco
	public static ArrayList<ModelDependente> listar() throws SQLException{
		// pega a conex�o e o Statement
		conn = (Connection) new ConnectionFactory().abrir();
		ArrayList<ModelDependente> dependentes = new ArrayList<ModelDependente>();
		String sql = "select * from dependente";

		stmt = conn.prepareStatement(sql);

		// executa um select
		rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			ModelDependente dependente = new ModelDependente();
                        dependente.setIdDependente(rs.getInt("id_dependente"));
			dependente.setCliente(rs.getInt("fk_cliente"));
                        dependente.setNome(rs.getString("nome"));
			dependente.setDataNascimento(rs.getString("data_nascimento"));
                        dependente.setCpf(rs.getString("cpf"));
			dependente.setRg(rs.getString("rg"));
			dependente.setEndereco(rs.getString("endereco"));
                        dependente.setTelefone(rs.getString("telefone"));
                        dependente.setSalario(rs.getDouble("salario"));
                        dependente.setProfissao(rs.getString("profissao"));
			dependentes.add(dependente);
		}
		
		//Fecha todas as conex�es
		rs.close();
		stmt.close();
		conn.close();
		return dependentes;
	}

    
    
    
}
