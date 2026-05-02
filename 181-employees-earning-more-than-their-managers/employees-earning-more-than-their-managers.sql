# Write your MySQL query statement below
SELECT E.name as 'Employee' FROM Employee E
INNER JOIN Employee M 
ON M.id=E.managerId 
WHERE E.salary>M.salary;
