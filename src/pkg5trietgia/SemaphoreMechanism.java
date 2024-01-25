package pkg5trietgia;

import java.util.concurrent.Semaphore;

public class SemaphoreMechanism implements SynchronizationMechanism {
    private Semaphore semaphore;

    public SemaphoreMechanism() {
        this.semaphore = new Semaphore(4); // khởi tạo số luồng có thể truy cập 
    }

    @Override
    public void acquire() {             // tương tự như hàm wait() 
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void release() { //  ăn xong sẽ trả lại đũa 
        semaphore.release();
    }

    @Override
    public Object getSyncObject() {
        return semaphore;
    }
}
