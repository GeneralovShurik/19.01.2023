use test;

-- 2. написать процедуру, которая создает результр таблицу с полями
-- name, id, adress, email, bday

-- включает пользователей, у которых день рождения
-- в текущем месяце, отсортированных в порядке убывания
-- по столбцу bday

-- пишем в новом скрипте

delimiter $$
create procedure proc4()
begin
	select name, u.id as user_id, address, email, bday
	
	from users u inner join users_info ui 
	
	-- нам нужно что бы (указываем по какому критерию эти две сравнивемые строки будут одинаковы)
	on u.id  = ui.user_id 
	
	where month(now()) = month(bday)
	
	-- сортируем по bday
	
	order by bday desc;
end $$
-- запуск через новый скрипт