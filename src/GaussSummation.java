import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class GaussSummation {

    public void GaussSum() {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        System.out.print("n>");
        int num = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> numbers = new ArrayList<>();

        //for (int i = 1; i <= num; i++) {
        //    numbers.add(i);
        //}

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

            while(run) {

                //if()



            }


            executor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });




    }
}
