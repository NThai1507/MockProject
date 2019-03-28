package fa.appcode.service;

import java.util.List;

import fa.appcode.entities.Class;

public interface ClassServices<E> {
  List<Class> getAllClassByType() throws Exception;

  List<Class> getAllClass() throws Exception;

  List<E> getAllClassByLocation() throws Exception;
}
