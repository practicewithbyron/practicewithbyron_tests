# Notes
It's worth noting that the config file needs to be 'refreshed' by adding this to the build phase
```
// Bind the secret file credential to a variable
withCredentials([file(credentialsId: 'd91e0f12-62f5-44e6-b4f5-50a2eff09d28', variable: 'CONFIG_FILE')]) {
    sh 'mkdir -p src/main/resources'
    sh 'echo "Config file: $CONFIG_FILE"'
    sh "cp \${CONFIG_FILE} ./src/main/resources/config.properties"
}
```
This creates the dir and adds the config file from Jenkins credentials so if the config file gets updated so will the
secret file inside Jenkins.