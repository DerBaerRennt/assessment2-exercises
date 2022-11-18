package assessment2_practice.test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {

    /**
     * Compare the two parameters and prints a message indicating whether
     * they are equal.
     *
     * Similar to JUnit's Assert.assertEquals
     */
    public static void equals(Object expected, Object actual) {
        boolean pass = Objects.equals(expected, actual);

        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String callSite = stackTraceElement.toString();

        if (pass) {
            System.out.print("✔️");
            System.out.println(callSite);
        } else {
            System.out.print("\033[0;31m"); // red color
            System.out.print("❌   ");
            System.out.println(callSite);
            System.out.print("\033[0m"); // reset color

            prettyPrintValue("      expected: ", expected);
            prettyPrintValue("      actual:   ", actual);

        }
    }

    private static void prettyPrintValue(String prefix, Object value) {
        List<String> lines = String.valueOf(value).lines().collect(Collectors.toList());
        System.out.print(prefix);
        if (lines.isEmpty()) {
            System.out.println();
            return;
        }
        System.out.println(lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            System.out.print(" ".repeat(prefix.length()));
            System.out.println(lines.get(i));
        }
    }

}
