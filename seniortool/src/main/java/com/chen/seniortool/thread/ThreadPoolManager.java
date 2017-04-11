package com.chen.seniortool.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by 陈德东 on 2017/4/10 11:24
 * 描述:线程池管理
 * <p>
 * 使用线程池的好处
 * 1.重用已经创建的好的线程，避免频繁创建进而导致的频繁GC
 * 2.控制线程并发数，合理使用系统资源，提高应用性能
 * 3.可以有效的控制线程的执行，比如定时执行，取消执行等
 * <p>
 * 参考网址:
 * http://blog.csdn.net/u012702547/article/details/52259529
 * http://www.cnblogs.com/whoislcj/p/5607734.html
 */

public class ThreadPoolManager {

    static ThreadPoolManager mPoolManager;


    /**
     *
     */
    static ThreadPoolExecutor executor;

    /**
     * 线程池中的任务队列，该队列主要用来存储已经被提交但是尚未执行的任务。
     * 存储在这里的任务是由ThreadPoolExecutor的execute方法提交来的
     */
    static BlockingQueue<Runnable> queue;

    /**
     * 队列上限
     */
    static int capacity = 20;

    /**
     * 线程池中核心线程的数量
     */
    static int corePoolSize = 10;

    /**
     * 线程池最大线程数
     */
    static int maximumPoolSize = 20;

    /**
     * 非核心线程的超时时长，当系统中非核心线程闲置时间超过keepAliveTime之后，则会被回收。
     * 如果ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true，则该参数也表示核心线程的超时时长
     */
    static long keepAliveTime = 100;


    /**
     * singleThreadExecutor和FixedThreadPool很像，不同的就是SingleThreadExecutor的核心线程数只有1
     * 使用SingleThreadExecutor的一个最大好处就是可以避免我们去处理线程同步问题，
     * 其实如果我们把FixedThreadPool的参数传个1，
     * 效果不就和SingleThreadExecutor一致了
     */
    static ExecutorService executorService;


    public static ThreadPoolManager getInstance() {
        if (null == mPoolManager) {
            mPoolManager = new ThreadPoolManager();
        }
        return mPoolManager;
    }

    private ThreadPoolManager() {
        queue = new ArrayBlockingQueue<Runnable>(capacity);
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);
        executorService = Executors.newSingleThreadExecutor();

    }

    /**
     * 创建时间:2017/4/10 11:36
     * 描述:单个执行任务,上一个执行完了,再执行下一个
     */
    public void execute(Runnable run) {
        try {
            executorService.execute(run);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建时间:2017/4/10 13:44
     * 描述:执行多个
     */
    public void executeMany(Runnable run) {
        try {
            if (queue.size() >= capacity) {
                queue.add(run);
            } else {
                executor.execute(run);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdownNow() {
        if (null != queue) {
            queue.clear();
        }
        if (null != executor) {
            //此处不能shutdown，不然除非杀掉进程，否则会导致线程池不能使用
            executor.shutdownNow();
        }


    }


}
