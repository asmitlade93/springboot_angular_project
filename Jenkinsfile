pipeline {
    agent any

    stages {

        stage('Build Backend') {
            steps {
                dir('Java21_SpringBoot_App') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}
