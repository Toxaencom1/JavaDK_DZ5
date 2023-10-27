import java.util.Objects;
import java.util.Random;

public class Philosopher extends Thread {
    private static final int BOUND = 4;
    private final Random random = new Random();
    private final String philosopherName;
    private Fork leftFork;
    private Fork rightFork;
    private final PhilosopherState philosopherState;

    public Philosopher(String philosopherName) {
        this.philosopherName = philosopherName;
        philosopherState = new PhilosopherState();
    }

    @Override
    public void run() {
        while (!philosopherState.isFinish()) {
            try {
                mealOrThink();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void mealOrThink() throws InterruptedException {
        if (leftForkUp()) {
//            System.out.println(philosopherName + " I have a left fork");
            if (rightForkUp()) {
//                System.out.println(philosopherName + " I have a right fork");
                eat();
                leftForkDown();
                rightForkDown();
                if (!philosopherState.isFinish())
                    reasoning();
            } else {
                leftForkDown();
                reasoning();
            }
        } else {
            reasoning();
        }
    }

    private boolean rightForkUp() {
        return rightFork.tryLock();
    }

    private boolean leftForkUp() {
        return leftFork.tryLock();
    }

    private void rightForkDown() {
        rightFork.unlock();
    }

    private void leftForkDown() {
        leftFork.unlock();
    }

    private void reasoning() throws InterruptedException {
        long timeout = random.nextInt(1, BOUND) * 1000L;
        System.out.println(philosopherName + philosopherState.reasoning()
                + timeout + " ms");
        sleep(timeout);
    }

    private void eat() throws InterruptedException {
        long eatTimeout = random.nextInt(1, BOUND) * 1000L * 2;
        System.out.println("    " + philosopherName + " thoughts: I have a forks, i am going to eat!!! "
                + eatTimeout + " ms "
                + "(" + (philosopherState.eatSpaghettiToFull - 1) + " more needed)");
        sleep(eatTimeout);
        System.out.println("        " + philosopherName + philosopherState.eat());
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Philosopher that = (Philosopher) o;
        return Objects.equals(philosopherName, that.philosopherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(philosopherName);
    }

    @Override
    public String toString() {
        return "Philosopher " + philosopherName +
                " leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                "}\n";
    }
}
