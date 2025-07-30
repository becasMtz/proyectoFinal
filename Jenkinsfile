pipeline{
    agent any //ayuda a definir si vamos a usar un agente en especifico (de java, python, node, etc.)

    triggers{
        gitHubPush()
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
                    docker.Build("proyectofinaltesting","--file=Dockerfile.test .")
                }
            }
        }
    }
}