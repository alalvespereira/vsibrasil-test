-- a. Returns the names of all Salesperson that don’t have any order with Samsonic.

with spaux as (
	select s.id
	from salesperson s  
		left join orders o on s.id  = o.salesperson_id
		left join customer c on c.id = o.customer_id and c."name" = 'Samsonic'
	where
		c."name" is not null)
select s.Name
from salesperson s
where
	s.id not in (select id from spaux)
	
-- b. Updates the names of Salesperson that have 2 or more orders. It’s necessary to add an ‘*’ in the end of the name. 

update Salesperson
set Name = concat(Name, '*')
where id in (
	select o.salesperson_id from orders o
	group by o.salesperson_id 
	having count(*) >= 2
)

-- c. Deletes all Ssalesperson that placed orders to the city of Jackson.

with spaux as (
	select s.id
	from salesperson s  
		left join orders o on s.id  = o.salesperson_id
		left join customer c on c.id = o.customer_id and c.city = 'Jackson'
	where
		c.city is not null
)
delete from salesperson where id in (select id from spaux)

-- d. The total sales amount for each Salesperson. If the salesperson hasn’t sold anything, show zero.

select s.id, s."name", coalesce(sum(o.Amount), 0) AS sales
from salesperson s  
	left join orders o on s.id  = o.salesperson_id
group by
	s.id, s."name"
	
-- Queries de criação das tabelas e carga inicial dos dados

CREATE TABLE Salesperson (
    ID INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Age INT NOT NULL,
    Salary DECIMAL(10, 2) NOT NULL
);

-- Inserção dos dados na tabela Salesperson
INSERT INTO Salesperson (ID, Name, Age, Salary) VALUES
(1, 'Abe', 61, 140000),
(2, 'Bob', 34, 44000),
(5, 'Chris', 34, 40000),
(7, 'Dan', 41, 52000),
(8, 'Ken', 57, 115000),
(11, 'Joe', 38, 38000);


CREATE TABLE Customer (
    ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    City VARCHAR(50) NOT NULL,
    IndustryType CHAR(1) NOT NULL
);

-- Inserção dos dados na tabela Customer
INSERT INTO Customer (ID, Name, City, IndustryType) VALUES
(4, 'Samsonic', 'Pleasant', 'J'),
(6, 'Panasung', 'Oaktown', 'J'),
(7, 'Samony', 'Jackson', 'B'),
(9, 'Orange', 'Jackson', 'B');


CREATE TABLE Orders (
    ID INT PRIMARY KEY,
    order_date DATE NOT NULL,
    customer_id INT NOT NULL,
    salesperson_id INT NOT NULL,
    Amount DECIMAL(10, 2) NOT NULL
--    FOREIGN KEY (customer_id) REFERENCES Customer(ID),
--    FOREIGN KEY (salesperson_id) REFERENCES Salesperson(ID)
);

INSERT INTO Orders (ID, order_date, customer_id, salesperson_id, Amount) VALUES
(10, '1996-08-02', 4, 2, 540),
(20, '1999-01-30', 4, 8, 1800),
(30, '1995-07-14', 9, 1, 460),
(40, '1998-01-29', 7, 2, 2400),
(50, '1998-02-03', 6, 7, 600),
(60, '1998-03-02', 6, 7, 720),
(70, '1998-05-06', 9, 7, 150);




