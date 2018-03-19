#!/bin/bash
echo "Stating App Direct Tests..."
mvn test -DsuiteFile=src/test/suites/testng.xml -Dtest=SignUpTests
