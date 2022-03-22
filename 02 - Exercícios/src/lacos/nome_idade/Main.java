package lacos.nome_idade;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		
		String nomeSalvo = "";
		int idadeMax = 0;		
		int parar = 1;
		
		do {
			String nome = JOptionPane.showInputDialog("Insira um nome");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira uma idade"));
			
			if(idade > idadeMax) {
				idadeMax = idade;
				nomeSalvo = nome;
			}
			
			parar = JOptionPane.showConfirmDialog(null, "Deseja parar de inserir dados?");
			
			
		}while(parar != 0);
		
		JOptionPane.showMessageDialog(null, "Nome e idade da pessoa mais velha: " + nomeSalvo + idadeMax);
				
	}
}
