# Activity Goal

Learn about JPA, Interfaces and Abstract classes while getting familiar with Git.

# Activity Details
1. Create a new branch called `4-JPA`.
2. Create a new package called `repository`.
3. Create an interface named `LearningResourceRepository`.
4. Add the dependency for Spring Data JPA in `build.gradle` file.
5. Add the dependency for an H2 in-memory database.
6. Add the database connection details in the properties file.
7. Add the SQL queries to insert the data to the in-memory database in the `data.sql` file.
8. Map your entity class to match with the database table and its columns. 
9. Modify your service class to load/save data to the in-memory database using the repository methods.
10. Delete the `LearningResources.csv` file.
11. Run the app and check if the records mentioned in `data.sql` are added successfully by navigating to http://localhost:8080/h2-console.
12. Call `saveLearningResources` method and check if the data is successfully stored in the database.
13. Raise a pull request and merge your changes to the `master` branch.
14. Delete the branch `4-JPA`.

⚠️ Do not push the password of the database to Git. You can choose to leave the password field empty before pushing or can use the environment variables feature in IntelliJ and use them in properties file.

# Activities to explore
1. Understand JPA concepts.
2. Understand resource files such as app.yml or app.properties.
3. Understand how to connect to dev database, stage database, prod database, etc
4. Understand good practise while checking in resource files. 
5. Understand what is an interface. Observe how it is used in the repository layer.
6. Understand JDBC as an alternative to connect to db.
