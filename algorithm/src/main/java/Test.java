public class Test implements Runnable {

    private static int i = 1;


    @Override
    public void run() {
        synchronized (this) {
            System.out.println(i++);
        }
    }
}
