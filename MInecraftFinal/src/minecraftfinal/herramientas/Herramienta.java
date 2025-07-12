
package minecraftfinal.herramientas;

import javax.swing.JFrame;


public abstract class Herramienta extends JFrame{
    protected final int alturaImagenHerramienta = 20;
    protected final int anchuraImagenHerramienta = 20;
    protected String nombreHerramienta; 
    
    public abstract boolean romperBloque(int tipoBloqueActual); 

       
    
}
