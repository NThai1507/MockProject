package fa.appcode.service;

import java.util.List;

import fa.appcode.entities.History;

public interface HistoryService {
  List<History> getAllHistory() throws Exception;

  void saveHistory(History history);
}
