package util;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

public class Util {

	public static String gerarCodigo() {

		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();

	}

	public static Duration calcularTempo(String horaEntrada, String horaSaida) {

		LocalTime entrada = LocalTime.parse(horaEntrada);
		LocalTime saida = LocalTime.parse(horaSaida);

		Duration intervalo = Duration.between(entrada, saida);

		intervalo.toHours();

		int intervaloConvertido = Integer.parseInt(intervalo);

		System.out.println(intervalo);

		return intervalo;

	}

}
