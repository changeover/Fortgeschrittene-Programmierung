/**
 * @author Gianni N. Di Pietro
 * @version 1.1
 */
class Baum<T>
{
    private Knoten<T> wurzel;
    private Consumer<T> levelOrderAktion, eulerAktionVonLinks, eulerAktionVonUnten, eulerAktionVonRechts;

    @FunctionalInterface
    public interface Consumer<T>
    {
        public abstract void accept(T inhalt);
    }

    @SuppressWarnings("unchecked")
    Baum()
    {
        wurzel =new Knoten<>
        (   (T) "+",
            new Knoten<>((T) "7"),
            new Knoten<>
                (   (T) "*",
                    new Knoten<>
                        ((T) "+",
                            new Knoten<>((T) "3"),
                            new Knoten<>((T) "4")
                        ),
                    new Knoten<>((T) "5")
                )
        );
    }

    private void traversiereLevelOrder(Knoten<T> k)
    {
        Queue<Knoten<T>> q = new Queue<>();
        Knoten<T> knoten = k;

        q.enqueue(knoten);

        // ToDo: Level-Order Traversierung implementieren
    }

    private void traversiereEuler(Knoten<T> knoten)
    {
        T inhalt = knoten.inhalt;

        eulerAktionVonLinks.accept(inhalt);
        if (knoten.left != null) traversiereEuler(knoten.left);
        eulerAktionVonUnten.accept(inhalt);
        if (knoten.right != null) traversiereEuler(knoten.right);
        eulerAktionVonRechts.accept(inhalt);
    }

    void traversiere(Consumer<T> aktion)
    {
        assert aktion != null;
        this.levelOrderAktion = aktion;

        traversiereLevelOrder(wurzel);
    }

    void traversiere(Consumer<T> vonLinks, Consumer<T> vonUnten, Consumer<T> vonRechts)
    {
        assert vonLinks != null && vonUnten != null && vonRechts != null;
        eulerAktionVonLinks = vonLinks;
        eulerAktionVonUnten = vonUnten;
        eulerAktionVonRechts = vonRechts;

        traversiereEuler(wurzel);
    }


    private class Knoten<R>
    {
        R inhalt;
        Knoten<R> left;
        Knoten<R> right;

        Knoten(R inhalt)
        {
            this.inhalt = inhalt;
            left = right = null;
        }

        Knoten(R inhalt, Knoten<R> left, Knoten<R> right)
        {
            this(inhalt);
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString()
        {
            return inhalt.toString();
        }
    }
}
