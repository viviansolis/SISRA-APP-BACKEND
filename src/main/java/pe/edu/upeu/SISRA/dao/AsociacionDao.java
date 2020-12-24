package pe.edu.upeu.SISRA.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.SISRA.entity.Asociacion;
import pe.edu.upeu.SISRA.entity.Tipo_Asociacion;

public interface AsociacionDao {
	int create(Asociacion a);
	int delete(int id);
	List<Map<String, Object>> readAll();
	Map<String, Object> readAllh();
}
