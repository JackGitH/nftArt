package main.java.nag;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

public class Application extends JFrame {

    public static final int PIXELS_W = 1181;
    public static final int PIXELS_H = 1181;
    public static final int F_I_PIXELS_W = 1181;
    public static final int F_I_PIXELS_H = 1181;
    public static final int RENDER_PER_MINUTE = 240;
    public static final double SCALE_RATE = 1;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Application());
    }

    private static final long serialVersionUID = 1L;

    // 猫
/*  public static final int PIXELS_W = 1240;
    public static final int PIXELS_H = 1754;
    public static final int F_I_PIXELS_W = 620;
    public static final int F_I_PIXELS_H = 877;
    public static final int RENDER_PER_MINUTE = 240;
    public static final double SCALE_RATE = 0.5;*/

    // 狗

    public Application() {
        initUI();
    }

    private void initUI() {
        setTitle("NAG");
        // setSize(PIXELS_W, PIXELS_H + 20);

        setSize(F_I_PIXELS_W, F_I_PIXELS_H );
        setVisible(true);
        //this.setPreferredSize(new Dimension(F_I_PIXELS_W, F_I_PIXELS_H));
        //this.pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        var folder = new File("outputs/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        if (!folder.exists()) {
            folder.mkdirs();
        }

        var dogs = new Collection("assets/TestFile");
        dogs.build();

        // add(new CardPrinter(folder, PIXELS_W, PIXELS_H, RENDER_PER_MINUTE, dogs));
        add(new FeaturedImagePrinter(new PrintOptions(folder, F_I_PIXELS_W, F_I_PIXELS_H), dogs));
    }
}
