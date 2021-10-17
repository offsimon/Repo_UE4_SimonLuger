import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsTester {

    public static List<String> strings = new ArrayList<>();
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        strings.add("abc");
        strings.add("bcd");
        strings.add("c");
        strings.add("");

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(8);

        System.out.println(getCountEmptyString(strings));

        System.out.println(getCountLength3(strings));

        List<String> l = deleteEmptyStrings(strings);
        for (String s: l) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println(getMergedString(strings, "-"));

        System.out.println(getSquares(numbers));

        System.out.println(getMax(numbers));

        System.out.println(getMin(numbers));

        System.out.println(getSum(numbers));

        System.out.println(getAverage(numbers));
    }

    private static int getCountEmptyString(List<String> strings){
        return (int) strings.stream().filter((a -> a.isEmpty())).count();
    }

    private static int getCountLength3(List<String> strings) {
        return (int) strings.stream().filter((a -> a.length() == 3)).count();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return (List<String>) strings.stream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator) {
        return (String) strings.stream().collect(Collectors.joining(separator));
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return (List<Integer>) numbers.stream().map((a -> a*a)).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return (int) numbers.stream().max(Integer::compareTo).get();
    }

    private static int getMin(List<Integer> numbers) {
        return (int) numbers.stream().min(Integer::compareTo).get();
    }

    private static int getSum(List<Integer> numbers)  {
        return (int) numbers.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) numbers.stream().mapToDouble(a -> a).average().getAsDouble();
    }
}
