package org.template.util.groovy

import org.java.*
import org.common.*

def call(Map config) {
    node {
        try {
            stage('Clean Workspace') {
                def cleaner = new CleanWorkspace(this)
                cleaner.cleanWorkspace()
            }

            stage('Git Clone') {
                def git = new GitClone(this)
                git.gitClone(config.branch, config.repoUrl, config.credentialsId)
            }

            stage('Compile') {
                def compiler = new Compilation(this)
                compiler.mavenCompile()
            }

            echo "Pipeline completed successfully!"
            sendNotification(config.email, config.projectName, true)

        } catch (Exception e) {
            echo "Pipeline failed with error: ${e}"
            sendNotification(config.email, config.projectName, false)
            throw e
        }
    }
}

def sendNotification(String email, String projectName, boolean success) {
    if (success) {
        echo "Build Successful! Sending success notification to ${email} for project ${projectName}"
    } else {
        echo "Build Failed! Sending failure notification to ${email} for project ${projectName}"
    }
}
