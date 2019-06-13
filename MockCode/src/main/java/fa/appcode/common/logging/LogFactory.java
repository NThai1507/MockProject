package fa.appcode.common.logging;

import org.apache.log4j.Logger;

public class LogFactory {

  /**
   * This method is getlogger.
   * 
   * @return logger
   */
	
	
  public static Logger getlogger() {
    Logger logger = Logger
        .getLogger(Thread.currentThread().getStackTrace()[2].getMethodName());
    return logger;
  }
}
