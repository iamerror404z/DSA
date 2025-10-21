SELECT e.name 
FROM Employee e

JOIN(
    SELECT managerId 
    FROM Employee 
    GROUP BY managerId
    HAVING COUNT(*)>=5 
    ) AS Aim

ON e.id=Aim.managerId;

