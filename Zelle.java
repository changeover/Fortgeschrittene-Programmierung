/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Zelle <T>
{
   T inhalt;
   Zelle <T> next;

   public Zelle(T t)
   {
      inhalt = t;
      next = null;
   }

   public String toString()
   {
      return "" + inhalt;
   }
}
