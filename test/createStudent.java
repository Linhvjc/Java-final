import model.Student;
import model.Province;

import static org.junit.Assert.*;
import org.testng.annotations.Test;

import java.util.Date;

public class createStudent {

    @Test
    public void testIdStudent() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(1,student.getStudentID());
    }

    @Test
    public void testNameStudent() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals("Linh",student.getStudentName());
    }

    @Test
    public void testNameTinh() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(Province.getProvinceById(2),student.getHomeTown());
    }

    @Test
    public void testDob() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        assertEquals(new Date("3/17/2002"),student.getDob());
    }
}
