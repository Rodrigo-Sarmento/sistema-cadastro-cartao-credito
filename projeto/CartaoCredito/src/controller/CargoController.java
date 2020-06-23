package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelCargo;
import dao.CargoDAO;
import java.util.ArrayList;


public class CargoController {
    public static Boolean inserirCargo(ModelCargo cargo) throws SQLException{
                return CargoDAO.inserir(cargo);
	}
	
	public static Boolean excluirCargo(int idCargo) throws SQLException{
		return CargoDAO.excluir(idCargo);
	}
	
	public static boolean alterarCargo(ModelCargo cargo) throws SQLException{
		return CargoDAO.alterar(cargo);
	}
	
	public static ModelCargo consultarCargo(int idCargo) throws SQLException{
		return CargoDAO.consultar(idCargo);
	}
        
        public static ModelCargo consultarPeloNome(String nomeCargo) throws SQLException{
		return CargoDAO.consultarPeloNome(nomeCargo);
	}
	
	public static ArrayList<ModelCargo> listarCargo() throws SQLException{
		return CargoDAO.listar();
	}
    
}
