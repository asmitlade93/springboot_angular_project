pipeline {
    agent any
    tools {
        nodejs 'NodeJs24'
    }
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
        stage('Check Frontend Files') {
            steps {
                dir('Angular20_Login_App') {
                    sh 'pwd'
                    sh 'ls -la'
                }
            }
        }
      
        stage('Build Frontend Docker Image') {
            steps {
                dir('Angular20_Login_App') {
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

        stage('Check Backend Files') {
            steps {
                dir('Java21_SpringBoot_App/demo_app/demo') {
                    sh 'pwd'
                    sh 'ls -la'
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
