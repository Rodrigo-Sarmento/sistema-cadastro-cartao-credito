
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelPreCliente;
import dao.PreClienteDAO;
import java.util.ArrayList;


public class PreClienteController {
    
    public static Boolean inserirPreCliente(ModelPreCliente precliente) throws SQLException{
                return PreClienteDAO.inserir(precliente);
	}
	
	public static Boolean excluirPreCliente(int idPreCliente) throws SQLException{
		return PreClienteDAO.excluir(idPreCliente);
	}
	
	public static boolean alterarPreCliente(ModelPreCliente precliente) throws SQLException{
		return PreClienteDAO.alterar(precliente);
	}
	
	public static ModelPreCliente consultarPreCliente(int idPreCliente) throws SQLException{
		return PreClienteDAO.consultar(idPreCliente);
	}
        
	
	public static ArrayList<ModelPreCliente> listarPreCliente() throws SQLException{
		return PreClienteDAO.listar();
	}
    
}
