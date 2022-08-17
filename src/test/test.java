package test;


import view.QLSVView;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new QLSVView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
