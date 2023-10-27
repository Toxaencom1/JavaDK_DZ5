import java.util.Objects;
import java.util.Random;

/**
 * The Philosopher class represents a philosopher in the Dining Philosophers problem.
 * Each philosopher thinks and eats using two forks. This class extends the Thread class
 * and simulates the behavior of a philosopher during a dinner.
 */
public class Philosopher extends Thread {
    private static final int BOUND = 4;
    private final Random random = new Random();
    private final String philosopherName;
    private Fork leftFork;
    private Fork rightFork;
    private final PhilosopherState philosopherState;


    /**
     * Creates a new Philosopher with the specified name.
     *
     * @param philosopherName The name of the philosopher.
     */
    public Philosopher(String philosopherName) {
        this.philosopherName = philosopherName;
        philosopherState = new PhilosopherState();
    }

    /**
     * The main execution method for the philosopher thread. The philosopher keeps
     * running until the dining process is finished.
     */
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

    /**
     * This method represents the decision-making process of a philosopher. The
     * philosopher can either pick up the left fork, then the right fork, and eat, or
     * think if the forks are not available.
     *
     * @throws InterruptedException If the thread is interrupted during execution.
     */
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

    /**
     * Methods to pick up or put down forks.
     */
    //region Forks up and down
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
    //endregion

    /**
     * Simulates the reasoning or thinking process of the philosopher. The philosopher
     * thinks for a random amount of time within a specified bound.
     *
     * @throws InterruptedException If the thread is interrupted during execution.
     */
    private void reasoning() throws InterruptedException {
        long timeout = random.nextInt(1, BOUND) * 1000L;
        System.out.println(philosopherName + philosopherState.reasoning()
                + timeout + " ms");
        sleep(timeout);
    }

    /**
     * Simulates the eating process of the philosopher. The philosopher eats for a
     * random amount of time within a specified bound.
     *
     * @throws InterruptedException If the thread is interrupted during execution.
     */
    private void eat() throws InterruptedException {
        long eatTimeout = random.nextInt(1, BOUND) * 1000L * 2;
        System.out.println("    " + philosopherName + " thoughts: I have a forks, i am going to eat!!! "
                + eatTimeout + " ms "
                + "(" + (philosopherState.getEatSpaghettiToFull() - 1) + " more needed)");
        sleep(eatTimeout);
        System.out.println("        " + philosopherName + philosopherState.eat());
    }

    /**
     * Sets the left fork for the philosopher.
     *
     * @param leftFork The left fork to be set.
     */
    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    /**
     * Sets the right fork for the philosopher.
     *
     * @param rightFork The right fork to be set.
     */
    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    /**
     * Compares this philosopher with another object for equality. Two philosophers are
     * considered equal if they have the same name.
     *
     * @param o The object to compare with this philosopher.
     * @return True if the two philosophers are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Philosopher that = (Philosopher) o;
        return Objects.equals(philosopherName, that.philosopherName);
    }

    /**
     * Computes a hash code for this philosopher based on their name.
     *
     * @return The hash code of this philosopher.
     */
    @Override
    public int hashCode() {
        return Objects.hash(philosopherName);
    }

    /**
     * Returns a string representation of the philosopher, including their name and
     * the state of their left and right forks.
     *
     * @return A string representation of the philosopher.
     */
    @Override
    public String toString() {
        return "Philosopher " + philosopherName +
                " leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                "}\n";
    }
}
