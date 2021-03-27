def call(string component)
pipeline {
    agent any
    stages {
        stage('SonarQube') {
            steps{
                sh "sonar-scanner \
            -Dsonar.projectKey=${component} \
            -Dsonar.sources=. \
            -Dsonar.host.url=http://100.24.117.168:9000 \
            -Dsonar.login=f8aaffb2b8ffd2f27270205c5775c20654b97530"
            }
        stage('SonarQube status') {
            steps {
                sh "sonar-quality-gate.sh admin password123 100.24.117.168 ${component}"
            }
        }
        }
    }
}