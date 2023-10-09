pipeline {
    agent any

    

    stages {
        stage('git'){
                steps{
                    echo 'pulling';
                    git branch: 'secteurs_activites-Hakim',
                    url : 'https://github.com/safouene-jebali/achat-devops.git';
                }
            }
        stage('maven') {
            steps {
                

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }
    }
}
