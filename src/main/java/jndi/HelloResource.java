package jndi;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Path("rs")
public class HelloResource {

    // Nueva forma con anotaciones
    @Resource(name = "myDerbyDataSource")
    private DataSource ds;

    @Path("hellodb")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject testHelloResource() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        try {
            Context ctx = new InitialContext();

            DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/myDerbyDataSource");
            Connection conn = dataSource.getConnection();

            // Nueva forma con anotaciones
            //Connection conn = ds.getConnection();

            //use conn
            Statement stmt = conn.createStatement();

            // create table
            stmt.executeUpdate("CREATE TABLE USERS (id int primary key, name varchar(30))");

            // insert 2 rows (CREATE)
            stmt.executeUpdate("INSERT INTO USERS VALUES (1, 'Ethien')");
            stmt.executeUpdate("INSERT INTO USERS VALUES (2, 'Daniel')");
            stmt.executeUpdate("INSERT INTO USERS VALUES (3, 'Adrian')");
            stmt.executeUpdate("INSERT INTO USERS VALUES (4, 'Eduardo')");

            //query
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

            //PRINT OUT QUERY RESULT
            while (rs.next()){
                builder.add(rs.getString("id"), rs.getString("name"));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return builder.build();
    }
}
