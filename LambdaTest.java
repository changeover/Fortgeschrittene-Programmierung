/**
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
            meineListe.setze(Liste.Pos.AM_ENDE);
            meineListe.fügeEin(nachricht.charAt(i), Liste.Pos.NACH_CURSOR);
        }

        System.out.println("-- Ausgabe mit Lambda-Ausdruck --");
        meineListe.forEach(/* toDo */);  // forEach ist als default-Methode im Interface 'Iterable' definiert

        System.out.println("-- Ausgabe mit Methoden-Referenz --");
        meineListe.forEach(/* toDo */);
    }
}