def call(String imageName, String buildNumber, String kubeconfigFile, String clusterName) {
    withCredentials([file(credentialsId: kubeconfigFile, variable: 'KUBECONFIG')]) {
        sh """
            export KUBECONFIG=${KUBECONFIG}
            echo "Deploying to Kind cluster..."
            
            kind load docker-image ${imageName}:${buildNumber} --name ${clusterName}
            
            kubectl apply -f deployment/${BRANCH_NAME}/deployment.yaml
            kubectl apply -f deployment/${BRANCH_NAME}/service.yaml
            
            kubectl rollout status deployment/lab-app --timeout=300s
        """
    }
}
