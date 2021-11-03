node('maven') {
    stage('Clone') {
        sh "git config --global http.sslVerify false"
        sh "git clone https://code.mylabzolution.com/nicopanjaitan0607/rnd-simplespring.git"
    }
    stage('Build') {
         sh 'oc login --token=sha256~92kx22OCNwcUCCginaukrCtrcaIuP9yKWsnpFi-iXbA --server=https://api.okade.mylabzolution.com:6443 --insecure-skip-tls-verify=true'
        sh "mvn -v"
        sh "mvn clean package -f hello-world/pom.xml"
         
        def jarFile = sh(returnStdout: true, script: 'find hello-world/target -maxdepth 1 -regextype posix-extended -regex ".+\\.(jar|war)\$" | head -n 1').trim()
        sh "cp ${jarFile} app.jar"
    }
    stage('Deploy') {
        sh "oc new-build --name rnd-spring-simple --binary -n rnd-spring --image-stream=rnd-spring/openjdk11  || true"
        sh "oc start-build rnd-spring-simple --from-file=app.jar -n rnd-spring --follow --wait"
        sh "oc new-app rnd-spring-simple || true"
        sh "oc expose svc/hello-world || true"
    }
}
