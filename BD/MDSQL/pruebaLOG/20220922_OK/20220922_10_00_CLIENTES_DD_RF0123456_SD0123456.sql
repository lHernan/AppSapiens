CREATE TABLE CLIENTES(
COD_CLIENTE VARCHAR2(10) NOT NULL,
TXT_NOMBRE VARCHAR2(50) NOT NULL,
TXT_APELLIDO1 VARCHAR2(50) NOT NULL,
TXT_APELLIDO2 VARCHAR2(50),
COD_DOCUM VARCHAR2(10) NOT NULL
);
COMMENT ON TABLE CLIENTES IS 'TABLA DE CLIENTES';
COMMENT ON COLUMN CLIENTES.COD_CLIENTE IS 'CODIGO DE CLIENTE';
COMMENT ON COLUMN CLIENTES.TXT_NOMBRE IS 'NOMBRE DEL CLIENTE';
COMMENT ON COLUMN CLIENTES.TXT_APELLIDO1 IS 'APELLIDO 1';
COMMENT ON COLUMN CLIENTES.TXT_APELLIDO2 IS 'APELLIDO 2';
COMMENT ON COLUMN CLIENTES.COD_DOCUM IS 'DOCUMENTO DE IDENTIDAD';

CREATE UNIQUE INDEX PK_CLIENTES ON CLIENTES
       (COD_CLIENTE ASC);

ALTER TABLE CLIENTES
      ADD CONSTRAINT PK_CLIENTES
      PRIMARY KEY(COD_CLIENTE)
      USING INDEX PK_CLIENTES;

CREATE UNIQUE INDEX AK_CLIENTES ON CLIENTES
       (COD_DOCUM ASC);
