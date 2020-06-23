
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelDependente;
import dao.DependenteDAO;
import java.util.ArrayList;

public class DependenteController {
    public static Boolean inserirDependente(ModelDependente dependente) throws SQLException{
                return DependenteDAO.inserir(dependente);
	}
	
	public static Boolean excluirDependente(int idDependente) throws SQLException{
		return DependenteDAO.excluir(idDependente);
	}
	
	public static boolean alterarDependente(ModelDependente dependente) throws SQLException{
		return DependenteDAO.alterar(dependente);
	}
	
	public static ModelDependente consultarDependente(int idDependente) throws SQLException{
		return DependenteDAO.consultar(idDependente);
	}
        
	public static ArrayList<ModelDependente> listarDependente() throws SQLException{
		return DependenteDAO.listar();
	}
}
