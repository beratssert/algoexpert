SELECT e.emp_id, e.emp_name, e.emp_no, m.manager_name, d.department_name
FROM (SELECT emp_id, emp_name, emp_no, manager_id, department_id
      FROM employee_table
      ORDER BY emp_id DESC
      LIMIT 3)
        AS e
        LEFT JOIN manager_table AS m ON e.manager_id = m.manager_id
        LEFT JOIN department_table AS d ON e.department_id = d.department_id