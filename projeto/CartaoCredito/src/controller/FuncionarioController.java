
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelFuncionario;
import dao.FuncionarioDAO;
import java.util.ArrayList;


public class FuncionarioController {
    
    public static Boolean inserirFuncionario(ModelFuncionario funcionario) throws SQLException{
                return FuncionarioDAO.inserir(funcionario);
	}
	
	public static Boolean excluirFuncionario(int idFuncionario) throws SQLException{
		return FuncionarioDAO.excluir(idFuncionario);
	}
	
	public static boolean alterarFuncionario(ModelFuncionario funcionario) throws SQLException{
		return FuncionarioDAO.alterar(funcionario);
	}
	
	public static ModelFuncionario consultarFuncionario(int idFuncionario) throws SQLException{
		return FuncionarioDAO.consultar(idFuncionario);
	}
        
        public static ModelFuncionario consultarPeloIdeCargo(int idFuncionario, int cargo) throws SQLException{
		return FuncionarioDAO.consultarPeloIdeCargo(idFuncionario, cargo);
	}
        
        public static ModelFuncionario consultarFuncionarioPeloNome(String nomeFuncionario) throws SQLException{
		return FuncionarioDAO.consultarPeloNome(nomeFuncionario);
	}
	
	public static ArrayList<ModelFuncionario> listarFuncionario() throws SQLException{
		return FuncionarioDAO.listar();
	}
}
