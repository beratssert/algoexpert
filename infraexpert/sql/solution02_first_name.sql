SELECT e.id, e.name, e.salary, e.department_id
FROM employee_table e
  JOIN department_table d
  ON e.department_id = d.department_id
WHERE e.name LIKE 'B%'
  AND e.salary > 50000
  AND d.department_name = 'Sales';