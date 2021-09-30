### Build all modules:

`mvn clean package -DskipTests=true`

### Start environment modules in docker:

`docker-compose up --build`

### Running Axon Server Enterprise

Please copy axoniq.license to ./config.
After the cluster is started, create a user by running:

`./bin/axonserver-cli.jar register-user -t F5B28D72-F0F5-4AD6-A003-99C1BD02830A -u admin -p admin -r ADMIN`

After that you can login to Axonw Server UI by using admin:admin.
