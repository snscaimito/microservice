# Sample Application about designing and testing RESTful server and client

This sample application illustrates how to design and test a RESTful server and client that can be used to implement microservices.

## Server
The RESTful server uses a three-tier architecture comprised of:

- HerdServiceController
- HerdService
- HerdRepository

HerdServiceController is the outmost layer and implements the RESTful interface. Its only concern is to receive a request via HTTP and return a JSON structure to the caller. In the most simplest form it only calls the HerdService and leaves all error handling etc to the default implementation of Spring.

HerdService talks to the HerdRepository in order to store or retrieve data. Its interface uses immutable Value Objects to exchange data with callers.

HerdRepository knows how to store and retrieve data to and from a database. It works with mutable Entity Objects.

The HerdServiceControllerTest mocks out the HerdService as it focuses on the web layer. It makes use of MockMvc to simulate the actual HTTP interaction.

Then the HerdServiceTest mocks out the HerdRepository as we don't want to use an actual database for the test. The HerdService is concerned with turning an Entity Object into a Value Object and error handling in a way that higher layers can deal with.

## Client
The client is implemented as HerdServiceClient. It uses a RestTemplate to make the actual call and returns a Herd Value Object which is immutable.

The HerdServiceClientTest makes use of a MockRestServiceServer to simulate the call to the server and examines the client's behavior.
