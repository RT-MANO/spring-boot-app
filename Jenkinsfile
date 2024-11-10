pipeline{
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    environment {
        APP_NAME = "bootapp-e2e-pipeline-demo"
        RELEASE = "1.0.0"
        DOCKER_USER = "rtmano"
        DOCKER_PASS = 'dockerhub-token'
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
        JENKINS_API_TOKEN = credentials("JENKINS_API_TOKEN")
    }
    stages{
        stage("Cleanup Workspace"){
            steps {
                cleanWs()
            }

        }

        stage("Checkout from SCM"){
            steps {
                git branch: 'master', credentialsId: 'github', url: 'https://github.com/RT-MANO/spring-boot-app'
            }

        }
        stage("Build Application"){
            steps {
                sh "mvn clean package"
            }

        }

        stage("Test Application"){
            steps {
                sh "mvn test"
            }

        }
        stage("Sonarqube Analysis") {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: 'jenkins-sonar-token') {
                        sh "mvn sonar:sonar"
                    }
                }
            }

        }

        stage("Quality Gate") {
            steps {
                 waitForQualityGate abortPipeline: false, credentialsId: 'jenkins-sonar-token'
            }

        }
        stage("Build & Push Docker Image") {
            steps {
                script {
                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image = docker.build "${IMAGE_NAME}"
                    }

                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image.push("${IMAGE_TAG}")
                        docker_image.push('latest')
                    }
                }
            }

        }
        stage("Trigger CD Pipeline") {
            steps {
                echo "JENKINS_API_IS is ${JENKINS_API_TOKEN}"
                sh 'printenv'
            }

        }

    }

}