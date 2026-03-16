package org.example.baixs2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {
    public static void checkDeadlock() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads();

        if (threadIds != null) {
            System.err.println("!!! PHÁT HIỆN DEADLOCK !!!");
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);
            for (ThreadInfo info : infos) {
                System.err.println("- Thread '" + info.getThreadName() + "' đang bị kẹt.");
            }
        } else {
            System.out.println("Không phát hiện deadlock.");
        }
    }
}
