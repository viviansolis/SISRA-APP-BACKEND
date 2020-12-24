package pe.edu.upeu.SISRA.dao;

import java.util.Map;

import pe.edu.upeu.SISRA.entity.Usuario;

public interface UsuarioDao {
	
 Usuario validarUsuario(String nomuser);
 Map<String, Object> datosUsuario(String username);
 Usuario read(int id);
}
