/*
    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    Вилки лежат на столе между каждой парой ближайших философов.
    Каждый философ может либо есть, либо размышлять.
    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)

Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

 */
/**
 * The Main class simulates the Dining Philosophers problem where five philosophers
 * sit around a round table, and each philosopher can either eat or think. Philosophers
 * can eat only when they have both the left and right forks. Each philosopher must eat
 * three times during the simulation.
 */
public class Main {
    public static void main(String[] args) {
        RoundTable roundTable = new RoundTable();
        System.out.println(roundTable.getPhilosophers());
        System.out.println("!!! The feast has begun  !!! ");
        roundTable.startMealOrThinking();
        for (Philosopher ph : roundTable.getPhilosophers()) {
            try {
                ph.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("!!! The meal is finished !!! ");
    }
}
