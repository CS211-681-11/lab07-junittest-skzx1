package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {

    @Test
    @DisplayName("ทดสอบ addNewStudent แบบ id+name")
    void testAddNewStudent() {
        StudentList list = new StudentList();
        list.addNewStudent("6710405371", "A");
        assertEquals(1, list.getStudents().size());

        Student s = list.findStudentById("6710405371");
        assertEquals("A", s.getName());
        assertEquals(0, s.getScore());

        list.addNewStudent("6710405371", "B");
        assertEquals(1, list.getStudents().size());

        list.addNewStudent("1234567890", "C");
        assertEquals(2, list.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบ addNewStudent แบบ id+name+score")
    void testAddNewStudentWithScore() {
        StudentList list = new StudentList();
        list.addNewStudent("111", "A1", 75);
        assertEquals(1, list.getStudents().size());
        Student s = list.findStudentById("111");
        assertEquals(75, s.getScore());

        list.addNewStudent("111", "B2", 90);
        assertEquals(1, list.getStudents().size());
        assertEquals("A1", list.findStudentById("111").getName());
    }

    @Test
    @DisplayName("ทดสอบ findStudentById")
    void testFindStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("1", "A");
        list.addNewStudent("2", "B");
    }

    @Test
    @DisplayName("ทดสอบ filterByName")
    void testFilterByName() {
        StudentList list = new StudentList();
        list.addNewStudent("1", "Alice");
        list.addNewStudent("2", "Bob");
        list.addNewStudent("3", "Boss");

        StudentList filtered = list.filterByName("Bo");
        ArrayList<Student> students = filtered.getStudents();
        assertEquals(2, students.size());
        assertTrue(students.stream().anyMatch(s -> s.getName().equals("Bob")));
        assertTrue(students.stream().anyMatch(s -> s.getName().equals("Boss")));
    }

    @Test
    @DisplayName("ทดสอบ giveScoreToId")
    void testGiveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("1", "Alice");
        list.giveScoreToId("1", 50);
        assertEquals(50, list.findStudentById("1").getScore());
        list.giveScoreToId("99", 100);
    }

    @Test
    @DisplayName("ทดสอบ viewGradeOfId")
    void testViewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("1", "Alice");
        list.giveScoreToId("1", 85);
        assertEquals("A", list.viewGradeOfId("1"));
    }
}
