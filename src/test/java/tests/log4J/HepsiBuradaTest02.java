package tests.log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HepsiBuradaTest02 {

    private static Logger logger= LogManager.getLogger(HepsiBuradaTest02.class.getName());

    @Test
    public void test01() {
        logger.info("LOG INFO");
        logger.debug("LOG DEBUG");
        logger.error("LOG ERROR");
        logger.fatal("LOG FATAL");
        logger.warn("LOG WARN");
    }
}
