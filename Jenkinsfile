pipeline {
    agent any

    stages {
        stage('compile stage') {
            steps {
               withMaven(maven :'maven_3_8_1'){
               bat 'mvn clean compile'
               }
            }
        }
        stage('Test') {
            steps {
               withMaven(maven :'maven_3_8_1'){
               bat 'mvn clean test'
               }
            }
        }
        stage('Deploy') {
           steps {
               withMaven(maven :'maven_3_8_1'){
               bat 'mvn deploy'
               }
            }
        }
    }
}