--------------------------------------------------------
-- Archivo creado  - lunes-septiembre-26-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AVISO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."AVISO" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"COD_NIVEL_AVISO" NUMBER(1,0), 
	"DES_NIVEL_AVISO" VARCHAR2(7 BYTE), 
	"COD_AVISO" NUMBER, 
	"DES_AVISO" VARCHAR2(100 BYTE), 
	"TXT_AVISO" VARCHAR2(500 BYTE), 
	"COD_PETICION" VARCHAR2(25 BYTE), 
	"FEC_ALTA" DATE DEFAULT sysdate, 
	"COD_USR_ALTA" VARCHAR2(8 BYTE), 
	"MCA_HABILITADO" VARCHAR2(1 BYTE), 
	"FEC_ACTU" DATE DEFAULT sysdate, 
	"COD_USR" VARCHAR2(8 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BBDD
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."BBDD" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"NOM_BBDD" VARCHAR2(30 BYTE), 
	"NOM_ESQUEMA" VARCHAR2(30 BYTE), 
	"NOM_BBDD_HIS" VARCHAR2(30 BYTE), 
	"NOM_ESQUEMA_HIS" VARCHAR2(30 BYTE), 
	"MCA_DEFECTO" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CAMPO_GLOSARIO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."CAMPO_GLOSARIO" 
   (	"NOM_COLUMNA" VARCHAR2(30 BYTE), 
	"TIP_DATO" VARCHAR2(40 BYTE), 
	"NUM_LONGITUD" NUMBER, 
	"NUM_DECIMAL" NUMBER, 
	"COD_GLOSARIO" NUMBER, 
	"MCA_EXCEPTION" VARCHAR2(1 BYTE), 
	"TXT_COMENTARIOS" VARCHAR2(4000 BYTE), 
	"TXT_EXCEPTION" VARCHAR2(200 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table DET_VALIDACION
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."DET_VALIDACION" 
   (	"NUM_VALIDACION" NUMBER, 
	"NUM_ELEM_VALID" NUMBER(6,0), 
	"DES_ELEMENTO" VARCHAR2(50 BYTE), 
	"NOM_ELEMENTO" VARCHAR2(30 BYTE), 
	"TIP_DATO" VARCHAR2(30 BYTE), 
	"NUM_LONGITUD" NUMBER, 
	"NUM_DECIMAL" NUMBER, 
	"COD_ESTADO_VALID" NUMBER(2,0), 
	"TXT_DES_VALID" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table ELEMENTO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."ELEMENTO" 
   (	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table ELEMENTO_NORMA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."ELEMENTO_NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50 BYTE), 
	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50 BYTE), 
	"VAL_TAM_MAX" NUMBER(2,0), 
	"TXT_FORMATO" VARCHAR2(200 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE, 
	"TXT_FORMATO_DES1" VARCHAR2(200 BYTE), 
	"TXT_FORMATO_DES2" VARCHAR2(200 BYTE), 
	"TXT_FORMATO_DES3" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table GLOSARIO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."GLOSARIO" 
   (	"COD_GLOSARIO" NUMBER(3,0), 
	"DES_GLOSARIO" VARCHAR2(150 BYTE), 
	"FEC_ALTA" DATE, 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table MODELO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."MODELO" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"NOM_MODELO" VARCHAR2(100 BYTE), 
	"NOM_ESQUEMA" VARCHAR2(30 BYTE), 
	"NOM_BBDD" VARCHAR2(30 BYTE), 
	"COD_GRUPO_BDS" VARCHAR2(50 BYTE), 
	"NOM_CARPETA_ADJ" VARCHAR2(100 BYTE), 
	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50 BYTE), 
	"NOM_APN_CMDB" VARCHAR2(200 BYTE), 
	"COD_GLOSARIO" NUMBER(3,0), 
	"DES_GLOSARIO" VARCHAR2(150 BYTE), 
	"COD_HERRAMIENTA" VARCHAR2(20 BYTE), 
	"OBS_MODELO" VARCHAR2(200 BYTE), 
	"COD_USR" VARCHAR2(30 BYTE), 
	"FEC_ACTU" DATE, 
	"COD_CAPA_USROWN" VARCHAR2(10 BYTE), 
	"MCA_VARIABLES" VARCHAR2(1 BYTE), 
	"MCA_GRANT_ALL" VARCHAR2(1 BYTE), 
	"MCA_GRANT_PUBLIC" VARCHAR2(1 BYTE), 
	"MCA_INH" VARCHAR2(1 BYTE), 
	"MCA_HIS" VARCHAR2(1 BYTE), 
	"MCA_PDC" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table NORMA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table OBJ_HIS
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."OBJ_HIS" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"LINEA" VARCHAR2(500 BYTE), 
	"NOM_OBJETO" VARCHAR2(30 BYTE), 
	"TIP_OBJETO" VARCHAR2(20 BYTE), 
	"MCA_VIG" VARCHAR2(1 BYTE), 
	"MCA_HIS" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PARTICULA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."PARTICULA" 
   (	"COD_PARTICULA" NUMBER(5,0), 
	"DES_PARTICULA" VARCHAR2(80 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE, 
	"MCA_PROYECTO" VARCHAR2(1 BYTE), 
	"MCA_SUB_PROY" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table PARTICULA_NORMA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."PARTICULA_NORMA" 
   (	"COD_NORMA" NUMBER(2,0), 
	"DES_NORMA" VARCHAR2(50 BYTE), 
	"COD_ELEMENTO" NUMBER(3,0), 
	"DES_ELEMENTO" VARCHAR2(50 BYTE), 
	"NUM_PARTICULA" NUMBER(2,0), 
	"DES_NUM_PART" VARCHAR2(50 BYTE), 
	"MCA_OBLIGATORIA" VARCHAR2(1 BYTE), 
	"MCA_VALIDACION" VARCHAR2(1 BYTE), 
	"VAL_TAM_MIN" NUMBER(2,0), 
	"VAL_TAM_MAX" NUMBER(2,0), 
	"MCA_VAL_PADRE" VARCHAR2(1 BYTE), 
	"NUM_PART_PADRE" NUMBER(2,0), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE, 
	"TIP_VALIDACION" VARCHAR2(20 BYTE), 
	"COD_PARTICULA" NUMBER(5,0), 
	"DES_PARTICULA" VARCHAR2(80 BYTE), 
	"MCA_PROYECTO" VARCHAR2(1 BYTE), 
	"TXT_FORMATO_PART" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table PROCESO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."PROCESO" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"ID_PROCESO" NUMBER, 
	"COD_PETICION" VARCHAR2(25 BYTE), 
	"COD_USR_PETICION" VARCHAR2(8 BYTE), 
	"FEC_INICIO" DATE DEFAULT SYSDATE, 
	"COD_USR" VARCHAR2(8 BYTE), 
	"COD_ESTADO_PROC" NUMBER(1,0), 
	"DES_ESTADO_PROC" VARCHAR2(20 BYTE), 
	"MCA_INICIAL" VARCHAR2(1 BYTE), 
	"TXT_DESCRIPCION" VARCHAR2(500 BYTE), 
	"TXT_OBS_ENTREGA" VARCHAR2(500 BYTE), 
	"MCA_ERRORES" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SUBPROYECTO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."SUBPROYECTO" 
   (	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"COD_SUB_PROY" VARCHAR2(30 BYTE), 
	"DES_SUB_PROY" VARCHAR2(150 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table TIPO_DATO
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."TIPO_DATO" 
   (	"TIP_DATO" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table VALIDA_PARTICULA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."VALIDA_PARTICULA" 
   (	"NUM_PARTICULA" NUMBER(*,0), 
	"TXT_VALIDACION" VARCHAR2(100 BYTE), 
	"TXT_VALOR" VARCHAR2(100 BYTE), 
	"DES_ESTADO_VALID" VARCHAR2(60 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Table VAL_PARTICULA
--------------------------------------------------------

  CREATE TABLE "SAPIENS"."VAL_PARTICULA" 
   (	"COD_PARTICULA" NUMBER(5,0), 
	"VAL_PARTICULA" VARCHAR2(10 BYTE), 
	"DES_VAL_PART" VARCHAR2(60 BYTE), 
	"COD_PROYECTO" VARCHAR2(30 BYTE), 
	"COD_SUB_PROY" VARCHAR2(30 BYTE), 
	"VAL_PART_PADRE" VARCHAR2(10 BYTE), 
	"COD_USR" VARCHAR2(8 BYTE), 
	"FEC_ACTU" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TBS_PERM_SAPIENS" ;
REM INSERTING into SAPIENS.AVISO
SET DEFINE OFF;
Insert into SAPIENS.AVISO (COD_PROYECTO,COD_NIVEL_AVISO,DES_NIVEL_AVISO,COD_AVISO,DES_AVISO,TXT_AVISO,COD_PETICION,FEC_ALTA,COD_USR_ALTA,MCA_HABILITADO,FEC_ACTU,COD_USR) values ('PROY1','0','BAJA','1','AVISO 1','AVISO SIN IMPORTANCIA',null,to_date('23/09/22','DD/MM/RR'),null,null,to_date('23/09/22','DD/MM/RR'),null);
Insert into SAPIENS.AVISO (COD_PROYECTO,COD_NIVEL_AVISO,DES_NIVEL_AVISO,COD_AVISO,DES_AVISO,TXT_AVISO,COD_PETICION,FEC_ALTA,COD_USR_ALTA,MCA_HABILITADO,FEC_ACTU,COD_USR) values ('PROY1','1','MEDIA','2','AVISO 2','AVISO NORMAL',null,to_date('23/09/22','DD/MM/RR'),null,null,to_date('23/09/22','DD/MM/RR'),null);
Insert into SAPIENS.AVISO (COD_PROYECTO,COD_NIVEL_AVISO,DES_NIVEL_AVISO,COD_AVISO,DES_AVISO,TXT_AVISO,COD_PETICION,FEC_ALTA,COD_USR_ALTA,MCA_HABILITADO,FEC_ACTU,COD_USR) values ('PROY1','2','ALTA','3','AVISO 3','AVISO ATENCION',null,to_date('23/09/22','DD/MM/RR'),null,null,to_date('23/09/22','DD/MM/RR'),null);
Insert into SAPIENS.AVISO (COD_PROYECTO,COD_NIVEL_AVISO,DES_NIVEL_AVISO,COD_AVISO,DES_AVISO,TXT_AVISO,COD_PETICION,FEC_ALTA,COD_USR_ALTA,MCA_HABILITADO,FEC_ACTU,COD_USR) values ('PROY1','3','CRITICA','4','AVISO 4','AVISO CRITICO',null,to_date('23/09/22','DD/MM/RR'),null,null,to_date('23/09/22','DD/MM/RR'),null);
REM INSERTING into SAPIENS.BBDD
SET DEFINE OFF;
Insert into SAPIENS.BBDD (COD_PROYECTO,NOM_BBDD,NOM_ESQUEMA,NOM_BBDD_HIS,NOM_ESQUEMA_HIS,MCA_DEFECTO) values ('PROY1','BBDD1','ESQUEMA1','BBDD0','ESQUEMA0','S');
Insert into SAPIENS.BBDD (COD_PROYECTO,NOM_BBDD,NOM_ESQUEMA,NOM_BBDD_HIS,NOM_ESQUEMA_HIS,MCA_DEFECTO) values ('PROY1','BBDD2','ESQUEMA2','BBDD0','ESQUEMA0','S');
REM INSERTING into SAPIENS.CAMPO_GLOSARIO
SET DEFINE OFF;
REM INSERTING into SAPIENS.DET_VALIDACION
SET DEFINE OFF;
REM INSERTING into SAPIENS.ELEMENTO
SET DEFINE OFF;
REM INSERTING into SAPIENS.ELEMENTO_NORMA
SET DEFINE OFF;
REM INSERTING into SAPIENS.GLOSARIO
SET DEFINE OFF;
REM INSERTING into SAPIENS.MODELO
SET DEFINE OFF;
Insert into SAPIENS.MODELO (COD_PROYECTO,NOM_MODELO,NOM_ESQUEMA,NOM_BBDD,COD_GRUPO_BDS,NOM_CARPETA_ADJ,COD_NORMA,DES_NORMA,NOM_APN_CMDB,COD_GLOSARIO,DES_GLOSARIO,COD_HERRAMIENTA,OBS_MODELO,COD_USR,FEC_ACTU,COD_CAPA_USROWN,MCA_VARIABLES,MCA_GRANT_ALL,MCA_GRANT_PUBLIC,MCA_INH,MCA_HIS,MCA_PDC) values ('PROY1','PROYECTO1','ESQUEMA1','BD1',null,'BDS',null,null,null,null,null,null,'MODELO DE PRUEBA 1',null,null,'CCU1','S','S','S','N','S','S');
Insert into SAPIENS.MODELO (COD_PROYECTO,NOM_MODELO,NOM_ESQUEMA,NOM_BBDD,COD_GRUPO_BDS,NOM_CARPETA_ADJ,COD_NORMA,DES_NORMA,NOM_APN_CMDB,COD_GLOSARIO,DES_GLOSARIO,COD_HERRAMIENTA,OBS_MODELO,COD_USR,FEC_ACTU,COD_CAPA_USROWN,MCA_VARIABLES,MCA_GRANT_ALL,MCA_GRANT_PUBLIC,MCA_INH,MCA_HIS,MCA_PDC) values ('PROY2','PROYECTO2','ESQUEMA2','BD2',null,'BDS',null,null,null,null,null,null,'MODELO DE PRUEBA 2',null,null,'CCU2','S','S','S','N','N','S');
Insert into SAPIENS.MODELO (COD_PROYECTO,NOM_MODELO,NOM_ESQUEMA,NOM_BBDD,COD_GRUPO_BDS,NOM_CARPETA_ADJ,COD_NORMA,DES_NORMA,NOM_APN_CMDB,COD_GLOSARIO,DES_GLOSARIO,COD_HERRAMIENTA,OBS_MODELO,COD_USR,FEC_ACTU,COD_CAPA_USROWN,MCA_VARIABLES,MCA_GRANT_ALL,MCA_GRANT_PUBLIC,MCA_INH,MCA_HIS,MCA_PDC) values (null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
REM INSERTING into SAPIENS.NORMA
SET DEFINE OFF;
REM INSERTING into SAPIENS.OBJ_HIS
SET DEFINE OFF;
Insert into SAPIENS.OBJ_HIS (COD_PROYECTO,LINEA,NOM_OBJETO,TIP_OBJETO,MCA_VIG,MCA_HIS) values ('PROY1',null,'OBJETO_1','INTEGER','S','S');
Insert into SAPIENS.OBJ_HIS (COD_PROYECTO,LINEA,NOM_OBJETO,TIP_OBJETO,MCA_VIG,MCA_HIS) values ('PROY1',null,'OBJETO_2','FLOAT','S','S');
REM INSERTING into SAPIENS.PARTICULA
SET DEFINE OFF;
REM INSERTING into SAPIENS.PARTICULA_NORMA
SET DEFINE OFF;
REM INSERTING into SAPIENS.PROCESO
SET DEFINE OFF;
Insert into SAPIENS.PROCESO (COD_PROYECTO,ID_PROCESO,COD_PETICION,COD_USR_PETICION,FEC_INICIO,COD_USR,COD_ESTADO_PROC,DES_ESTADO_PROC,MCA_INICIAL,TXT_DESCRIPCION,TXT_OBS_ENTREGA,MCA_ERRORES) values ('PROY1','1','PET1',null,to_date('24/09/22','DD/MM/RR'),null,'0','PENDIENTE',null,'CREAR CAMPO','NO DEBE CONTENER VALORES NULOS',null);
Insert into SAPIENS.PROCESO (COD_PROYECTO,ID_PROCESO,COD_PETICION,COD_USR_PETICION,FEC_INICIO,COD_USR,COD_ESTADO_PROC,DES_ESTADO_PROC,MCA_INICIAL,TXT_DESCRIPCION,TXT_OBS_ENTREGA,MCA_ERRORES) values ('PROY1','2','PET2',null,to_date('24/09/22','DD/MM/RR'),null,'1','INICIADA',null,'BORRAR DATOS','ATENCIÓN A LAS DEPENDENCIAS EN CASCADA',null);
REM INSERTING into SAPIENS.SUBPROYECTO
SET DEFINE OFF;
Insert into SAPIENS.SUBPROYECTO (COD_PROYECTO,COD_SUB_PROY,DES_SUB_PROY,COD_USR,FEC_ACTU) values ('PROY1','SUBPROY1','SUBPROYECTO 1',null,null);
Insert into SAPIENS.SUBPROYECTO (COD_PROYECTO,COD_SUB_PROY,DES_SUB_PROY,COD_USR,FEC_ACTU) values ('PROY1','SUBPROY2','SUBPROYECTO 2',null,null);
REM INSERTING into SAPIENS.TIPO_DATO
SET DEFINE OFF;
REM INSERTING into SAPIENS.VALIDA_PARTICULA
SET DEFINE OFF;
REM INSERTING into SAPIENS.VAL_PARTICULA
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index GLOSARIOS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SAPIENS"."GLOSARIOS_PK" ON "SAPIENS"."GLOSARIO" ("COD_GLOSARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS" ;
--------------------------------------------------------
--  DDL for Package SM2_K_LD_MDSQL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "SAPIENS"."SM2_K_LD_MDSQL" IS

  /**---------------------------------------------------------------------------------------------------
  || Paquete que se utiliza para la generación y ejecución de scripts
  */ ---------------------------------------------------------------------------------------------------
  ------------------
  -- Constantes
  ------------------
  C_RESULTADO_OK    CONSTANT NUMBER(1) := 1;
  C_RESULTADO_NOK   CONSTANT NUMBER(1) := 0;
  C_RESULTADO_AVISO CONSTANT NUMBER(1) := 2;

  -----------------------------------------
  -- Colecciones para intercambio con Java
  ------------------------------------------
  -- Línea de un script
  TYPE t_r_linea IS RECORD(
    txt_linea VARCHAR2(32000));

  -- Lista de líneas de un script
  TYPE t_t_linea IS TABLE OF t_r_linea INDEX BY BINARY_INTEGER;

  -- Texto de Error
  TYPE t_r_error IS RECORD(
    txt_error VARCHAR2(500));

  -- Lista de Errores
  TYPE t_t_error IS TABLE OF t_r_error INDEX BY BINARY_INTEGER;

  -- Tipo de dato
  TYPE t_r_tipo_dato IS RECORD(
    tip_dato VARCHAR2(30));

  -- Lista de tipos de dato  
  TYPE t_t_tipo_dato IS TABLE OF t_r_tipo_dato INDEX BY BINARY_INTEGER;

  -- Submodelos
  TYPE t_r_subproyecto IS RECORD(
    cod_sub_proy VARCHAR2(30),
    des_sub_proy VARCHAR2(150));

  -- Lista de Submodelos 
  TYPE t_t_subproyecto IS TABLE OF t_r_subproyecto INDEX BY BINARY_INTEGER;

  -- Datos de un modelo
  TYPE t_r_modelo IS RECORD(
    cod_proyecto     VARCHAR2(30),
    nom_modelo       VARCHAR2(100),
    nom_esquema      VARCHAR2(30),
    nom_bbdd         VARCHAR2(30),
    nom_carpeta_adj  VARCHAR2(100),
    cod_capa_usrown  VARCHAR2(10), -- Valores S ó N
    mca_variables    VARCHAR2(1), -- Valores S ó N 
    mca_grant_all    VARCHAR2(1), -- Valores S ó N
    mca_grant_public VARCHAR2(1), -- Valores S ó N
    mca_inh          VARCHAR2(1), -- Valores S ó N
    obs_modelo       VARCHAR2(200),
    mca_pdc          VARCHAR2(1), -- Valores S ó N
    mca_his          VARCHAR2(1), -- Valores S ó N  
    lista_sub_proy   t_t_subproyecto);

  -- Lista de Modelos
  TYPE t_t_modelo IS TABLE OF t_r_modelo INDEX BY BINARY_INTEGER;

  /*
  Estados de un script
  1	Pendiente
  2	Ejecutado
  3	Error
  4	Descuadrado
  5	Reparado
  6	Descartado
  7	Excepción
  */

  -- Datos de un script
  TYPE t_r_script IS RECORD(
    tip_script       VARCHAR2(4), -- Los tipos posibles serán SQL - Script SQL Modificado, PDC - Script PDC Modificado, SQLH - Script SQL Histórico, PDCH - Script PDC Histórico 
    txt_script       t_t_linea,
    nom_script       VARCHAR2(100),
    cod_estado_scrip NUMBER(1), -- Modificado 26/08/2022 de VARCHAR2 a NUMBER
    des_estado_scrip VARCHAR2(20),
    num_orden        NUMBER,
    nom_script_lanza VARCHAR2(106),
    txt_script_lanza VARCHAR2(4000),
    nom_script_log   VARCHAR2(100));

  -- Lista de scripts
  TYPE t_t_script IS TABLE OF t_r_script INDEX BY BINARY_INTEGER;

  -- Renombrado de scripts
  TYPE t_r_script_old IS RECORD(
    nom_script_old VARCHAR2(100),
    nom_script_new VARCHAR2(100));

  -- Lista de scripts renombrados
  TYPE t_t_script_old IS TABLE OF t_r_script_old INDEX BY BINARY_INTEGER;

  -- Script ejecutado
  TYPE t_r_script_ejec IS RECORD(
    num_orden        NUMBER,
    cod_estado_scrip NUMBER(1), -- Modificado 26/08/2022 de VARCHAR2 a NUMBER
    des_estado_scrip VARCHAR2(20),
    fec_ejec         DATE,
    txt_cuadre_oper  VARCHAR2(12),
    txt_cuadre_obj   VARCHAR2(12),
    nom_script       VARCHAR2(100),
    mca_errores      VARCHAR2(1)); -- Valores S ó N

  -- Lista de scripts ejecutados
  TYPE t_t_script_ejec IS TABLE OF t_r_script_ejec INDEX BY BINARY_INTEGER;

  -- Script de objetos TYPE
  TYPE t_r_script_type IS RECORD(
    txt_script t_t_linea,
    nom_script VARCHAR2(100));

  -- Lista de scripts de objetos TYPE
  TYPE t_t_script_type IS TABLE OF t_r_script_type INDEX BY BINARY_INTEGER;

  -- Datos de un objeto Type procesado
  TYPE t_r_type IS RECORD(
    num_orden_type   NUMBER,
    cod_estado_scrip NUMBER(1),
    des_estado_scrip VARCHAR2(20),
    fec_cambio       DATE,
    num_ejecucion    NUMBER,
    txt_cuadre_TYS   VARCHAR2(10),
    txt_cuadre_TYB   VARCHAR2(10),
    txt_cuadre_PDC   VARCHAR2(10),
    txt_cuadre_DROP  VARCHAR2(10),
    nom_objeto       VARCHAR2(30),
    script_type      t_t_script_type,
    nom_script_lanza VARCHAR2(106),
    txt_script_lanza t_t_linea,
    nom_script_log   VARCHAR2(100));

  -- Lista de objetos Type procesados
  TYPE t_t_type IS TABLE OF t_r_type INDEX BY BINARY_INTEGER;

  -- Objeto con histórico
  TYPE t_r_obj_his IS RECORD(
    nom_objeto VARCHAR2(30),
    tip_objeto VARCHAR2(20), -- Modificado tamaño 26/08/2022
    --des_tip_objeto VARCHAR2(30), -- Eliminado 26/08/2022
    mca_vig VARCHAR2(1), -- Añadido 26/08/2022. Valores S ó N. Valor check Vigente de la pantalla Seleccion Histórico - Debe ir relleno para la invocacion a p_procesa_script
    mca_his VARCHAR2(1)); -- Valores S ó N - Valor check Histórico de la pantalla Seleccion Histórico

  -- Lista de Objetos con histórico
  TYPE t_t_obj_his IS TABLE OF t_r_obj_his INDEX BY BINARY_INTEGER;

  -- Objeto con su tipo
  TYPE t_r_objetos IS RECORD(
    tip_objeto VARCHAR2(20), -- Modificado tamaño 26/08/2022
    nom_objeto VARCHAR2(30));

  -- Lista de objetos con su tipo
  TYPE t_t_objetos IS TABLE OF t_r_objetos INDEX BY BINARY_INTEGER;

  -- Aviso (nota) de un modelo 
  TYPE t_r_aviso IS RECORD(
    cod_nivel_aviso NUMBER(1),
    des_nivel_aviso VARCHAR2(7),
    cod_aviso       NUMBER, -- Código de aviso (interno)
    des_aviso       VARCHAR2(100), -- Título
    txt_aviso       VARCHAR2(500), -- Descripción
    cod_peticion    VARCHAR2(25),
    fec_alta        DATE,
    cod_usr_alta    VARCHAR2(8),
    mca_habilitado  VARCHAR2(1), -- Valores S ó N
    fec_actu        DATE,
    cod_usr         VARCHAR2(8));

  -- Lista de avisos de un modelo
  TYPE t_t_aviso IS TABLE OF t_r_aviso INDEX BY BINARY_INTEGER;

  /*
  Estados de un procesado
  1	Generado
  2	En ejecución
  3	Error
  4	Ejecutado
  5	Rechazado
  6	Entregado 
  */
  -- Datos de un procesado
  TYPE t_r_proceso IS RECORD(
    id_proceso       NUMBER,
    cod_peticion     VARCHAR2(25),
    cod_usr_peticion VARCHAR2(8), -- En pantalla figura como "Solicitado"
    fec_inicio       DATE,
    cod_usr          VARCHAR2(8),
    cod_estado_proc  NUMBER(1),
    des_estado_proc  VARCHAR2(20),
    mca_inicial      VARCHAR2(1),
    txt_descripcion  VARCHAR2(500),
    txt_obs_entrega  VARCHAR2(500),
    mca_errores      VARCHAR2(1)); -- Valores S ó N  

  -- Lista de procesados
  TYPE t_t_proceso IS TABLE OF t_r_proceso INDEX BY BINARY_INTEGER;

  -- Base de datos
  TYPE t_r_BBDD IS RECORD(
    nom_BBDD        VARCHAR2(30),
    nom_esquema     VARCHAR2(30),
    nom_BBDD_his    VARCHAR2(30),
    nom_esquema_his VARCHAR2(30),
    mca_defecto     VARCHAR2(1)); -- Valores S ó N  

  -- Lista de bases de datos
  TYPE t_t_BBDD IS TABLE OF t_r_BBDD INDEX BY BINARY_INTEGER;

  -- Cuadre de operaciones para un tipo de objeto
  TYPE t_r_cuadre_oper IS RECORD(
    tip_objeto VARCHAR2(20), -- Modificado tamaño 26/08/2022
    --des_tip_objeto  VARCHAR2(30), -- Eliminado 26/08/2022
    tip_accion      VARCHAR2(2),
    num_oper_bbdd   NUMBER, -- Operaciones del log
    num_oper_script NUMBER); -- Operaciones del script

  -- Listado de cuadres de operaciones por tipo de objeto 
  TYPE t_t_cuadre_oper IS TABLE OF t_r_cuadre_oper INDEX BY BINARY_INTEGER;

  -- Cuadre de operaciones para un objeto
  TYPE t_r_cuadre_obj IS RECORD(
    nom_objeto VARCHAR2(30),
    tip_objeto VARCHAR2(20), -- Modificado tamaño 26/08/2022
    --des_tip_objeto  VARCHAR2(30), -- Eliminado 26/08/2022
    tip_accion      VARCHAR2(2),
    num_oper_bbdd   NUMBER,
    num_oper_script NUMBER);

  -- Listado de cuadres de operaciones por objeto 
  TYPE t_t_cuadre_obj IS TABLE OF t_r_cuadre_obj INDEX BY BINARY_INTEGER;

  -- Error en un script
  TYPE t_r_error_script IS RECORD(
    num_orden     NUMBER,
    fec_error     DATE,
    id_proceso    NUMBER,
    num_iteracion NUMBER,
    num_ejecucion NUMBER,
    nom_script    VARCHAR2(100),
    num_sentencia NUMBER,
    txt_error     VARCHAR2(200));

  -- Lista de errores de scripts
  TYPE t_t_error_script IS TABLE OF t_r_error_script INDEX BY BINARY_INTEGER;

  /*
  Estados de ejecución
  1	Pendiente
  2	Ejecutado
  3	Error
  */
  -- Datos de un script tipo parche (ya ejecutado)
  TYPE t_r_script_parche IS RECORD(
    num_orden       NUMBER,
    cod_estado_ejec NUMBER(1),
    des_estado_ejec VARCHAR2(20),
    fec_script      DATE,
    id_proceso      NUMBER,
    num_iteracion   NUMBER,
    num_ejecucion   NUMBER,
    nom_script      VARCHAR2(100),
    txt_comentario  VARCHAR2(200));

  -- Lista de scripts parche
  TYPE t_t_script_parche IS TABLE OF t_r_script_parche INDEX BY BINARY_INTEGER;

  -- Datos de un objeto modificado un script
  TYPE t_r_det_objeto IS RECORD(
    num_sentencia NUMBER,
    nom_obj_padre VARCHAR2(30),
    tip_obj_padre VARCHAR2(20), -- Modificado tamaño 26/08/2022
    --des_tip_obj_padre VARCHAR2(30), -- Eliminado 26/08/2022
    tip_accion_padre VARCHAR2(2),
    nom_objeto       VARCHAR2(30),
    tip_objeto       VARCHAR2(20), -- Modificado tamaño 26/08/2022
    --des_tip_objeto    VARCHAR2(30), -- Eliminado 26/08/2022
    tip_accion   VARCHAR2(2),
    tip_dato     VARCHAR2(18),
    num_longitud NUMBER, -- Precisión
    num_decimal  NUMBER); -- Escala

  -- Listado de objetos modificados en un script
  TYPE t_t_det_objeto IS TABLE OF t_r_det_objeto INDEX BY BINARY_INTEGER;

  /*----------------------------------------------------------------------------------------
  || Procedimiento de procesado de un script
  || p_script                      : Conjunto de líneas que forman el script a procesar. 
  ||                                 Se enviarán todas las líneas que contenga el script, tanto si están vacías o solo es un salto de línea. 
  || p_cod_proyecto                : Código de modelo
  || p_cod_sub_proy                : Código de submodelo
  || p_cod_peticion                : Código de petición
  || p_cod_demanda                 : Código de demanda
  || p_cod_usr                     : Código de usuario logado en la aplicación
  || p_cod_usr_peticion            : Código de peticionario (Solicitada por)
  || p_mca_reprocesa               : Reprocesado: Si se trata de un reprocesado, se informará S/N.
  || p_nom_BBDD                    : BBDD
  || p_nom_esquema                 : Esquema
  || p_mca_HIS                     : Genera histórico (valores S y N)
  || p_nom_BBDD_HIS                : BBDD Histórico
  || p_nom_esquema_his             : Esquema Histórico
  || p_nom_fich_entrada            : Nombre del script a procesar.
  || p_txt_ruta_entrada            : Ruta completa
  || p_lista_obj_his               : Lista de objetos de los que se quiere generar histórico.
  || p_txt_descripcion             : Descripción.
  || p_id_proceso                  : Número de procesado
  || p_fec_proceso                 : Fecha de procesado
  || p_cod_estado_proc             : Estado del procesado (código)
  || p_des_estado_proc             : Estado del procesado (descripción)
  || p_lista_scripts               : Listado de scripts
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_procesa_script(p_script           IN t_t_linea,
                             p_cod_proyecto     IN VARCHAR2,
                             p_cod_sub_proy     IN VARCHAR2,
                             p_cod_peticion     IN VARCHAR2,
                             p_cod_demanda      IN VARCHAR2,
                             p_cod_usr          IN VARCHAR2,
                             p_cod_usr_peticion IN VARCHAR2,
                             p_mca_reprocesa    IN VARCHAR2,
                             p_nom_BBDD         IN VARCHAR2,
                             p_nom_esquema      IN VARCHAR2,
                             p_mca_HIS          IN VARCHAR2,
                             p_nom_BBDD_HIS     IN VARCHAR2,
                             p_nom_esquema_his  IN VARCHAR2,
                             p_nom_fich_entrada IN VARCHAR2,
                             p_txt_ruta_entrada IN VARCHAR2,
                             p_lista_obj_his    IN t_t_obj_his,
                             p_txt_descripcion  IN VARCHAR2,
                             p_id_proceso       IN OUT NOCOPY NUMBER,
                             p_fec_proceso      OUT NOCOPY DATE,
                             p_cod_estado_proc  OUT NOCOPY NUMBER,
                             p_des_estado_proc  OUT NOCOPY VARCHAR2,
                             p_lista_scripts    OUT NOCOPY t_t_script,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de procesado de un script de objetos TYPE
  || Entrada:
  || p_script                      : Conjunto de líneas que forman el script a procesar. 
  ||                                 Se enviarán todas las líneas que contenga el script, tanto si están vacías o solo es un salto de línea.
  || p_cod_proyecto                : Código de modelo
  || p_cod_sub_proy                : Código de submodelo
  || p_cod_peticion                : Código de petición
  || p_cod_demanda                 : Código de demanda
  || p_cod_usr                     : Código de usuario: usuario logado en la aplicación.
  || p_cod_usr_peticion            : Código del solicitante de la petición
  || p_nom_BBDD                    : BBDD
  || p_nom_esquema                 : Esquema
  || p_nom_fich_entrada            : Nombre del script a procesar.
  || p_txt_ruta_entrada            : Ruta completa de donde está situado el script a procesar.
  || p_txt_descripcion             : Descripción
  || Salida:
  || p_id_proceso                  : Número de procesado: Número de que se ha otorgado desde la lógica de negocio del procesado en curso. Se debe almacenar para realizar otras invocaciones.
  || p_fec_proceso                 : Fecha de procesado
  || p_cod_estado_proc             : Estado del procesado (código)
  || p_des_estado_proc             : Estado del procesado (descripción)
  || p_nom_script_lanza            : Nombre Script Lanzador
  || p_txt_script_lanza            : Contenido Lanzador
  || p_nom_script_log              : Nombre log lanzador
  || p_lista_type                  : Listado de objetos
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_procesa_type(p_script           IN t_t_linea,
                           p_cod_proyecto     IN VARCHAR2,
                           p_cod_sub_proy     IN VARCHAR2,
                           p_cod_peticion     IN VARCHAR2,
                           p_cod_demanda      IN VARCHAR2,
                           p_cod_usr          IN VARCHAR2,
                           p_cod_usr_peticion IN VARCHAR2,
                           p_nom_BBDD         IN VARCHAR2,
                           p_nom_esquema      IN VARCHAR2,
                           p_nom_fich_entrada IN VARCHAR2,
                           p_txt_ruta_entrada IN VARCHAR2,
                           p_txt_descripcion  IN VARCHAR2,
                           p_id_proceso       IN OUT NOCOPY NUMBER,
                           p_fec_proceso      OUT NOCOPY DATE,
                           p_cod_estado_proc  OUT NOCOPY NUMBER,
                           p_des_estado_proc  OUT NOCOPY VARCHAR2,
                           p_nom_script_lanza OUT NOCOPY VARCHAR2,
                           p_txt_script_lanza OUT NOCOPY VARCHAR2,
                           p_nom_script_log   OUT NOCOPY VARCHAR2,
                           p_lista_type       OUT NOCOPY t_t_type,
                           p_resultado        IN OUT NOCOPY INTEGER,
                           p_lista_errores    IN OUT NOCOPY t_t_error);

  /* MODIFICADO 19/08/2022 - Se corrige nombre del parámetro p_cod_sub_proy (faltaba el prefijo p_ )*/
  /*----------------------------------------------------------------------------------------
  || Procedimiento de búsqueda de modelos
  || Entrada:
  || p_cod_proyecto       : Código de modelo
  || p_nom_modelo         : Texto para buscar por nombre de modelo
  || p_cod_sub_proy       : Código de submodelo
  || Salida:
  || p_lista_modelos      : Lista de modelos que cumplen las condiciones de búsqueda
  || p_resultado          : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores      : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_modelos(p_cod_proyecto  IN VARCHAR2,
                          p_nom_modelo    IN VARCHAR2,
                          p_cod_sub_proy  IN VARCHAR2, -- se añade p_
                          p_lista_modelos OUT NOCOPY t_t_modelo,
                          p_resultado     IN OUT NOCOPY INTEGER,
                          p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de los avisos de un modelo
  || Entrada:
  || p_cod_proyecto       : Código de modelo
  || Salida:
  || p_lista_avisos       : Lista de avisos para el modelo
  || p_resultado          : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores      : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_avisos_modelo(p_cod_proyecto  IN VARCHAR2,
                                p_lista_avisos  OUT NOCOPY t_t_aviso,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devolverá los procesados que cumplan los filtros indicados en orden de fecha de inicio de procesado. Al menos es obligatorio informar uno de los filtros.
  || Entrada:
  || p_cod_peticion                : Petición.
  || p_cod_usr_peticion            : Usuario solicitante (Solicitado).
  || p_fec_inicio                  : Fecha inicio.
  || p_fec_fin                     : Fecha Fin
  || p_cod_usr                     : Usuario de proceso
  || p_cod_proyecto                : Modelo
  || p_cod_sub_proy                : Submodelo
  || p_des_estado_proc             : Estado procesado
  || p_ultimas                     : Parámetro que indica si se devuelven todas las peticiones o solo las últimas (10 últimas).1 devuelve las últimas, 0 o vacío, devuelve todas las ocurrencias.
  || Salida:
  || p_lista_procesos              : Listado de procesados
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_sel_procesados(p_cod_peticion     IN VARCHAR2,
                             p_cod_usr_peticion IN VARCHAR2,
                             p_fec_inicio       IN DATE,
                             p_fec_fin          IN DATE,
                             p_cod_usr          IN VARCHAR2,
                             p_cod_proyecto     IN VARCHAR2,
                             p_cod_sub_proy     IN VARCHAR2,
                             p_des_estado_proc  IN VARCHAR2,
                             p_ultimas          IN NUMBER,
                             p_lista_procesos   OUT NOCOPY t_t_proceso,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error);

  /* MODIFICADO 19/08/2022 - Se añade parámetro de entrada p_cod_sub_proy*/
  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de las bases de datos de un modelo /submodelo 
  || Entrada:
  || p_cod_proyecto       : Código de modelo
  || p_cod_sub_proy       : Código de submodelo
  || Salida:
  || p_lista_BBDD         : Lista de bases de datos para el modelo
  || p_resultado          : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores      : Lista de errores
  */ ---------------------------------------------------------------------------------------
  procedure p_con_bbdd_modelo(p_cod_proyecto  IN VARCHAR2,
                              p_cod_sub_proy  IN VARCHAR2, -- Nuevo parámetro de entrada
                              p_lista_BBDD    OUT NOCOPY t_t_BBDD,
                              p_resultado     IN OUT NOCOPY INTEGER,
                              p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que extrae las tablas, vistas y secuencias del script seleccionado para 
  || identificar si están ya configuradas para histórico o no. Devolverá aquellas tablas ya 
  || configuradas en histórico y las que se creen en la petición.
  || Entrada
  || p_script                      : Conjunto de líneas que forman el script a procesar. 
  ||                                 Se enviarán todas las líneas que contenga el script, tanto si están vacías o solo es un salto de línea. 
  || p_cod_proyecto                : Código de modelo
  || Salida
  || p_lista_obj_his               : Listado de objetos con histórico
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_sel_historico(p_script        IN t_t_linea,
                            p_cod_proyecto  IN VARCHAR2,
                            p_lista_obj_his OUT NOCOPY t_t_obj_his,
                            p_resultado     IN OUT NOCOPY INTEGER,
                            p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que añade tablas, vistas y secuencias al histórico.
  || Entrada
  || p_lista_obj_his               : Listado de objetos a añadir al histórico
  || p_cod_proyecto                : Código de modelo
  || p_cod_peticion                : Petición.
  || p_cod_usr                     : Código de usuario logado en la aplicación.
  || Salida
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_alta_historico(p_lista_objetos IN t_t_objetos,
                             p_cod_proyecto  IN VARCHAR2,
                             p_cod_peticion  IN VARCHAR2,
                             p_cod_usr       IN VARCHAR2,
                             p_resultado     IN OUT NOCOPY INTEGER,
                             p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve la contraseña de una BBDD. Parte de la clave se almacenará en la tabla de configuración
  || Entrada:
  || p_nom_BBDD                    : BBDD
  || p_nom_esquema                 : Esquema
  || p_txt_clave_encript           : Clave encriptado
  || Salida:
  || p_txt_pwd                     : Contraseña
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_con_pass_bbdd(p_nom_BBDD          IN VARCHAR2,
                            p_nom_esquema       IN VARCHAR2,
                            p_txt_clave_encript IN VARCHAR2,
                            p_txt_pwd           OUT NOCOPY VARCHAR2,
                            --p_txt_observacion   OUT NOCOPY VARCHAR2, -- Eliminado 07/09/2022 - No se necesita
                            --p_mca_habilitado    OUT NOCOPY VARCHAR2, -- Eliminado 07/09/2022 - No se necesita
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que trata el fichero de log generado por Oracle tras la ejecución de un script
  || Entrada:
  || p_id_proceso                  : Número de procesado
  || p_num_orden                   : Número de orden
  || p_cod_usr                     : Usuario de proceso
  || p_log_script                  : Contenido del log. Se enviarán todas las líneas que contenga el log, tanto si están vacías o sólo es un salto de línea
  || Salida:
  || p_cod_estado_proc             : Estado procesado (código)
  || p_des_estado_proc             : Estado procesado (descripción)
  || p_nom_script                  : Nombre del fichero.
  || p_cod_estado_scrip            : Estado del script (código)
  || p_des_estado_scrip            : Estado del script (descripción)
  || p_txt_cuadre_oper             : Cuadre Operaciones: texto que indica si hay descuadre en las operaciones (OK / Error)
  || p_txt_cuadre_obj              : Cuadre Objetos: texto que indica si hay descuadre en los Objetos (OK / Error)
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_registra_ejecucion(p_id_proceso       IN NUMBER,
                                 p_num_orden        IN NUMBER,
                                 p_cod_usr          IN VARCHAR2,
                                 p_log_script       IN t_t_linea,
                                 p_cod_estado_proc  OUT NOCOPY NUMBER,
                                 p_des_estado_proc  OUT NOCOPY VARCHAR2,
                                 p_nom_script       OUT NOCOPY VARCHAR2,
                                 p_cod_estado_scrip OUT NOCOPY NUMBER,
                                 p_des_estado_scrip OUT NOCOPY VARCHAR2,
                                 p_txt_cuadre_oper  OUT NOCOPY VARCHAR2,
                                 p_txt_cuadre_obj   OUT NOCOPY VARCHAR2,
                                 p_resultado        IN OUT NOCOPY INTEGER,
                                 p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que trata el fichero de log generado por Oracle tras la ejecución de un script de parche
  || Entrada:
  || p_id_proceso                  : Número de procesado
  || p_num_orden                   : Número de orden
  || p_cod_usr                     : Usuario de proceso
  || p_log_script                  : Contenido del log. Se enviarán todas las líneas que contenga el log, tanto si están vacías o sólo es un salto de línea
  || p_ind_repara                  : Tipo de operación que motiva el parche: Reparación (R) o Descarte (D)
  || Salida:
  || p_cod_estado_proc             : Estado procesado (código)
  || p_des_estado_proc             : Estado procesado (descripción)
  || p_nom_script                  : Nombre del fichero.
  || p_cod_estado_scrip            : Estado del script (código)
  || p_des_estado_scrip            : Estado del script (descripción)
  || p_txt_cuadre_oper             : Cuadre Operaciones: texto que indica si hay descuadre en las operaciones (OK / Error)
  || p_txt_cuadre_obj              : Cuadre Objetos: texto que indica si hay descuadre en los Objetos (OK / Error)
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_registra_ejecucion_parche(p_id_proceso       IN NUMBER,
                                        p_num_orden        IN NUMBER,
                                        p_cod_usr          IN VARCHAR2,
                                        p_log_script       IN t_t_linea,
                                        p_ind_repara       IN VARCHAR2,
                                        p_cod_estado_proc  OUT NOCOPY NUMBER,
                                        p_des_estado_proc  OUT NOCOPY VARCHAR2,
                                        p_nom_script       OUT NOCOPY VARCHAR2,
                                        p_cod_estado_scrip OUT NOCOPY NUMBER,
                                        p_des_estado_scrip OUT NOCOPY VARCHAR2,
                                        p_txt_cuadre_oper  OUT NOCOPY VARCHAR2,
                                        p_txt_cuadre_obj   OUT NOCOPY VARCHAR2,
                                        p_resultado        IN OUT NOCOPY INTEGER,
                                        p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que trata el fichero de log generado por Oracle tras la ejecución de un script de objetos TYPE
  || Entrada:
  || p_id_proceso                  : Número de procesado
  || p_cod_usr                     : Usuario de proceso
  || p_log_script                  : Contenido del log. Se enviarán todas las líneas que contenga el log, tanto si están vacías o sólo es un salto de línea
  || Salida:
  || p_cod_estado_proc             : Estado procesado (código)
  || p_des_estado_proc             : Estado procesado (descripción)
  || p_lista_type                  : Lista de objetos TYPE
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_registra_ejecucion_type(p_id_proceso      IN NUMBER,
                                      p_cod_usr         IN VARCHAR2,
                                      p_log_script      IN t_t_linea,
                                      p_cod_estado_proc OUT NOCOPY NUMBER,
                                      p_des_estado_proc OUT NOCOPY VARCHAR2,
                                      p_lista_type      OUT NOCOPY t_t_type,
                                      p_resultado       IN OUT NOCOPY INTEGER,
                                      p_lista_errores   IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de consulta de un procesado
  || Entrada
  || p_id_proceso                  : Código de procesado
  || Salida
  || p_nom_modelo                  : Modelo
  || p_cod_usr_peticion            : Solicitada
  || p_nom_bbdd_his                : BBDD histórico
  || p_des_sub_proy                : Submodelo
  || p_nom_esquema                 : Esquema
  || p_nom_esquema_his             : Esquema histórico
  || p_cod_peticion                : Petición
  || p_nom_bbdd                    : BBDD
  || p_cod_estado_proc             : Estado Procesado (código)
  || p_des_estado_proc             : Estado Procesado (descripción)
  || p_cod_usr                     : Usuario
  || p_fec_proceso                 : Fecha de procesado
  || p_txt_comentario              : Comentarios procesado
  || p_mca_inicial                 : Es script inicial: Indica que el procesado está asociado a la ejecución de un script inicial en un entorno de pruebas
  || p_txt_ruta_entrada            : Ruta: Ruta completa de generación
  || p_lista_ficheros              : Listado de ficheros ejecutados
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_con_procesado(p_id_proceso        IN NUMBER,
                            p_nom_modelo        OUT NOCOPY VARCHAR2,
                            p_cod_usr_peticion  OUT NOCOPY VARCHAR2,
                            p_nom_bbdd_his      OUT NOCOPY VARCHAR2,
                            p_des_sub_proy      OUT NOCOPY VARCHAR2,
                            p_nom_esquema       OUT NOCOPY VARCHAR2,
                            p_nom_esquema_his   OUT NOCOPY VARCHAR2,
                            p_cod_peticion      OUT NOCOPY VARCHAR2,
                            p_nom_bbdd          OUT NOCOPY VARCHAR2,
                            p_cod_estado_proc   OUT NOCOPY NUMBER,
                            p_des_estado_proc   OUT NOCOPY VARCHAR2,
                            p_cod_usr           OUT NOCOPY VARCHAR2,
                            p_fec_proceso       OUT NOCOPY DATE,
                            p_txt_comentario    OUT NOCOPY VARCHAR2,
                            p_mca_inicial       OUT NOCOPY VARCHAR2,
                            p_txt_ruta_entrada  OUT NOCOPY VARCHAR2,
                            p_lista_script_ejec OUT NOCOPY t_t_script_ejec,
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve el cuadre de operaciones del script
  || Entrada
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden
  || Salida
  || p_cuadre_oper                 : Listado de cuadre de operaciones
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_con_cuadre_oper_script(p_id_proceso    IN NUMBER,
                                     p_num_orden     IN NUMBER,
                                     p_cuadre_oper   OUT NOCOPY t_t_cuadre_oper,
                                     p_resultado     IN OUT NOCOPY INTEGER,
                                     p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve el cuadre de operaciones del script
  || Entrada
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden
  || Salida
  || p_cuadre_obj                  : Listado de cuadre de objetos
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_con_cuadre_obj_script(p_id_proceso    IN NUMBER,
                                    p_num_orden     IN NUMBER,
                                    p_cuadre_obj    OUT NOCOPY t_t_cuadre_obj,
                                    p_resultado     IN OUT NOCOPY INTEGER,
                                    p_lista_errores IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Devuelve la ruta donde se debe entregar el fichero ZIP con los nombres de los scripts a entregar en la petición
  || Entrada:
  || p_cod_proyecto                : Código de modelo
  || p_id_proceso                  : Número de procesado
  || Salida:
  || p_txt_ruta_entrega            : Ruta
  || p_nom_fichero_vig             : Nombre fichero zip vigente
  || p_nom_fichero_his             : Nombre fichero zip histórico
  || p_nom_fichero_typ             : Nombre fichero zip Types
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_con_ruta_entrega(p_cod_proyecto     IN VARCHAR2,
                               p_id_proceso       IN NUMBER,
                               p_txt_ruta_entrega OUT NOCOPY VARCHAR2,
                               p_nom_fichero_vig  OUT NOCOPY VARCHAR2,
                               p_nom_fichero_his  OUT NOCOPY VARCHAR2,
                               p_nom_fichero_typ  OUT NOCOPY VARCHAR2,
                               p_resultado        IN OUT NOCOPY INTEGER,
                               p_lista_errores    IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento de entrega de una petición
  || Entrada:
  || p_id_proceso                  : Código de procesado.
  || p_cod_usr                     : Usuario logado en la aplicación 
  || p_txt_comentario              : Descripción de la entrega
  || Salida:
  || p_des_estado_proc             : Estado Procesado
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_entregar_peticion(p_id_proceso      IN NUMBER,
                                p_cod_usr         IN VARCHAR2,
                                p_txt_comentario  IN VARCHAR2,
                                p_des_estado_proc OUT NOCOPY VARCHAR2,
                                p_resultado       IN OUT NOCOPY INTEGER,
                                p_lista_errores   IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve los errores que se han producido en BBDD al ejecutar un script
  || Entrada:
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden
  || Salida:
  || p_lista_errores_script        : Listado de errores del script.
  || p_lista_parches               : Listado de Parches asociados
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------                             
  procedure p_con_errores_script(p_id_proceso           IN NUMBER,
                                 p_num_orden            IN NUMBER,
                                 p_lista_errores_script OUT NOCOPY t_t_error_script,
                                 p_lista_parches        OUT NOCOPY t_t_script_parche,
                                 p_resultado            IN OUT NOCOPY INTEGER,
                                 p_lista_errores        IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve los errores que se han producido en BBDD al ejecutar un script de objetos TYPE
  || Entrada:
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden
  || Salida:
  || p_lista_errores_script        : Listado de errores del script.
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------                             
  procedure p_con_errores_type(p_id_proceso         IN NUMBER,
                               p_num_orden          IN NUMBER,
                               p_lista_errores_type OUT NOCOPY t_t_error_script,
                               p_resultado          IN OUT NOCOPY INTEGER,
                               p_lista_errores      IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que marca un procesado como rechazado
  || Entrada:
  || p_id_proceso                  : Código de procesado
  || p_txt_comentario              : Comentarios del rechazo
  || p_cod_usr                     : Usuario logado en la aplicación 
  || Salida:
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------                                  
  procedure p_rechazar_procesado(p_id_proceso     IN NUMBER,
                                 p_txt_comentario IN VARCHAR2,
                                 p_cod_usr        IN VARCHAR2,
                                 p_resultado      IN OUT NOCOPY INTEGER,
                                 p_lista_errores  IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que repara un script en estado Error o Descuadrado, cuyo procesado no esté Rechazado. La reparación puede conllevar el reprocesado del script o no
  || Entrada:
  || p_id_proceso                  : Código proceso.
  || p_num_orden                   : Número de orden del script reparado
  || p_cod_usr                     : Usuario logado en la aplicación 
  || p_mca_reprocesa               : Se debe reprocesar.
  || p_mca_mismo_script            : Se ejecuta el mismo script.
  || p_nom_script_new              : Nombre nuevo script a procesar.
  || p_txt_ruta_new                : Ruta nuevo script a procesar.
  || p_script_new                  : Conjunto de líneas que forman el script a reprocesar.
  || p_txt_comentario              : Comentario.
  || p_nom_script_parche           : Nombre script reparación.
  || p_txt_ruta_parche             : Ruta script reparación.
  || p_script_parche               : Contenido script reparación.
  || Salida:
  || p_nom_script_repara           : Nombre script reparación.
  || p_script_repara               : Contenido script reparación.
  || p_nom_script_lanza            : Nombre Script Lanzador de reparación.
  || p_script_lanza                : Contenido Lanzador de reparación.
  || p_nom_log_repara              : Nombre log lanzador de reparación.
  || p_lista_script_old            : Listado Scripts Anteriores para renombrarlos
  || p_lista_script                : Listado de scripts. Se informará en el caso de que se haya solicitado reprocesar el
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_repara_script(p_id_proceso        IN NUMBER,
                            p_num_orden         IN NUMBER,
                            p_cod_usr           IN VARCHAR2,
                            p_mca_reprocesa     IN VARCHAR2,
                            p_mca_mismo_script  IN VARCHAR2,
                            p_nom_script_new    IN VARCHAR2,
                            p_txt_ruta_new      IN VARCHAR2,
                            p_script_new        IN t_t_linea,
                            p_txt_comentario    IN VARCHAR2,
                            p_nom_script_parche IN VARCHAR2,
                            p_txt_ruta_parche   IN VARCHAR2,
                            p_script_parche     IN t_t_linea,
                            p_nom_script_repara OUT NOCOPY VARCHAR2,
                            p_script_repara     OUT NOCOPY t_t_linea,
                            p_nom_script_lanza  OUT NOCOPY VARCHAR2,
                            p_script_lanza      OUT NOCOPY t_t_linea,
                            p_nom_log_repara    OUT NOCOPY VARCHAR2,
                            p_lista_script_old  OUT NOCOPY t_t_script_old,
                            p_lista_script      OUT NOCOPY t_t_script,
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que descarta scripts de vigente ejecutados correctamente debido a cambios en el contenido de la petición
  || Entrada:
  || p_script                      : Conjunto de líneas que forman el script a reprocesar.
  || p_id_proceso                  : Código proceso
  || p_cod_usr                     : Usuario logado en la aplicación 
  || p_nom_script                  : Nombre Script
  || p_tip_cambio                  : Tipo cambio: Ampliación (A) o Reducción (R)
  || p_nom_script_new              : Nombre nuevo script a procesar
  || p_txt_ruta_new                : Ruta nuevo script a procesar
  || p_txt_comentario              : Comentario descarte. Obligatorio
  || p_nom_script_parche           : Nombre script parche
  || p_txt_ruta_parche             : Ruta script Parche
  || p_script_parche               : Contenido script Parche. Puede ir vacío. En tal caso se devolverá un script de parche sin sentencias para que al ejecutarlo no haya errores.
  || Salida:
  || p_lista_parches               : Listado de Parches
  || p_lista_script_old            : Listado Scripts Anteriores
  || p_lista_script_new            : Listado de scripts
  || p_cod_estado_proc             : Estado del procesado (código)
  || p_des_estado_proc             : Estado del procesado (descripción)
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_descartar_script(p_script            IN t_t_script,
                               p_id_proceso        IN NUMBER,
                               p_cod_usr           IN VARCHAR2,
                               p_nom_script        IN VARCHAR2,
                               p_tip_cambio        IN VARCHAR2,
                               p_nom_script_new    IN VARCHAR2,
                               p_txt_ruta_new      IN VARCHAR2,
                               p_txt_comentario    IN VARCHAR2,
                               p_nom_script_parche IN VARCHAR2,
                               p_txt_ruta_parche   IN VARCHAR2,
                               p_script_parche     IN t_t_linea,
                               p_lista_parches     OUT NOCOPY t_t_script,
                               p_lista_script_old  OUT NOCOPY t_t_script_old,
                               p_lista_script_new  OUT NOCOPY t_t_script,
                               p_cod_estado_proc   OUT NOCOPY NUMBER,
                               p_des_estado_proc   OUT NOCOPY VARCHAR2,
                               p_resultado         IN OUT NOCOPY INTEGER,
                               p_lista_errores     IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que marca un script ejecutado con error como excepción
  || Entrada:
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden del script 
  || p_txt_comentario              : Comentarios de la excepción
  || p_cod_estado_proc             : Estado del procesado (código)
  || p_des_estado_proc             : Estado del procesado (descripción)
  || p_cod_estado_script           : Estado del script (código)
  || p_des_estado_script           : Estado del script (descripción)
  || Salida:
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------                                  
  procedure p_excepcion_script(p_id_proceso        IN NUMBER,
                               p_num_orden         IN NUMBER, -- Añadido 07/09/2022. Aparecía en la cabecera pero faltaba aquí
                               p_txt_comentario    IN VARCHAR2,
                               p_cod_usr           IN VARCHAR2,
                               p_cod_estado_proc   OUT NOCOPY NUMBER,
                               p_des_estado_proc   OUT NOCOPY VARCHAR2,
                               p_cod_estado_script OUT NOCOPY NUMBER,
                               p_des_estado_script OUT NOCOPY VARCHAR2,
                               p_resultado         IN OUT NOCOPY INTEGER,
                               p_lista_errores     IN OUT NOCOPY t_t_error);

  /*----------------------------------------------------------------------------------------
  || Procedimiento que devuelve el conjunto de objetos afectados por un script, ordenados por sentencia ascendente
  || Entrada:
  || p_id_proceso                  : Código de procesado
  || p_num_orden                   : Número de orden
  || Salida:
  || p_lista_det_objetos           : Lista con el detalle de objetos
  || p_resultado                   : Resultado de la operación (1- Correcto, 0-Error, 2-Aviso)
  || p_lista_errores               : Lista de errores
  */ ----------------------------------------------------------------------------------------
  procedure p_detalle_objetos_scripts(p_id_proceso        IN NUMBER,
                                      p_num_orden         IN NUMBER,
                                      p_lista_det_objetos OUT NOCOPY t_t_det_objeto,
                                      p_resultado         IN OUT NOCOPY INTEGER,
                                      p_lista_errores     IN OUT NOCOPY t_t_error);

END sm2_k_ld_MDSQL;

/
--------------------------------------------------------
--  DDL for Package Body SM2_K_LD_MDSQL
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "SAPIENS"."SM2_K_LD_MDSQL" AS

  procedure p_procesa_script(p_script           IN t_t_linea,
                             p_cod_proyecto     IN VARCHAR2,
                             p_cod_sub_proy     IN VARCHAR2,
                             p_cod_peticion     IN VARCHAR2,
                             p_cod_demanda      IN VARCHAR2,
                             p_cod_usr          IN VARCHAR2,
                             p_cod_usr_peticion IN VARCHAR2,
                             p_mca_reprocesa    IN VARCHAR2,
                             p_nom_BBDD         IN VARCHAR2,
                             p_nom_esquema      IN VARCHAR2,
                             p_mca_HIS          IN VARCHAR2,
                             p_nom_BBDD_HIS     IN VARCHAR2,
                             p_nom_esquema_his  IN VARCHAR2,
                             p_nom_fich_entrada IN VARCHAR2,
                             p_txt_ruta_entrada IN VARCHAR2,
                             p_lista_obj_his    IN t_t_obj_his,
                             p_txt_descripcion  IN VARCHAR2,
                             p_id_proceso       IN OUT NOCOPY NUMBER,
                             p_fec_proceso      OUT NOCOPY DATE,
                             p_cod_estado_proc  OUT NOCOPY NUMBER,
                             p_des_estado_proc  OUT NOCOPY VARCHAR2,
                             p_lista_scripts    OUT NOCOPY t_t_script,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_procesa_script: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_procesa_script;

  procedure p_procesa_type(p_script           IN t_t_linea,
                           p_cod_proyecto     IN VARCHAR2,
                           p_cod_sub_proy     IN VARCHAR2,
                           p_cod_peticion     IN VARCHAR2,
                           p_cod_demanda      IN VARCHAR2,
                           p_cod_usr          IN VARCHAR2,
                           p_cod_usr_peticion IN VARCHAR2,
                           p_nom_BBDD         IN VARCHAR2,
                           p_nom_esquema      IN VARCHAR2,
                           p_nom_fich_entrada IN VARCHAR2,
                           p_txt_ruta_entrada IN VARCHAR2,
                           p_txt_descripcion  IN VARCHAR2,
                           p_id_proceso       IN OUT NOCOPY NUMBER,
                           p_fec_proceso      OUT NOCOPY DATE,
                           p_cod_estado_proc  OUT NOCOPY NUMBER,
                           p_des_estado_proc  OUT NOCOPY VARCHAR2,
                           p_nom_script_lanza OUT NOCOPY VARCHAR2,
                           p_txt_script_lanza OUT NOCOPY VARCHAR2,
                           p_nom_script_log   OUT NOCOPY VARCHAR2,
                           p_lista_type       OUT NOCOPY t_t_type,
                           p_resultado        IN OUT NOCOPY INTEGER,
                           p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_procesa_type: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_procesa_type;

  procedure p_con_modelos(p_cod_proyecto  IN VARCHAR2,
                          p_nom_modelo    IN VARCHAR2,
                          p_cod_sub_proy  IN VARCHAR2, -- se añade p_
                          p_lista_modelos OUT NOCOPY t_t_modelo,
                          p_resultado     IN OUT NOCOPY INTEGER,
                          p_lista_errores IN OUT NOCOPY t_t_error) IS
    i INTEGER;
  BEGIN
    i := 0;
    p_resultado := C_RESULTADO_OK;
	
	for reg in (SELECT cod_proyecto,
                     nom_modelo,
                     nom_esquema,
                     nom_bbdd,
                     nom_carpeta_adj,
                     cod_capa_usrown,
                     mca_variables,
                     mca_grant_all,
                     mca_grant_public,
                     mca_inh,
                     obs_modelo,
                     mca_his,
                     mca_pdc
                FROM MODELO
               WHERE cod_proyecto = p_cod_proyecto
                 AND upper(nom_modelo) LIKE
                     '%' || upper(p_nom_modelo) || '%'
               ORDER BY nom_modelo) loop

        i := i + 1;

        p_lista_modelos(i).cod_proyecto := reg.cod_proyecto;
        p_lista_modelos(i).nom_modelo := reg.nom_modelo;
        p_lista_modelos(i).nom_esquema := reg.nom_esquema;
        p_lista_modelos(i).nom_bbdd := reg.nom_bbdd;
        p_lista_modelos(i).nom_carpeta_adj := reg.nom_carpeta_adj;
        p_lista_modelos(i).mca_variables := reg.mca_variables;
        p_lista_modelos(i).cod_capa_usrown := reg.cod_capa_usrown;  
        p_lista_modelos(i).mca_grant_all := reg.mca_grant_all;
        p_lista_modelos(i).mca_grant_public := reg.mca_grant_public;
        p_lista_modelos(i).mca_inh := reg.mca_inh;
        p_lista_modelos(i).obs_modelo := reg.obs_modelo;
        p_lista_modelos(i).mca_his := reg.mca_his;
        p_lista_modelos(i).mca_pdc := reg.mca_pdc;

        -- Para cada modelo, obtenemos la lista de submodelos, rellenando la estructura "hija" de submodelos

        select cod_sub_proy,
            des_sub_proy
        bulk collect
        into p_lista_modelos(i).lista_sub_proy
        from SUBPROYECTO
        where 
            cod_proyecto = p_lista_modelos(i).cod_proyecto
        order by 
            cod_sub_proy;

  end loop;	
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_modelos: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_con_modelos;

  procedure p_con_avisos_modelo(p_cod_proyecto  IN VARCHAR2,
                                p_lista_avisos  OUT NOCOPY t_t_aviso,
                                p_resultado     IN OUT NOCOPY INTEGER,
                                p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
    
    SELECT 
        cod_nivel_aviso, des_nivel_aviso,
        cod_aviso, des_aviso, txt_aviso,
        cod_peticion, fec_alta, cod_usr_alta,
        mca_habilitado, fec_actu, cod_usr
    BULK COLLECT
    INTO p_lista_avisos
    FROM aviso
    WHERE
        cod_proyecto = p_cod_proyecto;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_avisos_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);    
  END p_con_avisos_modelo;

  procedure p_sel_procesados(p_cod_peticion     IN VARCHAR2,
                             p_cod_usr_peticion IN VARCHAR2,
                             p_fec_inicio       IN DATE,
                             p_fec_fin          IN DATE,
                             p_cod_usr          IN VARCHAR2,
                             p_cod_proyecto     IN VARCHAR2,
                             p_cod_sub_proy     IN VARCHAR2,
                             p_des_estado_proc  IN VARCHAR2,
                             p_ultimas          IN NUMBER,
                             p_lista_procesos   OUT NOCOPY t_t_proceso,
                             p_resultado        IN OUT NOCOPY INTEGER,
                             p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
    
    SELECT 
        id_proceso, cod_peticion, cod_usr_peticion,
        fec_inicio, cod_usr, cod_estado_proc,
        des_estado_proc, mca_inicial, txt_descripcion,
        txt_obs_entrega, mca_errores
    BULK COLLECT
    INTO p_lista_procesos
    FROM proceso
    WHERE
        cod_proyecto = p_cod_proyecto;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_avisos_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);    
  END p_sel_procesados;

  procedure p_con_bbdd_modelo(p_cod_proyecto  IN VARCHAR2,
                              p_cod_sub_proy  IN VARCHAR2, -- Nuevo parámetro de entrada
                              p_lista_BBDD    OUT NOCOPY t_t_BBDD,
                              p_resultado     IN OUT NOCOPY INTEGER,
                              p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
    
    SELECT 
        nom_bbdd, nom_esquema,
        nom_bbdd_his, nom_esquema_his,
        mca_defecto
    BULK COLLECT
    INTO p_lista_BBDD
    FROM BBDD
    WHERE
        cod_proyecto = p_cod_proyecto;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_con_bbdd_modelo: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);   
  END p_con_bbdd_modelo;

  procedure p_sel_historico(p_script        IN t_t_linea,
                            p_cod_proyecto  IN VARCHAR2,
                            p_lista_obj_his OUT NOCOPY t_t_obj_his,
                            p_resultado     IN OUT NOCOPY INTEGER,
                            p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
    
    SELECT 
        nom_objeto, tip_objeto,
        mca_vig, mca_his
    BULK COLLECT
    INTO p_lista_obj_his
    FROM obj_his
    WHERE
        cod_proyecto = p_cod_proyecto;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_sel_historico: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200); 
  END p_sel_historico;

  procedure p_alta_historico(p_lista_objetos IN t_t_objetos,
                             p_cod_proyecto  IN VARCHAR2,
                             p_cod_peticion  IN VARCHAR2,
                             p_cod_usr       IN VARCHAR2,
                             p_resultado     IN OUT NOCOPY INTEGER,
                             p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_historico: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_alta_historico;

  procedure p_con_pass_bbdd(p_nom_BBDD          IN VARCHAR2,
                            p_nom_esquema       IN VARCHAR2,
                            p_txt_clave_encript IN VARCHAR2,
                            p_txt_pwd           OUT NOCOPY VARCHAR2,
                            --p_txt_observacion   OUT NOCOPY VARCHAR2, -- Eliminado 07/09/2022 - No se necesita
                            --p_mca_habilitado    OUT NOCOPY VARCHAR2, -- Eliminado 07/09/2022 - No se necesita
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_pass_bbdd
    NULL;
  END p_con_pass_bbdd;

  procedure p_registra_ejecucion(p_id_proceso       IN NUMBER,
                                 p_num_orden        IN NUMBER,
                                 p_cod_usr          IN VARCHAR2,
                                 p_log_script       IN t_t_linea,
                                 p_cod_estado_proc  OUT NOCOPY NUMBER,
                                 p_des_estado_proc  OUT NOCOPY VARCHAR2,
                                 p_nom_script       OUT NOCOPY VARCHAR2,
                                 p_cod_estado_scrip OUT NOCOPY NUMBER,
                                 p_des_estado_scrip OUT NOCOPY VARCHAR2,
                                 p_txt_cuadre_oper  OUT NOCOPY VARCHAR2,
                                 p_txt_cuadre_obj   OUT NOCOPY VARCHAR2,
                                 p_resultado        IN OUT NOCOPY INTEGER,
                                 p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_registra_ejecucion
    NULL;
  END p_registra_ejecucion;

  procedure p_registra_ejecucion_parche(p_id_proceso       IN NUMBER,
                                        p_num_orden        IN NUMBER,
                                        p_cod_usr          IN VARCHAR2,
                                        p_log_script       IN t_t_linea,
                                        p_ind_repara       IN VARCHAR2,
                                        p_cod_estado_proc  OUT NOCOPY NUMBER,
                                        p_des_estado_proc  OUT NOCOPY VARCHAR2,
                                        p_nom_script       OUT NOCOPY VARCHAR2,
                                        p_cod_estado_scrip OUT NOCOPY NUMBER,
                                        p_des_estado_scrip OUT NOCOPY VARCHAR2,
                                        p_txt_cuadre_oper  OUT NOCOPY VARCHAR2,
                                        p_txt_cuadre_obj   OUT NOCOPY VARCHAR2,
                                        p_resultado        IN OUT NOCOPY INTEGER,
                                        p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_registra_ejecucion_parche
    NULL;
  END p_registra_ejecucion_parche;

  procedure p_registra_ejecucion_type(p_id_proceso      IN NUMBER,
                                      p_cod_usr         IN VARCHAR2,
                                      p_log_script      IN t_t_linea,
                                      p_cod_estado_proc OUT NOCOPY NUMBER,
                                      p_des_estado_proc OUT NOCOPY VARCHAR2,
                                      p_lista_type      OUT NOCOPY t_t_type,
                                      p_resultado       IN OUT NOCOPY INTEGER,
                                      p_lista_errores   IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_registra_ejecucion_type
    NULL;
  END p_registra_ejecucion_type;

  procedure p_con_procesado(p_id_proceso        IN NUMBER,
                            p_nom_modelo        OUT NOCOPY VARCHAR2,
                            p_cod_usr_peticion  OUT NOCOPY VARCHAR2,
                            p_nom_bbdd_his      OUT NOCOPY VARCHAR2,
                            p_des_sub_proy      OUT NOCOPY VARCHAR2,
                            p_nom_esquema       OUT NOCOPY VARCHAR2,
                            p_nom_esquema_his   OUT NOCOPY VARCHAR2,
                            p_cod_peticion      OUT NOCOPY VARCHAR2,
                            p_nom_bbdd          OUT NOCOPY VARCHAR2,
                            p_cod_estado_proc   OUT NOCOPY NUMBER,
                            p_des_estado_proc   OUT NOCOPY VARCHAR2,
                            p_cod_usr           OUT NOCOPY VARCHAR2,
                            p_fec_proceso       OUT NOCOPY DATE,
                            p_txt_comentario    OUT NOCOPY VARCHAR2,
                            p_mca_inicial       OUT NOCOPY VARCHAR2,
                            p_txt_ruta_entrada  OUT NOCOPY VARCHAR2,
                            p_lista_script_ejec OUT NOCOPY t_t_script_ejec,
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_procesado
    NULL;
  END p_con_procesado;

  procedure p_con_cuadre_oper_script(p_id_proceso    IN NUMBER,
                                     p_num_orden     IN NUMBER,
                                     p_cuadre_oper   OUT NOCOPY t_t_cuadre_oper,
                                     p_resultado     IN OUT NOCOPY INTEGER,
                                     p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_cuadre_oper_script
    NULL;
  END p_con_cuadre_oper_script;

  procedure p_con_cuadre_obj_script(p_id_proceso    IN NUMBER,
                                    p_num_orden     IN NUMBER,
                                    p_cuadre_obj    OUT NOCOPY t_t_cuadre_obj,
                                    p_resultado     IN OUT NOCOPY INTEGER,
                                    p_lista_errores IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_cuadre_obj_script
    NULL;
  END p_con_cuadre_obj_script;

  procedure p_con_ruta_entrega(p_cod_proyecto     IN VARCHAR2,
                               p_id_proceso       IN NUMBER,
                               p_txt_ruta_entrega OUT NOCOPY VARCHAR2,
                               p_nom_fichero_vig  OUT NOCOPY VARCHAR2,
                               p_nom_fichero_his  OUT NOCOPY VARCHAR2,
                               p_nom_fichero_typ  OUT NOCOPY VARCHAR2,
                               p_resultado        IN OUT NOCOPY INTEGER,
                               p_lista_errores    IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_ruta_entrega
    NULL;
  END p_con_ruta_entrega;

  procedure p_entregar_peticion(p_id_proceso      IN NUMBER,
                                p_cod_usr         IN VARCHAR2,
                                p_txt_comentario  IN VARCHAR2,
                                p_des_estado_proc OUT NOCOPY VARCHAR2,
                                p_resultado       IN OUT NOCOPY INTEGER,
                                p_lista_errores   IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_entregar_peticion
    NULL;
  END p_entregar_peticion;

  procedure p_con_errores_script(p_id_proceso           IN NUMBER,
                                 p_num_orden            IN NUMBER,
                                 p_lista_errores_script OUT NOCOPY t_t_error_script,
                                 p_lista_parches        OUT NOCOPY t_t_script_parche,
                                 p_resultado            IN OUT NOCOPY INTEGER,
                                 p_lista_errores        IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_errores_script
    NULL;
  END p_con_errores_script;

  procedure p_con_errores_type(p_id_proceso         IN NUMBER,
                               p_num_orden          IN NUMBER,
                               p_lista_errores_type OUT NOCOPY t_t_error_script,
                               p_resultado          IN OUT NOCOPY INTEGER,
                               p_lista_errores      IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_con_errores_type
    NULL;
  END p_con_errores_type;

  procedure p_rechazar_procesado(p_id_proceso     IN NUMBER,
                                 p_txt_comentario IN VARCHAR2,
                                 p_cod_usr        IN VARCHAR2,
                                 p_resultado      IN OUT NOCOPY INTEGER,
                                 p_lista_errores  IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_rechazar_procesado
    NULL;
  END p_rechazar_procesado;

  procedure p_repara_script(p_id_proceso        IN NUMBER,
                            p_num_orden         IN NUMBER,
                            p_cod_usr           IN VARCHAR2,
                            p_mca_reprocesa     IN VARCHAR2,
                            p_mca_mismo_script  IN VARCHAR2,
                            p_nom_script_new    IN VARCHAR2,
                            p_txt_ruta_new      IN VARCHAR2,
                            p_script_new        IN t_t_linea,
                            p_txt_comentario    IN VARCHAR2,
                            p_nom_script_parche IN VARCHAR2,
                            p_txt_ruta_parche   IN VARCHAR2,
                            p_script_parche     IN t_t_linea,
                            p_nom_script_repara OUT NOCOPY VARCHAR2,
                            p_script_repara     OUT NOCOPY t_t_linea,
                            p_nom_script_lanza  OUT NOCOPY VARCHAR2,
                            p_script_lanza      OUT NOCOPY t_t_linea,
                            p_nom_log_repara    OUT NOCOPY VARCHAR2,
                            p_lista_script_old  OUT NOCOPY t_t_script_old,
                            p_lista_script      OUT NOCOPY t_t_script,
                            p_resultado         IN OUT NOCOPY INTEGER,
                            p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_historico: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_repara_script;

  procedure p_descartar_script(p_script            IN t_t_script,
                               p_id_proceso        IN NUMBER,
                               p_cod_usr           IN VARCHAR2,
                               p_nom_script        IN VARCHAR2,
                               p_tip_cambio        IN VARCHAR2,
                               p_nom_script_new    IN VARCHAR2,
                               p_txt_ruta_new      IN VARCHAR2,
                               p_txt_comentario    IN VARCHAR2,
                               p_nom_script_parche IN VARCHAR2,
                               p_txt_ruta_parche   IN VARCHAR2,
                               p_script_parche     IN t_t_linea,
                               p_lista_parches     OUT NOCOPY t_t_script,
                               p_lista_script_old  OUT NOCOPY t_t_script_old,
                               p_lista_script_new  OUT NOCOPY t_t_script,
                               p_cod_estado_proc   OUT NOCOPY NUMBER,
                               p_des_estado_proc   OUT NOCOPY VARCHAR2,
                               p_resultado         IN OUT NOCOPY INTEGER,
                               p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    p_resultado := C_RESULTADO_OK;
	
	EXCEPTION
		WHEN OTHERS THEN
	    	p_resultado := C_RESULTADO_NOK;

			p_lista_errores(1).txt_error := substr('p_alta_historico: ' ||
	                                             sqlerrm,
	                                             1,
	                                             200);
  END p_descartar_script;

  procedure p_excepcion_script(p_id_proceso        IN NUMBER,
                               p_num_orden         IN NUMBER, -- Añadido 07/09/2022. Aparecía en la cabecera pero faltaba aquí
                               p_txt_comentario    IN VARCHAR2,
                               p_cod_usr           IN VARCHAR2,
                               p_cod_estado_proc   OUT NOCOPY NUMBER,
                               p_des_estado_proc   OUT NOCOPY VARCHAR2,
                               p_cod_estado_script OUT NOCOPY NUMBER,
                               p_des_estado_script OUT NOCOPY VARCHAR2,
                               p_resultado         IN OUT NOCOPY INTEGER,
                               p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_excepcion_script
    NULL;
  END p_excepcion_script;

  procedure p_detalle_objetos_scripts(p_id_proceso        IN NUMBER,
                                      p_num_orden         IN NUMBER,
                                      p_lista_det_objetos OUT NOCOPY t_t_det_objeto,
                                      p_resultado         IN OUT NOCOPY INTEGER,
                                      p_lista_errores     IN OUT NOCOPY t_t_error) AS
  BEGIN
    -- TAREA: Se necesita implantación para procedure SM2_K_LD_MDSQL.p_detalle_objetos_scripts
    NULL;
  END p_detalle_objetos_scripts;

END SM2_K_LD_MDSQL;

/
--------------------------------------------------------
--  Constraints for Table GLOSARIO
--------------------------------------------------------

  ALTER TABLE "SAPIENS"."GLOSARIO" ADD CONSTRAINT "GLOSARIOS_PK" PRIMARY KEY ("COD_GLOSARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBS_PERM_SAPIENS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROCESO
--------------------------------------------------------

  ALTER TABLE "SAPIENS"."PROCESO" MODIFY ("FEC_INICIO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AVISO
--------------------------------------------------------

  ALTER TABLE "SAPIENS"."AVISO" MODIFY ("FEC_ALTA" NOT NULL ENABLE);
  ALTER TABLE "SAPIENS"."AVISO" MODIFY ("FEC_ACTU" NOT NULL ENABLE);
