pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    stages {
        stage('Check pwd') {
            steps {
                sh 'pwd'
            }
        }
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Mdudzin/selenium-framework.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
//        stage('Deploy') {
//            steps {
//                bat 'mvn jar:jar deploy:deploy'
//            }
//        }
        stage('Generate Report') {
            steps {
                allure([
                        includeProperties: false,
                        reportBuildPolicy: 'ALWAYS',
                        results          : [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
