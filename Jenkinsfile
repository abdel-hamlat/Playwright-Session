pipeline {
  agent any
  tools { jdk 'jdk17'; maven 'maven3' }
  options { timestamps() }
  environment {
    PLAYWRIGHT_BROWSERS_PATH = '.playwright'
  }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build (no tests)') {
      steps {
        bat "mvn -B -DskipTests clean install --no-transfer-progress"
      }
    }
    stage('Install Playwright browsers') {
      steps {
        bat "mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args=\"install --with-deps\""
      }
    }
    stage('Test') {
      steps {
        bat "mvn -B test"
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/**', fingerprint: true
    }
  }
}
