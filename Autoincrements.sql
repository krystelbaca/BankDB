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

--Referencias

CREATE SEQUENCE seq_ref_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER trig_ref_id
BEFORE INSERT ON referencias
FOR EACH ROW
	BEGIN
  		SELECT seq_ref_id.nextval INTO :new.id_referencia from Dual;
	END
;

--Cuentas

CREATE SEQUENCE seq_cue_id
START WITH 10000
INCREMENT BY 1
NOMAXVALUE;

CREATE OR REPLACE TRIGGER trig_cue_id
BEFORE INSERT ON referencias
FOR EACH ROW
	BEGIN
  		SELECT seq_cue_id.nextval INTO :new.id_cuenta	 from Dual;
	END
;