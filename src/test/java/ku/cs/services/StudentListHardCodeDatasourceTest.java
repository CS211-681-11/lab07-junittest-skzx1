package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลและจำนวนนักเรียนทั้งหมด")
    void testReadDataSize() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals(10, list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบข้อมูลของนักเรียนคนแรก")
    void testFirstStudent() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals("6710400001", list.getStudents().get(0).getId());
        assertEquals("First", list.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบข้อมูลของนักเรียนคนสุดท้าย")
    void testLastStudent() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals("67104000010", list.getStudents().get(9).getId());
        assertEquals("Tenth", list.getStudents().get(9).getName());
    }
}