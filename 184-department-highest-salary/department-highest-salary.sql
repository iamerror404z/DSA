SELECT d.name as Department,e.name AS Employee ,e.salary as Salary
FROM Employee e

 INNER JOIN Department d ON d.id=e.departmentId

JOIN(
    SELECT MAX(salary) AS max_sal,departmentId
    FROM Employee e
    GROUP BY departmentId
)AS Aim

ON e.salary=Aim.max_sal AND e.departmentId=Aim.departmentId;