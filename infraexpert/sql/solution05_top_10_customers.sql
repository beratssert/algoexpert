SELECT customer_id, SUM(amount) as amount
FROM order_table
GROUP BY customer_id
ORDER BY amount DESC
  LIMIT 10;