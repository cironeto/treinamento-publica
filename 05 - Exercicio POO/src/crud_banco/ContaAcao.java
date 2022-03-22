package crud_banco;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

public class ContaAcao {

	private static int opcao = 0;

	public static void menu(List<Conta> contas, List<Transacoes> transacoes, int indiceConta) {
		do {
			opcao = Integer.parseInt(JOptionPane
					.showInputDialog("Saldo da conta: " + contas.get(indiceConta).getSaldo() + "\n\n" + "*OPÇÕES* \n"
							+ "1 - Sacar \n" + "2 - Depositar \n" + "3 - Extrato \n" + "4 - Sair \n\n"));

			switch (opcao) {
			case 1:
				double valorSacar = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?"));
				ContaAcao.sacar(contas.get(indiceConta), valorSacar);
				ContaAcao.registraExtratoSaque(transacoes, indiceConta, valorSacar);
				break;

			case 2:
				double valorDepositar = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar?"));
				ContaAcao.depositar(contas.get(indiceConta), valorDepositar);
				ContaAcao.registraExtratoDeposito(transacoes, indiceConta, valorDepositar);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, transacoes);
				break;
			}
		} while (opcao != 4);

	}

	public static void sacar(Conta conta, double valor) {
		if (valor > conta.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
		} else {
			conta.setSaldo(conta.getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque efetuado");
		}
	}

	public static void depositar(Conta conta, double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		JOptionPane.showMessageDialog(null, "Deposito efetuado");
	}

	public static void registraExtratoSaque(List<Transacoes> transacoes, int indiceConta, double valor) {
		transacoes.add(new Transacoes(indiceConta, LocalDateTime.now(), valor, "Saque"));
	}

	public static void registraExtratoDeposito(List<Transacoes> transacoes, int indiceConta, double valor) {
		transacoes.add(new Transacoes(indiceConta, LocalDateTime.now(), valor, "Deposito"));
	}


}
