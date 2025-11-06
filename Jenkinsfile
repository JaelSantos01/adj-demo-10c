pipeline{
    agent any 

    stages{
        //Etapa para parar todos los servicios 
        stage('Parando los servicios'){
            steps{
                sh '''
                    docker compose -p adj-demo down || true
                '''
            }
        }

        // Etapa para eliminar las imagenes anteriores
        stage('Borrando imágenes antiguas'){
            steps{
                sh '''
                    IMAGES=$(docker images --filter "label=com.docker.compose.project=adj-demo" -q)
                    if [ -n '$IMAGES' ]; then
                        docker images rmi -f $IMAGES
                    else
                        echo "No hay imágenes por borrar..."
                    fi
                '''
            }
        }

        //Bajar la actualización
        stage('Actualizando....'){
            steps{
                checkout scm
            }
        }

        //Levantar y desplegar el proyecto
        stage('Construyendo y desplegando...'){
            steps{
                sh '''
                    docker compose up --build -d
                '''
            }
        }
    }

    post{
        success{
            echo 'Pipeline ejecutado exitosamente'
        }

        failure{
            echo 'Error al ejecutar el pipeline'
        }

        always{
            echo 'Pipeline finalizado'
        }
    }

}