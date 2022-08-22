package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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

        // Set các đặc tính cho toàn bộ chương trình
        this.setTitle("Student manager system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        this.setLocationRelativeTo(null);
        ActionListener action = new QLSVController(this);

        // Set Icon => JFrame
        URL urlIconNotepad = QLSVView.class.getResource("../assets/main_icon.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
        this.setIconImage(img);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.addActionListener(action);
        menuBar.add(menuFile);

        JMenuItem menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        menuOpen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/open_icon.png"))));
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menuSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/save_icon.png"))));
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
        menuExit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/quit_icon.png"))));
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuExit);

        JMenu menuAbout = new JMenu("About");
        menuAbout.addActionListener(action);
        menuBar.add(menuAbout);

        JMenuItem menuAboutMe = new JMenuItem("About me");
        menuAboutMe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/info_icon.png"))));
        menuAboutMe.addActionListener(action);
        menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuAbout.add(menuAboutMe);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(0, 10));

        // Header panel
        JPanel panel_header = new JPanel();
        panel_header.setBackground(Color.WHITE);
        contentPane.add(panel_header, BorderLayout.NORTH);
        panel_header.setLayout(new GridLayout(1, 3, 5, 5));

        JPanel panel_searchLocation = new JPanel();
        panel_searchLocation.setBackground(Color.WHITE);
        panel_header.add(panel_searchLocation);
        panel_searchLocation.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel jLabel_location = new JLabel("Home Town", SwingConstants.CENTER);
        jLabel_location.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_searchLocation.add(jLabel_location);

        comboBox_location_search = new JComboBox();
        comboBox_location_search.setBackground(Color.WHITE);
        comboBox_location_search.setForeground(Color.BLACK);
        // Thêm từng tỉnh vào comboBox
        ArrayList<Tinh> listTinh = Tinh.getDSTinh();
        comboBox_location_search.addItem("");
        for(Tinh tinh : listTinh) {
            comboBox_location_search.addItem(tinh.getTenTinh());
        }
        panel_searchLocation.add(comboBox_location_search);

        JPanel panel_searchID = new JPanel();
        panel_searchID.setBackground(Color.WHITE);
        panel_header.add(panel_searchID);
        panel_searchID.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel label_studentID = new JLabel("Student ID", SwingConstants.CENTER);
        label_studentID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_searchID.add(label_studentID);

        textField_studentID_search = new JTextField();
        panel_searchID.add(textField_studentID_search);
        textField_studentID_search.setColumns(10);

        JPanel panel_searchBtn = new JPanel();
        panel_searchBtn.setBackground(Color.WHITE);
        panel_header.add(panel_searchBtn);
        panel_searchBtn.setLayout(new GridLayout(1, 2, 20, 0));

        JButton btnSearch = new JButton("Search");
        btnSearch.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/search_icon.png"))));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSearch.setBackground(new Color(132, 112 ,255));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(action);
        panel_searchBtn.add(btnSearch);

        JButton btnReload = new JButton("Reload");
        btnReload.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/reload_icon.png"))));
        btnReload.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnReload.setBackground(new Color(0, 139 ,0));
        btnReload.setForeground(Color.WHITE);
        btnReload.setFocusPainted(false);
        btnReload.addActionListener(action);
        panel_searchBtn.add(btnReload);

        // Content panel
        JPanel panel_content = new JPanel();
        panel_content.setBackground(Color.WHITE);
        contentPane.add(panel_content, BorderLayout.CENTER);
        panel_content.setLayout(new GridLayout(2, 1, 5, 5));
        Border border3 = panel_content.getBorder();
        Border margin3 = new EmptyBorder(0,0,10,0);
        panel_content.setBorder(new CompoundBorder(border3, margin3));

        JPanel panel_contentTable = new JPanel();
        panel_contentTable.setBackground(Color.WHITE);
        panel_content.add(panel_contentTable);
        panel_contentTable.setLayout(new BorderLayout(0, 0));



        JLabel label_body_header = new JLabel("List of students", SwingConstants.CENTER);
        label_body_header.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_contentTable.add(label_body_header, BorderLayout.NORTH);
        Border border = label_body_header.getBorder();
        Border margin = new EmptyBorder(0,0,10,0);
        label_body_header.setBorder(new CompoundBorder(border, margin));

        JScrollPane scrollPane = new JScrollPane();
        panel_contentTable.add(scrollPane, BorderLayout.CENTER);



        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Student ID", "Full name", "Home town", "Date of birth", "Sex", "Grade 1", "Grade 2", "Grade 3"
                }
        ));
        table.setBackground(new Color(81, 220, 175));
        table.setForeground(Color.WHITE);

        // Thay đổi kích cỡ, màu sắc phần heading của từng cột
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Verdana", Font.PLAIN, 14));
        tableHeader.setBackground(new Color(54, 48, 74));
        tableHeader.setForeground(Color.WHITE);
        table.setRowHeight(20);


        // Làm cho người dùng không thể chỉnh sửa trực tiếp trên bảng
        table.setDefaultEditor(Object.class, null);
        scrollPane.setViewportView(table);

        JPanel panel_contentForm = new JPanel();
        panel_contentForm.setBackground(Color.WHITE);
        panel_content.add(panel_contentForm);
        panel_contentForm.setLayout(new BorderLayout(0, 0));

        JLabel label_student_info = new JLabel("Student form", SwingConstants.CENTER);
        label_student_info.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_contentForm.add(label_student_info, BorderLayout.NORTH);
        Border border2 = label_student_info.getBorder();
        Border margin2 = new EmptyBorder(0,0,10,0);
        label_student_info.setBorder(new CompoundBorder(border2, margin2));

        JPanel panel_contentFormBody = new JPanel();
        panel_contentFormBody.setBackground(Color.WHITE);
        panel_contentForm.add(panel_contentFormBody, BorderLayout.CENTER);
        panel_contentFormBody.setLayout(new GridLayout(1, 2, 5, 5));

        JPanel panel_contentFormBodyLeft = new JPanel();
        panel_contentFormBodyLeft.setBackground(Color.WHITE);
        panel_contentFormBody.add(panel_contentFormBodyLeft);
        panel_contentFormBodyLeft.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label_studentID_form = new JLabel("Student ID:", SwingConstants.CENTER);
        label_studentID_form.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(label_studentID_form);


        textField_ID = new JTextField();
        textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(textField_ID);
        textField_ID.setColumns(10);

        JLabel label_studentName = new JLabel("Full name:", SwingConstants.CENTER);
        label_studentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(label_studentName);

        textField_studentName = new JTextField();
        textField_studentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(textField_studentName);
        textField_studentName.setColumns(10);

        JLabel lable_location_form = new JLabel("Home town:", SwingConstants.CENTER);
        lable_location_form.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(lable_location_form);

        comboBox_location = new JComboBox();
        comboBox_location.setBackground(Color.WHITE);
        comboBox_location.setForeground(Color.BLACK);
        // Thêm từng tỉnh vào comboBox
        comboBox_location.addItem("");
        for(Tinh tinh : listTinh) {
            comboBox_location.addItem(tinh.getTenTinh());
        }
        panel_contentFormBodyLeft.add(comboBox_location);

        JLabel label_dob = new JLabel("Date of birth (MM/dd/yyyy):", SwingConstants.CENTER);
        label_dob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(label_dob);

        textField_dob = new JTextField();
        textField_dob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(textField_dob);
        textField_dob.setColumns(10);

        JPanel panel_contentFormBodyRight = new JPanel();
        panel_contentFormBodyRight.setBackground(Color.WHITE);
        panel_contentFormBody.add(panel_contentFormBodyRight);
        panel_contentFormBodyRight.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label_sex = new JLabel("Sex:", SwingConstants.CENTER);
        label_sex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(label_sex);

        JPanel panel_Sex = new JPanel();
        panel_Sex.setBackground(Color.WHITE);
        panel_contentFormBodyRight.add(panel_Sex);
        panel_Sex.setLayout(new GridLayout(1, 2, 0, 0));

        radioButton_male = new JRadioButton("Male");
        radioButton_male.setBackground(Color.white);
        radioButton_male.setFocusPainted(false);
        radioButton_male.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panel_Sex.add(radioButton_male);

        radioButton_female = new JRadioButton("Female");
        radioButton_female.setBackground(Color.white);
        radioButton_female.setFocusPainted(false);
        radioButton_female.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panel_Sex.add(radioButton_female);

        // Tạo ButtonGroup cho 2 button giới tính
        btng_sex = new ButtonGroup();
        btng_sex.add(radioButton_male);
        btng_sex.add(radioButton_female);

        JLabel label_grade1 = new JLabel("Grade 1:", SwingConstants.CENTER);
        label_grade1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(label_grade1);

        textField_grade1 = new JTextField();
        textField_grade1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(textField_grade1);
        textField_grade1.setColumns(10);

        JLabel label_grade2 = new JLabel("Grade 2:", SwingConstants.CENTER);
        label_grade2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(label_grade2);

        textField_grade2 = new JTextField();
        textField_grade2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(textField_grade2);
        textField_grade2.setColumns(10);

        JLabel label_grade3 = new JLabel("Grade 3:", SwingConstants.CENTER);
        label_grade3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(label_grade3);

        textField_grade3 = new JTextField();
        textField_grade3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyRight.add(textField_grade3);
        textField_grade3.setColumns(10);

        // Footer panel
        JPanel panel_footer = new JPanel();
        panel_footer.setBackground(Color.WHITE);
        contentPane.add(panel_footer, BorderLayout.SOUTH);
        panel_footer.setLayout(new GridLayout(1, 5, 20, 10));

        JButton btnAdd = new JButton("Add");
        btnAdd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/add_icon.png"))));
        btnAdd.setBackground(new Color(243, 165, 184));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.addActionListener(action);
        panel_footer.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/delete_icon.png"))));
        btnDelete.setBackground(new Color(243, 165, 184));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.addActionListener(action);
        panel_footer.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/update_icon.png"))));
        btnUpdate.setBackground(new Color(243, 165, 184));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnUpdate.addActionListener(action);
        panel_footer.add(btnUpdate);

        JButton btnSave = new JButton("Save student");
        btnSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/saveStudent_icon.png"))));
        btnSave.setBackground(new Color(243, 165, 184));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFocusPainted(false);
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSave.addActionListener(action);
        panel_footer.add(btnSave);

        JButton btnCancel = new JButton("Reset");
        btnCancel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(QLSVView.class.getResource("../assets/reset_icon.png"))));
        btnCancel.setBackground(new Color(243, 165, 184));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFocusPainted(false);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancel.addActionListener(action);
        panel_footer.add(btnCancel);


        this.setVisible(true);
    }





