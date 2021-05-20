SELECT *
FROM y_emp;

SELECT emp_id, emp_name, position, dept_id
FROM y_emp
WHERE dept_id IS NULL;


SELECT emp_id, emp_name, position, dept_id
FROM y_emp
WHERE position = '사원'
OR dept_id = 400;


SELECT emp_name, position, salary
FROM y_emp
WHERE position = '차장'
OR position = '부장'
AND salary > 700;

select rowid, dept_id from y_dept;


SELECT emp_name, position, dept_id, hiredate
FROM y_emp
ORDER BY hiredate DESC;

SELECT emp_id, emp_name, dept_id, salary
FROM y_emp
ORDER BY dept_id, salary DESC;


SELECT emp_id, emp_name, salary * 12 annsal
FROM y_emp
ORDER BY annsal DESC;

SELECT emp_id, emp_name, salary * 12 annsal
FROM y_emp
ORDER BY 1 DESC;

SELECT UPPER(email), LOWER(email), INITCAP(email)
FROM y_emp
WHERE emp_id < 1005;

SELECT emp_id, emp_name, salary, dept_id
FROM y_emp
WHERE LOWER(emp_name) = 'mark kim';


SELECT CONCAT(emp_name, position)
FROM y_emp
WHERE emp_id < 1005;

SELECT SUBSTR('Computer Information', 10, 4) result1,
		SUBSTR('Computer Information', -4, 4) result2
		FROM dual;



SELECT emp_name, email, INSTR(email, 'a')
FROM y_emp
WHERE dept_id = 100;

SELECT RPAD(emp_name, 12, '*') AS name , LPAD(salary, 5, '*')AS salary
FROM y_emp
WHERE dept_id = 400;

SELECT emp_name, phone, REPLACE(phone, '.', '-')phone1
FROM y_emp
WHERE dept_id = 400;


SELECT LTRIM('ababababbBaXXXAbbbabab', 'ab'),
RTRIM('ababaaaBaXXXAbbbbaababa', 'ab')
FROM dual;

SELECT TRIM('w' FROM 'window'),
TRIM(LEADING 'w' FROM 'window'),
TRIM(TRAILING 'w' FROM 'window')
FROM dual;

SELECT TRIM('0' FROM '00000012345678900000')
FROM dual;

SELECT ROUND(56.834,2), ROUND(56.834), ROUND(56.834, -1)
FROM dual;

SELECT TRUNC(56.834,2), TRUNC(56.834), TRUNC(56.834, -1)
FROM dual;


SELECT emp_name, salary, MOD(salary, 50)
FROM y_emp
WHERE dept_id = 300;


SELECT emp_id, hiredate,
MONTHS_BETWEEN(SYSDATE, hiredate) 근무기간,
ADD_MONTHS(hiredate, 3) 수습종료일,
NEXT_DAY(hiredate, '수요일'), LAST_DAY(hiredate)
FROM y_emp
WHERE position = '사원';


SELECT emp_id, hiredate,
ROUND(hiredate, 'MONTH'), TRUNC(hiredate, 'MONTH')
FROM y_emp
WHERE hiredate LIKE '05%';


--SQL TEST1
