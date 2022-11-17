pipeline {
    agent any
    
tools 
{
    maven "M2_HOME"
}
    environment { 

        registry = "ihebdevops/achatproject" 

        registryCredential = 'docker_id' 

        dockerImage = '' 

    }

    stages {
         stage('GIT') {
            steps {
               echo 'bdina l git l git'
      //  sh " git url: 'https://github.com/ihebm123/GestionMagasinSpring.git' " 
              git branch:'iheb-stock-managment-branch',url: 'https://github.com/ihebm123/ProjetMagasin.git'

         /*  sh "ls -lart " 
             sh "git branch -a"
             sh "git checkout branchname"*/
           
              echo 'foutna l git'
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
              
                    stage('Building Jar File') {
            steps {

               sh "mvn package "
               //sh 'docker container prune'//delet non actif containers container 

            }
              }
              
                   
              stage('NEXUS DEPLOY') {
            steps {

               //sh "mvn deploy -Dmaven.test.skip=true "  
                  echo 'nexus yes'

            }

        }
        
              stage('SONAR') {
            steps {
              
        
             // sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  "
              echo 'sonar yes'
     
           
              
            }
            
            
        }
              
              
              
           /* stage("Building Docker Image") { 
             steps { 
                 script { 
                    
                    sh 'docker build -t ihebdevops/achatproject:1.0 .'
                   
                 } 
             } 
         } 
         
         
           stage("Pushing Image to DockerHub") { 
             steps { 
                 script { 
                     withCredentials([usernamePassword(credentialsId: 'docker_id', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push ihebdevops/achatproject:1.0'
                 } 
             } 
         } 
           }*/
           
        
       stage('Building Docker Image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":1.0" 
                   echo 'buildina'

                }

            } 

        }

      stage('Pushing Image to DockerHub') { 

            steps { 

                script { 

                  docker.withRegistry( '', registryCredential ) { 

                     dockerImage.push() 
                     
                       echo 'pushina'

                    }

                } 

            }
}
        
         
         
          /* stage('Cleaning Up Image') { 

            steps { 

                sh "docker rmi $registry:1.0" 

            }

        } */
         
         
          stage("Docker-Compose") { 
             steps { 
                 script { 
                    sh "docker-compose up -d  "
                                echo 'composina'
                 } 
             } 
         } 
              
        
        
    
}

   post {
            always{
                
                emailext to: "iheb.mhamdi@esprit.tn",
                subject: "[DevOps]jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
		attachLog: true
                
            }
        }



}
