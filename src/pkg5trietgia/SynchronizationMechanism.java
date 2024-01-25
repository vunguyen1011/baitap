
package pkg5trietgia;

import java.util.concurrent.locks.Lock;

public interface SynchronizationMechanism {
    Object getSyncObject(); 
    void acquire();
    void release();
  
}


