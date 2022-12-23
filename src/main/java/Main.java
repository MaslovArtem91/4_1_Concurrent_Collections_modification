public class Main {
    public static final int CALLS = 8;
    public static final int SPECIALISTS = 4;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 1; i <= CALLS; i++) {
            new Thread(null, center::call, "звонок № " + i).start();
        }

        for (int i = 1; i <= SPECIALISTS; i++) {
            new Thread(null, center::takeTheCall, "Специалист № " + i).start();
        }
    }
}
