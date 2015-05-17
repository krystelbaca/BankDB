DROP TABLE Cuentas_Debito;
DROP TABLE Cuentas_Ahorro;
DROP TABLE Referencias;
DROP TABLE Empleados;
DROP TABLE Movimientos;
DROP TABLE Cuentas;
DROP TABLE Clientes;

CREATE TABLE Empleados
(
	Id_empleado 		NUMBER CONSTRAINT empl_id_pk PRIMARY KEY,
	Nombre_empleado 	VARCHAR2(25) CONSTRAINT empl_nomb_nn NOT NULL,
	Apellidos_empleado 	VARCHAR2(25) CONSTRAINT empl_apell_nn NOT NULL,
	Direccion_empleado 	VARCHAR2(25) NOT NULL,
	f_nacimieto_empleado 	DATE CONSTRAINT empl_fnaci_nn NOT NULL,
	Telefono_empleado 	VARCHAR2(13) NOT NULL,
	Puesto 			VARCHAR2(15) CONSTRAINT empl_puesto_nn NOT NULL,
	Contrasenia 		VARCHAR2(25) CONSTRAINT empl_cont_nn NOT NULL,
	Usuario			VARCHAR2(20) CONSTRAINT empl_usua_nn NOT NULL
);

CREATE TABLE Clientes(
	Id_cliente 		NUMBER CONSTRAINT clie_id_pk PRIMARY KEY,
	Nombre_cliente 		VARCHAR2(20) CONSTRAINT clie_nomb_nn NOT NULL, 
	Apellidos_cliente 	VARCHAR2(20) CONSTRAINT clie_apell_nn NOT NULL,
	Direccion_cliente 	VARCHAR2(20) CONSTRAINT clie_dire_nn NOT NULL,
	f_nacimiento_cliente 	DATE CONSTRAINT clie_fnaci_nn NOT NULL,
	Telefono 		VARCHAR2(11) CONSTRAINT clie_tel_nn  NOT NULL,
	PIN			NUMBER(4) CONSTRAINT clie_pin_nn  NOT NULL
);

CREATE TABLE Cuentas(
	Id_cuenta 		NUMBER CONSTRAINT cuen_id_pk PRIMARY KEY,
	Saldo 			NUMBER CONSTRAINT cuen_sald_ch CHECK (Saldo>=0),
	Id_cliente 		NUMBER NOT NULL,
	Tipo varchar2(4) 	CONSTRAINT cuen_tipo_nn NOT NULL,
				CONSTRAINT cuen_clie_fk FOREIGN KEY (Id_cliente) REFERENCES clientes(Id_cliente)
);

CREATE TABLE Movimientos
(
	Folio			NUMBER CONSTRAINT tran_folio_pk PRIMARY KEY,
	Id_cuenta 		NUMBER CONSTRAINT tran_cuen_nn NOT NULL,
	Destino_cuenta 		NUMBER CONSTRAINT tran_dest_nn NOT NULL,
	Hora 			VARCHAR2(5) CONSTRAINT tran_hora_nn NOT NULL,
	Fecha 			DATE CONSTRAINT tran_fech_nn NOT NULL,
	Importe 		NUMBER CONSTRAINT tran_impo_ch CHECK (importe>=0),
	Tipo_movimiento 	VARCHAR2(2) CONSTRAINT tran_tipo_nn NOT NULL,
				CONSTRAINT tran_cuen_fk FOREIGN KEY (Id_cuenta) REFERENCES cuentas(Id_cuenta),
				CONSTRAINT tran_dest_cuen_fk FOREIGN KEY (Destino_cuenta) REFERENCES cuentas(Id_cuenta)
);

CREATE TABLE Referencias
(
	Id_referencia        	NUMBER NOT NULL ,
	Nombre               	VARCHAR2(20) NOT NULL ,
	Apellido             	VARCHAR2(20) NOT NULL ,
	Telefono             	VARCHAR2(11) NOT NULL ,
	Direccion            	VARCHAR2(20) NOT NULL ,
	Id_cliente           	NUMBER NOT NULL ,
				PRIMARY KEY (Id_referencia),
				FOREIGN KEY (Id_cliente) REFERENCES Clientes (Id_cliente)
);

CREATE TABLE Cuentas_Ahorro
(
	Id_cuenta            	NUMBER NOT NULL ,
	Tipo_interes         	VARCHAR2(20) NOT NULL ,
				PRIMARY KEY (Id_cuenta),
				FOREIGN KEY (Id_cuenta) REFERENCES Cuentas (Id_cuenta)
);

CREATE TABLE Cuentas_Debito
(
	Id_cuenta           	NUMBER NOT NULL ,
	Comision             	VARCHAR2(20) NOT NULL ,
				PRIMARY KEY (Id_cuenta),
				FOREIGN KEY (Id_cuenta) REFERENCES Cuentas (Id_cuenta)
);

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

INSERT INTO EMPLEADOS VALUES(1,'root','root','root',to_date('01/01/00'),'1','root','root','root');

