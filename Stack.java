
public class Stack <T> extends Liste<T>{
    public T peek (){
        setze(Pos.AM_ENDE);
        return zeige();
    }
    public boolean empty(){
        return istLeer();
    }
    public void pop(){
        lösche(Pos.AM_ENDE);
    }
    public Liste<T> push (T t){
        return fügeEin(t, Pos.NACH_CURSOR);
    }
}

