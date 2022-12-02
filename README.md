# Project-Group-13

This is our group's web app for our Moon Base Project Management System.

# Getting Started
1. [Install MySQL Workbench 8](https://dev.mysql.com/downloads/workbench/)
1. In MySQL Workbench 8, run our web app's database script. It contains the database structure and demo data [database/Moon_Base_Database.sql](database/Moon_Base_Database.sql)
    * It will create a DB user called `javauser` with a known password, and that user will just have access to our app database.
1. Adjust `spring.datasource.url` in [src/main/resources/application.properties](src/main/resources/application.properties) if needed. For example, your DB server may be on a different host or port.
1. Run [src/main/java/com/example/moonbaseresearchmanagement/MoonBaseResearchManagementApplication.java](src/main/java/com/example/moonbaseresearchmanagement/MoonBaseResearchManagementApplication.java)
1. Open the Webapp Frontend [frontend/index.html](frontend/index.html) <a href="frontend/index.html" target="_blank">example</a>
1. (Optional) Import [MoonBase_Postman.postman_collection](MoonBase_Postman.postman_collection) into Postman if you want to test the web API directly

Congratulations! 🎉 You are now running our Moon Base Project Management System!

# Demo Functionality

|SN|Description|Example|Front-end|Postman|
|----:|----|----|----|:----|
|1|Get all records in an entity table|Show all personnel|X|X|
|2|Get all records in an entity table, sorted|Show all personnel sorted by name|X|X|
|3|Get a specific entity item|Get a person's projects by name (non-existing records)|X|X|
|4|Add a record to an entity table|Create a new person using name and country (duplicate records)|X|X|
|5|Update an entity record|Edit a person's name (non-existing records)|X|X|
|6|Deleting an entity record|Removing a person (non-existing records)|X|X|
|7|Adding a relational record|Assign a person to a project|X|X|
|8|Deleting a relational record|Removing a person from a project|X|X|