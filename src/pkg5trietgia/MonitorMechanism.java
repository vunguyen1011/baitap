package pkg5trietgia;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// MonitorMechanism.java
public class MonitorMechanism implements SynchronizationMechanism {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    
   

    @Override
    public void acquire() {
        lock.lock();
    }

    @Override
    public void release() {
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    public void await() throws InterruptedException {
        condition.await();
    }

    public void signal() {
        condition.signal();
    }

    public void signalAll() {
        condition.signalAll();
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public Object getSyncObject() {
        return lock;
    }

  
}

