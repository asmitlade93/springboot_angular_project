pipeline {
    agent any

    stages {

        stage('Build Backend') {
            steps {
                dir('Java21_SpringBoot_App\demo_app\demo_app_demo') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}
