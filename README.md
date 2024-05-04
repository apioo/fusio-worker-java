
# Fusio-Worker-Java

A Fusio worker implementation to execute Groovy/Java code.
More information about the Worker system at our documentation:
https://docs.fusio-project.org/docs/use_cases/api_gateway/worker

## Example

The following example shows an action written in Groovy which gets data
from a database and returns a response

```groovy
def connection = connector.getConnection("app");

def entries = [];
def query = "SELECT name, description FROM app_product_0";
try (def stmt = connection.createStatement()) {
    def rs = stmt.executeQuery(query);
    while (rs.next()) {
        entries.add([
            name: rs.getString("name"),
            description: rs.getString("description")
        ]);
    }
}

response.build(200, [:], [
    foo: "bar",
    entries: entries
]);

```

## Types

This table contains an overview which connection types are implemented
and which implementation is used:

| Type                                                   | Implementation                                 |
|--------------------------------------------------------|------------------------------------------------|
| `Fusio.Adapter.Sql.Connection.Sql`                     | `java.sql.Connection`                          |
| `Fusio.Adapter.Sql.Connection.SqlAdvanced`             | `java.sql.Connection`                          |
| `Fusio.Adapter.Http.Connection.Http`                   | `org.apache.http.client.HttpClient`            |
| `Fusio.Adapter.Mongodb.Connection.MongoDB`             | `com.mongodb.client.MongoDatabase`             |
| `Fusio.Adapter.Elasticsearch.Connection.Elasticsearch` | `org.elasticsearch.client.RestHighLevelClient` |

