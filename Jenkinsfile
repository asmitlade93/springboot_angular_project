pipeline {
    agent any

    stages {

        stage('Build Java21_SpringBoot_App') {
            steps {
                dir('Java21_SpringBoot_App/demo_app/demo') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
         stage('Build Docker Image') {
            steps {
                dir('backend') {
                    sh '''
                    docker build \
                    -t springboot-app:${BUILD_NUMBER} .
                    '''
                }
            }
        }
        stage('Verify Image') {
            steps {
                sh 'docker images'
            }
        }
    }
}
