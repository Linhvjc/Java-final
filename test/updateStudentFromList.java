import static org.junit.Assert.*;

import model.StudentManagementModel;
import model.Student;
import model.Province;
import org.testng.annotations.Test;

import java.util.Date;

public class updateStudentFromList {

    @Test
    public void testUpdateStudent() {
        StudentManagementModel list = new StudentManagementModel();
        Student student = new Student(1,"Linh", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);
        list.insert(student);
        // Lưu lại thí sinh trước khi update
        Student temp = list.getListStudent().get(0);

        Student studentUpdated = new Student(1,"Linh2", Province.getProvinceById(2)
                ,new Date("3/17/2002"),true,1,2,3);

        // Lấy index của thí sinh cần xóa
        int index =-1;
        for(int i = 0; i<list.getListStudent().size(); i++) {
            if(student.getStudentID() == list.getListStudent().get(i).getStudentID()) {
                index = i;
            }
        }

        list.update(studentUpdated,index);
        // Lưu lại thí sinh sau khi update
        Student tempUpdate = list.getListStudent().get(0);

        assertNotEquals(temp, tempUpdate);
        assertNotEquals(temp.getStudentName(), tempUpdate.getStudentName());
    }
}
