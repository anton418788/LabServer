package group;

import org.junit.jupiter.api.Test;
import server_lab.server.Reader;
import server_lab.server.Server;
import server_lab.server.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetStudentGroupsTest {

    @Test
    void getStudentGroupsTest() throws Exception {
        Server server = new Server();
        server.initGroup();

        Reader reader0 = new Reader("getStudentGroups:: ");
        Writer writer0 = server.executeRequest(reader0);

        assertEquals(writer0.toString(), "200::{\"listName\":[]}");

        Reader reader1 = new Reader("addStudentGroups::{\"name\":\"GROUP-101\"}");
        server.executeRequest(reader1);
        Reader reader2 = new Reader("addStudentGroups::{\"name\":\"GROUP-102\"}");
        server.executeRequest(reader2);
        Reader reader3 = new Reader("addStudentGroups::{\"name\":\"GROUP-103\"}");
        server.executeRequest(reader3);

        Reader reader00 = new Reader("getStudentGroups:: ");
        Writer writer00 = server.executeRequest(reader00);

        assertEquals(writer00.toString(), "200::{\"listName\":[\"GROUP-101\",\"GROUP-102\",\"GROUP-103\"]}");
    }
}
