use test;
-- написать хранимую функцию, которая принимает данные пользователя
-- создает его (добавляет данные в таблицу) и возвращает средний возраст
-- пользователей, родившихся в тот же год

delimiter $$

create function func4(
user_age int,
user_name varchar(64),
user_bday datetime
)
returns float
deterministic
begin 
	
	declare avg_age float;--  объявляем переменную

	-- добавляем нового пользователя
	insert into users(age, name, bday)
	values(user_age, user_name, user_bday);

-- 2 часть задания-возвращает средний возраст
-- пользователей, родившихся в тот же год

-- делаем выборку
select avg(age) into avg_age from users
-- условие
where year(user_bday) = year(bday);

-- объявляем переменную после begin в начале

return avg_age;
end $$
-- запускаем в отдельном скрипте

-- 2. написать процедуру, которая создает результр таблицу с полями
-- name, id, adress, email, bday

-- включает пользователей, у которых день рождения
-- в текущем месяце, отсортированных в порядке убывания
-- по столбцу bday

-- пишем в новом скрипте