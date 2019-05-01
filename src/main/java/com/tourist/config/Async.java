package com.tourist.config;

import com.tourist.module.async.GetBaziAsyncUncaughtException;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步配置
 */
@EnableAsync
@Configuration
public class Async implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //当前线程数
        executor.setCorePoolSize(40);
        // 最大线程数
        executor.setMaxPoolSize(100);
        //线程池所使用的缓冲队列
        executor.setQueueCapacity(Integer.MAX_VALUE);
        //线程名称前缀
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new GetBaziAsyncUncaughtException();
    }

}
