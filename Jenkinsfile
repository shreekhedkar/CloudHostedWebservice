pipeline {
    agent any
    parameters {
        booleanParam 'skip_tests'
        booleanParam 'skip_sonar'
        booleanParam 'skip_publish'
    }
    tools {
        maven "MyMaven"
    }
    environment {
        RELEASE='2023.06'
        user='shreekhedkar'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/shreekhedkar/CloudHostedWebservice.git'
                echo "checkout completed for build ${env.BUILD_ID} on ${env.JENKINS_URL}"
                }
        }    
        stage('Compile') {
            steps {
                sh "mvn clean package"
            }
        }    
        stage('Unit tests') {
            steps {
              sh "mvn clean install"
            }
        }    
        stage('Publish Artifacts')  {
            when { expression { params.skip_publish != true } }
            steps {
                    script {
                        withCredentials([string(credentialsId: 'dockehubstringsecret', variable: 'dockerhubpass')]) {
                            sh "mvn compile com.google.cloud.tools:jib-maven-plugin:2.5.0:build -Dimage=registry.hub.docker.com/shreekhedkar/learn -Djib.to.auth.username=${user} -Djib.to.auth.password='${dockerhubpass}'"
                    
                        }
                    }    
            }
        }
        stage('Deploy') {
            agent {
               label 'server1' 
            }
            steps {
                echo "about to deploy ${RELEASE} on server 1."
                script {
                    sh "hostnamectl"
                    sh "sudo docker pull shreekhedkar/learn:latest"
                    sh "sudo nohup docker run -p 8090:8080 shreekhedkar/learn &"
                }
            }
         }
        stage('Tear Down') {
            agent {
               label 'server1' 
            }
            input {
                message 'Do you want to scale down the deployement?'
                ok 'yes'
                parameters {
                    choice choices: ['yes', 'no', 'do nothing'], name: 'user_choice'
                }
            }
            when {
                expression { user_choice == "yes" }
            }
            steps {
                echo "choice is $user_choice"
                echo "about to scale down ${RELEASE}..."
                script {
                    sh "sudo docker stop \$(sudo docker ps -q --filter ancestor=shreekhedkar/learn)"
                }
            }
         }
        }
    }
