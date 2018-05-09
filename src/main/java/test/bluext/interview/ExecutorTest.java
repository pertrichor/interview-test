package test.bluext.interview;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description：测试Executor
 *
 * @author : xutao
 *         Created_Date : 2018-04-26 11:30
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = null;
        try {
            executorService = Executors.newScheduledThreadPool(2);
//        executorService.scheduleAtFixedRate(() -> System.out.println("run.."), 5L, 5L, TimeUnit.SECONDS);// 定时循环启动
            executorService.schedule(() -> System.out.println("run.."), 5L, TimeUnit.SECONDS);// 延迟启动
        } finally {
            executorService.shutdown();
        }
    }

}
