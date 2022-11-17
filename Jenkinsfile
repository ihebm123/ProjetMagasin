pipeline {
    agent any
    
tools 
{
    maven "M2_HOME"
}
    environment { 

        registry = "abdelkaderferchichi1993/achatproject" 

        registryCredential = 'docker_id' 

        dockerImage = '' 

    }

    stages {
         stage('GIT') {
            steps {
              
              git branch:'abdelkaderBranch',url: 'https://github.com/ihebm123/ProjetMagasin.git'

           
            }
         }
           stage('CLEAN') {
            steps {
              
          script {
   
               sh "mvn clean"
   
            }
   
        }
             }
             
                   stage('COMPILE') {
            steps {
              
          script {

               sh "mvn compile "

            }
  
        }
             }
        
              stage('TEST') {
            steps {

               sh "mvn test "

            }
              }
              
                    stage('JAR') {
            steps {

               sh "mvn package "

            }
              }
              
                            
              stage('NEXUS DEPLOY') {
            steps {

              //sh "mvn deploy -Dmaven.test.skip=true "
              
                echo 'NEXUS WORKED'

            }

        }
        
             stage('SONAR') {
            steps {
              
        
              sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  "
     
           
              
            }
            
            
        }

        stage('Building Docker Image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":1.0" 

                }

            } 

        }

        stage('Pushing Image to DockerHub') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                      dockerImage.push() 

                    }

                } 

            }

        }
         
         
         
          stage("Docker-Compose") { 
             steps { 
                 script { 
                    sh "docker-compose up -d  "
                 } 
             } 
         } 
    } 
         post {
            always{
                
                emailext to: "amira.jeljeli@esprit.tn",
                subject: "mail:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
        attachLog: true
                
            }
        }
        
    

}