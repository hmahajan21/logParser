## Log Parser
### Pre Requisites
In order to run this program you will need to first installed java 1.8 and above on your machine and have previously set up
gradle so that you can use the gradle command.

### Running The Program
Clone the repository Locally

After that you can use any IDE and run LogParserApplication (set args in IDE for Log File path)

OR

After this you simply need to cd into **<Chosen Directory>**/LogParser and run the command
```gradle bootRun --args='<Log_file_path>'``` which will build and run the program with the log file to be parsed being

### Notes
Visualize Database
Find hsqlJar file in **jar_files** folder

1. Download HSQLDB jar.

2. Extract in the folder where we have "data" folder(it contains database files) database files generated ("data" folder).

3. Now we are in the folder, where database folder is created. Run this command "java -cp hsqldb-2.4.1/hsqldb/lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing" here "hsqldb-2.4.1" is the downloaded hsqldb folder. It will open up a UI.

4. In this UI, make a new connection, select type as "HSQL Database Engine Standalone" put URL as "jdbc:hsqldb:file:data/mydb" (here data is the folder and mydb is the DB name), give user and password as defined in application properties, then say ok. It should connect. (Maken sure the path to the file DB is relative to the folder from where we opened the UI)