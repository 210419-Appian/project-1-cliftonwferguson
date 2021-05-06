

 --DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  role_id integer PRIMARY KEY,
  user_role varchar(30) NOT NULL unique
 );

  INSERT INTO roles (role_id, user_role)
	VALUES (1, 'admin'), 
	(2, 'employee'),
	(3, 'standard'),
	(4, 'premium');
	
	
	SELECT * FROM roles;

 --DROP TABLE IF exists accountstatus;

 CREATE TABLE accountstatus (
    status_id Integer PRIMARY KEY,
    status varchar(30) NOT NULL UNIQUE 
 );

 INSERT INTO accountstatus (status_id, status)
   VALUES  (1, 'pending'),
           (2, 'open'),
           (3, 'closed'),
           (4, 'denied');

   SELECT * FROM accountstatus;

  
  --DROP TABLE IF EXISTS accounttype;
  
  CREATE TABLE accounttype (
    type_id integer PRIMARY KEY,
    type varchar(30) NOT NULL unique
  );
 
 INSERT INTO accounttype (type_id, type)
   VALUES (1, 'checking'),
          (2, 'savings');
 
   SELECT * FROM accounttype;
  
  --DROP TABLE IF EXISTS user_table;
  
  CREATE TABLE user_table (
   user_id SERIAL PRIMARY KEY,
   user_name varchar(30) NOT NULL UNIQUE,
   pass_word varchar(15) NOT null,
   first_name varchar(15) NOT null,
   last_name varchar(15) NOT NULL,
   email varchar(30) NOT NULL,
   user_role INTEGER REFERENCES roles(role_id)
   );
  
  INSERT INTO user_table (user_name, pass_word, first_name, last_name, email, user_role)
     VALUES ('c.ferguson', 'password1', 'clifton', 'ferguson', 'cf@email.com', 1),
            ('j.smith', 'password2', 'john', 'smith', 'js@email.com', 2),
            ('jandoe', 'password3', 'jane', 'doe', 'janedoe@email.com', 3),
            ('johndoe', 'password4', 'john', 'doe', 'johndoe@email.com', 4);
  
  SELECT * FROM user_table;
 
  --DELETE FROM user_table WHERE user_name = 'j.smit';

 --INSERT INTO user_table (user_id, user_name, pass_word, first_name, last_name, email, user_role)
   VALUES (2, 'j.smit', 'password2', 'john', 'smith', 'js@email.com', 2);
  
 DROP TABLE IF EXISTS account

  CREATE TABLE account (
  account_id SERIAL PRIMARY KEY,
  balance double precision NOT NULL,
  account_status_id INTEGER REFERENCES accountstatus(status_id),
  account_type INTEGER REFERENCES accounttype(type_id),
  user_id integer REFERENCES user_table(user_id)
  )
  
  INSERT INTO account (balance, account_status_id, account_type, user_id) 
   VALUES (10.00, 1, 1, 1),
          (100.00, 2, 2, 1),
          (23.00, 2, 1, 2),
          (00.00, 3, 1, 3),
          (00.00, 4, 2, 4);
  
 SELECT * FROM account;
  
 
   
   