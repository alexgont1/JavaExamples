package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	// Logger.getLogger doesn't work anymore
	public static Logger log = LogManager.getLogger(Log4jTest.class);

	public static void main(String[] args) {

		log.info("1st message");
		log.info("2nd message");
	}
}
