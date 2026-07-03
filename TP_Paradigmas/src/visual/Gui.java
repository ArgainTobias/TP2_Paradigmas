package visual;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import batallon.Batallon;
import personajes.Personaje;
import reclutador.ReclutadorSimpleFactory;

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
	private List<JLabel> indicadoresMagos,indicadoresMortifagos;
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

		indicadoresMagos = List.of(indMago1,indMago2,indMago3);
		indicadoresMortifagos = List.of(indMorti1,indMorti2,indMorti3);
		
		for (JProgressBar b : barrasMagos)
			b.setMaximum(200);
		for (JProgressBar b : barrasMortifagos)
			b.setMaximum(200);

		actualizarPantalla(); // pinto el estado inicial
	}

	private void actualizarPantalla() {
		actualizarBando(listaMagos, barrasMagos, labelsMagos,indicadoresMagos);
		actualizarBando(listaMortifagos, barrasMortifagos, labelsMortifagos,indicadoresMortifagos);
	}

	private void actualizarBando(List<Personaje> pjs, List<JProgressBar> barras, List<JLabel> labels,List<JLabel> indicadores) {
		for (int i = 0; i < pjs.size(); i++) {
			Personaje p = pjs.get(i);
			String estado = p.getEstado().getClass().getSimpleName();
			barras.get(i).setMaximum(p.getHpMaximo());
			barras.get(i).setValue(p.getHp());
			barras.get(i).setString(p.getHp() + "HP / " + p.getHpMaximo()+ "HP");
			labels.get(i).setText(p.getNombre() + " - " + p.getEstado().getClass().getSimpleName());
			indicadores.get(i).setBackground(colorPorEstado(estado));  
		}
	}
	
	private Color colorPorEstado(String estado) {
	    switch (estado) {
	        case "Sano":      return Color.GREEN;
	        case "Protegido": return Color.BLUE;
	        case "Aturdido":  return Color.YELLOW;
	        case "Muerto":    return Color.RED;
	        default:          return Color.LIGHT_GRAY;
	    }
	}

	private void inicializarElementos() {
		frmBatallaDeMagos = new JFrame();
		frmBatallaDeMagos.setTitle("BATALLA DE MAGOS VS MORTIFAGOS");
		frmBatallaDeMagos.setBounds(100, 100, 832, 572);
		frmBatallaDeMagos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatallaDeMagos.getContentPane().setLayout(null);
		frmBatallaDeMagos.setLocationRelativeTo(null);

		btnSigTurno = new JButton("Siguiente turno");
		btnSigTurno.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSigTurno.setForeground(new Color(255, 255, 255));
		btnSigTurno.setBackground(Color.BLACK);
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
					logTurno.append("=== Ganaron los " + ganador + " ===\n");
					btnSigTurno.setEnabled(false);
				}
			}
		});
		btnSigTurno.setBounds(595, 385, 157, 74);
		frmBatallaDeMagos.getContentPane().add(btnSigTurno);

		barraMago2 = new JProgressBar();
		barraMago2.setOpaque(true);
		barraMago2.setValue(100);
		barraMago2.setStringPainted(true);
		barraMago2.setBounds(201, 168, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago2);

		lblMago2 = new JLabel("Mago 2");
		lblMago2.setBounds(22, 166, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMago2);

		indMago2 = new JLabel();
		indMago2.setOpaque(true);           // para que se vea el color de fondo
		indMago2.setBounds(22, 186, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago2);
		
		
		lblMago3 = new JLabel("Mago 3");
		lblMago3.setBounds(22, 259, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMago3);

		indMago3 = new JLabel();
		indMago3.setOpaque(true);           // para que se vea el color de fondo
		indMago3.setBounds(22, 284, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago3);		
		
		barraMago3 = new JProgressBar();
		barraMago3.setValue(100);
		barraMago3.setStringPainted(true);
		barraMago3.setOpaque(true);
		barraMago3.setBounds(201, 261, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago3);

		barraMago1 = new JProgressBar();
		barraMago1.setValue(100);
		barraMago1.setStringPainted(true);
		barraMago1.setOpaque(true);
		barraMago1.setBounds(201, 77, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMago1);

		lblMago1 = new JLabel("Mago 1");
		lblMago1.setBounds(22, 75, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMago1);
		
		indMago1 = new JLabel();
		indMago1.setOpaque(true);           // para que se vea el color de fondo
		indMago1.setBounds(22, 95, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMago1);

		barraMorti1 = new JProgressBar();
		barraMorti1.setValue(100);
		barraMorti1.setStringPainted(true);
		barraMorti1.setOpaque(true);
		barraMorti1.setBounds(645, 77, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti1);

		lblMorti1 = new JLabel("Mago 2");
		lblMorti1.setBounds(507, 75, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMorti1);
		
		indMorti1 = new JLabel();
		indMorti1.setOpaque(true);           // para que se vea el color de fondo
		indMorti1.setBounds(507, 95, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti1);
		

		barraMorti2 = new JProgressBar();
		barraMorti2.setValue(100);
		barraMorti2.setStringPainted(true);
		barraMorti2.setOpaque(true);
		barraMorti2.setBounds(645, 168, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti2);

		lblMorti2 = new JLabel("Mago 2");
		lblMorti2.setBounds(507, 166, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMorti2);

		indMorti2 = new JLabel();
		indMorti2.setOpaque(true);           // para que se vea el color de fondo
		indMorti2.setBounds(507, 186, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti2);
		
		barraMorti3 = new JProgressBar();
		barraMorti3.setValue(100);
		barraMorti3.setStringPainted(true);
		barraMorti3.setOpaque(true);
		barraMorti3.setBounds(645, 261, 146, 14);
		frmBatallaDeMagos.getContentPane().add(barraMorti3);

		lblMorti3 = new JLabel("Mago 2");
		lblMorti3.setBounds(507, 259, 128, 14);
		frmBatallaDeMagos.getContentPane().add(lblMorti3);
		
		indMorti3 = new JLabel();
		indMorti3.setOpaque(true);           // para que se vea el color de fondo
		indMorti3.setBounds(507, 284, 20, 10); // debajo del nombre
		frmBatallaDeMagos.getContentPane().add(indMorti3);

		logTurno = new JTextArea();
		logTurno.setBounds(10, 325, 518, 186);
		logTurno.setEditable(false);

		JScrollPane scroll = new JScrollPane(logTurno);
		scroll.setBounds(10, 325, 511, 197);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		frmBatallaDeMagos.getContentPane().add(scroll);

		lblTitulo = new JLabel("BATALLA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(363, 11, 90, 41);
		frmBatallaDeMagos.getContentPane().add(lblTitulo);
	}
}
