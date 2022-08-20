package controller;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class QLSVController implements ActionListener {
    public QLSVView view;

    public QLSVController(QLSVView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();

        // Xử lý khi nhấn vào từng nút
        if(cm.equals("Add")) {
            this.view.xoaForm();
            this.view.model.setLuaChon("Them");
        } else if(cm.equals("Save student")) {
            // Bắt lỗi khi người dùng nhập sai kiểu dữ liệu
            try {
                this.view.thucHienThemThiSinh();
            } catch (Exception e1) {
                this.view.xoaForm();
                JOptionPane.showMessageDialog(view, "Please enter full information !\n" +
                        "Or your information is not correct!","Invalid information",JOptionPane.ERROR_MESSAGE);
            }
        } else if(cm.equals("Update")) {
            this.view.hienThiThongTinThiSinhDaChon();
        } else if(cm.equals("Delete")) {
            this.view.thucHienXoa();
        } else if(cm.equals("Cancel")) {
            this.view.xoaForm();
        } else if(cm.equals("Search")) {
            this.view.thucHienTim();
        } else if(cm.equals("Reload")) {
            this.view.thucHienTaiLaiDuLieu();
        } else if(cm.equals("About me")) {
            this.view.hienThiAbout();
        } else if(cm.equals("Exit")) {
            this.view.thoatKhoiChuongTrinh();
        } else if(cm.equals("Save")) {
            this.view.thucHienSaveFile();
        } else if(cm.equals("Open")) {
            this.view.thucHienOpenFile();
        }
    }
}
