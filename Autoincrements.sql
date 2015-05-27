--Empleados

CREATE SEQUENCE seq_emp_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER trig_rmp_id
BEFORE INSERT ON empleados
FOR EACH ROW
	BEGIN
  		SELECT seq_emp_id.nextval INTO :new.id_empleado from Dual;
	END
;

