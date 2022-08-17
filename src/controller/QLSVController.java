package controller;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        if(cm.equals("Them")) {
            this.view.xoaForm();
            this.view.model.setLuaChon("Them");
        } else if(cm.equals("Luu")) {
            // Bắt lỗi khi người dùng nhập sai kiểu dữ liệu
            try {
                this.view.thucHienThemThiSinh();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if(cm.equals("Cap nhat")) {
            this.view.hienThiThongTinThiSinhDaChon();
        } else if(cm.equals("Xoa")) {
            this.view.thucHienXoa();
        } else if(cm.equals("Huy bo")) {
            this.view.xoaForm();
        } else if(cm.equals("Tim")) {
            this.view.thucHienTim();
        } else if(cm.equals("Huy")) {
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
