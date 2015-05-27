--Empleados

CREATE SEQUENCE seq_emp_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER trig_emp_id
BEFORE INSERT ON empleados
FOR EACH ROW
	BEGIN
  		SELECT seq_emp_id.nextval INTO :new.id_empleado from Dual;
	END
;

--Clientes

CREATE SEQUENCE seq_clie_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER trig_clie_id
BEFORE INSERT ON clientes
FOR EACH ROW
	BEGIN
  		SELECT seq_clie_id.nextval INTO :new.id_cliente from Dual;
	END
;
