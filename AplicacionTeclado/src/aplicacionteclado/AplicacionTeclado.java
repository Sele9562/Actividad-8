/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionteclado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class AplicacionTeclado extends JFrame implements ActionListener{

    
    private JTextArea areaTexto;
    private List<String> listaPangramas; 
    private int pulsacionesCorrectas; 
    private int pulsacionesIncorrectas; 
    private String pangramaActual; 
    private JButton[] botonesTeclado;
    private Map<Character, Integer> teclasDificultad;
    
    
    public AplicacionTeclado() { 
        areaTexto = new JTextArea(10, 40);
        JScrollPane panelDesplazable = new JScrollPane(areaTexto); 
        JPanel panelTeclado = new JPanel(new GridLayout(4, 10)); 
        listaPangramas = new ArrayList<>();
        pulsacionesCorrectas = 0;
        pulsacionesIncorrectas = 0; teclasDificultad = new HashMap<>();
        cargarPangramas();
        botonesTeclado = new JButton[26]; char caracterTecla = 'A';
    
        for (int i = 0; i < 26; i++) { 
        botonesTeclado[i] = new JButton(Character.toString(caracterTecla)); 
        botonesTeclado[i].addActionListener(this); panelTeclado.add(botonesTeclado[i]); caracterTecla++;
        }
        setTitle("Aplicación de Escritura al Tacto"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());
        add(panelDesplazable, BorderLayout.CENTER); 
        add(panelTeclado, BorderLayout.SOUTH);
        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true);
        mostrarPangramaAleatorio();
    }
    
    private void cargarPangramas() {
        listaPangramas.add("José compró una vieja zampoña en Perú");
    }
    
    private void mostrarPangramaAleatorio() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listaPangramas.size()); 
        pangramaActual = listaPangramas.get(indiceAleatorio);
        JOptionPane.showMessageDialog(this, pangramaActual, "Pangrama de Práctica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String textoBoton = botonPresionado.getText();
        areaTexto.append(textoBoton);
        if (textoBoton.equalsIgnoreCase(pangramaActual)) { 
            pulsacionesCorrectas++;
        } else {
            pulsacionesIncorrectas++;
            char tecla = textoBoton.charAt(0); 
            teclasDificultad.put(tecla,
                    teclasDificultad.getOrDefault(tecla, 0) + 1);
        }
        mostrarPangramaAleatorio();
    }
    
    private void mostrarInforme() {
        StringBuilder informe = new StringBuilder("Informe de Escritura al Tacto:\n\n");
        informe.append("Pulsaciones Correctas: ").append(pulsacionesCorrectas).append("\n");
        informe.append("Pulsaciones Incorrectas: ").append(pulsacionesIncorrectas).append("\n\n");
        informe.append("Teclas con Dificultades:\n");
        for (Map.Entry<Character, Integer> entry : teclasDificultad.entrySet()) {
            informe.append("Tecla: ").append(entry.getKey()).append(" - Dificultad: ").append(entry.getValue()).append(" veces\n");
        }
        JOptionPane.showMessageDialog(this, informe.toString(), "Informe Final", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { AplicacionTeclado app = new AplicacionTeclado();
        app.addWindowListener(new java.awt.event.WindowAdapter() { 
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        }
        });
        });
        
        
    }
    
}
