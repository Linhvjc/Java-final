package controller;

import view.StudentManagementView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementController implements ActionListener {
    public StudentManagementView view;

    public StudentManagementController(StudentManagementView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();

        // Xử lý khi nhấn vào từng nút
        if(cm.equals("Add")) {
            this.view.deleteForm();
        } else if(cm.equals("Save student")) {
            // Bắt lỗi khi người dùng nhập sai kiểu dữ liệu
            try {
                this.view.handleAddStudent();
            } catch (Exception e1) {
//                this.view.deleteForm();
                JOptionPane.showMessageDialog(view, "Please enter full information !\n" +
                        "Or your information is not correct!","Invalid information",JOptionPane.ERROR_MESSAGE);
            }
        } else if(cm.equals("Update")) {
            try {
                this.view.displayStudentSelected();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(view, "Please select a student",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if(cm.equals("Delete")) {
            try {
                this.view.handleDeleteStudent();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(view, "Please select a student",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if(cm.equals("Reset")) {
            this.view.deleteForm();
        } else if(cm.equals("Search")) {
            this.view.handleSearchStudent();
        } else if(cm.equals("Reload")) {
            this.view.handleReLoadData();
        } else if(cm.equals("About me")) {
            this.view.displayAbout();
        } else if(cm.equals("Exit")) {
            this.view.exitProgram();
        } else if(cm.equals("Save")) {
            try {
                this.view.handleSaveFile();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Your data is empty",
                        "Cannot Save",JOptionPane.ERROR_MESSAGE);
            }
        } else if(cm.equals("Open")) {
            try {
                this.view.handleOpenFile();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Your file is empty or cannot open",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
