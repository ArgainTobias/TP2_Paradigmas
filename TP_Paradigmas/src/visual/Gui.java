package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import batallon.Batallon;
import personajes.Personaje;
import reclutador.ReclutadorSimpleFactory;
import javax.swing.SwingConstants;

public class Gui {

	private JFrame frmBatallaDeMagos;
	private JLabel lblMago1, lblMago2, lblMago3;
	private JLabel indMago1, indMago2, indMago3;
	private JLabel lblMorti1, lblMorti2, lblMorti3;
	private JLabel indMorti1, indMorti2, indMorti3;
	private JProgressBar barraMago1, barraMago2, barraMago3;
	private JProgressBar barraMorti1, barraMorti2, barraMorti3;
	private JTextArea logTurno;
	private JButton btnSigTurno;
	private JLabel lblTitulo;
	// batalla
	private Batallon batallonMagos, batallonMortifagos;
	private List<Personaje> listaMagos, listaMortifagos;
	private List<JProgressBar> barrasMagos, barrasMortifagos;
	private List<JLabel> labelsMagos, labelsMortifagos;
	private List<JLabel> indicadoresMagos, indicadoresMortifagos;
	private int turno = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmBatallaDeMagos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {

		inicializarElementos();
		inciarBatalla();
	}

	private void inciarBatalla() {
		batallonMagos = new Batallon();
		batallonMortifagos = new Batallon();
		// System.out.println("=== Batallon magos ===");
		while (batallonMagos.getCantSoldados() != 3) {
			batallonMagos.agregarPersonaje(ReclutadorSimpleFactory.crearMago());

		}
		// batallonMagos.mostrarBatallon();
		// System.out.println("=== Batallon mortifagos ===");
		while (batallonMortifagos.getCantSoldados() != 3) {
			batallonMortifagos.agregarPersonaje(ReclutadorSimpleFactory.crearMortifago());
		}
		// batallonMortifagos.mostrarBatallon();
		// System.out.println("-----------ARRANCA LA BATALLA--------------");

		listaMagos = batallonMagos.getPersonajes();
		listaMortifagos = batallonMortifagos.getPersonajes();

		barrasMagos = List.of(barraMago1, barraMago2, barraMago3);
		barrasMortifagos = List.of(barraMorti1, barraMorti2, barraMorti3);

		labelsMagos = List.of(lblMago1, lblMago2, lblMago3);
		labelsMortifagos = List.of(lblMorti1, lblMorti2, lblMorti3);

		indicadoresMagos = List.of(indMago1, indMago2, indMago3);
		indicadoresMortifagos = List.of(indMorti1, indMorti2, indMorti3);

		for (JProgressBar b : barrasMagos)
			b.setMaximum(200);
		for (JProgressBar b : barrasMortifagos)
			b.setMaximum(200);

		actualizarPantalla(); // pinto el estado inicial
	}

	private void actualizarPantalla() {
		actualizarBando(listaMagos, barrasMagos, labelsMagos, indicadoresMagos);
		actualizarBando(listaMortifagos, barrasMortifagos, labelsMortifagos, indicadoresMortifagos);
	}

	private void actualizarBando(List<Personaje> pjs, List<JProgressBar> barras, List<JLabel> labels,
			List<JLabel> indicadores) {
		for (int i = 0; i < pjs.size(); i++) {
			Personaje p = pjs.get(i);
			String estado = p.getEstado().getClass().getSimpleName();
			barras.get(i).setMaximum(p.getHpMaximo());
			barras.get(i).setValue(p.getHp());
			barras.get(i).setString(p.getHp() + "HP / " + p.getHpMaximo() + "HP");
			labels.get(i).setText(p.getNombre() + " - " + p.getEstado().getClass().getSimpleName());
			indicadores.get(i).setBackground(colorPorEstado(estado));
		}
	}

