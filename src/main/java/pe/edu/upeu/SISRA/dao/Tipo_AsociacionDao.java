package pe.edu.upeu.SISRA.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.SISRA.entity.Tipo_Asociacion;

public interface Tipo_AsociacionDao {
	int create(Tipo_Asociacion t);
	List<Map<String, Object>> readAll();
}
