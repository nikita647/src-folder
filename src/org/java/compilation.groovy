package org.java

class Compilation {
    def steps
    Compilation(steps) {
        this.steps = steps
    }

    def mavenCompile() {
        steps.echo "Compiling code using Maven..."
        steps.sh "mvn clean compile"
    }
}
