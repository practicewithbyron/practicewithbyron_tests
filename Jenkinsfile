pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git 'https://github.com/practicewithbyron/practicewithbyron_tests.git'
            }
        }
        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean package'
            }
        }
        stage('Run Tests') {
            steps {
                // Run tests using Maven Surefire plugin
                sh 'mvn test -Dtest=MongoDBTests'
            }
        }
    }

    post {
        always {
            // Cleanup steps if needed
        }
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
