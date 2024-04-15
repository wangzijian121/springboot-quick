package 多线程设计模式.两阶段终止模式;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 《两阶段终止模式》
 * 监控-2秒一次
 * 1.可能在监控时触发告警。
 * 2.可能在睡眠时触发告警。
 *
 * @author zijian Wang
 */
@Slf4j(topic = "c.TwoPhaseTerminationMain")
public class TwoPhaseTerminationMain {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        TimeUnit.SECONDS.sleep(5);
        twoPhaseTermination.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {

    private Thread monitor;

    public Thread start() {

        monitor = new Thread(() -> {
            for (; ; ) {
                try {
                    if (monitor.isInterrupted()) {
                        log.error("监控异常!!!发送邮件");
                        break;
                    }
                    log.info("监控...");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    monitor.interrupt();//再次打断为打断正常方法，会为true
                }
            }
        }, "thread-monitor");
        monitor.start();
        return monitor;
    }

    public void stop() {
        monitor.interrupt();
    }
}
