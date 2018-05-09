package test.bluext.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description：测试Callable接口
 *
 * @author : xutao
 *         Created_Date : 2018-04-26 10:52
 */
public class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable run..");
        return 1;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            CallableTest callableTest = new CallableTest();
            executorService.submit(callableTest);// 仅有ExecutorService.submit(Callable<T> callable)方法可以执行Callable实例
        } finally {
            executorService.shutdown();
        }
    }

}
