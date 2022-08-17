package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import controller.QLSVController;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

public class QLSVView extends JFrame {

    public JRadioButton radioButton_male;
    public JRadioButton radioButton_female;
    public ButtonGroup btng_sex;
    public JComboBox comboBox_location_search;
    public JComboBox comboBox_location;
    public QLSVModel model;
    private JPanel contentPane;
    public JTextField textField_studentID_search;
    public JTable table;
    public JTextField textField_ID;
    public JTextField textField_studentName;
    public JTextField textField_dob;
    public JTextField textField_grade1;
    public JTextField textField_grade2;
    public JTextField textField_grade3;


    /**
     * Create the frame.
     */
    public QLSVView() {
        this.model = new QLSVModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 803, 543);

        ActionListener action = new QLSVController(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.addActionListener(action);
        menuBar.add(menuFile);

        JMenuItem menuOpen = new JMenuItem("Open");
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuExit);

        JMenu menuAbout = new JMenu("About");
        menuAbout.addActionListener(action);
        menuBar.add(menuAbout);

        JMenuItem menuAboutMe = new JMenuItem("About me");
        menuAboutMe.addActionListener(action);
        menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuAbout.add(menuAboutMe);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 10));

        JPanel panel_header = new JPanel();
        contentPane.add(panel_header, BorderLayout.NORTH);
        panel_header.setLayout(new GridLayout(1, 3, 5, 5));

        JPanel panel_searchLocation = new JPanel();
        panel_header.add(panel_searchLocation);
        panel_searchLocation.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel jLabel_location = new JLabel("Que quan", SwingConstants.CENTER);
        jLabel_location.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panel_searchLocation.add(jLabel_location);

        comboBox_location_search = new JComboBox();
        // Thêm từng tỉnh vào comboBox
        ArrayList<Tinh> listTinh = Tinh.getDSTinh();
        comboBox_location_search.addItem("");
        for(Tinh tinh : listTinh) {
            comboBox_location_search.addItem(tinh.getTenTinh());
        }
        panel_searchLocation.add(comboBox_location_search);

        JPanel panel_searchID = new JPanel();
        panel_header.add(panel_searchID);
        panel_searchID.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel label_studentID = new JLabel("Ma Thi Sinh", SwingConstants.CENTER);
        panel_searchID.add(label_studentID);

        textField_studentID_search = new JTextField();
        panel_searchID.add(textField_studentID_search);
        textField_studentID_search.setColumns(10);

        JPanel panel_searchBtn = new JPanel();
        panel_header.add(panel_searchBtn);
        panel_searchBtn.setLayout(new GridLayout(1, 2, 20, 0));

        JButton btnSearch = new JButton("Tim");
        btnSearch.addActionListener(action);
        panel_searchBtn.add(btnSearch);

        JButton btnReload = new JButton("Huy");
        btnReload.addActionListener(action);
        panel_searchBtn.add(btnReload);

        JPanel panel_content = new JPanel();
        contentPane.add(panel_content, BorderLayout.CENTER);
        panel_content.setLayout(new GridLayout(2, 1, 5, 5));

        JPanel panel_contentTable = new JPanel();
        panel_content.add(panel_contentTable);
        panel_contentTable.setLayout(new BorderLayout(0, 0));

        JLabel label_body_header = new JLabel("Danh sach thi sinh");
        label_body_header.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_contentTable.add(label_body_header, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        panel_contentTable.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Ma Thi Sinh", "Ho va ten", "Que quan", "Ngay sinh", "Gioi tinh", "Diem 1", "Diem 2", "Diem 3"
                }
        ));
        scrollPane.setViewportView(table);

        JPanel panel_contentForm = new JPanel();
        panel_content.add(panel_contentForm);
        panel_contentForm.setLayout(new BorderLayout(0, 0));

        JLabel label_student_info = new JLabel("Thong tin thi sinh");
        label_student_info.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_contentForm.add(label_student_info, BorderLayout.NORTH);

        JPanel panel_contentFormBody = new JPanel();
        panel_contentForm.add(panel_contentFormBody, BorderLayout.CENTER);
        panel_contentFormBody.setLayout(new GridLayout(1, 2, 5, 5));

        JPanel panel_contentFormBodyLeft = new JPanel();
        panel_contentFormBody.add(panel_contentFormBodyLeft);
        panel_contentFormBodyLeft.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label_studentID_form = new JLabel("Ma Thi Sinh", SwingConstants.CENTER);
        panel_contentFormBodyLeft.add(label_studentID_form);

        textField_ID = new JTextField();
        panel_contentFormBodyLeft.add(textField_ID);
        textField_ID.setColumns(10);

        JLabel label_studentName = new JLabel("Ho va ten", SwingConstants.CENTER);
        panel_contentFormBodyLeft.add(label_studentName);

        textField_studentName = new JTextField();
        panel_contentFormBodyLeft.add(textField_studentName);
        textField_studentName.setColumns(10);

        JLabel lable_location_form = new JLabel("Que quan", SwingConstants.CENTER);
        panel_contentFormBodyLeft.add(lable_location_form);

        comboBox_location = new JComboBox();
        // Thêm từng tỉnh vào comboBox
        comboBox_location.addItem("");
        for(Tinh tinh : listTinh) {
            comboBox_location.addItem(tinh.getTenTinh());
        }
        panel_contentFormBodyLeft.add(comboBox_location);

        JLabel label_dob = new JLabel("Ngay sinh", SwingConstants.CENTER);
        panel_contentFormBodyLeft.add(label_dob);

        textField_dob = new JTextField();
        panel_contentFormBodyLeft.add(textField_dob);
        textField_dob.setColumns(10);

        JPanel panel_contentFormBodyRight = new JPanel();
        panel_contentFormBody.add(panel_contentFormBodyRight);
        panel_contentFormBodyRight.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label_sex = new JLabel("Gioi Tinh", SwingConstants.CENTER);
        panel_contentFormBodyRight.add(label_sex);

        JPanel panel_Sex = new JPanel();
        panel_contentFormBodyRight.add(panel_Sex);
        panel_Sex.setLayout(new GridLayout(1, 2, 0, 0));

        radioButton_male = new JRadioButton("Nam");
        panel_Sex.add(radioButton_male);

        radioButton_female = new JRadioButton("Nu");
        panel_Sex.add(radioButton_female);

        // Tạo ButtonGroup cho 2 button giới tính
        btng_sex = new ButtonGroup();
        btng_sex.add(radioButton_male);
        btng_sex.add(radioButton_female);

        JLabel lable_grade1 = new JLabel("Mon 1", SwingConstants.CENTER);
        panel_contentFormBodyRight.add(lable_grade1);

        textField_grade1 = new JTextField();
        panel_contentFormBodyRight.add(textField_grade1);
        textField_grade1.setColumns(10);

        JLabel lable_grade2 = new JLabel("Mon 2", SwingConstants.CENTER);
        panel_contentFormBodyRight.add(lable_grade2);

        textField_grade2 = new JTextField();
        panel_contentFormBodyRight.add(textField_grade2);
        textField_grade2.setColumns(10);

        JLabel lable_grade3 = new JLabel("Mon 3", SwingConstants.CENTER);
        panel_contentFormBodyRight.add(lable_grade3);

        textField_grade3 = new JTextField();
        panel_contentFormBodyRight.add(textField_grade3);
        textField_grade3.setColumns(10);

        JPanel panel_footer = new JPanel();
        contentPane.add(panel_footer, BorderLayout.SOUTH);
        panel_footer.setLayout(new GridLayout(1, 5, 20, 10));

        JButton btnAdd = new JButton("Them");
        btnAdd.addActionListener(action);
        panel_footer.add(btnAdd);

        JButton btnDelete = new JButton("Xoa");
        btnDelete.addActionListener(action);
        panel_footer.add(btnDelete);

        JButton btnUpdate = new JButton("Cap nhat");
        btnUpdate.addActionListener(action);
        panel_footer.add(btnUpdate);

        JButton btnSave = new JButton("Luu");
        btnSave.addActionListener(action);
        panel_footer.add(btnSave);

        JButton btnCancel = new JButton("Huy bo");
        btnCancel.addActionListener(action);
        panel_footer.add(btnCancel);


        this.setVisible(true);
    }


    /**
     * Các phương thức xử lý
     */


    // Phương thúc xoa toan bo thong tin tren form
    public void xoaForm() {
        textField_ID.setText("");
        textField_studentName.setText("");
        textField_studentID_search.setText("");
        textField_dob.setText("");
        textField_grade1.setText("");
        textField_grade2.setText("");
        textField_grade3.setText("");
        comboBox_location.setSelectedIndex(-1);
        btng_sex.clearSelection();
    }

    public void themThiSinhVaoTable (ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(
                new Object[]{ts.getMaThiSinh()+""
                        , ts.getTenThiSinh()
                        , ts.getQueQuan().getTenTinh()
                        , ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)
                        , (ts.isGioiTinh() ? "Nam" : "Nu")
                        , ts.getDiemMon1() +""
                        , ts.getDiemMon2() +""
                        , ts.getDiemMon3() +""
                });
    }

    public void themHoacCapNhatThiSinh(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(!this.model.kiemtraTonTai(ts)) {
            this.model.insert(ts);
            // Thêm hàng vào bảng
            this.themThiSinhVaoTable(ts);
        } else {
            this.model.update(ts);
            int soLuongDong = model_table.getRowCount();
            for(int i=0; i<soLuongDong; i++) {
                String id = model_table.getValueAt(i,0)+"";
                if(id.equals(ts.getMaThiSinh()+"")) {
                    model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
                    model_table.setValueAt(ts.getTenThiSinh()+"",i,1);
                    model_table.setValueAt(ts.getQueQuan().getTenTinh()+"",i,2);
                    model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)+"",i,3);
                    model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nu")+"",i,4);
                    model_table.setValueAt(ts.getDiemMon1()+"",i,5);
                    model_table.setValueAt(ts.getDiemMon2()+"",i,6);
                    model_table.setValueAt(ts.getDiemMon3()+"",i,7);

                }
            }
        }
    }

    public ThiSinh getThiSinhDangChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();  // index của dòng
        model_table.getValueAt(i_row,0);

        // Lấy dữ liệu
        int maThiSinh = Integer.parseInt(model_table.getValueAt(i_row,0) +"");
        String tenThiSinh = model_table.getValueAt(i_row,1) + "";
        Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row,2) + "");
        String s_ngaySinh = model_table.getValueAt(i_row,3) +"";
        Date ngaySinh = new Date(s_ngaySinh);
        String textGioiTinh = model_table.getValueAt(i_row,4) +"";
        boolean gioiTinh = textGioiTinh.equals("Nam");
        float diemMon1 = Float.parseFloat(model_table.getValueAt(i_row,5) +"");
        float diemMon2 = Float.parseFloat(model_table.getValueAt(i_row,6) +"");
        float diemMon3 = Float.parseFloat(model_table.getValueAt(i_row,7) +"");

        ThiSinh ts = new ThiSinh(maThiSinh,tenThiSinh,tinh,ngaySinh,gioiTinh,diemMon1,diemMon2,diemMon3);
        return ts;
    }

    public void hienThiThongTinThiSinhDaChon() {
        ThiSinh ts = getThiSinhDangChon();

        // Hiển thị thông tin thí sinh đã chọn lên form
        this.textField_ID.setText(ts.getMaThiSinh()+"");
        this.textField_studentName.setText(ts.getTenThiSinh()+"");
        this.comboBox_location.setSelectedItem(ts.getQueQuan().getTenTinh());
        String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
        this.textField_dob.setText(s_ngaySinh +"");
        if(ts.isGioiTinh()) {
            radioButton_male.setSelected(true);
        } else {
            radioButton_female.setSelected(true);
        }
        this.textField_grade1.setText(ts.getDiemMon1()+"");
        this.textField_grade2.setText(ts.getDiemMon2()+"");
        this.textField_grade3.setText(ts.getDiemMon3()+"");
    }

    public void thucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
        if (luaChon == JOptionPane.YES_OPTION) {
            ThiSinh ts = getThiSinhDangChon();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
    }

    public void thucHienThemThiSinh() {

        // Lấy dữ liệu
        int maThiSinh = Integer.parseInt(this.textField_ID.getText());
        String tenThiSinh = this.textField_studentName.getText();
        int queQuan = this.comboBox_location.getSelectedIndex() -1;
        Tinh tinh = Tinh.getTinhById(queQuan);
        Date ngaySinh = new Date(this.textField_dob.getText());
        boolean gioiTinh = true;

        if(this.radioButton_male.isSelected()) {
            gioiTinh = true;
        } else if(this.radioButton_female.isSelected()) {
            gioiTinh = false;
        }
        float diemMon1 = Float.parseFloat(this.textField_grade1.getText());
        float diemMon2 = Float.parseFloat(this.textField_grade2.getText());
        float diemMon3 = Float.parseFloat(this.textField_grade3.getText());

        // Thí sinh mới
        ThiSinh ts = new ThiSinh(maThiSinh,tenThiSinh,tinh,ngaySinh,gioiTinh,diemMon1,diemMon2,diemMon3);
        this.themHoacCapNhatThiSinh(ts);
        this.xoaForm();
    }

    public void thucHienTim() {
        // Gọi hàm hủy tìm kiếm trước
        this.thucHienTaiLaiDuLieu();

        // Thực hiện tìm kiếm
        int queQuan = this.comboBox_location_search.getSelectedIndex() -1;
        String maThiSinhTimKiem = this.textField_studentID_search.getText();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int soLuongDong = model_table.getRowCount();

        Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
        if(queQuan>=0) { // nếu có chọn quê quán
            Tinh tinhDaChon = Tinh.getTinhById(queQuan);
            for(int i=0; i<soLuongDong; i++) {
                String tenTinh = model_table.getValueAt(i,2)+"";
                String id = model_table.getValueAt(i,0) +"";
                if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
                    idCuaThiSinhCanXoa.add(Integer.valueOf(id));
                }
            }
        }
        if(maThiSinhTimKiem.length() >0) {  // Nếu đã nhập mã số sv
            for(int i=0; i<soLuongDong; i++) {
                String id = model_table.getValueAt(i,0)+"";
                if(!id.equals(maThiSinhTimKiem)) {
                    idCuaThiSinhCanXoa.add(Integer.valueOf(id));
                }
            }
        }

        for (Integer idCanXoa : idCuaThiSinhCanXoa) {
            soLuongDong = model_table.getRowCount();
            for(int i=0; i<soLuongDong; i++) {
                String idTrongTable = model_table.getValueAt(i,0) +"";
                if(idTrongTable.equals(idCanXoa.toString())) {
                    try {
                        model_table.removeRow(i);
                    } catch (Exception e) {

                    }
                    break;
                }
            }
        }


    }



    public void thucHienTaiLaiDuLieu() {
        // Xoa tat ca cac dong
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int soLuongDong = model_table.getRowCount();
            if(soLuongDong==0)
                break;
            else
                // Bắt lỗi khi xóa hàng
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        for (ThiSinh ts : this.model.getDsThiSinh()) {
            this.themThiSinhVaoTable(ts);
        }
    }

    public void hienThiAbout() {
        JOptionPane.showMessageDialog(this, "Copyright by Phan Nhat Linh");
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Ban co muon thoat khoi chuong trinh",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void saveFile(String path) {
        try {
            this.model.setTenFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            // Lưu đối tượng xuống
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Lưu từng thí sinh vào file
            for (ThiSinh ts : this.model.getDsThiSinh()) {
                oos.writeObject(ts);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thucHienSaveFile() {
        // Kiểm tra xem đã mở file hay chưa
        if(this.model.getTenFile().length()>0) {
            // Lưu lại với chính tên file đó
            saveFile(this.model.getTenFile());
        } else {
            // Mở cửa sổ để các tập tin file
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }

    public void openFile(File file) {
        ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
        try {
            this.model.setTenFile(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            // Lưu đối tượng xuống
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Tạo mảng mới để cập nhật tùng thí sinh vào Ds
            ThiSinh ts = null;
            while((ts = (ThiSinh) ois.readObject())!=null) {
                ds.add(ts);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.model.setDsThiSinh(ds);
    }

    public void thucHienOpenFile() {
        // Mở cửa sổ để các tập tin file
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            thucHienTaiLaiDuLieu();
        }
    }

}
