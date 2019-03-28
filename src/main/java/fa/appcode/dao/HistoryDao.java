package fa.appcode.dao;

import java.util.List;

import fa.appcode.entities.History;

public interface HistoryDao {

  List<History> getAllHistory();

  void saveHistory(History history);

}
