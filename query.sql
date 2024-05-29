SELECT p.* ,c.name AS category
FROM products AS p INNER JOIN categories AS c 
on c.id=p.category_id;