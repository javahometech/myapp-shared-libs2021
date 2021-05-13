def call(cred_id,user,ip){
     sshagent([cred_id]) {
          // rename the war file
       sh "mv target/*war target/myweb.war"
          // copy war file to tomcat server
       sh "scp -o StrictHostKeyChecking=no target/myweb.war ${user}@${ip}:/opt/tomcat8/webapps"
          // stop and start tomcat
       sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
       sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
     }
}
