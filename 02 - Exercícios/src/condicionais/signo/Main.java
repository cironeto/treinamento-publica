package condicionais.signo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		int diaNascimento = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de nascimento"));
		int mesNascimento = Integer.parseInt(JOptionPane.showInputDialog("Informe o mes de nascimento"));

		if ((mesNascimento == 3 && diaNascimento >= 21) || (mesNascimento == 4 && diaNascimento <= 20)) {
			JOptionPane.showMessageDialog(null, "Signo de �ries");
		} else if ((mesNascimento == 4 && diaNascimento >= 21) || (mesNascimento == 5 && diaNascimento <= 20)) {
			JOptionPane.showMessageDialog(null, "Signo de Touro");
		}else if ((mesNascimento == 5 && diaNascimento >= 21) || (mesNascimento == 6 && diaNascimento <= 20)) {
			JOptionPane.showMessageDialog(null, "Signo de G�meos");
		}else if ((mesNascimento == 6 && diaNascimento >= 21) || (mesNascimento == 7 && diaNascimento <= 22)) {
			JOptionPane.showMessageDialog(null, "Signo de C�ncer");
		}else if ((mesNascimento == 7 && diaNascimento >= 23) || (mesNascimento == 8 && diaNascimento <= 22)) {
			JOptionPane.showMessageDialog(null, "Signo de Le�o");
		}else if ((mesNascimento == 8 && diaNascimento >= 23) || (mesNascimento == 9 && diaNascimento <= 22)) {
			JOptionPane.showMessageDialog(null, "Signo de Virgem");
		}else if ((mesNascimento == 9 && diaNascimento >= 23) || (mesNascimento == 10 && diaNascimento <= 22)) {
			JOptionPane.showMessageDialog(null, "Signo de Libra");
		}else if ((mesNascimento == 10 && diaNascimento >= 23) || (mesNascimento == 11 && diaNascimento <= 21)) {
			JOptionPane.showMessageDialog(null, "Signo de Escorpi�o");
		}else if ((mesNascimento == 11 && diaNascimento >= 22) || (mesNascimento == 12 && diaNascimento <= 21)) {
			JOptionPane.showMessageDialog(null, "Signo de Sagit�rio");
		}else if ((mesNascimento == 12 && diaNascimento >= 22) || (mesNascimento == 1 && diaNascimento <= 20)) {
			JOptionPane.showMessageDialog(null, "Signo de Capric�rnio");
		}else if ((mesNascimento == 1 && diaNascimento >= 21) || (mesNascimento == 2 && diaNascimento <= 18)) {
			JOptionPane.showMessageDialog(null, "Signo de Aqu�rio");
		}else if ((mesNascimento == 2 && diaNascimento >= 19) || (mesNascimento == 3 && diaNascimento <= 20)) {
			JOptionPane.showMessageDialog(null, "Signo de Peixes");
		}

	}

}
