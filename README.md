# LineAPI RESTful 
### Use the Line Messaging API to  build bots
# INSTALLATION
- - - 
1. go to https://developers.line.me/en/
2. Login and Create a new provider 
3. create a channel in new provider and select create a message API channel 
4. check Message API -> issue Channel access token , open Use webhook, use QR code join channel
5. copy Channel access token application.properties
6. install ngrok and run ngrok.exe and Project
7. go to https://developers.line.me/en/ set Webhook URL from ngrok.exe-> Forwarding
8. insert test to channel and check mongoDb or use postman to send message 


# DESCRIPTION
- - -
1. receive message from line webhook, save the user info and message in MongoDB
2. send message back to line
3. query message list of the user from MongoDB

# Tool
- - -
* IDE: IntelliJ IDEA 2022.2
* DB: mongoDB
* Test tool:Postman
* postman test file:https://www.getpostman.com/collections/fd9c815709965b6b7546