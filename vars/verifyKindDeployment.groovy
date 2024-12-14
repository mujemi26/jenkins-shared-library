def call(String kubeconfigFile) {
    withCredentials([file(credentialsId: kubeconfigFile, variable: 'KUBECONFIG')]) {
        sh """
            export KUBECONFIG=${KUBECONFIG}
            echo "Verifying deployment..."
            
            kubectl get pods -l app=lab-app
            kubectl get services
            curl -v http://localhost:30080 || true
        """
    }
}
