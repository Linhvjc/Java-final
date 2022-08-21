package running;


import view.QLSVView;

import javax.swing.*;
import java.io.IOException;

public class running {
    public static void main(String[] args) throws IOException {
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new QLSVView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
