package pe.edu.upeu.SISRA.dao;

import java.util.Map;

import pe.edu.upeu.SISRA.entity.Documento;

public interface DocumentoDao {
	
	Map<String, Object> read(int id_req_asc);
	int update_apro(int id_req_apro);
	int update_repro(int id_req_repro);
	
	int create(Documento r);
	Map<String, Object> listar_req(int id);
	Map<String, Object> historial_doc(int id_asc, int id_doc);
	
}
