package group;

import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditStudentGroupsTest {
    @Test
    void editStudentGroupsTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader0 = new Reader("addStudentGroups::{\"name\":\"GROUP-101\"}");
        server.executeRequest(reader0); // 1

        Reader reader1 = new Reader("editStudentGroups::{\"id\":\"1\",\"name\":\"GROUP-101-O1\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "200::");

        Reader reader10 = new Reader("getStudentGroupById::{\"id\":\"1\"}");
        Writer writer10 = server.executeRequest(reader10);

        assertEquals(writer10.toString(), "200::{\"name\":\"GROUP-101-O1\"}");
    }

    @Test
    void validateTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader1 = new Reader("editStudentGroups::{\"id\":\"\",\"name\":\"GROUP-101-O1\"}");
        Writer writer1 = server.executeRequest(reader1);
        Reader reader2 = new Reader("editStudentGroups::{\"id\":\"1\",\"name\":\"\"}");
        Writer writer2 = server.executeRequest(reader2);
        Reader reader3 = new Reader("editStudentGroups::{\"id\":\"1\",\"name\":\"GROUP-101-O1050950159095019501950195019509501950950590950\"}");
        Writer writer3 = server.executeRequest(reader3);

        assertEquals(writer1.toString(), "400::6:\"Validation error\":[\"id: zero\"]");
        assertEquals(writer2.toString(), "400::6:\"Validation error\":[\"name: empty\"]");
        assertEquals(writer3.toString(), "400::6:\"Validation error\":[\"name: big\"]");
    }

    @Test
    void exceptionTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader1 = new Reader("editStudentGroups::{\"id\":\"5\",\"name\":\"GROUP-101-O1\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "422::6:\"Object with ID not found\":[]");
    }
}
