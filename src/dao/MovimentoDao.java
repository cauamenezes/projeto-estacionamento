package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import model.Movimento;

public class MovimentoDao {

	private Movimento movimento;

	private static final String LOCAL_ARQUIVO = "C:/Users/User/Documents/SENAI 2021/Prof. Celso/projeto_estacionamento/movimentacao.ds1";

	// Construtor que pede o movimento
	public MovimentoDao(Movimento movimento) {
		this.movimento = movimento;
	}

	// Construtor Vazio
	public MovimentoDao() {

	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void salvar() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			// Abre o arquivo para editar
			writer.write(movimento.toString());
			// Cria uma nova linha
			writer.newLine();
			// Fecha o arquivo (necessário para inserir a informação desejada no arquivo)
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Movimento> listarMovimentos() {
		// Procedimento para abrir um arquivo para leitura ou escrita

		// Passo 1 - Obter o local do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo
		// Buffer é quando os dados de um arquivo passam para a memória RAM, para assim,
		// serem manipulados e gravados no HD.
		// Try e Catch podem ser comparados com if e else

		try {
			// Lê o conteúdo do arquivo
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			// Lê a linha e muda para a de baixo
			String linha = reader.readLine();

			ArrayList<Movimento> movimentos = new ArrayList<>();

			// ! = diferente
			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				Movimento movimento = new Movimento();
				movimento.setCodigo(vetorMovimento[0]);
				movimento.setPlaca(vetorMovimento[1]);
				movimento.setModelo(vetorMovimento[2]);
				movimento.setDataEntrada(vetorMovimento[3]);
				movimento.setHoraEntrada(vetorMovimento[4]);
				movimento.setDataSaida(vetorMovimento[5]);
				movimento.setHoraSaida(vetorMovimento[6]);
				movimento.setTempo(vetorMovimento[7]);
				movimento.setValor((vetorMovimento[8]));

				movimentos.add(movimento);

				// Lê de fato o arquivo que foi indicado
				linha = reader.readLine();
			}

			// Fecha o arquivo
			reader.close();

			return movimentos;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			// Mostra no console o erro se ele ocorrer
			e.printStackTrace();

			return null;
		}
	}

	public Movimento buscarMovimento(String placa) {
		// Procedimento para abrir um arquivo para leitura ou escrita

		// Passo 1 - Obter o local do arquivo

		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo
		// Buffer é quando os dados de um arquivo passam para a memória RAM, para assim,
		// serem manipulados e gravados no HD.
		// Try e Catch podem ser comparados com if e else

		try {
			// Lê o conteúdo do arquivo
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			// Lê a linha e muda para a de baixo
			String linha = reader.readLine();
			movimento = new Movimento();

			// ! = diferente
			while (linha != null) {
				String[] vetorMovimento = linha.split(";");

				if (vetorMovimento[1].equals(placa) && vetorMovimento[5].equals("0")) {
					movimento.setCodigo(vetorMovimento[0]);
					movimento.setPlaca(vetorMovimento[1]);
					movimento.setModelo(vetorMovimento[2]);
					movimento.setDataEntrada(vetorMovimento[3]);
					movimento.setHoraEntrada(vetorMovimento[4]);
					movimento.setDataSaida(vetorMovimento[5]);
					movimento.setHoraSaida(vetorMovimento[6]);
					movimento.setTempo(vetorMovimento[7]);
					movimento.setValor((vetorMovimento[8]));

					break;
				}

				// Lê de fato o arquivo que foi indicado
				linha = reader.readLine();
			}

			// Fecha o arquivo
			reader.close();

			return movimento;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			// Mostra no console o erro se ele ocorrer
			e.printStackTrace();

			return null;
		}
	}

}
