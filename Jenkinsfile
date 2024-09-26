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
    
    post {
        always {
            echo "Executing post scripts"
             junit 'testng 'target/surefire-reports/testng-results.xml'
        }
        success {
            echo "Build successful"
        }
        failure {
            script {
                mail to: 'nanduniranjana@gmail.com',
                     subject: "The pipeline failed",
                     body: "The pipeline has failed. Please check the Jenkins job for details."
            }
        }
    }
}
