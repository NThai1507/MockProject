package fa.appcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.dao.ClassDao;
import fa.appcode.entities.Class;

@SuppressWarnings("rawtypes")
@Service
public class ClassServicesImpl implements ClassServices {
  @Autowired
  ClassDao<?> classDao;

  @SuppressWarnings("unchecked")
  @Override
  public List<Class> getAllClassByType() throws Exception {

    return (List<Class>) classDao.classByType();
  }

  @Override
  public List<Class> getAllClass() throws Exception {

    return (List<Class>) classDao.getAllClass();
  }

  @Override
  public List<?> getAllClassByLocation() throws Exception {
    return classDao.classByTypeAndLocation();
  }

}
