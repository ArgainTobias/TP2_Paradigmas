package visual;

import javax.swing.*;

public class PruebaSwing {
    public static void main(String[] args) {
        // 1. La ventana
        JFrame frame = new JFrame("Prueba Swing");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // posicionamiento manual, simple para probar
        // 2. Una barra de HP y una etiqueta
        JProgressBar barra = new JProgressBar(0, 100); // min 0, max 40
        barra.setValue(100);
        barra.setBounds(400, 300, 200, 25);
        barra.setStringPainted(true); // muestra el número encima
        frame.add(barra);
        // 3. Un botón que le baja "HP"
        JButton boton = new JButton("Recibir daño (-10)");
        boton.setBounds(50, 80, 200, 30);
        
        boton.addActionListener(e -> {
            int nuevo = barra.getValue() - 10;
            barra.setValue(Math.max(nuevo, 0)); // no baja de 0
        });
        
        JButton botonCura = new JButton("Curar(+10)");
        botonCura.setBounds(50, 120, 200, 30);
        
        botonCura.addActionListener(e -> {
            int nuevo = barra.getValue() + 10;
            barra.setValue(Math.min(nuevo, 100)); // no baja de 0
        });
        
        frame.add(botonCura);
        frame.add(boton);
        // 4. Mostrar la ventana
        frame.setVisible(true);
   
  
    }
    }
