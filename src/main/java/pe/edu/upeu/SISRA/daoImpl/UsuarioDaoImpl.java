package pe.edu.upeu.SISRA.daoImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import pe.edu.upeu.SISRA.dao.UsuarioDao;
import pe.edu.upeu.SISRA.entity.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	Gson g = new Gson();
@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public Usuario validarUsuario(String nomuser) {
		String SQL = "select *from usuario where username=?";
		Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] {nomuser}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		System.out.println("Prueba: "+g.toJson(usuario));
		return usuario;
	}
	@Override
	public Map<String, Object> datosUsuario(String username) {
		String SQL = "SELECT u.id_usua, r.id_rol, p.nombre, u.username FROM persona p " + 
				"INNER JOIN usuario u ON u.id_usua = p.id_pers " + 
				"INNER JOIN usuario_rol ur ON u.id_usua = ur.usuario_id_usua  " + 
				"INNER JOIN rol r ON r.id_rol=ur.rol_id_rol "+
				"where u.username = ?";
		Map<String, Object> map= jdbcTemplate.queryForMap(SQL, username);
		return map;
	}

	@Override
	public Usuario read(int id) {
		String SQL = "select *from usuario where ID_USUA=?";
		Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		System.out.println("Prueba: "+g.toJson(usuario));
		return usuario;
	}
}
