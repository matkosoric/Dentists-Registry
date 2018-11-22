
create table dentists(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(45) NOT NULL,
	city VARCHAR(30) NOT NULL,
	street VARCHAR(50),
	number_of_patients INT NOT NULL,
	PRIMARY KEY ( id )
)
CHARACTER SET utf8
;

LOAD DATA INFILE "/var/lib/mysql-files/dentists.csv"
INTO TABLE dentists
COLUMNS TERMINATED BY ','
ENCLOSED BY '\"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;