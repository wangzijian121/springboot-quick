package 多线程设计模式.两阶段终止模式;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 《两阶段终止模式-使用volatile》
 * 监控-1秒一次
 * 1.可能在监控时触发告警。
 * 2.可能在睡眠时触发告警。
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.TwoPhaseTerminationMain")
public class TwoPhaseTerminationMainUsedVolatile {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTerminationV2 twoPhaseTerminationV2 = new TwoPhaseTerminationV2();
        twoPhaseTerminationV2.start();

        TimeUnit.SECONDS.sleep(5);
        twoPhaseTerminationV2.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTerminationV2 {

    private volatile boolean single = false;

    public Thread start() {

        Thread monitor = new Thread(() -> {
            for (; ; ) {
                try {
                    if (single) {
                        log.error("监控异常!!!发送邮件");
                        break;
                    }
                    log.info("监控...");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread-monitor");
        monitor.start();
        return monitor;
    }

    public void stop() {
        single = true;
    }
}
