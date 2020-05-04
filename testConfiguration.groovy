def builds = [:]

node('master') {
    stage('Compile') {
        git 'https://github.com/RedShiftSolutions/JavaLoadTest'
        sh 'mvn -B package'
        stash includes: 'target/*.jar', name: 'Jars'
    }
}

def testApp(int magic) {
   def retVal = 'OK'
    try {
        sh "java -cp target/widget-1.0.jar com.acme.App ${magic} > results_${magic}.out"  
    } catch (e) {
        retVal = 'Fail'
    }
    return retVal
}

def mkBuild(n) {
    def i = n
    return {
        node('Linux') {
            unstash 'Jars'
            if (testApp(i) != "OK") {
                // "Save" test data
                archive includes: "results_${i}.out"
            }
        }
    }
}

stage('EnqueueBuilds') {
    //  Try magic numbers 1 - 50
    for (i=1; i<=50; i++) {
        builds["Build$i"] = mkBuild(i)
    }
}

stage('RunTests') {
    parallel builds
}