#! /bin/sh

gradle clean assemble

cp build/libs/* $JBOSS_HOME/server/default/deploy

source clearDB.sh
