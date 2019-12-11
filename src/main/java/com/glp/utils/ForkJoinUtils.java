package com.glp.utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author zmm
 * @date 2019/12/10
 */
public class ForkJoinUtils extends RecursiveAction {
    /**
     * 每个"小任务"最多只打印20个数
     */
    private static final int MAX = 20;

    private int start;
    private int end;

    public ForkJoinUtils(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        //当end-start的值小于MAX时，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                System.out.println("START:" + start + "   " + Thread.currentThread().getName() + "i的值" + i);
            }
        } else {
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            ForkJoinUtils left = new ForkJoinUtils(start, middle);
            ForkJoinUtils right = new ForkJoinUtils(middle, end);
            left.fork();
            right.fork();
        }
    }


}


class amwi {
    public static void main(String[] args) throws Exception {
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 提交可分解的PrintTask任务
        forkJoinPool.submit(new ForkJoinUtils(1, 100));

        //阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束

        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);

        // 关闭线程池
        forkJoinPool.shutdown();
    }
}



