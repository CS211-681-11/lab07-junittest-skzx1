package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore() {
        Student s = new Student("6710405371", "Frong");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade() {
        Student s = new Student("6710405371", "Frong");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6710405371", "Frong");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเช็คไอดี")
    void testIsId() {
        Student s = new Student("6710405371", "Frong");
        assertTrue(s.isId("6710405371"));
        assertFalse(s.isId("1234567890"));
    }

    @Test
    @DisplayName("ทดสอบชื่อ")
    void testIsNameContains() {
        Student s = new Student("6710405371", "Frong");
        assertTrue(s.isNameContains("Frong"));
        assertFalse(s.isNameContains("1234567890"));
    }
    @Test
    @DisplayName("ทดสอบGetter")
    void testGetter(){
        Student s = new Student("6710405371", "Frong",40.0);
        assertEquals("6710405371", s.getId());
        assertEquals("Frong", s.getName());
        assertEquals(40.0, s.getScore());
        assertEquals("F", s.getGrade());
    }
    @Test
    @DisplayName("ทดสอบTostring")
    void testToString() {
        Student s = new Student("6710405371", "Frong", 55.5);
        String expected = "{id: '6710405371', name: 'Frong', score: 55.5}";
        assertEquals(expected, s.toString());
    }
}
