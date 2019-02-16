package com.imooc.web.async;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.concurrent.Callable;
/**
 * Created by 吴猛
 * Date:2019/1/30
 */
@RestController
public class AsyncController {
    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    //传统rest处理模式
    @RequestMapping("/order")
    private String order() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(100);
        logger.info("主线程结束");
        return "success";
    }

    //异步rest处理模式
    @RequestMapping("/async/order")
    private Callable<String> asyncOrder() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(100);
                logger.info("副线程结束");
                return "SUCCESS";
            }
        };
        logger.info("主线程结束");
        return result;
    }


    //使用Deferred异步rest处理模式
    @RequestMapping("/deferred/order")
    private DeferredResult<String> asyncDeferredOrder() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.random(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        deferredResultHolder.getMap().put(orderNumber,deferredResult);
        return deferredResult;
    }
}
