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
                bat 'mvn test'
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
             junit 'target/surefire-reports/*.xml'
        }
        success {
            echo "Build successful"
            script {
                mail to: 'nanduniranjana@gmail.com',
                     subject: "Build successful",
                     body: "The build is successful."
            }
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
