package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลนักเรียนจากไฟล์ student-list.csv")
    void testReadData() {
        StudentListFileDatasource datasource = new StudentListFileDatasource("data", "student-list.csv");
        StudentList list = datasource.readData();
        assertEquals(5, list.getStudents().size());

        assertEquals("Tim Berners-Lee", list.findStudentById("6410450001").getName());
        assertEquals(145.5, list.findStudentById("6410450001").getScore());

        assertEquals("Barbara Liskov", list.findStudentById("6410450002").getName());
        assertEquals(60.7, list.findStudentById("6410450002").getScore());

        assertEquals("Alan Turing", list.findStudentById("6410450003").getName());
        assertEquals(346.2, list.findStudentById("6410450003").getScore());

        assertEquals("John McCarthy", list.findStudentById("6410450004").getName());
        assertEquals(63.8, list.findStudentById("6410450004").getScore());

        assertEquals("Alan Kay", list.findStudentById("6410450005").getName());
        assertEquals(68.0, list.findStudentById("6410450005").getScore());
    }
}