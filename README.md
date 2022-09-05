# MySigninSignup-springboot
I searched a lot but couldn't find a signin-signup service which uses jwt and supports microservice architecture applications since spring-cloud and spring-boot-starter-web don't work together (because spring-cloud uses webflux).
So I made a user-service application that works in isolation(on port 9001). It can interact and validate other microservice's API calls. 
It is also free of preflight request cors error.

To add another microservice:
1. Specify path in application.yml of apigateway-microservice
2. Follow the format of sample-microservice format.
Rest of the stuff is same as the traditional microservice applications. 

Note: API Gateway runs on port 9090 and signin-signup service works on port 9001.

Warning: Passwords are stored in plain text format. Use a suitable password encoder.

<img alt="1" src="https://user-images.githubusercontent.com/61863442/188450386-65f1a665-b467-451c-b4ff-cd6fec9d811c.PNG" style="width: 100%;">
<img width="632" alt="2" src="https://user-images.githubusercontent.com/61863442/188450413-2332fef3-9539-45d5-ba5e-318b9222fa70.PNG">
<img width="636" alt="3" src="https://user-images.githubusercontent.com/61863442/188450430-49895d45-ef32-4743-85fe-12dc54149ec3.PNG">

