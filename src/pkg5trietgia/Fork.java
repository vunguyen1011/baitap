package pkg5trietgia;

import java.awt.Color;

public class Fork {
	private boolean isAvailable = true;
	private int id;

	public Fork(int id) {
		super();
		this.id = id;
	}

	public synchronized boolean isAvailable() {
		return isAvailable;
	}
          public boolean isInUse() {
        return !isAvailable;
    }
	public synchronized void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String toString(){
		return id + "";
	}
}
