SELECT e.first_name, e.last_name, e.salary
FROM EMPLOYEES e
join departments d on e.department_id = d.department_id;

-- виюрать всех рабочих у ко торых менеджер 100

SELECT e.first_name, e.last_name ,e.manager_id
FROM employees e
where e.manager_id = 100;

-- виюрать всех рабочих у которых зарплата больше 1000 

select e.first_name, e.last_name,e.salary
from employees e
where e.salary > '1000' ;

-- виюрать всех рабочих у которых зарплата больше 5000 менеше 10000

select e.first_name, e.last_name,e.salary
from employees e
where e.salary > '5000' AND e.salary < '10000';

-- виюрать всех рабочих из europe 

select e.FIRST_NAME,r.region_name 
from employees e
join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID
join countries co on l.COUNTRY_ID = co.COUNTRY_ID
join REGIONS r on co.REGION_ID = r.REGION_ID
where r.region_name = 'Europe';

-- виюрать всех програмистовs
select e.first_name,j.job_title,e.salary
from employees e
join jobs j on e.job_id = j.job_id
where j.job_title = 'Programmer';

-- виюрать всех програмистов
select e.first_name,e.salary,e.JOB_ID,e.DEPARTMENT_ID
from employees e
where e.DEPARTMENT_ID = '60';






--вибрать всех роботников имя которых имеет буквы le 
SELECT e.first_name
FROM EMPLOYEES e
where e.FIRST_NAME LIKE '%le%';

--Обычное удаление таблицы 
DROP TABLE NOTEBOOK ;

--Удаление таблицы со связями
DROP TABLE MANUFACTURER CASCADE  CONSTRAINTS ;

-- вибрать всех робочих у которых комисии не нул 
SELECT FIRST_NAME,COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL AND
ROWNUM <= 4;
















