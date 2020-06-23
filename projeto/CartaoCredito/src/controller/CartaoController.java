
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelCartao;
import dao.CartaoDAO;
import java.util.ArrayList;


public class CartaoController {
    
    public static Boolean inserirCartao(ModelCartao cartao) throws SQLException{
                return CartaoDAO.inserir(cartao);
	}
	
	public static Boolean excluirCartao(int idCartao) throws SQLException{
		return CartaoDAO.excluir(idCartao);
	}
	
	public static boolean alterarCartao(ModelCartao cartao) throws SQLException{
		return CartaoDAO.alterar(cartao);
	}
	
	public static ModelCartao consultarCartao(int idCartao) throws SQLException{
		return CartaoDAO.consultar(idCartao);
	}
	
	public static ArrayList<ModelCartao> listarCartao() throws SQLException{
		return CartaoDAO.listar();
	}
    
}
