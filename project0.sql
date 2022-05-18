CREATE TABLE bankingacct(acct_num INT GENERATED ALWAYS AS IDENTITY, user_num INT, acct_type VARCHAR(20), acct_balance INT, PRIMARY KEY(acct_num));
CREATE TABLE bankinguser(user_num INT GENERATED ALWAYS AS IDENTITY, acct_num INT, fname VARCHAR(20), lname VARCHAR(20), address VARCHAR(255), zip INT, phone varchar(20), dob INT, username VARCHAR(20), password VARCHAR(20), PRIMARY KEY(user_num), CONSTRAINT fk_acct_num FOREIGN KEY(acct_num) REFERENCES bankingacct(acct_num));



SELECT * FROM bankinguser;
SELECT * FROM bankingacct;
TRUNCATE bankinguser, bankingacct RESTART IDENTITY;
TRUNCATE bankinguser, bankingacct;




INSERT INTO bankingacct (user_num, acct_type, acct_balance) VALUES (1, 'Checking', 1500.89);
INSERT INTO bankinguser (acct_num, fname, lname, address, zip, phone, dob, username, password) VALUES (1, 'John', 'McCallister', '123 Country Way', 34563, '323-232-2345', 05231960, 'john123', 'rambo123');