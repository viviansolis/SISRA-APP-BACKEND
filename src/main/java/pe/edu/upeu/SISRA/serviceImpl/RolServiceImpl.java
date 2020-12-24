package pe.edu.upeu.SISRA.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.SISRA.dao.RolDao;
import pe.edu.upeu.SISRA.entity.Rol;
import pe.edu.upeu.SISRA.service.RolService;


@Service
public class RolServiceImpl implements RolService{
@Autowired
private RolDao rolDao;
	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return rolDao.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return rolDao.readAll();
	}

	@Override
	public int create(Rol r) {
		// TODO Auto-generated method stub
		return rolDao.create(r);
	}

	@Override
	public int update(Rol r) {
		// TODO Auto-generated method stub
		System.out.println("service: "+r.getNombre());
		return rolDao.update(r);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return rolDao.delete(id);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return rolDao.update(id);
	}

}
