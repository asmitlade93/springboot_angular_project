pipeline {
    agent any

    stages {

        stage('Build Frontend') {
            steps {
                dir('Angular20_Login_App') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }
        stage('Verify Angular Build') {
            steps {
                sh 'find Angular20_Login_App/dist'
            }
        }
        stage('Build Frontend Docker Image') {
            steps {
                dir('frontend') {
                    sh '''
                    docker build \
                    -t angular-app:${BUILD_NUMBER} .
                    '''
                }
            }
        }
        stage('Build Java21_SpringBoot_App') {
            steps {
                dir('Java21_SpringBoot_App/demo_app/demo') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
         stage('Build Docker Image') {
            steps {
                dir('Java21_SpringBoot_App/demo_app/demo') {
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
