
package parte2finalaplicacionteclado;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Parte2finalAplicacionTeclado extends JFrame implements ActionListener{

    
    public Parte2finalAplicacionTeclado() { 
        areaTexto = new JTextArea(10, 40);
        JScrollPane panelDesplazable = new JScrollPane(areaTexto); 
        JPanel panelTeclado = new JPanel(new GridLayout(4, 10)); 
        listaPangramas = new ArrayList<>();
        pulsacionesCorrectas = 0;
   
    public static void main(String[] args) {
        
    }
    
}
