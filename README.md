# Peony-API
Web service for Peony

### Required Tools
- [Maven](https://maven.apache.org)
- [MongoDB Atlas](https://cloud.mongodb.com/)

### How to run this project
- install Maven
- create MongoDB Atlas account and create a new cluster
- After creating a cluster, go to **Security** tab. Under **MongoDB Users**, click *ADD NEW USER* to create a new user for our application
- Under **IP Whitelist**, click *ADD IP ADDRESS* to grant access to your computer, or add **0.0.0.0** to allow access from any computer(good for testing purpose)
- When done creating all the required resources, go back to **Overview** tab. Click *Connect*, then click *Connect Your Application* and choose your mongo driver version to get a connection string that looks similar to ```mongodb+srv://<USER>:<PASSWORD>@<CLUSTER_URI>/<DATABASE_NAME>?retryWrites=true```
- Clone and open this project. Go to *src/main/resources/application.properties*, place your connection string in *spring.data.mongodb.uri*
- Go to command line, run ```mvn install``` and then ```mvn spring-boot:run```. The API is now ready to be tested!

