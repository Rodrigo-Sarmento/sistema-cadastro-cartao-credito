package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelCliente;
import dao.ClienteDAO;
import java.util.ArrayList;


public class ClienteController {
    
    public static Boolean inserirCliente(ModelCliente cliente) throws SQLException{
                return ClienteDAO.inserir(cliente);
	}
	
	public static Boolean excluirCliente(int idCliente) throws SQLException{
		return ClienteDAO.excluir(idCliente);
	}
	
	public static boolean alterarCliente(ModelCliente cliente) throws SQLException{
		return ClienteDAO.alterar(cliente);
	}
	
	public static ModelCliente consultarCliente(int idCliente) throws SQLException{
		return ClienteDAO.consultar(idCliente);
	}
        public static ModelCliente consultarPeloNome(String nomeCliente) throws SQLException{
		return ClienteDAO.consultarPeloNome(nomeCliente);
	}
	
	public static ArrayList<ModelCliente> listarCliente() throws SQLException{
		return ClienteDAO.listar();
	}
    
}
