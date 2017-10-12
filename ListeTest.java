/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class ListeTest
{

   public static void main(String[] args)
   {
      Liste <String> meineListe = new Liste <> ("x");
      System.out.println
      (
         meineListe
            .finde("x").fügeEin("y", Pos.NACH_CURSOR)
            .finde("y").fügeEin("z", Pos.NACH_CURSOR)
            .finde("x").fügeEin("ö", Pos.VOR_CURSOR)
            .finde("ö").fügeEin("ä", Pos.VOR_CURSOR)
            .finde("x").fügeEin("ü", Pos.VOR_CURSOR)
            .finde("b").fügeEin("r", Pos.VOR_CURSOR)
      );
      for(Object str:meineListe){
         System.out.println("Eintrag: " +str);
      }
      System.out.println
      (
         meineListe
            .finde("r").lösche(Pos.NACH_CURSOR)
            .finde("ä").lösche(Pos.NACH_CURSOR)
            .finde("z").lösche(Pos.NACH_CURSOR)
            .finde("x").lösche(Pos.NACH_CURSOR)
      );
      System.out.println
      (
         meineListe
            .finde("ü").lösche(Pos.BEI_CURSOR)
            .finde("ä").lösche(Pos.BEI_CURSOR)
      );
      System.out.println
      (
         meineListe.setze(Pos.AM_ENDE).fügeEin("r", Pos.NACH_CURSOR)
      );
      System.out.println
      (
         meineListe.setze(Pos.AM_ANFANG).fügeEin("s", Pos.VOR_CURSOR)
      );



      System.out.println(meineListe.finde("y").zeige());
      System.out.println(meineListe.setze(Pos.AM_ANFANG).zeige());
      System.out.println(meineListe.setze(Pos.AM_ENDE).zeige());

      System.out.println(meineListe.setze(Pos.AM_ANFANG).lösche(Pos.BEI_CURSOR));
      System.out.println(meineListe.setze(Pos.AM_ENDE).lösche(Pos.BEI_CURSOR));

      System.out.println(meineListe.setze(Pos.AM_ANFANG).lösche(Pos.BEI_CURSOR));
      System.out.println(meineListe.setze(Pos.AM_ENDE).lösche(Pos.BEI_CURSOR));
   }
}
