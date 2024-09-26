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
	
	post{
	always{
	echo "Executing post scripts"
	}
	success{
	echo "Build successful"
	}
	failure{
	mail to: nanduniranjana@gmail.com, subject: "The pipeline failed"
	}
	
}
