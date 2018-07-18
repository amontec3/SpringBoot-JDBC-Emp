create table employee
(	id integer not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	empDeptNo integer not null,
	empHireDate timestamp,
	active boolean not null,
	primary key (id)
	);
	
	
	INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,EMPDEPTNO,EMPHIREDATE,ACTIVE)
	values(10001,'Mike','Smith',23,sysdate(),true);
	
	INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,EMPDEPTNO,EMPHIREDATE,ACTIVE)
	values(10002,'Jack','Wilber',22,sysdate(),true);
	
	INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,EMPDEPTNO,EMPHIREDATE,ACTIVE)
	values(10003,'Lisa','Arron',23,sysdate(),true);
	
	INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,EMPDEPTNO,EMPHIREDATE,ACTIVE)
	values(10004,'Arnold','Mon',22,sysdate(),false);
	
	
	