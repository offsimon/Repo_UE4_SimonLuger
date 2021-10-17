import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class GaussSummation {

    public void GaussSum() {

        Scanner scanner = new Scanner(System.in);

        boolean b = false;
        int res = 0;

        int upperLimit = 0;
        int lowerLimit = 1;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
        Future<Integer> future = new CompletableFuture();

        System.out.print("n>");
        int num = Integer.parseInt(scanner.nextLine());

        int chunks = 0;
        if (num % 100 == 0) {
            chunks = num / 100;
        } else {
            chunks = num / 100 + 1;
            b = true;
        }

        for (int i = 0; i < chunks; i++) {

            if(i == chunks-1 && b) {
                //upperLimit = num - (chunks-1)*100;
                upperLimit = num;
            }else {
                upperLimit += 100;
            }

            final int upperFinal = upperLimit;
            final int lowerFinal = lowerLimit;

            future = (Future<Integer>) executor.submit((() -> {
                int count = 0;
                for (int j = lowerFinal; j <= upperFinal; j++) {

                    count = count +j;
                }
                return count;
            }));

            try {
                res+= future.get().intValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            lowerLimit += 100;
        }

        if(res == testWithGaussSum(num)) {
            System.out.println("res> " + res);
        }else {
            System.out.println("Error!");
        }

        executor.shutdown();
        }

        public int testWithGaussSum(int num) {
            return (num*num+num)/2;
        }
    }
