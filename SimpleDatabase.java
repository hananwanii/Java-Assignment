import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleDatabase {
    private static final String METADATA_FILE = "metadata.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input until they enter "exit"
        while (true) {
            System.out.print("Enter SQL statement (or 'exit' to quit): ");
            String sqlStatement = scanner.nextLine();

            if (sqlStatement.equalsIgnoreCase("exit")) {
                break;
            }

            processSqlStatement(sqlStatement);
        }

        scanner.close();
    }

    private static void processSqlStatement(String sqlStatement) {
        if (sqlStatement.startsWith("CREATE TABLE")) {
            parseCreateTableStatement(sqlStatement);
        } else if (sqlStatement.startsWith("INSERT INTO")) {
            parseInsertStatement(sqlStatement);
        } else {
            System.out.println("Invalid SQL statement");
        }
    }

    private static void parseCreateTableStatement(String sqlStatement) {
        Pattern pattern = Pattern.compile("CREATE TABLE (\\w+) \\((.+)\\)");
        Matcher matcher = pattern.matcher(sqlStatement);

        if (matcher.find()) {
            String tableName = matcher.group(1);
            String columnDefinitions = matcher.group(2);

            // Store metadata in the metadata file
            try {
                FileWriter metadataWriter = new FileWriter(METADATA_FILE, true);
                String[] columns = columnDefinitions.split(",");
                for (String column : columns) {
                    String[] columnInfo = column.trim().split(" ");
                    String columnName = columnInfo[0];
                    String columnType = columnInfo[1];

                    metadataWriter.write(tableName + "," + columnName + "," + columnType + "\n");
                }
                metadataWriter.close();

                System.out.println("Table created: " + tableName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parseInsertStatement(String sqlStatement) {
        Pattern pattern = Pattern.compile("INSERT INTO (\\w+) VALUES \\((.+)\\)");
        Matcher matcher = pattern.matcher(sqlStatement);

        if (matcher.find()) {
            String tableName = matcher.group(1);
            String values = matcher.group(2);

            // Insert data into the table file
            try {
                FileWriter tableWriter = new FileWriter(tableName + ".txt", true);
                tableWriter.write(values + "\n");
                tableWriter.close();

                System.out.println("Data inserted into table: " + tableName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
