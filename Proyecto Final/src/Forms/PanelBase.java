/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase para hacer una plantilla de Panel.
 * @author Krystel Baca
 */
public class PanelBase extends JPanel {
    
    public PanelBase() {
        this.setSize(400, 280);
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension tamano = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/imagenes/fondopng.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamano.width, tamano.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
