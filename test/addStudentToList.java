import static org.junit.Assert.*;

import model.StudentManagementModel;
import model.Student;
import model.Province;
import org.testng.annotations.Test;

import java.util.Date;

public class addStudentToList {

    @Test
    public void testAddStudentToList() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        StudentManagementModel model = new StudentManagementModel();
        model.insert(student);
        assertNotNull(model.getListStudent());
    }

    @Test
    public void testCompareStudent() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        StudentManagementModel model = new StudentManagementModel();
        model.insert(student);
        assertSame(student,model.getListStudent().get(0));
    }
}
