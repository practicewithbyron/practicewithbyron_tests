pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git branch: 'Main', url: 'https://github.com/practicewithbyron/practicewithbyron_tests.git'
            }
        }
        stage('Build') {
            steps {
                // Bind the secret file credential to a variable
                withCredentials([file(credentialsId: 'd91e0f12-62f5-44e6-b4f5-50a2eff09d28', variable: 'CONFIG_FILE')]) {
                    sh 'echo "Config file: $CONFIG_FILE"'
                    sh "cp \${CONFIG_FILE} ./src/main/resources/config.properties"
                }
                // Build the project using Maven
                sh 'mvn clean package -DskipTests -e -X'
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
