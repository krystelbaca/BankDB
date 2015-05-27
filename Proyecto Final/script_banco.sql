DROP TABLE  REFERENCIAS;
DROP TABLE  BURO_CREDITO;
DROP TABLE CUENTA_CREDITO;
DROP TABLE CUENTA_AHORRO;
DROP TABLE MOVIMIENTOS;
DROP TABLE EMPLEADOS;
DROP table CUENTA_AHORRO;
DROP TABLE CUENTAS_SEGUROS;
DROP TABLE SEGUROS;
DROP TABLE CUENTAS;
DROP table CLIENTES;


CREATE TABLE Clientes
(
	id_cliente           INTEGER NOT NULL ,
	nombre_cliente       VARCHAR2(20) CONSTRAINT clie_nomb_nn NOT NULL ,
	apellidos_cliente    VARCHAR2(20) CONSTRAINT clie_apell_nn NOT NULL ,
	direccion_cliente    VARCHAR2(20) CONSTRAINT clie_dire_nn NOT NULL ,
	f_nacimiento_cliente DATE CONSTRAINT clie_fnaci_nn NOT NULL ,
	telefono             INTEGER CONSTRAINT clie_tel_nn NOT NULL ,
	email                VARCHAR2(50) NULL ,
CONSTRAINT  clie_id_pk PRIMARY KEY (id_cliente)
);

CREATE TABLE Cuentas
(
	id_cuenta            INTEGER NOT NULL ,
	num_tarjeta          INTEGER NULL ,
	fecha_apertura       DATE NULL ,
	fecha_cierre         DATE NULL ,
	estado               VARCHAR2(20) NULL ,
	id_cliente           INTEGER NULL ,
CONSTRAINT  XPKCuentas PRIMARY KEY (id_cuenta),
CONSTRAINT R_11 FOREIGN KEY (id_cliente) REFERENCES Clientes (id_cliente)
);

CREATE UNIQUE INDEX XPKCuentas ON Cuentas
(id_cuenta   ASC);

CREATE TABLE Seguros
(
	id_seguro            INTEGER NOT NULL ,
	tipo_seguro          VARCHAR2(20) NULL ,
	importe              FLOAT NULL ,
	descripcion          VARCHAR2(50) NULL ,
CONSTRAINT  XPKSeguros PRIMARY KEY (id_seguro)
);

CREATE UNIQUE INDEX XPKSeguros ON Seguros
(id_seguro   ASC);

CREATE TABLE Cuentas_Seguros
(
	id_cuenta            INTEGER NOT NULL ,
	id_seguro            INTEGER NOT NULL ,
CONSTRAINT  XPKCuentas_Seguros PRIMARY KEY (id_cuenta,id_seguro),
CONSTRAINT R_17 FOREIGN KEY (id_cuenta) REFERENCES Cuentas (id_cuenta),
CONSTRAINT R_18 FOREIGN KEY (id_seguro) REFERENCES Seguros (id_seguro)
);

CREATE UNIQUE INDEX XPKCuentas_Seguros ON Cuentas_Seguros
(id_cuenta   ASC,id_seguro   ASC);

CREATE TABLE Empleados
(
	id_empleado          INTEGER NOT NULL ,
	nombre_empleado      VARCHAR2(25) CONSTRAINT empl_nomb_nn NOT NULL ,
	apellidos_empleado   VARCHAR2(25) CONSTRAINT empl_apell_nn NOT NULL ,
	direccion_empleado   VARCHAR2(25) NULL ,
	f_nacimieto_empleado DATE CONSTRAINT empl_fnaci_nn NOT NULL ,
	telefono_empleado    INTEGER NULL ,
	puesto               VARCHAR2(15) CONSTRAINT empl_puesto_nn NOT NULL ,
	contraseña           VARCHAR2(25) CONSTRAINT empl_cont_nn NOT NULL ,
CONSTRAINT  empl_id_pk PRIMARY KEY (id_empleado)
);

CREATE TABLE Movimientos
(
	folio                VARCHAR2(9) NOT NULL ,
	id_empleado          INTEGER NULL ,
	hora                 TIMESTAMP CONSTRAINT tran_hora_nn NOT NULL ,
	fecha                DATE CONSTRAINT tran_fech_nn NOT NULL ,
	importe              FLOAT NULL ,
	tipo_movimiento      VARCHAR2(20) NULL ,
	id_cuenta            INTEGER NULL ,
CONSTRAINT  tran_folio_pk PRIMARY KEY (folio),
CONSTRAINT R_3 FOREIGN KEY (id_empleado) REFERENCES Empleados (id_empleado),
CONSTRAINT R_14 FOREIGN KEY (id_cuenta) REFERENCES Cuentas (id_cuenta)
);

CREATE TABLE Cuenta_ahorro
(
	id_cuenta            INTEGER NOT NULL ,
	saldo                FLOAT NULL ,
CONSTRAINT  XPKCuenta_ahorro PRIMARY KEY (id_cuenta),
CONSTRAINT R_9 FOREIGN KEY (id_cuenta) REFERENCES Cuentas (id_cuenta)
);

CREATE UNIQUE INDEX XPKCuenta_ahorro ON Cuenta_ahorro
(id_cuenta   ASC);

CREATE TABLE Cuenta_credito
(
	id_cuenta            INTEGER NOT NULL ,
	credito              FLOAT NULL ,
CONSTRAINT  XPKCuenta_credito PRIMARY KEY (id_cuenta),
CONSTRAINT R_10 FOREIGN KEY (id_cuenta) REFERENCES Cuentas (id_cuenta)
);

CREATE UNIQUE INDEX XPKCuenta_credito ON Cuenta_credito
(id_cuenta   ASC);

CREATE TABLE Buro_credito
(
	id_bc                INTEGER NOT NULL ,
	adeudo               FLOAT NULL ,
	plazo__dias_         INTEGER NULL ,
	id_cuenta            INTEGER NULL ,
CONSTRAINT  XPKBuro_credito PRIMARY KEY (id_bc),
CONSTRAINT R_20 FOREIGN KEY (id_cuenta) REFERENCES Cuentas (id_cuenta)
);

CREATE UNIQUE INDEX XPKBuro_credito ON Buro_credito
(id_bc   ASC);


CREATE TABLE Referencias
(
	id_referencia        INTEGER NOT NULL ,
	nombre               VARCHAR2(20) NULL ,
	apellido             VARCHAR2(20) NULL ,
	telefono             INTEGER NULL ,
	direccion            VARCHAR2(20) NULL ,
	id_cliente           INTEGER NULL ,
	email                VARCHAR2(50) NULL ,
CONSTRAINT  XPKReferencias PRIMARY KEY (id_referencia),
CONSTRAINT R_7 FOREIGN KEY (id_cliente) REFERENCES Clientes (id_cliente)
);

CREATE UNIQUE INDEX XPKReferencias ON Referencias
(id_referencia   ASC);