package io.meighen.service_bulder.service.builders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class Template {
    public void execute() {
        String param1 = "'{\n" +
                "    \"application\": {\n" +
                "        \"app_id\": \"7-YUF4T54\",\n" +
                "        \"vip_application\": false,\n" +
                "        \"utm_source\": \"none\"\n" +
                "\t    }\n" +
                "\t}'";

        String SQL_SELECT = "DO $$\n" +
                "DECLARE\n" +
                "    in_json text := " + param1 + ";\n" +
                "BEGIN\n" +
                "   \n" +
                "\tINSERT INTO application (app_id, vip_application, utm_source)\n" +
                "\t\tSELECT (rec->>'app_id')::text, (rec->>'vip_application')::boolean, (rec->>'utm_source')::text \n" +
                "\t\tfrom json(in_json::json->'application') rec\n" +
                "\t;\n" +
                "END $$;";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/klusterdb", "postgres", "pass");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
