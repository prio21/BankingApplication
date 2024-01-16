pipeline {
    agent any
 
    stages {
        stage('SCM Checkout') {
            steps {
                script {
                    git 'https://github.com/prio21/BankingApplication.git'
                }
            }
        }
 
        stage('Compile-Package') {
            steps {
                script {
                    bat 'mvn package'
                }
            }
        }
 
        stage('Deploy to Tomcat') {
            steps {
                script {
                    echo "Deploy to Tomcat server"
                     bat 'copy "C:\\Users\\pribania\\.jenkins\\workspace\\BankingApplication\\target\\bankApp-0.0.1-SNAPSHOT.war" "C:\\Users\\pribania\\Downloads\\apache-tomcat-10.1.18-windows-x64\\apache-tomcat-10.1.18\\webapps\\"'
                }
            }
        }
    }
}
