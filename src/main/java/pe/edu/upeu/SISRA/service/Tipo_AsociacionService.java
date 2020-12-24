package pe.edu.upeu.SISRA.service;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.SISRA.entity.Tipo_Asociacion;


public interface Tipo_AsociacionService {

	int create(Tipo_Asociacion t);
	List<Map<String, Object>> readAll();

}
