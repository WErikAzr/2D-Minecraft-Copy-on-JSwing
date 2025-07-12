
package minecraftfinal.herramientas;

import minecraftfinal.bloques.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Bloque extends JFrame{
    protected static int anchuraImagenBloque = 50;
    protected static int alturaImagenBloque = 50;
    
    //indica el tipo de herramienta con el que el bloque
    //podrá ser destruido
    
    protected int tipoDureza; 
    
    public Bloque(){
       this.tipoDureza = 0;
    }
    

    
}
