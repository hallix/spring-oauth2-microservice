## Oath2
1. Basic authorization
2. Service to Service authorization

#### Components
1. Authorization server - Used to issue tokens and authenticate clients using credentials
2. Microservice 1 - Provides REST endpoints protected by Spring security but authenticated using the auth server. Basic authentication can be to generate a token from auth server
3. Microservice 2 - Provides REST endpoints protected by Spring security but authenticated using the auth server. The application.yaml file can be used to configure a clientId and secret to be used to authenticate this service to access Microservice 1.


#### Flow:
1. Add credentials to the auth server in the Registered Clients Repository. clientId and secret which is analogues username and password respectively.
2. Get token by authenticating using Basic Authentication to the Auth server.
3. Once the token is generated, make a request to the Microservice 1, Pass the bearer in the header.
4. Add credentials to the auth server in the Registered Clients Repository to test service to service authentication.
5. In Microservice 2, configure the clientId, secret and link to the auth server in the application.yaml file.
6. Access the next REST endpoint in Microservice 2. If configure correctly, you should see this message `Hello from microservice 1 but requested from microservice 2`.