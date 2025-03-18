
package org

class CleanWorkspace {
    def steps

    CleanWorkspace(steps) {
        this.steps = steps
    }

    def cleanWorkspace() {
        steps.echo "Cleaning workspace..."
        steps.deleteDir()
    }
}
