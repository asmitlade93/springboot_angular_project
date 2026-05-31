pipeline {
    agent any

    stages {

        stage('Build Backend') {
            steps {
                dir('Java21_SpringBoot_App/demo_app/demo') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}
