package onlineShop.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
@Component
public class TaskTest {
    private static final Logger log = LoggerFactory.getLogger(TaskTest.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //    @Scheduled(cron = "0 */1 * * * *")
//    @Scheduled(fixedRate = 5000)
    public void test() {
        log.info("TASK: ", dateFormat.format(new Date()));
    }
}
