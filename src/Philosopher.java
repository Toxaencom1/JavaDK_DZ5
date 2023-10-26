import java.util.Random;

public class Philosopher extends Thread {
    private static final int BOUND = 4;
    private final Random random = new Random();
    private final String philosopherName;
    private Fork leftFork;
    private Fork rightFork;
    private final PhilosopherState ps;

    public Philosopher(String philosopherName) {
        this.philosopherName = philosopherName;
        ps = new PhilosopherState();
    }

    @Override
    public void run() {
        while (!ps.isFinish()) {
            try {
                mealOrThink();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void mealOrThink() throws InterruptedException {
        if (leftFork.tryLock()) {
//            System.out.println(philosopherName + " I have a left fork");
            if (rightFork.tryLock()) {
//                System.out.println(philosopherName + " I have a right fork");
                eat();
                leftFork.unlock();
                rightFork.unlock();
                reasoning();
            } else {
                leftFork.unlock();
                reasoning();
            }
        } else {
            reasoning();
        }
    }

    private void reasoning() throws InterruptedException {
        long noRForkTimeout = random.nextInt(1, BOUND) * 1000L;
        System.out.println(philosopherName + " thought about something "
                + noRForkTimeout + " ms");
        sleep(noRForkTimeout);
    }

    private void eat() throws InterruptedException {
        long eatTimeout = random.nextInt(1, BOUND) * 1000L * 2;
        ps.decrementCount();
        System.out.println("    " + philosopherName + " thoughts:  I have a forks, i am going to EAT!!! "
                + eatTimeout + " ms "
                + "(" + ps.eatSpaghettiToFull + " more needed)");
        sleep(eatTimeout);
        if (ps.getEatSpaghettiToFull() != 0) {
            System.out.println(philosopherName + " thoughts:  I ate some, time to think!!! ");
        } else {
            System.out.println("        " + philosopherName + " thoughts: I finished my meal, I am full");
            ps.setFinish(true);
        }
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    @Override
    public String toString() {
        return "Philosopher " + philosopherName +
                " leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                "}\n";
    }
}
