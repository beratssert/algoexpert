SELECT department_table.department_name, AVG(employee_table.salary) AS average_salary
FROM employee_table INNER JOIN department_table ON employee_table.department_id = department_table.department_id
GROUP BY department_table.department_name
ORDER BY average_salary DESC;