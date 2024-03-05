package group;
import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeleteStudentGroupTest {

    @Test
    void deleteStudentGroupTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader1 = new Reader("addStudentGroups::{\"name\":\"GROUP-101\"}");
        server.executeRequest(reader1); // 1
        Reader reader2 = new Reader("addStudentGroups::{\"name\":\"GROUP-102\"}");
        server.executeRequest(reader2); // 2

        Reader reader10 = new Reader("deleteStudentGroup::{\"id\":\"1\"}}");
        Writer writer10 = server.executeRequest(reader10);
        Reader reader20 = new Reader("deleteStudentGroup::{\"id\":\"2\"}}");
        Writer writer20 = server.executeRequest(reader20);

        assertEquals(writer10.toString(), "200::");
        assertEquals(writer20.toString(), "200::");

        Reader reader100 = new Reader("getStudentGroupById::{\"id\":\"1\"}");
        Writer writer100 = server.executeRequest(reader100);
        Reader reader200 = new Reader("getStudentGroupById::{\"id\":\"2\"}");
        Writer writer200 = server.executeRequest(reader200);


        assertEquals(writer100.toString(), "422::6:\"Object with ID not found\":[]");
        assertEquals(writer200.toString(), "422::6:\"Object with ID not found\":[]");
    }

    @Test
    void validateTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader1 = new Reader("deleteStudentGroup::{\"id\":\"\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "400::6:\"Validation error\":[\"id: zero\"]");
    }

    @Test
    void exceptionTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader1 = new Reader("deleteStudentGroup::{\"id\":\"5\"}");
        Writer writer1 = server.executeRequest(reader1);

        assertEquals(writer1.toString(), "422::6:\"Object with ID not found\":[]");
    }
}
