/*

    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    Вилки лежат на столе между каждой парой ближайших философов.
    Каждый философ может либо есть, либо размышлять.
    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)

Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

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
