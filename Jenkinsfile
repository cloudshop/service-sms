#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

        stage('check java') {
            sh "java -version"
        }

        stage('clean') {
            sh "chmod +x mvnw"
            sh "./mvnw clean"
        }

        stage('package and deploy') {
            sh "./mvnw -DskipTests -Pprod package"
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
