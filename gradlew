#!/usr/bin/env sh

# Gradle startup script for Unix
APP_HOME=$(pwd)

CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

exec java -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
