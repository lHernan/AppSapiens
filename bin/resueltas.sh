#!/usr/bin/env bash

SQL_DIR=.

JOB_NAME=version

CMD="/usr/bin/mysql -D bugtracker "

OPTS="-s"
	
$CMD $OPTS -e "SELECT c.name, LPAD(b.id, 7, \"0\") ,b.summary FROM bugtracker.mantis_bug_table b inner join bugtracker.mantis_category_table c on b.category_id = c.id where fixed_in_version = '$1'"
