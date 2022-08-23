import static org.junit.Assert.*;

import model.StudentManagementModel;
import model.Student;
import model.Province;
import org.testng.annotations.Test;

import java.util.Date;

public class checkIfExist {
    @Test
    public void checkIfExist() {
        Student student1 = new Student(1,"Linh1", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        Student student2 = new Student(2,"Linh2", Province.getProvinceById(3)
                ,new Date("3/17/2002"),false,1,2,3);
        Student student3 = new Student(3,"Linh3", Province.getProvinceById(4)
                ,new Date("3/17/2002"),true,1,2,3);
        StudentManagementModel model = new StudentManagementModel();
        model.insert(student1);
        model.insert(student2);
        model.insert(student3);

        assertTrue(model.checkIfExist(student2));
    }
}
