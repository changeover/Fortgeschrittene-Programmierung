import java.util.Iterator;

/**
 * @author Gianni N. Di Pietro
 * @version 1.1
 */
public class Liste <T> implements Iterable
{
   private Zelle <T> anfang;
   private Zelle <T> cursor;

   private class cursor implements Iterator{
      private Zelle<T> iCursor = anfang;

      public boolean hasNext(){
         if(anfang != null && iCursor != null){
            return true;
         }
         else{
            return false;
         }
      }

      public T next() {
         if (iCursor != null) {
            T val = iCursor.inhalt;
            iCursor = iCursor.next;
            return val;
         }
         else {
            return null;
         }
      }

      public void remove(){
            throw new UnsupportedOperationException("Not supported");
      }
   }
   public Liste() { anfang = null; }

   public Liste (T t)
   {
      anfang = new Zelle <> (t);
   }

   public boolean istLeer()
   {
      return anfang == null;
   }

   public Liste <T> setze(Pos p)
   {
      cursor = anfang;
      if (cursor != null)
      {
         if (p.equals(Pos.AM_ENDE))
         {
            while (cursor.next != null)
            {
               cursor = cursor.next;
            }
         }
      }
      return this;
   }

   public Liste <T> finde(T t)
   {
      if (anfang != null)
      {
         cursor = anfang;
         while (cursor != null && !cursor.inhalt.equals(t))
            cursor = cursor.next;
      }
      return this;
   }

   public T zeige()
   {
      if (cursor != null) return cursor.inhalt;
      else return null;
   }

   public Liste <T> fügeEin(T t, Pos p)
   {
      assert p.equals(Pos.VOR_CURSOR) || p.equals(Pos.NACH_CURSOR);
      Zelle <T> z = new Zelle <> (t);

      if (anfang == null)
      {
         anfang = z;
      } else
      {
         if (p.equals(Pos.VOR_CURSOR))
         {
            if (cursor != null)
            {
               if (cursor == anfang)
               {
                  z.next = anfang;
                  anfang = z;
               } else
               {
                  Zelle hilfsCursor = anfang;
                  while (hilfsCursor.next != cursor)
                     hilfsCursor = hilfsCursor.next;
                  cursor = hilfsCursor;
                  z.next = cursor.next;
                  cursor.next = z;
               }
            }
         } else if (p.equals(Pos.NACH_CURSOR))
         {
            if (cursor != null)
            {
               z.next = cursor.next;
               cursor.next = z;
            }
         }
      }
      return this;
   }

   public Liste <T> lösche(Pos p)
   {
      assert p.equals(Pos.BEI_CURSOR) || p.equals(Pos.NACH_CURSOR);
      if (p.equals(Pos.BEI_CURSOR))
      {
         if (cursor != null)
         {
            if (cursor == anfang)
            {
               anfang = anfang.next;
            } else
            {
               Zelle hilfsCursor = anfang;
               while (hilfsCursor.next != cursor)
                  hilfsCursor = hilfsCursor.next;
               cursor = hilfsCursor;
               cursor.next = cursor.next.next;
            }
         }
      }
      else if (p.equals(Pos.NACH_CURSOR))
      {
         if (cursor != null && cursor.next != null)
         {
            cursor.next = cursor.next.next;
         }
      }
      return this;
   }

   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      cursor = anfang;
      sb.append("[ ");
      while (cursor != null)
      {
         sb.append(cursor.inhalt);
         sb.append(' ');
         cursor = cursor.next;
      }
      sb.append(']');
      return sb.toString();
   }
   public Iterator<T> iterator(){
      return new cursor();
   }

}
