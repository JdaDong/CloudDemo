package com.example.ribbon.Utils;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.properties.HystrixProperty;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//扩展
public class ThreadLocalAwareStrategy extends HystrixConcurrencyStrategy {
    private HystrixConcurrencyStrategy existHystrixConcurrencyStrategy;

    public ThreadLocalAwareStrategy(HystrixConcurrencyStrategy existHystrixConcurrencyStrategy) {
        this.existHystrixConcurrencyStrategy = existHystrixConcurrencyStrategy;
    }

//    @Override
//    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//        return super.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//    }



    @Override
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
        return existHystrixConcurrencyStrategy!=null?existHystrixConcurrencyStrategy.getBlockingQueue(maxQueueSize): super.getBlockingQueue(maxQueueSize);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return existHystrixConcurrencyStrategy != null?
                existHystrixConcurrencyStrategy.wrapCallable(new MyDelegatingUserContextCallable<>(callable, UserContextHolder.getUserContext())):
                super.wrapCallable(new MyDelegatingUserContextCallable<>(callable, UserContextHolder.getUserContext()));
    }

    @Override
    public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
        return super.getRequestVariable(rv);
    }
}
