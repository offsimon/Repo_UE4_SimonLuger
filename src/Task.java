import java.util.ArrayList;

public class Task implements Runnable {

    private int i;
    private int chunkSize;
    private ArrayList<Integer> allNumbers;
    private int divider;

    public Task(int i, int chunkSize, int divider, ArrayList<Integer> allNumbers) {
        this.i = i;
        this.chunkSize = chunkSize;
        this.allNumbers = allNumbers;
        this.divider = divider;
    }

    @Override
    public void run() {

        for (int j=i; j < i*2; j++) {

            if(allNumbers.get(j) % divider == 0) {
                System.out.println(allNumbers.get(j));
            }
        }
    }
}
