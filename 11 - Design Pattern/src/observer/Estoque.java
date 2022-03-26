package observer;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements Observable {
	 int quantidade = 200;
	
	private List<Observer> observers = new ArrayList();	


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.notificarObservers();
	}
	

	public int getQuantidade() {
		return quantidade;
	}


	@Override
	public void registrarObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removerObserver(Observer observer) {
		observers.remove(observer);
		System.out.println("'Observer' removido");
	}

	@Override
	public void notificarObservers() {
		System.out.println("\n ---- Notificando Observers ---- \n");
		for (Observer ob : observers) {
			ob.update(this.quantidade);
		}
	}
}
