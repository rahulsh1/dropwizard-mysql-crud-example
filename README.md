dropwizard-mssql-crud-example
=============================

Need MYSQL database:

	database: hello_world
	
	user: hello_user
	
	pass: pass1234
	

Build:

	mvn clean package
	

database update:

	java -jar target\holdinarms-0.0.1.jar db migrate main.yml
	
	
run:

	java -jar target\holdinarms-0.0.1.jar server main.yml
	
	

And listen on :

	http://localhost:9000
	
