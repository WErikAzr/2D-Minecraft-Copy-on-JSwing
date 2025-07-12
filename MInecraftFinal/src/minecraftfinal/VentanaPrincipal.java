package minecraftfinal;

import minecraftfinal.herramientas.Pala;
import minecraftfinal.herramientas.Hacha;
import minecraftfinal.herramientas.Pico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import minecraftfinal.bloques.Bedrock;
import minecraftfinal.bloques.Madera;
import minecraftfinal.bloques.Pasto;
import minecraftfinal.bloques.Piedra;
import minecraftfinal.bloques.Tierra;
import minecraftfinal.herramientas.Herramienta;

public final class VentanaPrincipal extends JFrame implements ActionListener {
    
    Pico piquito = new Pico();
    Pala palita = new Pala();
    Hacha hachita = new Hacha();
    Herramienta herramientaActual = piquito;
    
    int capaInicial = 14;
    int filas = 10, columnas = 10, profundidad = 20;
    
    private final int[][][] matrizMundo = new int[filas][columnas][profundidad];

    private final int[][] matrizEstadoMinado = new int[filas][columnas];
    
    JButton[][] interfazGeneracionMundo = new JButton[filas][columnas];
    
    HashMap<Integer, ImageIcon> iconosDeBloque = new HashMap<>();
    private final int claveBloqueBedrock = 0;
    private final int claveBloquePiedra = 1;
    private final int claveBloqueTierra = 2;
    private final int claveBloquePasto = 3;
    private final int claveBloqueMadera = 4;
    
    Bedrock bloqueGenericoBedrock = new Bedrock();
    Tierra bloqueGenericoTierra = new Tierra();
    Piedra bloqueGenericoPiedra = new Piedra();
    Pasto bloqueGenericoPasto = new Pasto();
    Madera bloqueGenericoMadera = new Madera();
    
    ImageIcon imagenMadera = new ImageIcon(bloqueGenericoMadera.getImagenMadera());
    ImageIcon imagenBedrock = new ImageIcon(bloqueGenericoBedrock.getImagenBedrock());
    ImageIcon imagenTierra = new ImageIcon(bloqueGenericoTierra.getImagenTierra());
    ImageIcon imagenPiedra = new ImageIcon(bloqueGenericoPiedra.getImagenPiedra());
    ImageIcon imagenPasto = new ImageIcon(bloqueGenericoPasto.getImagenPasto());
    ImageIcon imagenPico = new ImageIcon(piquito.getImagenPico());
    ImageIcon imagenPala = new ImageIcon(palita.getImagenPala());
    ImageIcon imagenHacha = new ImageIcon(hachita.getImagenHacha());
    ImageIcon logoIcon = new ImageIcon("logo.jpg");
    Image logo = logoIcon.getImage();
    
    Rectangle tamanioVentanaPrincipal = new Rectangle(500, 500);

    //Generacion principal del mundo
    JPanel generacion = new JPanel(new GridLayout(10, 10));
    
    public VentanaPrincipal() {
        
        initComponents();
        generarMundo();
        
        this.add(generacion, BorderLayout.CENTER);
        this.add(crearPanelHerramientas(), BorderLayout.SOUTH);
        this.pack();
        
    }
    
    public void initComponents() {
        
        setTitle("Minecraft");
        setIconImage(logo);
        setBounds(tamanioVentanaPrincipal);
        setMinimumSize(tamanioVentanaPrincipal.getSize());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
    }

    //Metodo que crea el panel de herramientas. No indica el funcionamiento de éstas.
    public JPanel crearPanelHerramientas() {
        
        JPanel panelHerramientas = new JPanel();
        
        panelHerramientas.setLayout(new FlowLayout());
        
        JButton casillaUno = new JButton(imagenPico);
        JButton casillaDos = new JButton(imagenPala);
        JButton casillaTres = new JButton(imagenHacha);
        JLabel herramientaSeleccionada = new JLabel("Pico");
        herramientaSeleccionada.setHorizontalTextPosition(JLabel.CENTER);
        
        casillaUno.addActionListener((ActionEvent e) -> {
            herramientaSeleccionada.setText("Pico");
            herramientaActual = piquito;
        });
        
        casillaDos.addActionListener((ActionEvent e) -> {
            herramientaSeleccionada.setText("Pala");
            herramientaActual = palita;
        });
        
        casillaTres.addActionListener((ActionEvent e) -> {
            herramientaSeleccionada.setText("Hacha");
            herramientaActual = hachita;
        });
        
        panelHerramientas.add(casillaUno);
        panelHerramientas.add(casillaDos);
        panelHerramientas.add(casillaTres);
        panelHerramientas.add(herramientaSeleccionada);
        
        return panelHerramientas;
    }
    
