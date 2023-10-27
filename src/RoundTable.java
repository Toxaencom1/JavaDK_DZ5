import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The RoundTable class simulates a round table where philosophers engage in dining and thinking.
 * It manages a group of philosophers and forks, initializing their interaction for the dining problem.
 */
public class RoundTable {
    private final Random random = new Random();
    private static final int PHILOSOPHERS_AMT = 5;
    private final List<Philosopher> philosophers;
    private final List<Fork> forks;

    /**
     * Creates a new RoundTable instance with a specified number of philosophers and forks.
     * The table is initialized with philosophers and their corresponding forks.
     */
    public RoundTable() {
        this.philosophers = new ArrayList<>(PHILOSOPHERS_AMT);
        this.forks = new ArrayList<>(PHILOSOPHERS_AMT);
        initialize();
    }

    /**
     * Initializes the round table by creating philosophers with unique names and associated forks.
     */
    private void initialize() {
        PhilosophersNames[] values = PhilosophersNames.values();
        for (int i = 0; i < PHILOSOPHERS_AMT; i++) {
            while (true) {
                Philosopher philosopher = new Philosopher(values[random.nextInt(values.length)].getName());
                if (philosophers.contains(philosopher)) {
                    continue;
                }
                philosophers.add(philosopher);
                break;
            }
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

    /**
     * Starts the dining and thinking processes for the philosophers at the round table.
     */
    public void startMealOrThinking() {
        philosophers.forEach(Thread::start);
    }

    /**
     * Retrieves the list of philosophers sitting at the round table.
     *
     * @return A list of philosophers at the table.
     */
    public List<Philosopher> getPhilosophers() {
        return philosophers;
    }
}
