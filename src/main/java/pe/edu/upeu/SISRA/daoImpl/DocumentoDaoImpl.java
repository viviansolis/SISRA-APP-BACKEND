package pe.edu.upeu.SISRA.daoImpl;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.SISRA.dao.DocumentoDao;
import pe.edu.upeu.SISRA.entity.Documento;

@Component
public class DocumentoDaoImpl implements DocumentoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public Map<String, Object> read(int id_req_asc) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("pk_requisitos")
		.withProcedureName("sp_req_asc")
		.declareParameters(new SqlOutParameter("cursor_r", Types.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_req_asc", Types.NUMERIC));
		SqlParameterSource in = new MapSqlParameterSource().addValue("id_req_asc", id_req_asc);
		Map<String, Object> map = simpleJdbcCall.execute(in);	
		return map;
	}
	@Override
	public int update_apro(int id_req_apro) {
		return jdbcTemplate.update("call pk_documento.estad_apro(?)",id_req_apro);
	}

	@Override
	public int update_repro(int id_req_repro) {
		return jdbcTemplate.update("call pk_documento.estad_repro(?)",id_req_repro);
	}

	
	@Override
	public Map<String, Object> listar_req(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("pk_requisitos") //nombre del paquete
				.withProcedureName("sp_req_list") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_r", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("ID_ASC", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("ID_ASC", id);
		        Map<String, Object> map= simpleJdbcCall.execute(in);	
				return map;
	}

	@Override
	public Map<String, Object> historial_doc(int id_asc, int id_doc) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
				.withCatalogName("pk_requisitos") //nombre del paquete
				.withProcedureName("sp_his_doc") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_his", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_asc", OracleTypes.NUMBER), new SqlParameter("id_doc", OracleTypes.NUMBER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("id_asc", id_asc).addValue("id_doc", id_doc);
		        Map<String, Object> map= simpleJdbcCall.execute(in);	
				return map;	
	}
	@Override
	public int create(Documento r) {
	System.out.print(r.getUrl());
	System.out.print(r.getTipo_documento_id_doc_tipo());
	System.out.print(r.getAsociacion_id_asc());
	System.out.print(r.getCategoria());
		// TODO Auto-generated method stub
	
		return  jdbcTemplate.update("call pk_documento.sp_create_doc(?,?,?,?)",
			r.getUrl(),
			r.getTipo_documento_id_doc_tipo(),
			r.getAsociacion_id_asc(),
			r.getCategoria());
	}
}
