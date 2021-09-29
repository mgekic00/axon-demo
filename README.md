
### Build all modules:

`mvn clean package -DskipTests=true`

### Start infrastructure modules in docker:

`docker-compose up --build`

Rest endpoints: http://localhost:{port}/api/v1/{url}
