# whfnp-volunteer-portal-api
Women Hack for Non Profits Volunteer Portal API (Backend)

*****Data Access Layer (Entities and Repositories) for the future WHFNP PORTAL API*****

Dev Setup Instructions

You will need Java 1.8 installed

You will need MYSQL installed and set up a username and password

Clone the git hub repository with the command: git clone https://github.com/womenhackfornonprofits/whfnp-volunteer-portal-api.git

In the src/main/database directory - use WHFNP_CreateDatabase.sql script and run in MySQL to create the required database for this application

Create a new project in your IDE (e.g. IntelliJ or Eclipse) by selecting New Project from Existing Source (select the directory where you cloned the code to).

Edit the application.properties file and update the URL, Username and password for your MySQL database server

Run the Application.java class to test the code

The application should automatically create the required tables and relationships in the database, and populate with some test data. 

Some test user records from the database should be displayed in the console.





