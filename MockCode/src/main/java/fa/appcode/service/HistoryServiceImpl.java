package fa.appcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.dao.HistoryDao;
import fa.appcode.entities.History;

@Service
public class HistoryServiceImpl implements HistoryService {

  @Autowired
  private HistoryDao historyDao;

  @Override
  public List<History> getAllHistory() throws Exception {
    return historyDao.getAllHistory();
  }

  public void saveHistory(History history) {
    historyDao.saveHistory(history);
  }

  //  public void saveHistory(Candidate candidate)
}
