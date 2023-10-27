/**
 * The PhilosopherState class represents the state of a philosopher during a dining session.
 * It keeps track of how much spaghetti the philosopher has left to eat and whether they have finished.
 */
public class PhilosopherState {
    private int eatSpaghettiToFull = 3;
    private boolean finish;

    // no need to Constructor initializer, boolean false by default, int initialize in field

    /**
     * Checks if the philosopher has finished their meal.
     *
     * @return True if the philosopher has finished, false otherwise.
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * Checks how much spaghetti you still need to eat to be full.
     *
     * @return int value.
     */
    public int getEatSpaghettiToFull() {
        return eatSpaghettiToFull;
    }

    /**
     * Simulates the act of a philosopher eating and updates the remaining amount of spaghetti.
     * If the philosopher finishes eating, it sets the "finish" flag to true.
     *
     * @return A message indicating the philosopher's eating status.
     */
    public String eat() {
        eatSpaghettiToFull--;
        if (eatSpaghettiToFull != 0) {
            return " thoughts:  I ate some, time to think!!! ";
        } else {
            this.finish = true;
            return " thoughts: I finished my meal, I am full";
        }
    }

    /**
     * Simulates the philosopher thinking or reasoning about something.
     *
     * @return A message indicating that the philosopher is thinking about something.
     */
    public String reasoning() {
        return " thought about something ";
    }
}
