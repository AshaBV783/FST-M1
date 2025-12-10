-- Activity3

-- Show data from the salesman_id and salesman_city columns
select salesman_id , salesman_city from SALESMAN ;

--Show data of salesman from Paris
select * from SALESMAN where salesman_city = 'Paris';

--Show salesman_id and commission of Paul Adam
select salesman_id , commission  from SALESMAN   where salesman_name = 'Paul Adam';