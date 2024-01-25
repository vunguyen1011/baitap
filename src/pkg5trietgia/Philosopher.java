package pkg5trietgia;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable {
    private SynchronizationMechanism synchronizationMechanism;
    private boolean isEating;
    private boolean hasLeftFork;
    private boolean hasRightFork;
    private int amountEaten;
    private boolean isFinished;
    private boolean isSnoozing;
    private String name;
    private ArrayList<Fork> forks = new ArrayList<>();

    public Philosopher(int name, Fork leftFork, Fork rightFork, SynchronizationMechanism syncMechanism) {
        super();
        this.name = "Philosopher: " + name;
        forks.add(leftFork);
        forks.add(rightFork);
        this.synchronizationMechanism = syncMechanism;
    }

    public void setSynchronizationMechanism(SynchronizationMechanism syncMechanism) {
        this.synchronizationMechanism = syncMechanism;
    }

    public boolean isSnoozing() {
        return isSnoozing;
    }

    public void setSnoozing(boolean isSnoozing) {
        this.isSnoozing = isSnoozing;
    }

    public boolean isEating() {
        return isEating;
    }

    public void setEating(boolean isEating) {
        this.isEating = isEating;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public void hasLeftFork(boolean hasLeftFork) {
        this.hasLeftFork = hasLeftFork;
    }

    public void hasRightFork(boolean hasRightFork) {
        this.hasRightFork = hasRightFork;
    }

    public int getAmountEaten() {
        return amountEaten;
    }

    public void setAmountEaten(int amountEaten) {
        this.amountEaten = amountEaten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (amountEaten < 51) {
            synchronizationMechanism.acquire();
            try {
                checkIfLeftForkAvailable();
                if (hasLeftFork) checkIfRightForkAvailable();
                if (hasLeftFork && hasRightFork) {
                    isEating = true;
                    startEating();
                } else {
                    try {
                        // Đợi cho đến khi có đũa
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                synchronizationMechanism.release();
            }
        }
        isFinished = true;
    }
 private void startEating() {
    for (int i = 0; i < 10; ++i) {
        ++amountEaten;
        System.out.println(this.name + " is now eating, amount is now: " + amountEaten);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    for (Fork fork : forks) {
        fork.setAvailable(true);
    }
    isEating = false;

    // Nhường bộ cho các triết gia khác
    synchronizationMechanism.release();

    try {
        isSnoozing = true;
        Thread.sleep(5000);
        isSnoozing = false;
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


    private void checkIfRightForkAvailable() {
        System.out.println(this.name + " checking if right fork available");
        if (forks.get(1).isAvailable()) {
            hasRightFork = true;
            forks.get(1).setAvailable(false);
            System.out.println(this.name + "right fork is available & now setting it to: " + forks.get(1).isAvailable());
            return;
        }
        System.out.println(this.name + "right fork was not available & status is: " + forks.get(1).isAvailable());
        forks.get(0).setAvailable(true);
        hasRightFork = false;
        hasLeftFork = false;
    }

    private void checkIfLeftForkAvailable() {
        System.out.println(this.name + " checking if left fork available");
        if (forks.get(0).isAvailable()) {
            hasLeftFork = true;
            forks.get(0).setAvailable(false);
            System.out.println(this.name + ": left fork is available & now setting it to: " + forks.get(0).isAvailable());
            return;
        }
        System.out.println(this.name + ": left fork was not available & status is: " + forks.get(0).isAvailable());
        hasLeftFork = false;
    }

    public String toString() {
        return name + " has forks " + forks;
    }
}
