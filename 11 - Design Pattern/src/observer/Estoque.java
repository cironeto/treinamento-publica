package observer;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements Observable {
	private int quantidade;
	
	private List<Observer> observers = new ArrayList();	


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		this.notificarObservers();
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
		for (Observer ob : observers) {
			ob.update(this.quantidade);
		}
	}
}
