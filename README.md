# whfnp-volunteer-portal-api
Women Hack for Non Profits Volunteer Portal API (Backend)

***Proposed PORTAL API for retrieving and saving data in the Portal Database***

**Registering Volunteer**

POST /api/register/{type}   (e.g. type is volunteer - /api/register/volunteer)

sending the Volunteer's details in the following Json format:

Example:

{

    "firstName":"Fiona",
    "lastName":"Condor",
    "emailAddress":"fee@yahoo.co.uk",
    "telephoneNumber":"01234567890",
    "type":"volunteer",
    "userRoles":
  		[
              		{"id":"1","roleName":"User"},
        		 {"id":"2","roleName":"Admin"}
        	],	
     "status":{"id":"1","statusName":"AVAILABLE"}, 
     "userSkills":
  		[
    			{"id":"1","skill":"Java"},
    			{"id":"2","skill":"MySQL"}     
    		],
     "vptypes":
  		[
    			{"fieldName": "AgeRange","fieldValue":"25-35"},
    			{"fieldName": "Occupation","fieldValue":"Java Developer"},    			
  			{"fieldName": "Location","fieldValue":"London"},
    			{"fieldName": "Biography","fieldValue":"Experienced Java Developer 10 years, wanna be Mobile dev"},
	   		{"fieldName": "LinkedinProfile","fieldValue":"https://www.linkedin.com/in/feecondor"},
	   		{"fieldName": "TwitterHandle","fieldValue":"@feecondor"},
    			{"fieldName": "AreasOfInterest","fieldValue":"Back-end, Front-end"},
    			{"fieldName": "AvailableFromDate","fieldValue":"04/01/2016"},
    			{"fieldName": "AvailableToDate","fieldValue":"20/12/2016"},
    			{"fieldName": "DisplayOnWebsite","fieldValue":"Y"},
    			{"fieldName": "Status","fieldValue":"Active"},
    			{"fieldName": "TimeCommittment","fieldValue":"5 hours per week"}
  		]
}

returns the following:

*For successful submission:*

{

    "success": true,
    "message": "Profile saved"
}

OR

*For failed submission:*

{

    "success": false,
    "message":"Profile could not be save"
}

**Retrieving a list of Volunteers**

GET /api/profiles/{type}   (e.g. type is volunteer - /api/profiles/volunteer)

returns the following:

//TODO Example of GET request list of volunteers//


**Registering a Non-Profit**

POST /api/register/{type}   (e.g. type is non-profit - /api/register/non-profit)

sending the Non-Profit's details in the following Json format:

Example:

{

    "firstName":"Jeanette",
    "lastName":"Condor",
    "emailAddress":"jc@yahoo.co.uk",
    "telephoneNumber":"01234567890",
    "type":"non-profit",
    "userRoles":
  		[
              		{"id":"1","roleName":"User"},
        		 {"id":"2","roleName":"Admin"}
        	],	
     "status":{"id":"3","statusName":"ACTIVE"}, 
     "vptypes":
  		[
    			{"fieldName": "OrganisationName","fieldValue":"Pimp My Cause"},
    			{"fieldName": "Address","fieldValue":"123 Anywhere Rd, Anytown,UK EC1 2HP"},    			
  			{"fieldName": "Location","fieldValue":"London"},
    			{"fieldName": "Biography","fieldValue":"Pimp My Cause brings together worthwhile causes with talentedmarketers – including innovators, strategists, advertisers, graphic designers, web developers, PR specialists and researchers who can provide transformational input pro bono."},
	   		{"fieldName": "Website","fieldValue":"http://www.pimpmycause.org"},
	   		{"fieldName": "TwitterHandle","fieldValue":"@pimpmycause"},
    			{"fieldName": "LogoUrl","fieldValue":"http://www.pimpmycause.org/images/logo.png"},
    			{"fieldName": "DisplayOnWebsite","fieldValue":"Y"}
  		]
}

returns the following:

*For successful submission:*

{

    "success": true,
    "message": "Profile saved"
}

OR

*For failed submission:*

{

    "success": false,
    "message":"Profile could not be save"
}


**Retrieving a list of Non-Profits**

GET /api/profiles/{type}   (e.g. type is non-profit - /api/profiles/non-profit)

returns the following:

//TODO Example of GET request list of non-profits//




**List of Statuses for Drop Down List on Sign Up form**

GET /api/statuses

returns the following:

Example:

{

  -0:{
      
      "id": 1
      "statusName": "AVAILABLE"
  }
  
  -1:{
  
    "id": 2
    "statusName": "UNAVAILABLE"
  }
  
  -2:{
  
    "id": 3
    "statusName": "ACTIVE"
  }
  
  -3:{
  
    "id": 4
    "statusName": "DISABLED"
  }
  
}

**List of Skills for Drop Down List on Volunteer form**

GET /api/skills

returns the following in Json format:

Example:

{

  -0:{

    "id": 1
    "skill": "Java"
    "description": "Java Programming"
    "proficiencyLevel": "3"
  }

  -1:{

    "id": 2
    "skill": "MySQL"
    "description": "MySQL Database Development"
  }

  -2:{

    "id": 3
    "skill": "Redis"
    "description": "Redis Configuration"
  }

}

**List of Roles for Drop Down List of Volunteer form**

GET /api/roles

returning the following in Json format:

Example:

{

  0:  {
  
      "id": 1
      "roleName": "user"
  }

  1:  {
  
      "id": 2
      "roleName": "admin"
  }
  
}




***TODO: Below needs updating again***

*****Data Access Layer (Entities and Repositories) for the future WHFNP PORTAL API*****

Dev Setup Instructions

You will need Java 1.8 installed

You will need Apache Maven 3.*  installed 

You will need MYSQL installed and set up a username and password

Clone the git hub repository with the command: git clone https://github.com/womenhackfornonprofits/whfnp-volunteer-portal-api.git

In the src/main/database directory - use WHFNP_CreateDatabase.sql script and run in MySQL to create the required database for this application

Create a new project in your IDE (e.g. IntelliJ or Eclipse) by selecting New Project from Existing Source (select the directory where you cloned the code to).

Edit the application.properties file and update the URL, Username and password for your MySQL database server

Run the Application.java class to test the code

The application should automatically create the required tables and relationships in the database, and populate with some test data. 

Some test user records from the database should be displayed in the console.





