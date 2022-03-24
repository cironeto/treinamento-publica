package observer;

public interface Observable {

	public void registrarObserver(Observer observer);
    public void removerObserver(Observer observer);
    public void notificarObservers(); 


}
