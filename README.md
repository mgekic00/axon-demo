### Build all modules:

`mvn clean package -DskipTests=true`

### Start environment modules in docker:

`docker-compose up --build`

### Running Axon Server Enterprise

Please copy axoniq.license to ./config. After the cluster is started, create a user by running:

`./bin/axonserver-cli.jar register-user -t f5b28d72-f0f5-4ad6-a003-99c1bd02830a -u admin -p admin -r ADMIN,USE_CONTEXT@ledger,USE_CONTEXT@payments`

After that you can login to Axon Server UI by using admin:admin.

Then you need to register the applications by running:

`./bin/axonserver-cli.jar register-application -t f5b28d72-f0f5-4ad6-a003-99c1bd02830a -a fake-ledger -r USE_CONTEXT@ledger -T c32eebdf-e82a-4447-8463-c3905d44d2b4`

`./bin/axonserver-cli.jar register-application -t f5b28d72-f0f5-4ad6-a003-99c1bd02830a -a fake-payments -r USE_CONTEXT@payments -T 2dfb6d59-72ec-4537-93f8-302111004932`
