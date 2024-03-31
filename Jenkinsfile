pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git branch: 'Main', url: 'https://github.com/practicewithbyron/practicewithbyron_tests.git'
                echo 'mvn -version'
            }
        }
        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean package -e'
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
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
