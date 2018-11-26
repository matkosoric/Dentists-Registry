
Croatian dentists registry 2015 web application
===================================================

This is a CRUD application intended to provide user-friendly searching capabilities of a small dataset about dentists. It has a login screen, main searching form, view form with out enabled editing, view form with enabled editing, and similar form for entering new data. Dentists can be searched by name, surname, city and street; fifth column contains number of patients, but is not searchable. There are slightly over 2000 entries in the dataset, and since I did not integrated pagination, it takes some time to load the main screen, depending on the client machine. CSV file and SQL scripts for importing are located at src/main/resources.   

Login credentials are:    
Username: root    
Password: root


### Original DataSet

These datasets are lists of doctors grouped by four criteria: medical protection for pre-school children, women, general medicine and dental health care. Just like in the case of data visualization subproject with Impala, I was using the same dataset about professionals in dental health care, without some columns. It was published at the end of February 2015.
* [Popis doktora ugovorenih u djelatnosti dentalne zdravstvene zaštite - data.gov.hr](https://data.gov.hr/dataset/broj-pacijenata-po-ordinaciji-primarne-zdravstvene-za-tite)


### Created With

* [Spring Boot 2.1.0](https://spring.io/projects/spring-boot)
* [MySql Community Server 8.0.13](https://dev.mysql.com/downloads/mysql/)
* [Thymeleaf 3.0.11](https://www.thymeleaf.org/)
* [jQuery 3.3.1](https://jquery.com/)
* [Bootstrap 4.0.0](https://getbootstrap.com/)
 

### Screenshots

![Croatian Dentists Register - Login Screen - Matko Soric](https://raw.githubusercontent.com/matkosoric/Dentists-Registry/master/src/main/resources/screenshots/CDR1.png?raw=true "Croatian Dentists Register - Login Screen - Matko Soric")
      
![Croatian Dentists Register - Search - Matko Soric](https://raw.githubusercontent.com/matkosoric/Dentists-Registry/master/src/main/resources/screenshots/CDR2.png?raw=true "Croatian Dentists Register - Search - Matko Soric")

![Croatian Dentists Register - View Detils - Matko Soric](https://raw.githubusercontent.com/matkosoric/Dentists-Registry/master/src/main/resources/screenshots/CDR3.png?raw=true "Croatian Dentists Register - View Detils - Matko Soric")

![Croatian Dentists Register - Edit Details - Matko Soric](https://raw.githubusercontent.com/matkosoric/Dentists-Registry/master/src/main/resources/screenshots/CDR4.png?raw=true "Croatian Dentists Register - Edit Details - Matko Soric")
