
# Fusio-Worker-Java

A Fusio worker implementation to execute Java code.
More information about the worker API at:
https://www.fusio-project.org/documentation/worker

## Example

The following example shows an action written in Java which gets data
from a database and returns a response

```java
import org.fusioproject.worker.ActionAbstract;
import org.fusioproject.worker.Connector;
import org.fusioproject.worker.Dispatcher;
import org.fusioproject.worker.Logger;
import org.fusioproject.worker.generated.Context;
import org.fusioproject.worker.generated.Request;
import org.fusioproject.worker.generated.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyJavaAction extends ActionAbstract {

    public MyJavaAction(Connector connector, Dispatcher dispatcher, Logger logger) {
        super(connector, dispatcher, logger);
    }

    public Response handle(Request request, Context context) throws Exception {

        Connection connection = (Connection) this.connector.getConnection("my_db");
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM app_todo");

        List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
        while (result.next()) {
            HashMap<String, String> row = new HashMap<String, String>();
            row.put("id", result.getString(1));
            row.put("title", result.getString(3));
            rows.add(row);
        }

        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("hello", "foobar");
        body.put("result", rows);

        return this.response.build(200, null, body);

    }

}

```

## Types

This table contains an overview which connection types are implemented
and which implementation is used:

| Type | Implementation |
| ---- | -------------- |
| `Fusio.Adapter.Sql.Connection.Sql` | `mysql / mysql-connector-java`
| `Fusio.Adapter.Sql.Connection.SqlAdvanced` | `mysql / mysql-connector-java`
| `Fusio.Adapter.Http.Connection.Http` | `org.apache.httpcomponents / httpclient`
| `Fusio.Adapter.Mongodb.Connection.MongoDB` | `-`
| `Fusio.Adapter.Elasticsearch.Connection.Elasticsearch` | `-`

