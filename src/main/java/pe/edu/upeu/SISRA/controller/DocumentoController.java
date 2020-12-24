package pe.edu.upeu.SISRA.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.SISRA.service.DocumentoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService docService;
	
	@GetMapping("/req/{id_req_asc}")
	public Map<String, Object> read(@PathVariable int id_req_asc){
		try {
			return docService.read(id_req_asc);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error" + e);
			return null;
		}
	}
	
	@GetMapping("/req/apro/{id_req_apro}")
	public int edit1 (@PathVariable int id_req_apro) {
		System.out.println(id_req_apro);
		return docService.update_apro(id_req_apro);
	}
	
	@GetMapping("/req/repro/{id_req_repro}")
	public int edit2 (@PathVariable int id_req_repro) {
		System.out.println(id_req_repro);
		return docService.update_repro(id_req_repro);
	}
	
	@GetMapping("/list_req/{id}")
	public Map<String, Object> listar_req(@PathVariable int id ) {
		try {
			 return docService.listar_req(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error"+e);
			return null;
		}
	}
	@GetMapping("/his/asc={id_asc}/doc={id_doc}")
	public Map<String, Object> historial_doc(@PathVariable int id_asc ,@PathVariable int id_doc) {
		try {
			 return docService.historial_doc(id_asc, id_doc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error"+e);
			return null;
		}
	}
}
