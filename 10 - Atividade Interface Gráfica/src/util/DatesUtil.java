package util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DatesUtil {

	public static ArrayList<LocalDate> retornaListaFeriadosPorDiaDoAno() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ArrayList<LocalDate> feriados = new ArrayList();
		feriados.add(LocalDate.parse("01/01/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("20/02/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("21/02/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("15/04/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("21/04/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("01/05/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("16/06/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("07/09/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("12/10/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("02/11/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("15/11/0001", dateTimeFormatter));
		feriados.add(LocalDate.parse("25/12/0001", dateTimeFormatter));

		return feriados;
	}

	public static long calculaDiasCorridos(int mesesASomar) {
		return ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().plusMonths(mesesASomar));

	}

	public static List<LocalDate> retornaListaDiasSemFinalDeSemana(int mesesASomar) {
		List<LocalDate> diasUteis = new ArrayList();
		int diasTotais = (int) DatesUtil.calculaDiasCorridos(mesesASomar);

		LocalDate date = LocalDate.now();

		for (int i = 0; i <= diasTotais; i++) {
			if ((!date.plusDays(i).getDayOfWeek().equals(DayOfWeek.SATURDAY))
					&& (!date.plusDays(i).getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
				diasUteis.add(date.plusDays(i));
			}
		}
		return diasUteis;
	}

	public static int calculaDiasUteis(List<LocalDate> diasSemFinalDeSemana) {
		ArrayList<LocalDate> feriados = DatesUtil.retornaListaFeriadosPorDiaDoAno();

		for (int i = 0; i < diasSemFinalDeSemana.size(); i++) {
			for (int j = 0; j < feriados.size(); j++) {
				if ((diasSemFinalDeSemana.get(i).getMonth() == feriados.get(j).getMonth()
						&& diasSemFinalDeSemana.get(i).getDayOfMonth() == feriados.get(j).getDayOfMonth())
						&& ((!diasSemFinalDeSemana.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY))
								&& (!diasSemFinalDeSemana.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)))) {
					diasSemFinalDeSemana.remove(i);
				}
			}
		}
		return diasSemFinalDeSemana.size();
	}
	
	public static LocalDate getVencimentoDiaUtil(int mesesASomar) {
		List<LocalDate> feriados =  DatesUtil.retornaListaFeriadosPorDiaDoAno();
		LocalDate vencimento = LocalDate.now().plusMonths(mesesASomar);
		
		if(vencimento.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
			vencimento.plusDays(2);
		}else if(vencimento.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			vencimento.plusDays(1);
		}
		return vencimento;
	}
}




