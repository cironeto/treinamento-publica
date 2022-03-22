package interfaces;

import java.util.List;

public interface CrudDependenciaOutroArray<E, T> {
	
	//interface para classes que dependem de outroas ArrayList para alguma ação
	public void cadastrarDependenciaOutroArray(List<E> list, List<T> list2);
	public void listarDependenciaOutroArray(List<E> list, List<T> list2);
	public void alterarDependenciaOutroArray(List<E> list, List<T> list2);
	public void removerDependenciaOutroArray(List<E> list, List<T> list2);

}
