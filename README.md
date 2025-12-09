# Utopia Fitness Tracker
## CS4900: Application of the Software Development Lifecycle

## Information:
This is the backend API for the Fitness Tracker. It handles the main features like exercise, routines, and sesions. It contains all the necessary features such as add, remove, update, GET, and POST.  

Find some info about [API routes](./utopia-api-routes.md)

---
## Tools Needed
- Docker 
- Java 17+ -- to run Spring Boot API
- Gradle 
- Bruno -- to test API 

--- 
## How to execute
- **Clone the api repo:** 
  ```
  git clone https://github.com/WSU-kduncan/cs4900-api-utopia.git
  ```
- **Start the Database:**
  ```
  Go to main repo -- [Utopia repo](https://github.com/WSU-kduncan/cs4900-utopia)
  cd Database/Scripts
  docker compose up
  ```
- **Back in API repo:** 
  ```
  ./gradlew bootRun
  ```
--- 
## How to test with Bruno  
- Add Enviroment: 
  - BASE_URL --> `http://localhost:{{PORT}}/OpenTrainer`
  - PORT --> `8080`
- Click new request 
- Select GET, POST, PUT, or DELETE
- Add Request Body (if needed: POST / PUT) 
  - Go to Body 
  - Select JSON
  - Enter JSON (below is an example from POST Session)
    ``` 
    {
      "client": { "id": 1 },
      "trainer": { "id": 2 },
      "routine": { "id": 3 },
      "date": "2025-10-30",
      "note": "Chest workout session",
      "duration": "01:00:00"
    }
    ```
- Send Request  


