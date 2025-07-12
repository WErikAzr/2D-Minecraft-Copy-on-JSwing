package minecraftfinal.herramientas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Pico extends Herramienta {

    private static final int clavePiedra = 1;
    private static final int claveBedrcok = 0; 
    
    public Pico() {
       this.nombreHerramienta = "Pico";
         
    }
   
    public Image getImagenPico(){
         try {
            BufferedImage imagenPico = ImageIO.read(new File("herramientaPico.jpg"));
            Image scaledImage = imagenPico.getScaledInstance(anchuraImagenHerramienta, alturaImagenHerramienta, Image.SCALE_SMOOTH);
            return scaledImage;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    
    
    @Override
    public boolean romperBloque(int tipoBloqueActual) {
          if (tipoBloqueActual == clavePiedra) {
            
            return true; // Bloque roto con éxito
        }
        // El pico no puede romper Bedrock, Tierra, Madera, Aire
        
        return false; // No se pudo romper el bloque
    }
    
}
