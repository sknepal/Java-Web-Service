# Java-Web-Service
A sample RESTful API with JAX-RS (implements the basic HTTP methods on a MySQL db).

##A few things
* Uses Maven. So import accordingly.
* No authentication involved. (As simple as it gets.)
* No database persistence or connection pooling done.
* Import the db, and change the connection details on DBUtil.java.
* GET ALL: localhost:8080/relisnp/webresources/states/
* GET INDIVIDUAL: localhost:8080/relisnp/webresources/states/{stateId}
* UPDATE : localhost:8080/relisnp/webresources/states/{stateId}
* DELETE : localhost:8080/relisnp/webresources/states/{stateId}

stateID refers to a state's Id. For example, AL for Alabama.

Note: I made it when I was learning JAX-RS. It is just a sample showing how to perform basic Database connections & manipulations in a web service. It is not complete and certainly not of production grade.