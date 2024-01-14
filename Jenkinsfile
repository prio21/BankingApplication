node {
  stage('SCM Checkout') {
    git 'https://github.com/prio21/BankingApplication.git'
  }

  stage('Compile-Package') {
    bat 'mvn package'
  }
}
