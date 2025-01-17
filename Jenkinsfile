pipeline {
  agent any 
  stages {
    stage('Checkout') {
            steps {
                git 'https://github.com/jayashreebondre/fooproject.git'
            }
        }
    stage('Build') {
      steps {
        sh "mvn compile"
      }
    }   
    
    stage('Test') {
      steps {
        sh "mvn test"
      }
     post {
      always {
        junit '**/TEST*.xml'
      }
     }
  }
    
 stage('Code Coverage') {
     steps {
        sh "mvn test"
        junit '**/TEST*.xml'
        step( [ $class: 'JacocoPublisher' ] )
     }
  }  
     
   
    stage('newman') {
            steps {
                sh 'newman run collection.json --environment environment.json --reporters junit'
                  }
            post {
                always {
                        junit '**/*xml'
                    }
                }
        }
    
       stage('Robot Framework System tests with Selenium') {
            steps {
                sh 'robot --variable BROWSER:headlesschrome -d Results  Tests'
            }
            post {
                always {
                    script {
                          step(
                                [
                                  $class              : 'RobotPublisher',
                                  outputPath          : 'Results',
                                  outputFileName      : '**/output.xml',
                                  reportFileName      : '**/report.html',
                                  logFileName         : '**/log.html',
                                  disableArchiveOutput: false,
                                  passThreshold       : 50,
                                  unstableThreshold   : 40,
                                  otherFiles          : "**/*.png,**/*.jpg",
                                ]
                          )
                    }
                }
            }
        }
 }
}
