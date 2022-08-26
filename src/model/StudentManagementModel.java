package model;

import java.util.ArrayList;

public class StudentManagementModel {
    private ArrayList<Student> listStudent;
    private String fileName;

    /**
     * Constructor
     */
    public StudentManagementModel() {
        this.listStudent = new ArrayList<Student>();
        this.fileName ="";
    }

    public StudentManagementModel(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    /**
     * Getter and Setter
     */
    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method
     */

    // Them thi sinh
    public void insert(Student student) {
        this.listStudent.add(student);
    }

    // Xoa thi sinh
    public void delete(Student student) {
        int index =-1;
        for(int i = 0; i<this.listStudent.size(); i++) {
            if(student.getStudentID() == this.listStudent.get(i).getStudentID()) {
                index = i;
            }
        }
        this.listStudent.remove(index);
    }

    // Cap nhat thong tin thi sinh
    public void update(Student student, int indexDelete) {
        this.listStudent.remove(indexDelete);
        this.listStudent.add(student);
    }

    // Kiem tra Thí sinh đã tồn tại chưa
    public boolean checkIfExist(Student ts) {
        for (Student student : listStudent) {
            if(student.getStudentID() == ts.getStudentID()) {
                return true;
            }
        }
        return false;
    }

//    public boolean kiemtraIdTonTai(ThiSinh ts) {
//        for (ThiSinh thiSinh : dsThiSinh) {
//            if(thiSinh.getMaThiSinh() == ts.getMaThiSinh()) {
//                return true;
//            }
//        }
//        return false;
//    }
}
