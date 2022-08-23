package running;


import view.StudentManagementView;

import java.io.IOException;

public class running {
    public static void main(String[] args) throws IOException {
        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new StudentManagementView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
