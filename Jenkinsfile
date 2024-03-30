pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your code from your version control system (e.g., Git)
                git 'https://github.com/practicewithbyron/practicewithbyron_tests.git'
            }
        }

        stage('Build') {
            steps {
                // Build your Maven project
                sh 'mvn clean package'
            }
        }

        stage('Run Integration Tests') {
            steps {
                // Run your integration tests
                sh 'mvn verify'
            }
        }
    }

    post {
        success {
            // Notify or perform actions if the pipeline succeeds
            echo 'Integration tests passed!'
        }
        failure {
            echo "Build successful"
        }
    }
}