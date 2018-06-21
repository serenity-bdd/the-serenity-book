pipeline {
  agent any
  stages {
    stage('compile book') {
      steps {
        sh '''rm -Rf build
mkdir -p build
cp -Rf modules/ROOT/assets build'''
        sh 'asciidoctor modules/ROOT/pages/*.adoc -D build -a imagesdir=assets/images'
      }
    }
    stage('frequent flyer mvn') {
      parallel {
        stage('frequent flyer') {
          steps {
            sh 'cd modules/ROOT/examples/frequent-flyer && mvn clean verify'
          }
        }
        stage('serenity-screenplay-rest mvn') {
          steps {
            sh 'cd modules/ROOT/examples/serenity-screenplay-rest && mvn clean verify'
          }
        }
      }
    }
    stage('frequent-flyer gradle') {
      parallel {
        stage('frequent-flyer gradle') {
          steps {
            sh 'cd modules/ROOT/examples/frequent-flyer && gradle clean test'
          }
        }
        stage('serenity-screenplay-rest gradle') {
          steps {
            sh 'cd modules/ROOT/examples/serenity-screenplay-rest && gradle clean test'
          }
        }
      }
    }
  }
}