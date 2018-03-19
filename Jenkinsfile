#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    gitlabCommitStatus('build') {
        docker.image('openjdk:8').inside('-u root -e MAVEN_OPTS="-Duser.home=./"') {
            stage('check java') {
                sh "java -version"
            }

            stage('clean') {
                sh "chmod +x mvnw"
                sh "./mvnw clean"
            }

            stage('backend tests') {
                try {
                    sh "./mvnw test"
                } catch(err) {
                    throw err
                } finally {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }

            stage('package and deploy') {
                sh "./mvnw com.heroku.sdk:heroku-maven-plugin:1.1.1:deploy -DskipTests -Pprod -Dheroku.appName="
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
            }

            stage('quality analysis') {
                withSonarQubeEnv('Sonar') {
                    sh "./mvnw sonar:sonar"
                }
            }
        }

        def dockerImage
        stage('build docker') {
            sh "cp -R src/main/docker target/"
            sh "cp target/*.war target/docker/"
            dockerImage = docker.build('docker-login/sms', 'target/docker')
        }

        stage('publish docker') {
            docker.withRegistry('https://dev.eyun.online:9082', 'docker-login') {
                dockerImage.push 'latest'
            }
        }
    }
}
