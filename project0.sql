CREATE TABLE bankingacct(acct_num INT GENERATED ALWAYS AS IDENTITY, user_num INT, acct_type VARCHAR(20), acct_balance INT, PRIMARY KEY(acct_num));
CREATE TABLE bankinguser(user_num INT GENERATED ALWAYS AS IDENTITY, acct_num INT, fname VARCHAR(20), lname VARCHAR(20), address VARCHAR(255), zip INT, phone varchar(20), dob INT, username VARCHAR(20), password VARCHAR(20), PRIMARY KEY(user_num), CONSTRAINT fk_acct_num FOREIGN KEY(acct_num) REFERENCES bankingacct(acct_num));

acct_num INT REFERENCES bankingacct(acct_num) ON DELETE CASCADE ON UPDATE CASCADE
user_num INT REFERENCES bankinguser(user_num) ON DELETE CASCADE ON UPDATE CASCADE
truncate table bankingacct, bankinguser;
select * from bankinguser;
select * from bankingacct;




CREATE TABLE bankingacct(acct_num INT GENERATED ALWAYS AS IDENTITY, user_num INT REFERENCES bankinguser(user_num) ON DELETE CASCADE ON UPDATE CASCADE, acct_type VARCHAR(20), acct_balance INT, PRIMARY KEY(acct_num));
CREATE TABLE bankinguser(user_num INT GENERATED ALWAYS AS IDENTITY, acct_num INT REFERENCES bankingacct(acct_num) ON DELETE CASCADE ON UPDATE CASCADE, fname VARCHAR(20), lname VARCHAR(20), address VARCHAR(255), zip INT, phone varchar(20), dob INT, username VARCHAR(20), password VARCHAR(20), PRIMARY KEY(user_num), CONSTRAINT fk_acct_num FOREIGN KEY(acct_num) REFERENCES bankingacct(acct_num));




CREATE TABLE bankinguser(user_num INT GENERATED ALWAYS AS IDENTITY, acct_num INT, fname VARCHAR(20), lname VARCHAR(20), address VARCHAR(255), zip INT, phone varchar(20), dob INT, username VARCHAR(20), password VARCHAR(20), PRIMARY KEY(user_num), CONSTRAINT fk_acct_num FOREIGN KEY(acct_num) REFERENCES bankingacct(acct_num));