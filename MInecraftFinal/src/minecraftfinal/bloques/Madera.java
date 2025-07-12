
package minecraftfinal.bloques;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static minecraftfinal.bloques.Bloque.alturaImagenBloque;
import static minecraftfinal.bloques.Bloque.anchuraImagenBloque;


public class Madera {
     public Image getImagenMadera() {
        try {
            BufferedImage imagenPasto = ImageIO.read(new File("bloqueMadera.jpg"));
            Image scaledImage = imagenPasto.getScaledInstance(anchuraImagenBloque, alturaImagenBloque, Image.SCALE_SMOOTH);
            return scaledImage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
