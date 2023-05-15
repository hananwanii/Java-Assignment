## How to run


Set up a Java development environment: Install the Java Development Kit (JDK) on your system. You can download the JDK from the Oracle website or use a package manager if you're on a Unix-like system.

Create a new Java file: Create a new file with a .java extension, such as SimpleDatabase.java, and copy the code provided in the previous response into that file.

Save the file: Save the Java file.

Compile the Java file: Open a command prompt or terminal, navigate to the directory where the Java file is saved, and compile the code using the javac command:
javac SimpleDatabase.java

This will generate a compiled bytecode file with a .class extension.

Run the Java program: After successfully compiling the Java file, you can run the program using the java command:
java SimpleDatabase

In this code, the program prompts the user to enter SQL statements with the "SQL> " prefix. The user can enter any valid SQL statement, such as CREATE TABLE, INSERT INTO. To exit the program, the user can enter "exit".

Whenever the user creates a table, the syntax will be of the form CREATE TABLE "table_name" ( col1 INTEGER, col2
STRING,....).

Whenever the user issues an insert command the insert will happen in the table file. The insert will be of
the form INSERT into "table_name" VALUES (col1, col2,..) VALUES(,)...