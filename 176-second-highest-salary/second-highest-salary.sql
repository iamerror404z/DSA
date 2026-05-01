# Write your MySQL query statement below
SELECT (SELECT DISTINCT Salary FROM Employee
ORDER BY salary DESC
LIMIT 1 ,1) AS SecondHighestSalary;