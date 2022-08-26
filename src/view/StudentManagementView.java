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

import controller.StudentManagementController;
import model.StudentManagementModel;
import model.Student;
import model.Province;

public class StudentManagementView extends JFrame {

    public JRadioButton radioButton_male;
    public JRadioButton radioButton_female;
    public ButtonGroup btng_sex;
    public JComboBox comboBox_location_search;
    public JComboBox comboBox_location;
    public StudentManagementModel model;
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
    public StudentManagementView() {
        this.model = new StudentManagementModel();

        // Set các đặc tính cho toàn bộ chương trình
        this.setTitle("Student manager system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        this.setLocationRelativeTo(null);
        ActionListener action = new StudentManagementController(this);

        // Set Icon => JFrame
        URL urlIconNotepad = StudentManagementView.class.getResource("../assets/main_icon.png");
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
                .createImage(StudentManagementView.class.getResource("../assets/open_icon.png"))));
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menuSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/save_icon.png"))));
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
        menuExit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/quit_icon.png"))));
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuFile.add(menuExit);

        JMenu menuAbout = new JMenu("About");
        menuAbout.addActionListener(action);
        menuBar.add(menuAbout);

        JMenuItem menuAboutMe = new JMenuItem("About me");
        menuAboutMe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/info_icon.png"))));
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
        ArrayList<Province> listProvince = Province.getListProvince();
        comboBox_location_search.addItem("");
        for(Province province : listProvince) {
            comboBox_location_search.addItem(province.getProvinceName());
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
                .createImage(StudentManagementView.class.getResource("../assets/search_icon.png"))));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSearch.setBackground(new Color(132, 112 ,255));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(action);
        panel_searchBtn.add(btnSearch);

        JButton btnReload = new JButton("Reload");
        btnReload.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/reload_icon.png"))));
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

        JLabel label_location_form = new JLabel("Home town:", SwingConstants.CENTER);
        label_location_form.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_contentFormBodyLeft.add(label_location_form);

        comboBox_location = new JComboBox();
        comboBox_location.setBackground(Color.WHITE);
        comboBox_location.setForeground(Color.BLACK);
        // Thêm từng tỉnh vào comboBox
        comboBox_location.addItem("");
        for(Province province : listProvince) {
            comboBox_location.addItem(province.getProvinceName());
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
                .createImage(StudentManagementView.class.getResource("../assets/add_icon.png"))));
        btnAdd.setBackground(new Color(243, 165, 184));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.addActionListener(action);
        panel_footer.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/delete_icon.png"))));
        btnDelete.setBackground(new Color(243, 165, 184));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFocusPainted(false);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.addActionListener(action);
        panel_footer.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/update_icon.png"))));
        btnUpdate.setBackground(new Color(243, 165, 184));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnUpdate.addActionListener(action);
        panel_footer.add(btnUpdate);

        JButton btnSave = new JButton("Save student");
        btnSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/saveStudent_icon.png"))));
        btnSave.setBackground(new Color(243, 165, 184));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFocusPainted(false);
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSave.addActionListener(action);
        panel_footer.add(btnSave);

        JButton btnCancel = new JButton("Reset");
        btnCancel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
                .createImage(StudentManagementView.class.getResource("../assets/reset_icon.png"))));
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
    public void deleteForm() {
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
    public void addStudentToTable(Student student) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[] {
                student.getStudentID() + ""
                , student.getStudentName()
                , student.getHomeTown().getProvinceName()
                , student.getDob().getDate() + "/" + (student.getDob().getMonth() + 1) +
                "/" + (student.getDob().getYear() + 1900)
                , (student.isSex() ? "Male" : "Female")
                , student.getGrade1() + ""
                , student.getGrade2() + "",
                student.getGrade3() + "", });
    }

    /**
     * Phương thúc thêm hoặc cập nhật sinh viên vào bảng và model
     */
    public void addOrUpdateStudent(Student student) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();

        // Lấy index của thí sinh cần xóa
        int index =-1;
        for(int i = 0; i<model.getListStudent().size(); i++) {
            if(student.getStudentID() == model.getListStudent().get(i).getStudentID()) {
                index = i;
            }
        }
        if (!this.model.checkIfExist(student)) {
            this.model.insert(student);
            this.addStudentToTable(student);
        } else {
            int rowCount = model_table.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String id = model_table.getValueAt(i, 0) + "";
                if (id.equals(student.getStudentID() + "")) {
                    model_table.setValueAt(student.getStudentID() + "", i, 0);
                    model_table.setValueAt(student.getStudentName() + "", i, 1);
                    model_table.setValueAt(student.getHomeTown().getProvinceName() + "", i, 2);
                    model_table.setValueAt(student.getDob().getDate() + "/" + (student.getDob().getMonth() + 1) + "/"
                            + (student.getDob().getYear() + 1900) + "", i, 3);
                    model_table.setValueAt((student.isSex() ? "Male" : "Female"), i, 4);
                    model_table.setValueAt(student.getGrade1() + "", i, 5);
                    model_table.setValueAt(student.getGrade2() + "", i, 6);
                    model_table.setValueAt(student.getGrade3() + "", i, 7);
                }
            }
            this.model.update(student, index);
        }
    }

    /**
     * Phương thúc lấy thông tin của sinh viên đã chọn
     */
    public Student getStudentSelected() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();  // index của dòng
        model_table.getValueAt(i_row,0);

        // Lấy dữ liệu
        int studentId = Integer.parseInt(model_table.getValueAt(i_row,0) +"");
        String studentName = model_table.getValueAt(i_row,1) + "";
        Province province = Province.getProvinceByName(model_table.getValueAt(i_row,2) + "");
        String s_dob = model_table.getValueAt(i_row,3) +"";
        String[] arr = s_dob.split("/");
        int date= Integer.parseInt(arr[0]);
        int month= Integer.parseInt(arr[1]);
        int year= Integer.parseInt(arr[2]);
        Date dob = new Date(year,month,date);
        String textSex = model_table.getValueAt(i_row,4) +"";
        boolean sex = textSex.equals("Male");
        float grade1 = Float.parseFloat(model_table.getValueAt(i_row,5) +"");
        float grade2 = Float.parseFloat(model_table.getValueAt(i_row,6) +"");
        float grade3 = Float.parseFloat(model_table.getValueAt(i_row,7) +"");

        Student ts = new Student(studentId,studentName,province,dob,sex,grade1,grade2,grade3);
        return ts;
    }

    /**
     * Phương thúc hiển thị thông tin của sinh viên đã chọn
     */
    public void displayStudentSelected() {
        Student student;

        // Kiểm tra xem người dùng đã chọn sinh viên chưa
        try {
            student = getStudentSelected();
        } catch (Exception e) {
            throw e;
        }

        // Hiển thị thông tin thí sinh đã chọn lên form
        this.textField_ID.setText(student.getStudentID()+"");
        this.textField_ID.setEditable(false);
        this.textField_studentName.setText(student.getStudentName()+"");
        this.comboBox_location.setSelectedItem(student.getHomeTown().getProvinceName());
        String s_dob = (student.getDob().getMonth()) +"/"+(student.getDob().getDate())
                +"/"+ (student.getDob().getYear());
//        String s_dob = student.getNgaySinh().getDate() +"/"+(student.getNgaySinh().getMonth()+1)
//                +"/"+ (student.getNgaySinh().getYear()+1900);
        this.textField_dob.setText(s_dob +"");
        if(student.isSex()) {
            radioButton_male.setSelected(true);
        } else {
            radioButton_female.setSelected(true);
        }
        this.textField_grade1.setText(student.getGrade1()+"");
        this.textField_grade2.setText(student.getGrade2()+"");
        this.textField_grade3.setText(student.getGrade3()+"");
    }

    /**
     * Phương thúc xóa sinh viên đã chọn
     */
    public void handleDeleteStudent() throws Exception {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if(i_row < 0) throw new Exception();
        int choice = JOptionPane.showConfirmDialog(this,
                "Are you sure to delete the selected line?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            Student ts = getStudentSelected();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
        this.deleteForm();
    }

    /**
     * Phương thúc xóa sinh viên đã chọn
     */
    public void handleAddStudent() throws Exception {
        this.textField_ID.setEditable(true);

        // Lấy dữ liệu
        int studentId = Integer.parseInt(this.textField_ID.getText());
        String studentName = this.textField_studentName.getText();
        int homeTown = this.comboBox_location.getSelectedIndex() -1;
        Province province = Province.getProvinceById(homeTown);

        Date dob = new Date(this.textField_dob.getText());
//        if (dob.getDate()) throw new Exception();
        boolean sex = true;

        // Validate giới tính
        if(this.radioButton_male.isSelected()) {
            sex = true;
        } else if(this.radioButton_female.isSelected()) {
            sex = false;
        } else {
            throw new Exception();
        }

        // validate khi nhập điểm >10 hoặc <0
        float grade1 = Float.parseFloat(this.textField_grade1.getText());
        float grade2 = Float.parseFloat(this.textField_grade2.getText());
        float grade3 = Float.parseFloat(this.textField_grade3.getText());
        if (grade1 > 10 || grade1 <0) throw new Exception();
        if (grade2 > 10 || grade2 <0) throw new Exception();
        if (grade3 > 10 || grade3 <0) throw new Exception();

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
        Student ts = new Student(studentId,studentName,province,dob,sex,grade1,grade2,grade3);
        this.addOrUpdateStudent(ts);
        this.deleteForm();
    }

    /**
     * Phương thức tìm kiếm sinh viên
     */
    public void handleSearchStudent() {
        // Gọi phương thức load lại dữ liệu trước
        this.handleReLoadData();

        // Thực hiện tìm kiếm
        int homeTownSearch = this.comboBox_location_search.getSelectedIndex() -1;
        String StudentIdSearch = this.textField_studentID_search.getText();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int rowCount = model_table.getRowCount();

        Set<Integer> StudentIdDelete = new TreeSet<Integer>();
        if(homeTownSearch>=0) { // nếu có chọn quê quán
            Province provinceSelected = Province.getProvinceById(homeTownSearch);
            for(int i=0; i<rowCount; i++) {
                String provinceName = model_table.getValueAt(i,2)+"";
                String id = model_table.getValueAt(i,0) +"";
                if(!provinceName.equals(provinceSelected.getProvinceName())) {
                    StudentIdDelete.add(Integer.valueOf(id));
                }
            }
        }
        if(StudentIdSearch.length() >0) {  // Nếu đã nhập mã số sv
            for(int i=0; i<rowCount; i++) {
                String id = model_table.getValueAt(i,0)+"";
                if(!id.equals(StudentIdSearch)) {
                    StudentIdDelete.add(Integer.valueOf(id));
                }
            }
        }

        for (Integer idNeedToDelete : StudentIdDelete) {
            rowCount = model_table.getRowCount();
            for(int i=0; i<rowCount; i++) {
                String idInTable = model_table.getValueAt(i,0) +"";
                if(idInTable.equals(idNeedToDelete.toString())) {
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
    public void handleReLoadData() {
        // Xoa tat ca cac dong
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int rowCount = model_table.getRowCount();
            if(rowCount==0)
                break;
            else
                // Bắt lỗi khi xóa hàng
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    throw e;
                }
        }
        for (Student ts : this.model.getListStudent()) {
            this.addStudentToTable(ts);
        }
    }

    /**
     * hiển thị cửa sổ aboutme
     */
    public void displayAbout() {
        JOptionPane.showMessageDialog(this, "Copyright by Phan Nhat Linh");
    }

    /**
     * Thoát khỏi chương trình
     */
    public void exitProgram() {
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
            this.model.setFileName(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Lưu từng đối tượng thí sinh vào file
            for (Student student : this.model.getListStudent()) {
                oos.writeObject(student);
            }
            oos.close();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * thực hiện lưu file
     */
    public void handleSaveFile() throws Exception {
        // Kiểm tra xem dữ liệu rỗng hay không
        handleReLoadData();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int num_row = model_table.getRowCount();
        if(num_row <1) throw new Exception();
        // Kiểm tra xem đã mở file hay chưa
        if(this.model.getFileName().length()>0) {
            // Lưu lại với chính tên file đó
            try {
                saveFile(this.model.getFileName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Cannot save this file",
                        "Error",JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, "Cannot save this file",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Mở file
     */
    public void openFile(File file) {
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            this.model.setFileName(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Tạo mảng mới để cập nhật tùng thí sinh vào Ds
            Student student = null;
            while((student = (Student) ois.readObject())!=null) {
                list.add(student);
            }
            ois.close();
        } catch (Exception ignored) {

        }
        this.model.setListStudent(list);
    }

    /**
     * Thực hiện mở file
     */
    public void handleOpenFile() throws Exception {

        JFileChooser fc = new JFileChooser();
        // Mở cửa sổ để các tập tin file (document)
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            handleReLoadData();
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int num_row = model_table.getRowCount();
            if(num_row <1) throw new Exception();
        }
    }

}
