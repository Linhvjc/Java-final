import model.StudentManagementModel;
import model.Student;
import model.Province;
import org.testng.annotations.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class deleteStudentFromList {
    @Test
    public void testDeleteStudentFromList() {
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        StudentManagementModel model = new StudentManagementModel();
        model.insert(student);
        assertEquals(model.getListStudent().size(), 1);
        model.delete(student);
        assertEquals(model.getListStudent().size(), 0);
    }
}
