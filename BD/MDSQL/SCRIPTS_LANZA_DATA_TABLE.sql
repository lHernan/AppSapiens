REM INSERTING into SAPIENS.SCRIPTS_LANZA
SET DEFINE OFF;
Insert into SAPIENS.SCRIPTS_LANZA (ID,NOMBRE,TXT,TIPO) values ('2','Lanza_script_name','SET DEFINE ON
SET VERIFY	ON
SET ECHO OFF
spool "[ruta]/[script]_sqlplus.log"
@"[ruta]/[script]"
spool off
EXIT;',null);
Insert into SAPIENS.SCRIPTS_LANZA (ID,NOMBRE,TXT,TIPO) values ('1','Lanza_script_name','SET DEFINE ON
SET VERIFY	ON
SET ECHO OFF
spool "[script]_sqlplus.log"
@"[script].pdc"
spool off
drop synonym CLIENTES_VIG;
EXIT;','PDC');
Insert into SAPIENS.SCRIPTS_LANZA (ID,NOMBRE,TXT,TIPO) values ('3','Lanza_script_name','SET DEFINE ON
SET VERIFY ON
SET ECHO OFF
SPOOL "[ruta]/[script].log"
DEFINE DAT_SMD_LD_U64K=DAT_SMD_LD_U64K
DEFINE IND_SMD_LD_U64K=IND_SMD_LD_U64K
DEFINE USROWN=[usr]
@"[ruta]/[script]"
SPOOL OFF
EXIT','SQL');
