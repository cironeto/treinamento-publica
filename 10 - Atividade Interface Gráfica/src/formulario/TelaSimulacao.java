package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.border.LineBorder;

import grafico.Grafico;
import model.SimulacaoInvestimento;
import util.Calculos;
import util.DatesUtil;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class TelaSimulacao extends JFrame {

	private JPanel contentPane;

	public TelaSimulacao(SimulacaoInvestimento simulacaoInvestimento) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("0.00");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 827);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelGrafico = new JPanel();
		panelGrafico.setBounds(10, 11, 735, 436);
		panelGrafico.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Grafico grafico = new Grafico(simulacaoInvestimento);
		panelGrafico.add(grafico);
		contentPane.add(panelGrafico);		
		

		JLabel lblValorInicial = new JLabel("Valor inicial R$");
		lblValorInicial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorInicial.setBounds(121, 458, 115, 29);
		contentPane.add(lblValorInicial);

		JLabel lblValorInicialValor = new JLabel("-");
		lblValorInicialValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorInicialValor.setBounds(235, 458, 89, 29);
		contentPane.add(lblValorInicialValor);
		lblValorInicialValor.setText(String.valueOf(simulacaoInvestimento.getValorInicial()));

		JLabel lblDiasRendimento = new JLabel("Dias rendimento");
		lblDiasRendimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiasRendimento.setBounds(121, 484, 135, 29);
		contentPane.add(lblDiasRendimento);

		JLabel lblValorDiasRendimento = new JLabel("-");
		lblValorDiasRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorDiasRendimento.setBounds(258, 484, 69, 29);
		contentPane.add(lblValorDiasRendimento);
		lblValorDiasRendimento.setText(String.valueOf(DatesUtil
				.calculaDiasUteis(DatesUtil.retornaListaDiasSemFinalDeSemana(simulacaoInvestimento.getMeses()))));

		JLabel lblDiasCorridos = new JLabel("Dias corrido");
		lblDiasCorridos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiasCorridos.setBounds(407, 484, 109, 29);
		contentPane.add(lblDiasCorridos);

		JLabel lblValorDiasCorridos = new JLabel("-");
		lblValorDiasCorridos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorDiasCorridos.setBounds(518, 484, 69, 29);
		contentPane.add(lblValorDiasCorridos);
		lblValorDiasCorridos.setText(String.valueOf(DatesUtil.calculaDiasCorridos(simulacaoInvestimento.getMeses())));

		JPanel panelPoupanca = new JPanel();
		panelPoupanca.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelPoupanca.setBounds(10, 578, 240, 158);
		contentPane.add(panelPoupanca);
		panelPoupanca.setLayout(null);

		JLabel lblRendimentosPoupanca = new JLabel("Rendimentos R$");
		lblRendimentosPoupanca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRendimentosPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRendimentosPoupanca.setBounds(0, 27, 131, 29);
		panelPoupanca.add(lblRendimentosPoupanca);

		JLabel lblImpostoRendaPoupanca = new JLabel("I.R.");
		lblImpostoRendaPoupanca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImpostoRendaPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImpostoRendaPoupanca.setBounds(10, 68, 109, 29);
		panelPoupanca.add(lblImpostoRendaPoupanca);

		JLabel lblLiquidoPoupanca = new JLabel("L\u00EDquido R$");
		lblLiquidoPoupanca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLiquidoPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLiquidoPoupanca.setBounds(10, 118, 109, 29);
		panelPoupanca.add(lblLiquidoPoupanca);

		JLabel lblValorRendimentosPoupanca = new JLabel("-");
		lblValorRendimentosPoupanca.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorRendimentosPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorRendimentosPoupanca.setBounds(131, 27, 99, 29);
		panelPoupanca.add(lblValorRendimentosPoupanca);
		lblValorRendimentosPoupanca.setText(df.format(
				Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalPoupanca())));

		JLabel lblValorImpostoRendaPoupanca = new JLabel("-");
		lblValorImpostoRendaPoupanca.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorImpostoRendaPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorImpostoRendaPoupanca.setBounds(121, 67, 109, 29);
		panelPoupanca.add(lblValorImpostoRendaPoupanca);
		lblValorImpostoRendaPoupanca.setText("ISENTO");

		JLabel lblValorLiquidoPoupanca = new JLabel("-");
		lblValorLiquidoPoupanca.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorLiquidoPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorLiquidoPoupanca.setBounds(121, 118, 109, 29);
		panelPoupanca.add(lblValorLiquidoPoupanca);
		lblValorLiquidoPoupanca.setText(df.format(simulacaoInvestimento.getValorInicial()
				+ Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalPoupanca())));

		JPanel panelCDB = new JPanel();
		panelCDB.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelCDB.setBounds(258, 578, 240, 158);
		contentPane.add(panelCDB);
		panelCDB.setLayout(null);

		JLabel lblValorRendimentosCDB = new JLabel("-");
		lblValorRendimentosCDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorRendimentosCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorRendimentosCDB.setBounds(134, 27, 96, 29);
		panelCDB.add(lblValorRendimentosCDB);
		lblValorRendimentosCDB.setText(df
				.format(Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalCDB())));

		JLabel lblRendimentosCDB = new JLabel("Rendimentos R$");
		lblRendimentosCDB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRendimentosCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRendimentosCDB.setBounds(0, 27, 131, 29);
		panelCDB.add(lblRendimentosCDB);

		JLabel lblImpostoRendaCDB = new JLabel("I.R.");
		lblImpostoRendaCDB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImpostoRendaCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImpostoRendaCDB.setBounds(10, 68, 109, 29);
		panelCDB.add(lblImpostoRendaCDB);

		JLabel lblValorImpostoRendaCDB = new JLabel("-");
		lblValorImpostoRendaCDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorImpostoRendaCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorImpostoRendaCDB.setBounds(121, 67, 109, 29);
		panelCDB.add(lblValorImpostoRendaCDB);
		lblValorImpostoRendaCDB.setText(df.format(Calculos.calculaImpostoRendaCDB(simulacaoInvestimento.getMeses(),
				Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalCDB()))));

		JLabel lblValorLiquidoCDB = new JLabel("-");
		lblValorLiquidoCDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorLiquidoCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorLiquidoCDB.setBounds(121, 118, 109, 29);
		panelCDB.add(lblValorLiquidoCDB);
		lblValorLiquidoCDB.setText(df.format(simulacaoInvestimento.getValorInicial()
				+ Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalCDB())
				- Calculos.calculaImpostoRendaCDB(simulacaoInvestimento.getMeses(),
						Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalCDB()))));

		JLabel lblLiquidoCDB = new JLabel("L\u00EDquido R$");
		lblLiquidoCDB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLiquidoCDB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLiquidoCDB.setBounds(10, 118, 109, 29);
		panelCDB.add(lblLiquidoCDB);

		JPanel paneLCI = new JPanel();
		paneLCI.setBorder(new LineBorder(Color.GRAY, 1, true));
		paneLCI.setBounds(505, 578, 240, 158);
		contentPane.add(paneLCI);
		paneLCI.setLayout(null);

		JLabel lblValorRendimentosLCI = new JLabel("-");
		lblValorRendimentosLCI.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorRendimentosLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorRendimentosLCI.setBounds(137, 27, 93, 29);
		paneLCI.add(lblValorRendimentosLCI);
		lblValorRendimentosLCI.setText(df
				.format(Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalLCI())));

		JLabel lblRendimentosLCI = new JLabel("Rendimentos R$");
		lblRendimentosLCI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRendimentosLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRendimentosLCI.setBounds(0, 27, 134, 29);
		paneLCI.add(lblRendimentosLCI);

		JLabel lblImpostoRendaLCI = new JLabel("I.R.");
		lblImpostoRendaLCI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImpostoRendaLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImpostoRendaLCI.setBounds(10, 68, 109, 29);
		paneLCI.add(lblImpostoRendaLCI);

		JLabel lblValorImpostoRendaLCI = new JLabel("-");
		lblValorImpostoRendaLCI.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorImpostoRendaLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorImpostoRendaLCI.setBounds(121, 67, 109, 29);
		paneLCI.add(lblValorImpostoRendaLCI);
		lblValorImpostoRendaLCI.setText("ISENTO");

		JLabel lblValorLiquidoLCI = new JLabel("-");
		lblValorLiquidoLCI.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorLiquidoLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorLiquidoLCI.setBounds(121, 118, 109, 29);
		paneLCI.add(lblValorLiquidoLCI);
		lblValorLiquidoLCI.setText(df.format(simulacaoInvestimento.getValorInicial()
				+ Calculos.calculaRendimentos(simulacaoInvestimento, simulacaoInvestimento.getTaxaMensalLCI())));

		JLabel lblLiquidoLCI = new JLabel("L\u00EDquido R$");
		lblLiquidoLCI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLiquidoLCI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLiquidoLCI.setBounds(10, 118, 109, 29);
		paneLCI.add(lblLiquidoLCI);

		JLabel lblPoupanca = new JLabel("POUPAN\u00C7A");
		lblPoupanca.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPoupanca.setBounds(86, 538, 109, 29);
		contentPane.add(lblPoupanca);

		JLabel lblCdb = new JLabel("CDB 100% cdi");
		lblCdb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCdb.setBounds(313, 538, 129, 29);
		contentPane.add(lblCdb);

		JLabel lblLci = new JLabel("LCI 100% cdi");
		lblLci.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLci.setBounds(568, 538, 119, 29);
		contentPane.add(lblLci);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaInicial().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(327, 747, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblDataResgate = new JLabel("Data resgate");
		lblDataResgate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataResgate.setBounds(406, 458, 115, 29);
		contentPane.add(lblDataResgate);

		JLabel lblValorDataResgate = new JLabel("0.0");
		lblValorDataResgate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorDataResgate.setBounds(520, 458, 140, 29);
		contentPane.add(lblValorDataResgate);
		lblValorDataResgate.setText(DatesUtil.getVencimentoDiaUtil(3).toString());
	}
}
