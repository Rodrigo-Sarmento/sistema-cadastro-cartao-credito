package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelSpc;
import dao.SpcDAO;
import java.util.ArrayList;


public class SpcController {
    
    public static Boolean inserirSpc(ModelSpc spc) throws SQLException{
                return SpcDAO.inserir(spc);
	}
	
	public static Boolean excluirSpc(int idPessoa) throws SQLException{
		return SpcDAO.excluir(idPessoa);
	}
	
	public static boolean alterarSpc(ModelSpc spc) throws SQLException{
		return SpcDAO.alterar(spc);
	}
	
	public static ModelSpc consultarSpc(int idPessoa) throws SQLException{
		return SpcDAO.consultar(idPessoa);
	}
        
        public static ModelSpc consultarSpcPeloNome(String nomePessoa) throws SQLException{
		return SpcDAO.consultarPeloNome(nomePessoa);
	}
	
	public static ArrayList<ModelSpc> listarSpc() throws SQLException{
		return SpcDAO.listar();
	}
    
}
