pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building Project'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests'
                bat 'mvn clean test'
            }
        }
        stage('Release') {
            steps {
                echo 'Releasing Project'
            }
        }
    }
}
