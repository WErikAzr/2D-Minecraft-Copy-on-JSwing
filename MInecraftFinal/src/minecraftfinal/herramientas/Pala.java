
package minecraftfinal.herramientas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pala extends Herramienta {
    
    private static final int claveTierra = 2;
    private static final int clavePasto = 3;
    
    public Pala(){
        this.nombreHerramienta = "Pico";
    }
    
     public Image getImagenPala(){
         try {
            BufferedImage imagenPala = ImageIO.read(new File("herramientaPala.jpg"));
            Image scaledImage = imagenPala.getScaledInstance(anchuraImagenHerramienta, alturaImagenHerramienta, Image.SCALE_SMOOTH);
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
   // El pico es efectivo contra la piedra
        if (tipoBloqueActual == claveTierra || tipoBloqueActual ==clavePasto) {
           
            return true; // Bloque roto con éxito
        }
       
        return false; // No se pudo romper el bloque

    }
}
