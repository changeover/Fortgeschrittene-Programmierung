
public class Queue <T> extends Liste<T>{
    public T front (){
        setze(Pos.AM_ENDE);
        return zeige();
    }
    public boolean empty(){
        return istLeer();
    }
    public Queue<T> dequeue(){
        setze(Pos.AM_ENDE);
        lösche(Pos.BEI_CURSOR);
        return this;
    }
    public Queue<T> enqueue (T t){
        setze(Pos.VOR_CURSOR);
        fügeEin(t, Pos.NACH_CURSOR);
        return this;
    }
}
