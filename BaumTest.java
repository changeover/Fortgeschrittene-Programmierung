/**
 * @author Gianni N. Di Pietro
 * @version 1.1
 */
public class BaumTest
{
    public static void main(String[] args)
    {
        Baum<String> baum = new Baum<>();

        System.out.printf("\n%20s ", "Level-Order:");
        baum.traversiere(
            inhalt -> System.out.print(inhalt + " "));

        System.out.printf("\n%20s ", "Pre-Order:");
        baum.traversiere(
            inhalt -> System.out.print(inhalt + " "),
            inhalt -> {},
            inhalt -> {});

        System.out.printf("\n%20s ", "In-Order:");
        baum.traversiere(
            inhalt -> {},
            inhalt -> System.out.print(inhalt + " "),
            inhalt -> {});

        System.out.printf("\n%20s ", "Post-Order:");
        baum.traversiere(
            inhalt -> {},
            inhalt -> {},
            inhalt -> System.out.print(inhalt + " "));

        System.out.printf("\n%20s ", "Euler:");
        baum.traversiere(
            inhalt -> System.out.print("→" + inhalt + " "),
            inhalt -> System.out.print("↑" + inhalt + " "),
            inhalt -> System.out.print("←" + inhalt + " "));

        System.out.printf("\n%20s ", "Klammerung (Euler):");
        baum.traversiere(
            inhalt -> System.out.print('('),
            System.out::print,
            inhalt -> System.out.print(')'));

        System.out.printf("\n%20s ", "Auswertung (Euler):");
        Stack<Double> s = new Stack<>();
        baum.traversiere(
            inhalt -> {},
            inhalt -> {},
            inhalt ->
            {
                // ToDo: Auswertung implementieren
            });
        System.out.print(String.format("%-8.2f", s.peek()));

        System.out.printf("\n%20s \n", "Ausgabe (Euler):");
        class ÄnderbareKonstante { public int betrag = 0; }
        final ÄnderbareKonstante einrückung = new ÄnderbareKonstante();
        baum.traversiere(
            inhalt ->
            {   System.out.printf("%20s ", " ");
                einrückung.betrag++;
                if (einrückung.betrag > 1)
                {
                    for (int i = 2; i < einrückung.betrag; i++)
                        System.out.print("   ");
                    System.out.print("└─ ");
                }
                System.out.println(inhalt);
            },
            inhalt ->  {},
            inhalt -> einrückung.betrag--);
    }
}