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


## Set up AWS S3 after creating an AWS account

1. Sign In to AWS Console
   Go to https://aws.amazon.com/ and log in with your AWS account credentials.

2. Create an S3 Bucket
   Navigate to Services → S3.

Click Create bucket.

Enter a unique bucket name and select the AWS region closest to your users.

Keep the defaults or adjust options like versioning, encryption, and access control as needed.

Click Create bucket.

3. Configure IAM User/Role
   Go to Services → IAM (Identity and Access Management).

Create a new IAM User (or Role) with Programmatic access.

Assign the AmazonS3FullAccess policy (or a more restricted policy as required) to this user.

Save the Access Key ID and Secret Access Key—you’ll need them for SDK/CLI setup.

4. Install and Configure AWS CLI (Optional but Recommended)
   Download and install the AWS CLI.

Run aws configure and provide:

Access Key ID

Secret Access Key

Default region (e.g., ap-south-1)

Default output format (e.g., json)

5. (Optional) Set Bucket Permissions
   Edit bucket permissions as needed (public/private, CORS, etc.).

For public file hosting, update the bucket policy to allow public read access (be mindful of security implications).

6. Integrate S3 in Code or Tools
   Use the access keys to configure SDKs (like AWS SDK for Java).

Connect from your application and perform S3 actions (upload, list, download).


