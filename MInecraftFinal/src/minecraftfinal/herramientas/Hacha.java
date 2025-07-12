
package minecraftfinal.herramientas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Hacha extends Herramienta{
    
    
    private static final int claveMadera = 4;
    
    
    public Hacha(){
        this.nombreHerramienta = "Hacha";
    }
    
     public Image getImagenHacha(){
         try {
            BufferedImage imagenHacha = ImageIO.read(new File("herramientaHacha.jpg"));
            Image scaledImage = imagenHacha.getScaledInstance(anchuraImagenHerramienta, alturaImagenHerramienta, Image.SCALE_SMOOTH);
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
        if(tipoBloqueActual == claveMadera){
            return true;
        }
        return false;
    }
     
     
}
