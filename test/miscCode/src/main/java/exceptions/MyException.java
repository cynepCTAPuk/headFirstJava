package exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyException extends RuntimeException {
	private static final Logger log = LogManager.getLogger(MyException.class);

	public MyException(String message) {
		super(message);
		log.error(message);
//		System.out.println(message + " - MyException");
	}
}
