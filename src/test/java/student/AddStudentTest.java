package student;

import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddStudentTest {

    @Test
    void addStudentTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();


        Reader reader01 = new Reader("addStudentGroups::{\"name\":\"GROUP-101\"}");
        server.executeRequest(reader01); // 1
        Reader reader02 = new Reader("addStudentGroups::{\"name\":\"GROUP-102\"}");
        server.executeRequest(reader02); // 2
        Reader reader03 = new Reader("addStudentGroups::{\"name\":\"GROUP-103\"}");
        server.executeRequest(reader03); // 3

        Reader reader1 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer1 = server.executeRequest(reader1);
        Reader reader2 = new Reader("addStudent::{\"groupId\":\"3\",\"surname\":\"Ermolaev\",\"name\":\"Igor\",\"patronymic\":\"Patronymic\",\"status\":\"vacation\"}");
        Writer writer2 = server.executeRequest(reader2);
        Reader reader3 = new Reader("addStudent::{\"groupId\":\"2\",\"surname\":\"Petrova\",\"name\":\"Yulia\",\"patronymic\":\"Patronymic\",\"status\":\"expelled\"}");
        Writer writer3 = server.executeRequest(reader3);

        assertEquals(writer1.toString(), "200::{\"id\":1}");
        assertEquals(writer2.toString(), "200::{\"id\":2}");
        assertEquals(writer3.toString(), "200::{\"id\":3}");
    }

    @Test
    void validateTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("addStudent::{\"groupId\":\"\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "400::6:\"Validation error\":[\"groupId: empty\"]");

        Reader reader21 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer21 = server.executeRequest(reader21);
        Reader reader22 = new Reader("addStudent::{\"groupId\":\"9\",\"surname\":\"antonantonantonantonantonantonantonantonantonantonantonantonanton\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer22 = server.executeRequest(reader22);

        assertEquals(writer21.toString(), "400::6:\"Validation error\":[\"surname: empty\"]");
        assertEquals(writer22.toString(), "400::6:\"Validation error\":[\"surname: big\"]");

        Reader reader31 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer31 = server.executeRequest(reader31);
        Reader reader32 = new Reader("addStudent::{\"groupId\":\"6\",\"surname\":\"Igorev\",\"name\":\"antonantonantonantonantonantonantonantonantonantonantonantonanton\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer32 = server.executeRequest(reader32);

        assertEquals(writer31.toString(), "400::6:\"Validation error\":[\"name: empty\"]");
        assertEquals(writer32.toString(), "400::6:\"Validation error\":[\"name: big\"]");

        Reader reader41 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"\",\"status\":\"study\"}");
        Writer writer41 = server.executeRequest(reader41);
        Reader reader42 = new Reader("addStudent::{\"groupId\":\"6\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"antonantonantonantonantonantonantonantonantonantonantonantonanton\",\"status\":\"study\"}");
        Writer writer42 = server.executeRequest(reader42);

        assertEquals(writer41.toString(), "400::6:\"Validation error\":[\"patronymic: empty\"]");
        assertEquals(writer42.toString(), "400::6:\"Validation error\":[\"patronymic: big\"]");

        Reader reader51 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"\"}");
        Writer writer51 = server.executeRequest(reader51);
        Reader reader53 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"nope\"}");
        Writer writer53 = server.executeRequest(reader53);

        assertEquals(writer51.toString(), "400::6:\"Validation error\":[\"status: empty\",\"status: no status\"]");
        assertEquals(writer53.toString(), "400::6:\"Validation error\":[\"status: no status\"]");
    }

    @Test
    void exceptionTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "422::6:\"Object with ID not found\":[]");
    }
}
