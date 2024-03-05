package student;

import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetStudentByGroupTest {

    @Test
    void getStudentByGroupTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader01 = new Reader("addStudentGroups::{\"name\":\"GROUP-101\"}");
        server.executeRequest(reader01); // 1
        Reader reader02 = new Reader("addStudentGroups::{\"name\":\"GROUP-102\"}");
        server.executeRequest(reader02); // 2

        Reader reader1 = new Reader("addStudent::{\"groupId\":\"1\",\"surname\":\"Igorev\",\"name\":\"Artem\",\"patronymic\":\"Patronymic\",\"status\":\"study\"}");
        server.executeRequest(reader1); // 1
        Reader reader2 = new Reader("addStudent::{\"groupId\":\"2\",\"surname\":\"Ermolaev\",\"name\":\"Igor\",\"patronymic\":\"Patronymic\",\"status\":\"vacation\"}");
        server.executeRequest(reader2); // 2
        Reader reader3 = new Reader("addStudent::{\"groupId\":\"2\",\"surname\":\"Petrova\",\"name\":\"Yulia\",\"patronymic\":\"Patronymic\",\"status\":\"expelled\"}");
        server.executeRequest(reader3); // 3

        Reader reader10 = new Reader("getStudentByGroup::{\"groupId\":\"1\"}");
        Writer writer10 = server.executeRequest(reader10);
        Reader reader20 = new Reader("getStudentByGroup::{\"groupId\":\"2\"}");
        Writer writer20 = server.executeRequest(reader20);

        assertEquals(writer10.toString(), "200::{\"listName\":[\"Artem\"],\"listSurname\":[\"Igorev\"],\"listPatronymic\":[\"Patronymic\"],\"listStatus\":[\"study\"]}");
        assertEquals(writer20.toString(), "200::{\"listName\":[\"Igor\",\"Yulia\"],\"listSurname\":[\"Ermolaev\",\"Petrova\"],\"listPatronymic\":[\"Patronymic\",\"Patronymic\"],\"listStatus\":[\"vacation\",\"expelled\"]}");
    }

    @Test
    void validateTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("getStudentByGroup::{\"groupId\":\"\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "400::6:\"Validation error\":[\"groupId: zero\"]");
    }

    @Test
    void exceptionTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("getStudentByGroup::{\"groupId\":\"5\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "422::6:\"Object with ID not found\":[]");
    }
}
