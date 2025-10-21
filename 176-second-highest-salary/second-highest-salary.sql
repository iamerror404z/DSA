
SELECT MAX(salary) AS SecondHighestSalary 
    FROM Employee e
    JOIN(
        SELECT  MAX(salary) as highest_salary From Employee
    )  AS     Aim

WHERE NOT e.salary=Aim.highest_salary;