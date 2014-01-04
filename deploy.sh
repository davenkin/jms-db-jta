#! /bin/sh

gradle clean build

cp build/libs/* ~/software/jboss-5.0.1.GA/server/default/deploy
