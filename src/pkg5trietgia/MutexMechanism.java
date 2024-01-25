package pkg5trietgia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MutexMechanism implements SynchronizationMechanism {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void acquire() {
        lock.lock();  // khởi tạo khóa đảm bảo không có 2  tiến trình cố thể truy cập cùng 1 luồng
                        // trong 1 khoảng thời điểm
    }

    @Override
    public void release() { // giải phóng khóa  nếu nó được giữ bởi luồng hiện tại
        if (lock.isHeldByCurrentThread()) {
            condition.signal(); 
            lock.unlock();
        }
    }

    @Override
    public Object getSyncObject() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }
    
}
