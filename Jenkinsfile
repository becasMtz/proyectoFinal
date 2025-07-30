pipeline{
    agent any //ayuda a definir si vamos a usar un agente en especifico (de java, python, node, etc.)

    environment{
        IMAGE_NAME = 'proyectoFinal'
        IMAGE_NAME_TEST = 'proyectofinaltesting'
        DOCKER_USERNAME = 'becasmtz'
        DOCKER_CREDENTIALS = 'docker-hub-credentials'
        DOCKER_IMAGE = "${DOCKER_USERNAME}/${IMAGE_NAME}"
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
                    docker.build(DOCKER_IMAGE,".");
                }
            }
        }
    }
}