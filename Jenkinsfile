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
    stage('Frequent Flyer') {
      parallel {
        stage('Maven') {
          steps {
            sh '(cd modules/ROOT/examples/frequent-flyer && mvn clean verify)'
          }
        }
        stage('Gradle') {
          steps {
            sh '(cd modules/ROOT/examples/frequent-flyer && ./gradlew clean test)'
          }
        }
      }
    }
    stage('REST with Screenplay') {
      parallel {
        stage('Maven') {
          steps {
            sh '(cd modules/ROOT/examples/serenity-screenplay-rest && mvn clean verify -Pprod)'
          }
        }
        stage('Gradle') {
          steps {
            sh '(cd modules/ROOT/examples/serenity-screenplay-rest && ./gradlew clean test)'
          }
        }
      }
    }
  }
  post {
        always {
            junit '**/target/site/serenity/SERENITY-JUNIT*'
        }
    }
}
