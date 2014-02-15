#! /bin/sh

mvn clean package

cp target/jms-db-jta-1.0-SNAPSHOT.war ~/software/jboss-5.0.1.GA/server/default/deploy

source clearDB.sh
