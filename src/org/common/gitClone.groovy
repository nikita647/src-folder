
package org

class GitClone {
    def steps

    GitClone(steps) {
        this.steps = steps
    }

    def gitClone(branch, repoUrl, credentialsId) {
        steps.echo "Cloning repository from ${repoUrl} - branch: ${branch}"
        steps.checkout([
            $class: 'GitSCM',
            branches: [[name: "refs/heads/${branch}"]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
    }
}
