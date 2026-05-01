SELECT id,movie,description,rating from Cinema
WHERE id%2=1 AND NOT ( description REGEXP 'boring$')
ORDER by rating DESC;