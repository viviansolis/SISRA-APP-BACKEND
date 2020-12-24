package pe.edu.upeu.SISRA.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upeu.SISRA.dao.UsuarioDao;
import pe.edu.upeu.SISRA.entity.Documento;
import pe.edu.upeu.SISRA.entity.Usuario;
import pe.edu.upeu.SISRA.service.DocumentoService;
import pe.edu.upeu.SISRA.service.UploadFileService;


@RestController
@RequestMapping("/archivos")
public class ArchivosController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private DocumentoService documentoService;
	@Autowired
	private UploadFileService uploadService;
		
		@PostMapping("/upload")
		public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") int id){
			Map<String, Object> response = new HashMap<>();		
			Usuario user = usuarioDao.read(id);		
			if(!archivo.isEmpty()) {
				String nombreArchivo = null;
				try {
					nombreArchivo = uploadService.copiar(archivo);
				} catch (IOException e) {
					response.put("mensaje", "Error al subir archivo");
					response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				String ruta = uploadService.getPath(nombreArchivo).toString();
				documentoService.create(new Documento(ruta, 4, id, "R"));
				/*create(new Archivos(0, nombreArchivo, ruta, user.getIdusuario()));	*/		
				response.put("usuario", user.getUsername());
				response.put("mensaje", "Has subido correctamente el archivo: " + nombreArchivo);			
			}		
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		@GetMapping("/img/{nombreArchivo:.+}")
		public ResponseEntity<Resource> verFoto(@PathVariable String nombreArchivo){
			Resource recurso = null;		
			try {
				recurso = uploadService.cargar(nombreArchivo);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}		
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
			return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		}
}
