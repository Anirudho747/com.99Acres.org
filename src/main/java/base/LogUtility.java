package base;

import org.testng.Reporter;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

/*
    Log levels and their messages -
    Steps - INFO
 */

public class LogUtility {

    private Logger logger;

    public LogUtility(Class className) {
        logger = getLogger(className.getName());
        logger.getLevel();
    }

    public void logStep(String stepMessage) {
        logger.info(stepMessage);
        Reporter.log("<br><h3>" + stepMessage + "</h3></br>");
    }

    public void logWarning(String warningMessage) {
        logger.warning(warningMessage);
        Reporter.log("<br><h4>" + warningMessage + "</br></h4>");
    }

    public void logTestTitle(String titleMessage) {
        logger.info(titleMessage);
        Reporter.log("<br><h2>" + titleMessage + "</h2></br>");
    }

    public void logInfo(String infoMessage) {
        logger.info(infoMessage);
        Reporter.log("<br>" + infoMessage + "</br>");
    }

    public void logTestInfo(String testInfoMessage) {
        logger.info(testInfoMessage);
        Reporter.log("<br><h4>" + testInfoMessage + "</h4></br>");
    }

    public void logDebug(String debugMessage) {
        logger.info(debugMessage);
        Reporter.log("<br>" + debugMessage + "</br>");
    }

    public void logException(String logException) {
        logger.severe(logException);
        Reporter.log("<br>" + logException + "</br>");
    }

    public void logMessage(String message, boolean extentCheck) {
        logger.info(message);
        Reporter.log("<br>" + message + "</br>");
    }

    public void logUrl(String message) {
        logger.info(message);
        Reporter.log("<br>" + message + "</br>");
    }

    public void logSuccess(String message) {
        logger.info(message);
        Reporter.log("<br>" + message + "</br>");
    }


}
