pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ThatGuyWink/Midterm_Project_CEN4802C.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("midterm_project:${env.BUILD_ID}")
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    docker.image("midterm_project:${env.BUILD_ID}").run('-d -p 8080:8080')
                }
            }
        }
    }

    post {
        always {
            cleanWs()  
        }
    }
}

