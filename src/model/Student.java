package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {
    private int studentID;
    private String studentName;
    private Province homeTown;
    private Date dob;
    private boolean sex;
    private float grade1, grade2, grade3;


    /**
     * Constructor
     */
    public Student() {
    }

    public Student(int studentID, String studentName, Province homeTown, Date dob, boolean sex, float grade1, float grade2, float grade3) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.homeTown = homeTown;
        this.dob = dob;
        this.sex = sex;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }


    /**
     * Getter and Setter
     */
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Province getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(Province homeTown) {
        this.homeTown = homeTown;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getGrade1() {
        return grade1;
    }

    public void setGrade1(float grade1) {
        this.grade1 = grade1;
    }

    public float getGrade2() {
        return grade2;
    }

    public void setGrade2(float grade2) {
        this.grade2 = grade2;
    }

    public float getGrade3() {
        return grade3;
    }

    public void setGrade3(float grade3) {
        this.grade3 = grade3;
    }

    /**
     * Method
     */
    @Override
    public String toString() {
        return "ThiSinh{" +
                "maThiSinh=" + studentID +
                ", tenThiSinh='" + studentName + '\'' +
                ", queQuan=" + homeTown +
                ", ngaySinh=" + dob +
                ", gioiTinh=" + sex +
                ", diemMon1=" + grade1 +
                ", diemMon2=" + grade2 +
                ", diemMon3=" + grade3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student thiSinh = (Student) o;
        return studentID == thiSinh.studentID && sex == thiSinh.sex && Float.compare(thiSinh.grade1, grade1) == 0 && Float.compare(thiSinh.grade2, grade2) == 0 && Float.compare(thiSinh.grade3, grade3) == 0 && Objects.equals(studentName, thiSinh.studentName) && Objects.equals(homeTown, thiSinh.homeTown) && Objects.equals(dob, thiSinh.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName, homeTown, dob, sex, grade1, grade2, grade3);
    }
}
