pipeline {
    agent any
    tools{
        maven 'M2_HOME'
    }
    environment { 
        registry = "abdazizfitouri1998/achatproject" 
        registryCredential = 'docker_fitou' 
        dockerImage = '' 
    }
    stages {
         stage('GIT') {
            steps {
              
                echo 'INITIATE GIT'
                git branch:'AbdAzizFitouri69-PersonalNexusLink-1',url: 'https://github.com/ihebm123/ProjetMagasin.git'
            }
         }
        stage('CLEAN') {
            steps {
                script {
                    echo 'MAVEN CLEAN' 
                    sh "mvn clean"
                }  
            }
        }
        stage('INSTALL') {
            steps {
                script {
                    echo 'MAVEN INSTALL'
                    sh "mvn install -e -DskipTests"
                }
            }
        }
        stage('PACKAGE') {
            steps {
                echo 'MAVEN PACKAGE'
                sh "mvn package -DskipTests"
            }
        }
        stage("DOCKER COMPOSE") { 
             steps { 
                 script { 
                    sh "docker-compose up -d"
                } 
            } 
        }
        stage('MAVEN TEST'){
            steps{
                script
                {
                    if (isUnix())
                    {
                        sh 'mvn --batch-mode test'
                    }
                    else
                    {
                        bat 'mvn --batch-mode test'
                    }
                }
            }
        }
        stage('SONARQUBE') {
            steps {
              sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=FuckingPassword -DskipTests" 
            }
        }
        stage('NEXUS') {
            steps {
                sh "mvn deploy -DskipTests"
            }
        }
        stage('BUILD DOCKER IMAGE') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":1.0" 
                }
            } 
        }
        stage('PUSH DOCKER IMAGE') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) {
                      dockerImage.push()
                    }
                } 
            }
        }
        stage('SENDING EMAIL'){
	        steps {
        	    mail bcc: '', body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}", cc: '', from: '', replyTo: '', subject: 'BUILD CONFIRMATION', to: 'mohamedabdaziz.fitouri@esprit.tn'
	        }
	    }
    }
}