	private Color colorPorEstado(String estado) {
		switch (estado) {
		case "Sano":
			return Color.GREEN;
		case "Protegido":
			return Color.BLUE;
		case "Aturdido":
			return Color.YELLOW;
		case "Muerto":
			return Color.RED;
		default:
			return Color.LIGHT_GRAY;
		}
	}

	private void inicializarElementos() {
		Font fuenteNombres;
		Font fuenteTitulo;   // Lumos/Cinzel para títulos
		Font fuenteLog;      // Monospaced/Tahoma para el log
		try {
			fuenteNombres = Font.createFont(Font.TRUETYPE_FONT, new File("recursos/IMFellEnglish-Italic.ttf"))
					.deriveFont(Font.BOLD, 19f); // estilo y tamaño
		} catch (Exception e) {
			e.printStackTrace();
			fuenteNombres = new Font("Tahoma", Font.BOLD, 28); // fuente de respaldo si falla
		}
		try {
		    fuenteTitulo = Font.createFont(Font.TRUETYPE_FONT,
		        new File("recursos/HARRYP__.TTF")).deriveFont(Font.BOLD, 28f);
		} catch (Exception e) {
		    fuenteTitulo = new Font("Tahoma", Font.BOLD, 28);
		}

		fuenteLog = new Font("Monospaced", Font.PLAIN, 13);  // esta no necesita archivo, es del sistema
		frmBatallaDeMagos = new JFrame();
		frmBatallaDeMagos.setTitle("BATALLA DE MAGOS VS MORTIFAGOS");
		frmBatallaDeMagos.setBounds(100, 100, 959, 665);
		frmBatallaDeMagos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatallaDeMagos.getContentPane().setLayout(null);
		frmBatallaDeMagos.setLocationRelativeTo(null);

		lblTitulo = new JLabel("BATALLA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setFont(fuenteTitulo);
		lblTitulo.setBounds(389, 11, 164, 41);
		frmBatallaDeMagos.getContentPane().add(lblTitulo);

		btnSigTurno = new JButton("SIGUIENTE TURNO");
		btnSigTurno.setBackground(new Color(255, 128, 0));
		btnSigTurno.setFont(fuenteNombres.deriveFont(14f));
		btnSigTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logTurno.append("--- Turno " + turno + " ---\n");
				logTurno.append(batallonMagos.atacar(batallonMortifagos));
				if (batallonMortifagos.tienePersonajesSaludables())
					logTurno.append(batallonMortifagos.atacar(batallonMagos));
				turno++;

				actualizarPantalla();

				if (!batallonMagos.tienePersonajesSaludables() || !batallonMortifagos.tienePersonajesSaludables()) {
					String ganador = batallonMagos.tienePersonajesSaludables() ? "MAGOS" : "MORTIFAGOS";
					JOptionPane.showMessageDialog(frmBatallaDeMagos, "¡Ganaron los " + ganador + "!");
					btnSigTurno.setEnabled(false);
				}
			}
		});
		btnSigTurno.setBounds(699, 381, 213, 52);
		frmBatallaDeMagos.getContentPane().add(btnSigTurno);

		barraMago2 = new JProgressBar();
		barraMago2.setForeground(new Color(0, 255, 0));
		barraMago2.setOpaque(true);
		barraMago2.setValue(100);
		barraMago2.setStringPainted(true);
		barraMago2.setBounds(217, 198, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago2);

		lblMago2 = new JLabel("Mago 2");
		lblMago2.setBounds(217, 167, 213, 28);
		lblMago2.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMago2);

		indMago2 = new JLabel();
		indMago2.setOpaque(true); // para que se vea el color de fondo
		indMago2.setBounds(191, 167, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago2);

		lblMago3 = new JLabel("Mago 3");
		lblMago3.setBounds(217, 266, 215, 28);
		lblMago3.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMago3);

		indMago3 = new JLabel();
		indMago3.setOpaque(true); // para que se vea el color de fondo
		indMago3.setBounds(191, 274, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago3);

		barraMago3 = new JProgressBar();
		barraMago3.setForeground(new Color(0, 255, 0));
		barraMago3.setValue(100);
		barraMago3.setStringPainted(true);
		barraMago3.setOpaque(true);
		barraMago3.setBounds(217, 300, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago3);

		barraMago1 = new JProgressBar();
		barraMago1.setForeground(new Color(0, 255, 0));
		barraMago1.setValue(100);
		barraMago1.setStringPainted(true);
		barraMago1.setOpaque(true);
		barraMago1.setBounds(217, 101, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago1);

		lblMago1 = new JLabel("Mago 1");
		lblMago1.setBounds(217, 68, 250, 22);
		lblMago1.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMago1);

		indMago1 = new JLabel();
		indMago1.setOpaque(true); // para que se vea el color de fondo
		indMago1.setBounds(191, 68, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago1);

		barraMorti1 = new JProgressBar();
		barraMorti1.setForeground(new Color(0, 255, 0));
		barraMorti1.setValue(100);
		barraMorti1.setStringPainted(true);
		barraMorti1.setOpaque(true);
		barraMorti1.setBounds(580, 104, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti1);

		lblMorti1 = new JLabel("Mago 2");
		lblMorti1.setBounds(580, 65, 174, 28);
		lblMorti1.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMorti1);

		indMorti1 = new JLabel();
		indMorti1.setOpaque(true); // para que se vea el color de fondo
		indMorti1.setBounds(547, 68, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti1);

		barraMorti2 = new JProgressBar();
		barraMorti2.setForeground(new Color(0, 255, 0));
		barraMorti2.setValue(100);
		barraMorti2.setStringPainted(true);
		barraMorti2.setOpaque(true);
		barraMorti2.setBounds(580, 201, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti2);

		lblMorti2 = new JLabel("Mago 2");
		lblMorti2.setBounds(580, 167, 174, 28);
		lblMorti2.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMorti2);

		indMorti2 = new JLabel();
		indMorti2.setOpaque(true); // para que se vea el color de fondo
		indMorti2.setBounds(547, 167, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti2);

		barraMorti3 = new JProgressBar();
		barraMorti3.setForeground(new Color(0, 255, 0));
		barraMorti3.setValue(100);
		barraMorti3.setStringPainted(true);
		barraMorti3.setOpaque(true);
		barraMorti3.setBounds(580, 303, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti3);

		lblMorti3 = new JLabel("Mago 2");
		lblMorti3.setBounds(580, 262, 174, 28);
		lblMorti3.setFont(fuenteNombres);
		frmBatallaDeMagos.getContentPane().add(lblMorti3);

		indMorti3 = new JLabel();
		indMorti3.setOpaque(true); // para que se vea el color de fondo
		indMorti3.setBounds(547, 270, 20, 20); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti3);

		logTurno = new JTextArea();
		logTurno.setBackground(new Color(255, 255, 255));
		logTurno.setFont(new Font("Serif", Font.PLAIN, 18));
		logTurno.setBounds(10, 325, 518, 186);
		logTurno.setEditable(false);

		JScrollPane scroll = new JScrollPane(logTurno);
		scroll.setBounds(10, 348, 654, 267);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		frmBatallaDeMagos.getContentPane().add(scroll);


		JButton btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setBackground(new Color(128, 128, 255));
		btnReiniciar.setFont(fuenteNombres);
		btnReiniciar.setBounds(718, 509, 164, 52);
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turno = 1; // 1. reset contador
				logTurno.setText(""); // 2. limpiar log
				btnSigTurno.setEnabled(true); // 3. rehabilitar botón de turno
				inciarBatalla(); // 4. batallones nuevos + refresca pantalla
			}
		});
		frmBatallaDeMagos.getContentPane().add(btnReiniciar);
	}
}
