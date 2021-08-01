pipeline {
    agent any

    stages {
        stage('compile stage') {
            steps {
               withMaven(maven :'myMaven')
               sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
               withMaven(maven :'myMaven')
               sh 'mvn clean test'
            }
        }
        stage('Deploy') {
           steps {
               withMaven(maven :'myMaven')
               sh 'mvn deploy'
            }
        }
    }
}