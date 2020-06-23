package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ModelUsuario;
import dao.UsuarioDAO;
import java.util.ArrayList;


public class UsuarioController {
       public static Boolean inserirUsuario(ModelUsuario usuario) throws SQLException{
                return UsuarioDAO.inserir(usuario);
	}
       public static ModelUsuario validarUsuario(ModelUsuario usuario) throws SQLException{
                return UsuarioDAO.validarUsuario(usuario);
	}
	
	public static Boolean excluirUsuario(int idUsuario) throws SQLException{
		return UsuarioDAO.excluir(idUsuario);
	}
	
	public static boolean alterarUsuario(ModelUsuario usuario) throws SQLException{
		return UsuarioDAO.alterar(usuario);
	}
	
	public static ModelUsuario consultarUsuario(int idUsuario) throws SQLException{
		return UsuarioDAO.consultar(idUsuario);
	}
	
	public static ArrayList<ModelUsuario> listarUsuario() throws SQLException{
		return UsuarioDAO.listar();
	}
}
