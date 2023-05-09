package Task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {

    private int number;
    private AtomicBoolean isProcessed = new AtomicBoolean(true);
    private NumberProcessor processor;
    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }

    public void process(int a) {
        this.number = a;
        isProcessed.set(false);
    }

    @Override
    public void run() {
        while (true) {
            if (isProcessed.get()) {
                continue;
            }
            processor.process(number);
            isProcessed.set(true);
        }
    }

    public AtomicBoolean getIsProcessed() {
        return isProcessed;
    }
}
