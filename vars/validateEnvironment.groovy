def call() {
    sh '''
        echo "Validating environment..."
        docker version
        kubectl version --client
        kind version
    '''
}
