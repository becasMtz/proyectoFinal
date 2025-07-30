pipeline{
    agent any //ayuda a definir si vamos a usar un agente en especifico (de java, python, node, etc.)

    environment{
        KUBECONFIG = 'C:\\Program Files\\Jenkins\\kubeconfig.yaml'
        IMAGE_NAME = 'proyectofinal'
        IMAGE_NAME_TEST = 'proyectofinaltesting'
        DOCKER_USERNAME = 'becasmtz'
        DOCKER_CREDENTIALS = 'docker-hub-credentials'
        DOCKER_IMAGE = "${DOCKER_USERNAME}/${IMAGE_NAME}"
        EMAIL_FROM 'rmtzbarron@gmail.com'
        EMAIL_TO = 'rmtzbarron@gmail.com'
    }

    triggers{
        githubPush()
    }

    stages{
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/becasMtz/proyectoFinal.git'
            }
        }

        stage('Test'){
            steps{
                script{
                    docker.build(IMAGE_NAME_TEST,"--file=Dockerfile.test .")
                }
            }
        }

        stage('Build'){
            steps{
                script{
                    image = docker.build(DOCKER_IMAGE, ".")
                }
            }
        }

        stage('Push'){
            steps{
                script{
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS){
                        image.push()
                    }
                }
            }
        }

        stage('Deploy'){
            steps{
                script{
                    bat 'kubectl apply -f k8s/namespace.yaml'
                    bat 'kubectl apply -f k8s/deployment.yaml'
                    bat 'kubectl apply -f k8s/service.yaml'
                }
            }
        }
    }

    post{
        success{
            mail to: EMAIL_TO, EMAIL_FROM, subject: "Jenkins build was successfull", body: "Jenkins build was successfull"
        }
        failure{
            mail to: EMAIL_TO, EMAIL_FROM, subject: "Jenkins build failed", body: "Jenkins build failed"
        }
    }
}