    public void generarMundo() {
        
        iconosDeBloque.put(claveBloqueBedrock, imagenBedrock);
        iconosDeBloque.put(claveBloquePiedra, imagenPiedra);
        iconosDeBloque.put(claveBloqueTierra, imagenTierra);
        iconosDeBloque.put(claveBloquePasto, imagenPasto);
        iconosDeBloque.put(claveBloqueMadera, imagenMadera);
        
        JButton bloqueActual = new JButton();
        JButton bloqueAMostrar = new JButton();
        
        int tipoBloque = 0;
        for (int k = 0; k < profundidad; k++) {
            for (int j = 0; j < columnas; j++) {
                for (int i = 0; i < filas; i++) {
                    
                    if (k >= 0 && k <= 2) {
                        tipoBloque = claveBloqueBedrock;
                    } else if (k >= 3 && k <= 6) {
                        tipoBloque = claveBloquePiedra;
                        
                    } else if (k >= 7 && k <= 10) {
                        tipoBloque = claveBloqueTierra;
                        
                    } else if (k >= 11 && k <= 14) {
                        
                        double bloqueRandom = Math.random() * 100;
                        
                        if (bloqueRandom <= 30) {
                            tipoBloque = claveBloqueMadera;
                        } else if (bloqueRandom <= 70) {
                            tipoBloque = claveBloqueTierra;
                        } else {
                            tipoBloque = claveBloquePasto;
                        }
                        
                    }
                    matrizMundo[i][j][k] = tipoBloque;
                    tipoBloque = 0;
                }
            }
        }
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JButton bloqueVisible = new JButton();
                bloqueVisible.setPreferredSize(new Dimension(30, 30));

                // Todas las posiciones empiezan mostrando la 'capaInicialVisual'
                matrizEstadoMinado[i][j] = capaInicial;
                
                int tipoBloqueMostrado = matrizMundo[i][j][matrizEstadoMinado[i][j]];
                
                bloqueVisible.setIcon(getIconForBlockType(tipoBloqueMostrado));
                // Establecer el texto del botón a la capa actual (profundidad individual)
                bloqueVisible.setText(String.valueOf(matrizEstadoMinado[i][j]));
                bloqueVisible.setHorizontalTextPosition(SwingConstants.CENTER);
                // AQUI se aplica la alineación vertical
                bloqueVisible.setVerticalTextPosition(SwingConstants.CENTER); // CAMBIO CLAVE
                bloqueVisible.setForeground(new Color(0x54a9f8));
                bloqueVisible.setEnabled(true);
                
                bloqueVisible.putClientProperty("fila", i);
                bloqueVisible.putClientProperty("columna", j);
                
                bloqueVisible.addActionListener(this);
                generacion.add(bloqueVisible);
                interfazGeneracionMundo[i][j] = bloqueVisible;
            }
        }
        
    }
    
    private ImageIcon getIconForBlockType(int blockType) {
        return iconosDeBloque.get(blockType);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        
        if (clickedButton.getClientProperty("fila") != null) {
            int clickedFila = (int) clickedButton.getClientProperty("fila");
            int clickedColumna = (int) clickedButton.getClientProperty("columna");
            
            int profundidadIndividualActual = matrizEstadoMinado[clickedFila][clickedColumna];
            
            int tipoBloqueActual = matrizMundo[clickedFila][clickedColumna][profundidadIndividualActual];
            
            if (tipoBloqueActual == claveBloqueBedrock) {
                return;                
            }
            
            boolean bloqueRoto = herramientaActual.romperBloque(tipoBloqueActual);
            
            if (bloqueRoto) {
                int siguienteProfundidadIndividual = profundidadIndividualActual - 1;
                if (siguienteProfundidadIndividual >= 0) {
                    int tipoBloqueDeSiguienteCapa = matrizMundo[clickedFila][clickedColumna][siguienteProfundidadIndividual];
                    clickedButton.setIcon(getIconForBlockType(tipoBloqueDeSiguienteCapa));
                    clickedButton.setText(String.valueOf(siguienteProfundidadIndividual));
                    clickedButton.setVerticalTextPosition(SwingConstants.CENTER); // Opcional: reiterar si es necesario, pero ya está configurado.
                    matrizEstadoMinado[clickedFila][clickedColumna] = siguienteProfundidadIndividual;
                } else {
                    clickedButton.setIcon(null);
                    clickedButton.setText("Max"); // 
                    clickedButton.setVerticalTextPosition(SwingConstants.CENTER);
                    
                }
            } else {
                System.out.println("operacion no valida");
                
            }
        }
    }
}
