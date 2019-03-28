package fa.appcode.dao;

import java.util.List;

import fa.appcode.entities.Class;

public interface ClassDao<E> {
  List<Class> getAllClass() throws Exception;

  List<E> classByType() throws Exception;

  List<E> classByTypeAndLocation() throws Exception;

}
