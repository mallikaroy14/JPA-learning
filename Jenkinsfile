pipeline {
    agent any

    stages {
        stage('Checkout for git'){
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mallikaroy14/JPA-learning']])                  }
            }
         stage('create jar'){
            steps {
                  sh 'mvn clean install -DskipTests'
                }
            }
         stage('Build Docker image'){
            steps {
                sh "docker compose up --build"
                }
            }
    }
}
// only app deployment file apply cmd