/**
 * Các phương thức xử lý
 */



    /**
     * Phương thúc xoa toan bo thong tin tren form
     */
    public void xoaForm() {
        textField_ID.setText("");
        textField_ID.setEditable(true);
        textField_studentName.setText("");
        textField_studentID_search.setText("");
        textField_dob.setText("");
        textField_grade1.setText("");
        textField_grade2.setText("");
        textField_grade3.setText("");
        comboBox_location.setSelectedIndex(-1);
        btng_sex.clearSelection();
    }

    /**
     * Phương thúc thêm sinh viên vào bảng
     */
    public void themThiSinhVaoTable (ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[] {
                ts.getMaThiSinh() + ""
                , ts.getTenThiSinh()
                , ts.getQueQuan().getTenTinh()
                , ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) +
                "/" + (ts.getNgaySinh().getYear() + 1900)
                , (ts.isGioiTinh() ? "Male" : "Female")
                , ts.getDiemMon1() + ""
                , ts.getDiemMon2() + "",
                ts.getDiemMon3() + "", });
    }

    /**
     * Phương thúc thêm hoặc cập nhật sinh viên vào bảng và model
     */
    public void themHoacCapNhatThiSinh(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if (!this.model.kiemtraTonTai(ts)) {
            this.model.insert(ts);
            this.themThiSinhVaoTable(ts);
        } else {
            this.model.update(ts);
            int soLuongDong = model_table.getRowCount();
            for (int i = 0; i < soLuongDong; i++) {
                String id = model_table.getValueAt(i, 0) + "";
                if (id.equals(ts.getMaThiSinh() + "")) {
                    model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
                    model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
                    model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
                    model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
                            + (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
                    model_table.setValueAt((ts.isGioiTinh() ? "Male" : "Female"), i, 4);
                    model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
                    model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
                    model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
                }
            }
        }
    }

    /**
     * Phương thúc lấy thông tin của sinh viên đã chọn
     */
    public ThiSinh getThiSinhDangChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();  // index của dòng
        model_table.getValueAt(i_row,0);

        // Lấy dữ liệu
        int maThiSinh = Integer.parseInt(model_table.getValueAt(i_row,0) +"");
        String tenThiSinh = model_table.getValueAt(i_row,1) + "";
        Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row,2) + "");
        String s_ngaySinh = model_table.getValueAt(i_row,3) +"";
        String[] arr = s_ngaySinh.split("/");
        int date= Integer.parseInt(arr[0]);
        int month= Integer.parseInt(arr[1]);
        int year= Integer.parseInt(arr[2]);
        Date ngaySinh = new Date(year,month,date);
        String textGioiTinh = model_table.getValueAt(i_row,4) +"";
        boolean gioiTinh = textGioiTinh.equals("Male");
        float diemMon1 = Float.parseFloat(model_table.getValueAt(i_row,5) +"");
        float diemMon2 = Float.parseFloat(model_table.getValueAt(i_row,6) +"");
        float diemMon3 = Float.parseFloat(model_table.getValueAt(i_row,7) +"");

        ThiSinh ts = new ThiSinh(maThiSinh,tenThiSinh,tinh,ngaySinh,gioiTinh,diemMon1,diemMon2,diemMon3);
        return ts;
    }

    /**
     * Phương thúc hiển thị thông tin của sinh viên đã chọn
     */
    public void hienThiThongTinThiSinhDaChon() {
        ThiSinh ts;
        try {
            ts = getThiSinhDangChon();
        } catch (Exception e) {
            throw e;
        }

        // Hiển thị thông tin thí sinh đã chọn lên form
        this.textField_ID.setText(ts.getMaThiSinh()+"");
        this.textField_ID.setEditable(false);
        this.textField_studentName.setText(ts.getTenThiSinh()+"");
        this.comboBox_location.setSelectedItem(ts.getQueQuan().getTenTinh());
        String s_ngaySinh = (ts.getNgaySinh().getMonth()) +"/"+(ts.getNgaySinh().getDate())
                +"/"+ (ts.getNgaySinh().getYear());
//        String s_ngaySinh = ts.getNgaySinh().getDate() +"/"+(ts.getNgaySinh().getMonth()+1)
//                +"/"+ (ts.getNgaySinh().getYear()+1900);
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

    /**
     * Phương thúc xóa sinh viên đã chọn
     */
    public void thucHienXoa() throws Exception {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if(i_row < 0) throw new Exception();
        int luaChon = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected line?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (luaChon == JOptionPane.YES_OPTION) {
            ThiSinh ts = getThiSinhDangChon();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
        this.xoaForm();
    }

    /**
     * Phương thúc xóa sinh viên đã chọn
     */
    public void thucHienThemThiSinh() throws Exception {
        this.textField_ID.setEditable(true);

        // Lấy dữ liệu
        int maThiSinh = Integer.parseInt(this.textField_ID.getText());
        String tenThiSinh = this.textField_studentName.getText();
        int queQuan = this.comboBox_location.getSelectedIndex() -1;
        Tinh tinh = Tinh.getTinhById(queQuan);
//        String[] time_data = this.textField_dob.getText().split("/");
//        Date newDate = new Date(this.textField_dob.getText());
//        int date = newDate.getDate();
//        int month = newDate.getMonth();
//        int year = newDate.getYear();
//        Date ngaySinh = new Date(year,month,date);
        Date ngaySinh = new Date(this.textField_dob.getText());
//        if (ngaySinh.getDate()) throw new Exception();
        boolean gioiTinh = true;

        if(this.radioButton_male.isSelected()) {
            gioiTinh = true;
        } else if(this.radioButton_female.isSelected()) {
            gioiTinh = false;
        } else {
            throw new Exception();
        }

        // validate khi nhập điểm >10 hoặc <0
        float diemMon1 = Float.parseFloat(this.textField_grade1.getText());
        float diemMon2 = Float.parseFloat(this.textField_grade2.getText());
        float diemMon3 = Float.parseFloat(this.textField_grade3.getText());
        if (diemMon1 > 10 || diemMon1 <0) throw new Exception();
        if (diemMon2 > 10 || diemMon2 <0) throw new Exception();
        if (diemMon3 > 10 || diemMon3 <0) throw new Exception();

        // validate Ngày tháng năm sinh
        String dateString = this.textField_dob.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try
        {
            Date javaDate = sdf.parse(dateString);
        } catch (Exception e) {
            throw e;
        }



        // Thí sinh mới
        ThiSinh ts = new ThiSinh(maThiSinh,tenThiSinh,tinh,ngaySinh,gioiTinh,diemMon1,diemMon2,diemMon3);
        this.themHoacCapNhatThiSinh(ts);
        this.xoaForm();
    }

    /**
     * Phương thức tìm kiếm sinh viên
     */
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
                        throw e;
                    }
                    break;
                }
            }
        }


    }


    /**
     * Phương thức tải lại dữ liệu trong bảng
     */
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
                    throw e;
                }
        }
        for (ThiSinh ts : this.model.getDsThiSinh()) {
            this.themThiSinhVaoTable(ts);
        }
    }

    /**
     * hiển thị cửa sổ aboutme
     */
    public void hienThiAbout() {
        JOptionPane.showMessageDialog(this, "Copyright by Phan Nhat Linh");
    }

    /**
     * Thoát khỏi chương trình
     */
    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit the program?",
                "Exit Program Message Box",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if(luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * lưu file
     */
    public void saveFile(String path) throws IOException {
        try {
            this.model.setTenFile(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Lưu từng thí sinh vào file
            for (ThiSinh ts : this.model.getDsThiSinh()) {
                oos.writeObject(ts);
            }
            oos.close();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * thực hiện lưu file
     */
    public void thucHienSaveFile() throws Exception {
        // Kiểm tra xem dữ liệu rỗng hay không
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int num_row = model_table.getRowCount();
        if(num_row <1) throw new Exception();
        // Kiểm tra xem đã mở file hay chưa
        if(this.model.getTenFile().length()>0) {
            // Lưu lại với chính tên file đó
            try {
                saveFile(this.model.getTenFile());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Cannot save this file","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else {

            // Mở cửa sổ để các tập tin file
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    saveFile(file.getAbsolutePath());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Cannot save this file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Mở file
     */
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
        } catch (Exception ignored) {

        }
        this.model.setDsThiSinh(ds);
    }

    /**
     * Thực hiện mở file
     */
    public void thucHienOpenFile(){
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
