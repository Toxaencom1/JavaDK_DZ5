import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoundTable {
    private final Random random = new Random();
    private static final int PHILOSOPHERS_AMT = 5;
    private final List<Philosopher> philosophers;
    private final List<Fork> forks;

    public RoundTable() {
        this.philosophers = new ArrayList<>(PHILOSOPHERS_AMT);
        this.forks = new ArrayList<>(PHILOSOPHERS_AMT);
        initialize();
    }

    private void initialize() {
        PhilosophersNames[] values = PhilosophersNames.values();
        for (int i = 0; i < PHILOSOPHERS_AMT; i++) {
            philosophers.add(new Philosopher(values[random.nextInt(values.length)].getName()));
        }
        Fork fork = new Fork();
        forks.add(fork);
        for (int i = 1; i < PHILOSOPHERS_AMT; i++) {
            forks.add(new Fork());
        }
        forks.add(fork);
        for (int i = 0; i < PHILOSOPHERS_AMT; i++) {
            philosophers.get(i).setLeftFork(forks.get(i));
            philosophers.get(i).setRightFork(forks.get(i + 1));
        }
    }

    public void startMealOrThinking() {
        philosophers.forEach(Thread::start);
    }

    public List<Philosopher> getPhilosophers() {
        return philosophers;
    }
}
