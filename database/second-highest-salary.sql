# Write your MySQL query statement below

# Problem: Write a SQL query to get the second highest salary from the Employee table.

select max(Salary) from Employee  where Salary not in (select max(Salary) from Employee )
