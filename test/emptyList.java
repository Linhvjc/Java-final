import static org.junit.Assert.*;

import model.StudentManagementModel;
import model.Student;
import org.testng.annotations.Test;

public class emptyList {

    @Test
    public void testEmptyList() {
        // Kiểm tra xem danh sách thí sinh lúc đầu có trống hay không
        StudentManagementModel list = new StudentManagementModel();
        assertTrue(list.getListStudent().isEmpty());
        Student student = new Student();
        list.insert(student);
        assertFalse(list.getListStudent().isEmpty());
        list.delete(student);
        assertTrue(list.getListStudent().isEmpty());
    }
}
