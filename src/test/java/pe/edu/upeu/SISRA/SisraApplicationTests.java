package pe.edu.upeu.SISRA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.edu.upeu.SISRA.dao.AsociacionDao;
import pe.edu.upeu.SISRA.dao.DocumentoDao;
import pe.edu.upeu.SISRA.entity.Rol;
import pe.edu.upeu.SISRA.dao.UsuarioDao;

@SpringBootTest
class SisraApplicationTests {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AsociacionDao asc; 
	@Test
	void contextLoads() {
		/*System.out.println(passwordEncoder.encode("123"));*/
		System.out.println(asc.readAllh());
		
	}
}
