#!/usr/bin/env bash

SQL_DIR=.

JOB_NAME=version

CMD="/usr/bin/mysql -D bugtracker "

OPTS="-s"
	
$CMD $OPTS -e "SELECT summary FROM mantis_bug_table where fixed_in_version = '$1'"
