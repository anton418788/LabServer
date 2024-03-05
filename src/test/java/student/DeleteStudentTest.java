package student;

import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteStudentTest {

    @Test
    void deleteStudentTest() throws Exception {
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
        server.executeRequest(reader1); // 1
        Reader reader2 = new Reader("addStudent::{\"groupId\":\"3\",\"surname\":\"Ermolaev\",\"name\":\"Igor\",\"patronymic\":\"Patronymic\",\"status\":\"vacation\"}");
        server.executeRequest(reader2); // 2
        Reader reader3 = new Reader("addStudent::{\"groupId\":\"2\",\"surname\":\"Petrova\",\"name\":\"Yulia\",\"patronymic\":\"Patronymic\",\"status\":\"expelled\"}");
        server.executeRequest(reader3); // 3

        Reader reader10 = new Reader("deleteStudent::{\"id\":\"1\"}");
        Writer writer10 = server.executeRequest(reader10);
        Reader reader20 = new Reader("deleteStudent::{\"id\":\"2\"}");
        Writer writer20 = server.executeRequest(reader20);
        Reader reader30 = new Reader("deleteStudent::{\"id\":\"3\"}");
        Writer writer30 = server.executeRequest(reader30);

        assertEquals(writer10.toString(), "200::");
        assertEquals(writer20.toString(), "200::");
        assertEquals(writer30.toString(), "200::");

        Reader reader100 = new Reader("getStudentById::{\"id\":\"1\"}");
        Writer writer100 = server.executeRequest(reader100);
        Reader reader200 = new Reader("getStudentById::{\"id\":\"2\"}");
        Writer writer200 = server.executeRequest(reader200);
        Reader reader300 = new Reader("getStudentById::{\"id\":\"3\"}");
        Writer writer300 = server.executeRequest(reader300);

        assertEquals(writer100.toString(), "422::6:\"Object with ID not found\":[]");
        assertEquals(writer200.toString(), "422::6:\"Object with ID not found\":[]");
        assertEquals(writer300.toString(), "422::6:\"Object with ID not found\":[]");
    }

    @Test
    void validateTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("deleteStudent::{\"id\":\"\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "400::6:\"Validation error\":[\"id: zero\"]");
    }

    @Test
    void exceptionTest() throws Exception {
        Server server = new Server();
        server.initGroup();
        server.initStudent();

        Reader reader1 = new Reader("deleteStudent::{\"id\":\"5\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "422::6:\"Object with ID not found\":[]");
    }
}
