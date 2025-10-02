# DBConnections

## Setup:

https://dev.mysql.com/doc/mysql-getting-started/en/


fci@MacBook-Air Documents % mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 12
Server version: 9.2.0 Homebrew

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;

+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| test               |
+--------------------+
5 rows in set (0.06 sec)

mysql> USE test;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| users          |
+----------------+
1 row in set (0.00 sec)

mysql> select * from users;
+----+------+---------------+------------+-----------+
| id | age  | created_at    | first_name | last_name |
+----+------+---------------+------------+-----------+
|  1 |   30 | 1743881294544 | John       | Doe       |
+----+------+---------------+------------+-----------+
1 row in set (0.01 sec)
