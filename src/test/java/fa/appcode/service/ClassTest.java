package fa.appcode.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fa.appcode.dao.ClassDaoImpl;
import fa.appcode.entities.Class;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ClassTest {
  @InjectMocks
  ClassServicesImpl classServicesImpl;

  @SuppressWarnings("rawtypes")
  @Mock
  ClassDaoImpl classDaoImpl;

  @Test
  public void testGetAllClass() throws Exception {
    Class classtest = new Class();
    List<Class> classes = new ArrayList<>();
    classes.add(classtest);
    classes.add(classtest);
    when(classServicesImpl.getAllClass()).thenReturn(classes);
    assertEquals(2, classes.size());
  }

  @Test
  public void testGetAllClassFail() throws Exception {
    Class classtest = new Class();
    List<Class> classes = new ArrayList<>();
    classes.add(classtest);
    classes.add(classtest);
    when(classServicesImpl.getAllClass()).thenReturn(classes);
    assertNotEquals(3, classes.size());
  }

}
