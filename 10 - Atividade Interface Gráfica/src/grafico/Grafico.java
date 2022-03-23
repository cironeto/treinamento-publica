package grafico;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import model.SimulacaoInvestimento;
import util.Calculos;

public class Grafico extends JPanel {

	public Grafico(SimulacaoInvestimento obj) {
		setBounds(10, 11, 735, 190);

		criarGrafico(obj);

		setVisible(true);
	}

	public void criarGrafico(SimulacaoInvestimento obj) {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		barra.setValue(Calculos.calculaRendimentos(obj, obj.getTaxaMensalPoupanca()) + obj.getValorInicial(), "Rendimento Poupança", "");
		barra.setValue(Calculos.calculaRendimentos(obj, obj.getTaxaMensalCDB())+ obj.getValorInicial(), "Rendimento CDB", "");
		barra.setValue(Calculos.calculaRendimentos(obj, obj.getTaxaMensalLCI())+ obj.getValorInicial(), "Rendimento LCI", "");

		JFreeChart grafico = ChartFactory.createBarChart3D("Comparativo de Investimentos", "Investimentos",
				"Rendimento (R$)", barra, PlotOrientation.VERTICAL, true, true, false);

		CategoryPlot barraItem = grafico.getCategoryPlot();
		barraItem.getRenderer().setSeriesPaint(0, Color.BLACK);
		barraItem.getRenderer().setSeriesPaint(1, Color.DARK_GRAY);
		barraItem.getRenderer().setSeriesPaint(2, Color.GRAY);

		BarRenderer renderer = (BarRenderer) grafico.getCategoryPlot().getRenderer();
		renderer.setMaximumBarWidth(.1);

		ChartPanel painel = new ChartPanel(grafico);
		painel.setBounds(10, 11, 735, 190);
		add(painel);
	}

}
