#!/usr/bin/env bash

./gradlew jar

echo $'\n-------------Drawing-------------\n'

java -jar ./build/libs/Drawing-0.1.jar