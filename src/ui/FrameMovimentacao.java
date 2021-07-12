package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MovimentoDao;
import model.Movimento;
import util.Util;

public class FrameMovimentacao {

	private JLabel labelEntrada;
	private JLabel labelPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JLabel labelSaida;
	private JLabel labelPlacaSaida;
	private JLabel labelModeloSaida;
	private JLabel labelDataEntrada;
	private JLabel labelHoraEntrada;
	private JLabel labelDataSaida;
	private JLabel labelHoraSaida;
	private JLabel labelTempo;
	private JLabel labelValor;
	private JTextField textFieldPlacaEntrada;
	private JTextField textFieldModeloEntrada;
	private JTextField textFieldPlacaSaida;
	private JTextField textFieldModeloSaida;
	private JTextField textFieldDataEntrada;
	private JTextField textFieldHoraEntrada;
	private JTextField textFieldDataSaida;
	private JTextField textFieldHoraSaida;
	private JTextField textFieldTempo;
	private JTextField textFieldValor;
	private JButton buttonEntrar;
	private JButton buttonBuscar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;

	private JTable tabelaVeiculos;
	private DefaultTableModel modeloTabelaVeiculos;
	private JScrollPane scrollTabelaVeiculos;

	public void criarTela() {

		JFrame telaMovimentacao = new JFrame();
		telaMovimentacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaMovimentacao.setSize(950, 800);
		telaMovimentacao.setTitle("Movimentção de veículos");
		telaMovimentacao.setLayout(null);
		telaMovimentacao.setResizable(false);

		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(30, 10, 100, 50);

		labelPlacaEntrada = new JLabel("PLACA:");
		labelPlacaEntrada.setBounds(30, 60, 70, 30);

		textFieldPlacaEntrada = new JTextField();
		textFieldPlacaEntrada.setBounds(30, 90, 340, 40);

		labelModeloEntrada = new JLabel("MODELO:");
		labelModeloEntrada.setBounds(390, 60, 70, 30);

		textFieldModeloEntrada = new JTextField();
		textFieldModeloEntrada.setBounds(390, 90, 340, 40);

		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(755, 90, 150, 40);

		modeloTabelaVeiculos = new DefaultTableModel();
		modeloTabelaVeiculos.addColumn("CÓDIGO");
		modeloTabelaVeiculos.addColumn("PLACA");
		modeloTabelaVeiculos.addColumn("MODELO");
		modeloTabelaVeiculos.addColumn("DATA ENTRADA");

		MovimentoDao movimentoDao = new MovimentoDao();

		ArrayList<Movimento> movimentos = movimentoDao.listarMovimentos();

		for (Movimento movimento : movimentos) {

			// Vetor que representa cada linha da tabela
			String vetorMovimento[] = { movimento.getCodigo(), movimento.getPlaca(), movimento.getModelo(),
					movimento.getDataEntrada() };

			modeloTabelaVeiculos.addRow(vetorMovimento);
		}

		tabelaVeiculos = new JTable(modeloTabelaVeiculos);

		scrollTabelaVeiculos = new JScrollPane(tabelaVeiculos);
		scrollTabelaVeiculos.setBounds(30, 140, 875, 200);

		tabelaVeiculos.getTableHeader().setReorderingAllowed(false);

		labelSaida = new JLabel("SAÍDA");
		labelSaida.setBounds(30, 350, 50, 50);

		labelPlacaSaida = new JLabel("PLACA:");
		labelPlacaSaida.setBounds(30, 390, 50, 50);

		textFieldPlacaSaida = new JTextField();
		textFieldPlacaSaida.setBounds(30, 440, 150, 40);

		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(190, 440, 140, 40);

		labelModeloSaida = new JLabel("MODELO:");
		labelModeloSaida.setBounds(30, 500, 80, 50);

		textFieldModeloSaida = new JTextField();
		textFieldModeloSaida.setBounds(30, 535, 150, 40);

		labelDataEntrada = new JLabel("DATA ENTRADA:");
		labelDataEntrada.setBounds(190, 500, 100, 50);

		textFieldDataEntrada = new JTextField();
		textFieldDataEntrada.setBounds(190, 535, 150, 40);

		labelHoraEntrada = new JLabel("HORA ENTRADA:");
		labelHoraEntrada.setBounds(350, 500, 100, 50);

		textFieldHoraEntrada = new JTextField();
		textFieldHoraEntrada.setBounds(350, 535, 150, 40);

		labelDataSaida = new JLabel("DATA SAÍDA:");
		labelDataSaida.setBounds(510, 500, 100, 50);

		textFieldDataSaida = new JTextField();
		textFieldDataSaida.setBounds(510, 535, 150, 40);

		labelHoraSaida = new JLabel("HORA SAÍDA:");
		labelHoraSaida.setBounds(670, 500, 100, 50);

		textFieldHoraSaida = new JTextField();
		textFieldHoraSaida.setBounds(670, 535, 150, 40);

		labelTempo = new JLabel("TEMPO:");
		labelTempo.setBounds(830, 500, 100, 50);

		textFieldTempo = new JTextField();
		textFieldTempo.setBounds(830, 535, 75, 40);

		labelValor = new JLabel("VALOR A PAGAR:");
		labelValor.setBounds(40, 610, 150, 50);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(150, 600, 260, 70);

		buttonEfetuarSaida = new JButton("EFETUAR SAÍDA");
		buttonEfetuarSaida.setBounds(420, 600, 220, 70);

		buttonFecharSistema = new JButton("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(675, 600, 230, 70);

		telaMovimentacao.getContentPane().add(labelEntrada);
		telaMovimentacao.getContentPane().add(labelPlacaEntrada);
		telaMovimentacao.getContentPane().add(labelModeloEntrada);
		telaMovimentacao.getContentPane().add(labelSaida);
		telaMovimentacao.getContentPane().add(labelPlacaSaida);
		telaMovimentacao.getContentPane().add(labelModeloSaida);
		telaMovimentacao.getContentPane().add(labelDataEntrada);
		telaMovimentacao.getContentPane().add(labelHoraEntrada);
		telaMovimentacao.getContentPane().add(labelDataSaida);
		telaMovimentacao.getContentPane().add(labelHoraSaida);
		telaMovimentacao.getContentPane().add(labelTempo);
		telaMovimentacao.getContentPane().add(labelValor);
		telaMovimentacao.getContentPane().add(textFieldPlacaEntrada);
		telaMovimentacao.getContentPane().add(textFieldModeloEntrada);
		telaMovimentacao.getContentPane().add(textFieldPlacaSaida);
		telaMovimentacao.getContentPane().add(textFieldModeloSaida);
		telaMovimentacao.getContentPane().add(textFieldDataEntrada);
		telaMovimentacao.getContentPane().add(textFieldHoraEntrada);
		telaMovimentacao.getContentPane().add(textFieldDataSaida);
		telaMovimentacao.getContentPane().add(textFieldHoraSaida);
		telaMovimentacao.getContentPane().add(textFieldTempo);
		telaMovimentacao.getContentPane().add(textFieldValor);
		telaMovimentacao.getContentPane().add(buttonEntrar);
		telaMovimentacao.getContentPane().add(buttonBuscar);
		telaMovimentacao.getContentPane().add(buttonEfetuarSaida);
		telaMovimentacao.getContentPane().add(buttonFecharSistema);
		telaMovimentacao.getContentPane().add(scrollTabelaVeiculos);

		telaMovimentacao.setVisible(true);

		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarEntrada()) {

					Movimento movimento = new Movimento();
					movimento.setCodigo(Util.gerarCodigo());
					movimento.setPlaca(textFieldPlacaEntrada.getText().trim().toUpperCase());
					movimento.setModelo(textFieldModeloEntrada.getText().toUpperCase());
					movimento.setDataEntrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					movimento.setHoraEntrada(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

					MovimentoDao dao = new MovimentoDao(movimento);
					dao.salvar();

					// Quando os dados forem salvo, uma janela é aberta com a mensagem indicada
					JOptionPane.showMessageDialog(null, movimento.getModelo() + "\ncadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);

					limparFormulario();

					// O cursor ficará piscando no campo do nome, quando os dados forem salvos
					textFieldPlacaEntrada.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null,
							// Mensagem principal aberta na caixa de diálogo
							"Você deve preencher todos os campos!",
							// Título da caixa de diálogo
							"Atenção",
							// Ícone temático da caixa de mensagem (configurado de acordo com o contexto da
							// mensagem)
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		buttonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String placa = textFieldPlacaSaida.getText().toUpperCase();

				MovimentoDao dao = new MovimentoDao();
				Movimento movimento = dao.buscarMovimento(placa);

				textFieldPlacaSaida.setText(movimento.getPlaca());
				textFieldModeloSaida.setText(movimento.getModelo());
				textFieldDataEntrada.setText(movimento.getDataEntrada());
				textFieldHoraEntrada.setText(movimento.getHoraEntrada());
				textFieldDataSaida.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				textFieldHoraSaida.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));

				validarBuscar();

			}
		});

		buttonEfetuarSaida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		buttonFecharSistema.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

	} // fim do método criarTela

	private boolean validarEntrada() {

		boolean valido = true;

		// trim -> remove os espaços antes e depois do que foi inserido
		if (textFieldPlacaEntrada.getText().trim().length() == 0) {
			labelPlacaEntrada.setForeground(Color.RED);
			valido = false;
		} else if (textFieldModeloEntrada.getText().trim().length() == 0) {
			labelModeloEntrada.setForeground(Color.RED);
			valido = false;
		}

		return valido;
	}

	private boolean validarBuscar() {

		boolean valido = true;

		// trim -> remove os espaços antes e depois do que foi inserido
		if (textFieldPlacaSaida.getText().trim().length() == 0) {
			labelPlacaSaida.setForeground(Color.RED);
			valido = false;
		}

		return valido;
	}

	private void limparFormulario() {

		textFieldPlacaEntrada.setText("");
		textFieldModeloEntrada.setText("");
		textFieldPlacaSaida.setText("");
		textFieldModeloSaida.setText("");
		textFieldDataEntrada.setText("");
		textFieldHoraEntrada.setText("");
		textFieldDataSaida.setText("");
		textFieldHoraSaida.setText("");
		textFieldTempo.setText("");
		textFieldValor.setText("");
	}

}