package pe.edu.upeu.SISRA.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.SISRA.entity.Rol;



public interface RolService {
	int create(Rol r);
	int update(Rol r);
	int update(int id);
	int delete(int id);
	List<Map<String, Object>> read(int id);
	List<Map<String, Object>> readAll();
}
