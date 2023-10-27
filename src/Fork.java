import java.util.concurrent.locks.ReentrantLock;

/**
 * The Fork class represents a fork in the context of the Dining Philosophers problem.
 * It extends the ReentrantLock class to provide synchronization capabilities for fork access.
 */
public class Fork extends ReentrantLock {
    private static int defaultNumber = 1;
    private final Integer number;

    /**
     * Creates a new Fork object. Each fork is assigned a unique number.
     */
    public Fork() {
        number = defaultNumber++;
    }

    /**
     * Returns a string representation of the fork, which is its assigned number.
     *
     * @return The string representation of the fork's number.
     */
    @Override
    public String toString() {
        return number.toString();
    }
}
