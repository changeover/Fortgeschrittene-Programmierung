
public class Queue <T> extends Liste<T>{
    public T front (){
        setze(Pos.AM_ANFANG);
        return zeige();
    }
    public boolean empty(){
        return istLeer();
    }
    public Queue<T> dequeue(){
        lösche(Pos.AM_ANFANG);
        return this;
    }
    public Queue<T> enqueue (T t){
        fügeEin(t, Pos.AM_ENDE);
        return this;
    }
}
