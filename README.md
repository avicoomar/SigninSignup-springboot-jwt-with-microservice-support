# SigninSignup-springboot-jwt-with-microservice-support
I searched a lot but couldn't find a signin-signup service which uses jwt and supports microservice architecture applications since spring-cloud and spring-boot-starter-web don't work together (because spring-cloud uses webflux).
So I made a user-service application that works in isolation(on port 9001). It can interact and validate other microservice's API calls. 
It is also free of preflight request cors error.
API Gateway uses port 9090 and signin-signup service uses port 9001.

To add another microservice:
1. Specify path in application.yml of apigateway-microservice
2. Follow the format of sample-microservice format.
Rest of the stuff is same as the traditional microservice applications. 

Note: user-service requires the username too (Refer API calls in the attached screenshots)

Warning: Passwords are stored in plain text format. Use a suitable password encoder.

<p align="center">
<img width="60%" alt="1" src="https://user-images.githubusercontent.com/61863442/188452493-8f3d5836-cfda-4eda-9b92-dda92e263449.PNG">
<img width="60%" alt="2" src="https://user-images.githubusercontent.com/61863442/188452514-b7501c71-5c40-4082-a1e2-afa75027d106.PNG">
<img width="60%" alt="3" src="https://user-images.githubusercontent.com/61863442/188452530-d5218c09-29e0-4cf7-9384-fd9b97a49540.PNG">
</p>
