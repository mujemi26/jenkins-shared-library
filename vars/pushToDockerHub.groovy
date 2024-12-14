def call(String imageName, String buildNumber, String credentialsId) {
    withDockerRegistry([credentialsId: credentialsId, url: '']) {
        sh """
            echo "Pushing Docker image to Docker Hub..."
            docker push ${imageName}:${buildNumber}
            docker tag ${imageName}:${buildNumber} ${imageName}:latest
            docker push ${imageName}:latest
        """
    }
}
