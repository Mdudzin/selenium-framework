pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Mdudzin/selenium-framework.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            allure(
                    includeProperties: false,
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
            )
            recordCoverage(
                    tools: [[parser: 'JACOCO']],
                    id: 'jacoco', name: 'JaCoCo Coverage',
                    sourceCodeRetention: 'EVERY_BUILD',
            )
        }
    }
}
