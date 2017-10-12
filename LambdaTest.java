/*
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class LambdaTest
{
    public static void main(String[] args)
    {
        Liste<Character> meineListe = new Liste<>();
        String nachricht = "meine liebeste pulzilla wir treffen uns am tor";

        for (int i = 0; i < nachricht.length(); i++)
        {
            meineListe.setze(Pos.AM_ENDE);
            meineListe.fügeEin(nachricht.charAt(i), Pos.NACH_CURSOR);
        }
        final String res;
        System.out.println("-- Ausgabe mit Lambda-Ausdruck --");
        meineListe.forEach(z->System.out.println(z));  // forEach ist als default-Methode im Interface 'Iterable' definiert

        System.out.println("-- Ausgabe mit Methoden-Referenz --");
        meineListe.forEach(System.out::println);
    }
}