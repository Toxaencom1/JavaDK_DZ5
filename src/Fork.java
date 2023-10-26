import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock {
    private static int defaultNumber = 1;
    private final Integer number;

    public Fork() {
        number = defaultNumber++;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
