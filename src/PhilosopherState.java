public class PhilosopherState {
    int eatSpaghettiToFull = 3;
    boolean finish;

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void decrementCount() {
        eatSpaghettiToFull--;
    }

    public int getEatSpaghettiToFull() {
        return eatSpaghettiToFull;
    }
}
