def call(String imageName, String buildNumber) {
    sh """
        echo "Building Docker image ${imageName}:${buildNumber}..."
        docker build -t ${imageName}:${buildNumber} .
    """
}
