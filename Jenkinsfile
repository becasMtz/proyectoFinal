pipeline{
    agent any //ayuda a definir si vamos a usar un agente en especifico (de java, python, node, etc.)

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
                    docker.build("proyectofinaltesting","--file=Dockerfile.test .")
                }
            }
        }
    }
}