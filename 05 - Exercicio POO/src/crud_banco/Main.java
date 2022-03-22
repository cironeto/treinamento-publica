package crud_banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		List<Conta> contas = new ArrayList<>();
		List<Transacoes> transacoes = new ArrayList<>();

		Login login1 = new Login("ciro", "123");
		Conta conta1 = new Conta("Ciro", 0474, 10773, login1, 1500);

		Login login2 = new Login("neto", "123");
		Conta conta2 = new Conta("Neto", 7575, 36545, login2, 3000);

		contas.add(conta1);
		contas.add(conta2);

		int indiceConta = LoginAcao.autenticaUsuarioRetornaIndiceUsuario(contas);
		
		ContaAcao.menu(contas, transacoes, indiceConta);

	}
}
