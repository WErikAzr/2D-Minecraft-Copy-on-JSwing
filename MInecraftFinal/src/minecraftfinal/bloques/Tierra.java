
package minecraftfinal.bloques;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static minecraftfinal.bloques.Bloque.alturaImagenBloque;
import static minecraftfinal.bloques.Bloque.anchuraImagenBloque;

public class Tierra {
     public Image getImagenTierra() {
        try {
            BufferedImage imagenTierra = ImageIO.read(new File("bloqueTierra.jpg"));
            Image scaledImage = imagenTierra.getScaledInstance(anchuraImagenBloque, alturaImagenBloque, Image.SCALE_SMOOTH);
            return scaledImage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
