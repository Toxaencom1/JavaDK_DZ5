public class PhilosopherState {
    int eatSpaghettiToFull = 3;
    boolean finish;

    public boolean isFinish() {
        return finish;
    }

    public String eat() {
        eatSpaghettiToFull--;
        if (eatSpaghettiToFull != 0) {
            return " thoughts:  I ate some, time to think!!! ";
        } else {
            this.finish = true;
            return " thoughts: I finished my meal, I am full";
        }
    }

    public String reasoning() {
        return " thought about something ";
    }
}
