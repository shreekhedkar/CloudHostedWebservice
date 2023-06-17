pipeline {
    agent any
    parameters {
        booleanParam 'skip_tests'
        booleanParam 'skip_sonar'
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MyMaven"
    }
    environment {
        RELEASE='2023.06'
    }
    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
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
        stage('publish artifacts')  {
            steps {
                   sh "mvn compile com.google.cloud.tools:jib-maven-plugin:2.5.0:build -Dimage=registry.hub.docker.com/shreekhedkar/learn"
                }
            }
        }
        stage('Deploy') {
            steps {
                echo "about to deploy ${RELEASE}.Hold your breath."
            }
         }
        }
    }
