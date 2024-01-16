node {
  stage('SCM Checkout') {
    git 'https://github.com/prio21/BankingApplication.git'
  }

  stage('Compile-Package') {
    bat 'mvn package'
  }
  
  stage('Deploy to Tomcat') {
            steps {
                echo "Deploy to Tomcat server"
                bat 'copy "C:\Users\pribania\.jenkins\workspace\BankingApplication\target\bankApp-0.0.1-SNAPSHOT.war" "C:\Users\pribania\Downloads\apache-tomcat-10.1.18-windows-x64\apache-tomcat-10.1.18\webapps"'
            }
        }
    }
 
    post {
        success {
            echo 'Pipeline succeeded. You may want to send notifications or perform additional actions.'
        }
        failure {
            echo 'Pipeline failed. You may want to send notifications or take corrective actions.'
        }
    }
}
