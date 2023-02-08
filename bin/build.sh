#!/usr/bin/env bash

DIR_PROJECT=$HOME/workspace-jboss/AppSapiens

ENTREGABLES=Entregables
MDVAL_PROJECT=MDVAL
MDSQL_PROJECT=MDSQL
MDCOMMON=mdcommon
BUILD_DIR=target

MDVAL_PACKAGE=
MDSQL_PACKAGE=mdsql-1.0.0-SNAPSHOT.jar

LATEST=`cat $DIR_PROJECT/last.txt`
TO=Mario.Pampliega@sapiens.com
CC=agarcia@esoluzion.com,fmartin@esoluzion.com

clear

echo "Se va a construir la entrega ${DIR_PROJECT}/$MDSQL"

echo "Construyendo arquitectura común..."

cd $DIR_PROJECT/$MDCOMMON

mvn clean install
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al construir la arquitectura común"
	exit
fi

clear

echo "Construyendo $MDSQL_PROJECT"

cd $DIR_PROJECT/$MDSQL_PROJECT

mvn clean install -DskipTests=true
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al construir el proyecto $MDSQL_PROJECT"
	exit
fi

clear

echo "Instalando $MDSQL_PROJECT"

cd $DIR_PROJECT/$MDSQL_PROJECT/$BUILD_DIR

cp $MDSQL_PACKAGE $DIR_PROJECT/$ENTREGABLES/$MDSQL_PROJECT

cd $DIR_PROJECT/$MDSQL_PROJECT

cp CHANGELOG.md $DIR_PROJECT/$ENTREGABLES/$MDSQL_PROJECT
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al copiar el fichero CHANGELOG.md"
	exit
fi

cp literales.properties $DIR_PROJECT/$ENTREGABLES/$MDSQL_PROJECT
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al copiar el fichero literales.properties"
	exit
fi

cp configuration.properties $DIR_PROJECT/$ENTREGABLES/$MDSQL_PROJECT
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al copiar el fichero configuration.properties"
	exit
fi

git add .
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al añadir archivos para commit"
	exit
fi

echo "Archivos de instalación copiados"

clear

echo "Comprimiendo paquete..."

cd $DIR_PROJECT/$ENTREGABLES/

zip -9 -r $MDSQL_PROJECT.zip $MDSQL_PROJECT/
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "No se ha podido crear el paquete $MDSQL_PROJECT.zip"
	exit
fi

mv $MDSQL_PROJECT.zip $MDSQL_PROJECT-$LATEST.zip

git add $MDSQL_PROJECT-$LATEST.zip
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al añadir archivo $MDSQL_PROJECT-$LATEST.zip para commit"
	exit
fi

git commit -m "Entregable $LATEST"
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al hacer commit"
	exit
fi

git push
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al hacer push"
	exit
fi

echo "Enviando aviso a $TO con copia a $CC"

echo "Muy señor mío/a.

Nos complace comunicarle que está disponible para su revisión la entrega

https://github.com/lHernan/AppSapiens/blob/develop/Entregables/$MDSQL_PROJECT-$LATEST.zip

Cualquier error nos lo comunican lo más pronto posible para poder solucionarlo.

Atentamente
Federico Martín Lara <fmartin@esoluzion.com>" | mail -s "Entregable $LATEST" -aCC:$CC $TO
if [ $? -ne 0 ] ; then 
	notify-send --urgency=low "Ocurrió un error al enviar aviso"
	exit
fi


notify-send --urgency=low "Entrega $LATEST completada"
