/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte5finalaplicacionteclado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Parte5finalAplicacionTeclado extends JFrame implements ActionListener{

    
    public Parte5finalAplicacionTeclado() { 
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
    
    
    
    public static void main(String[] args) {
        
    }
    
}
