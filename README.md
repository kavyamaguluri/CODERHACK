# CODERHACK

Problem Description
While coding platforms usually host multiple contests while maintaining numerous leaderboards, this assignment requires you to design a service for managing the leaderboard of a specific contest. Assume the platform has only one contest with a single leaderboard. The platform also gives virtual awards to the users called Badges based on their score.


Requirements
The API must handle CRUD operations for competing user registrations

Each user has the following fields:

User ID (Unique Identifier)

Username

Score (0 <= Score <= 100)

Badges (Code Ninja, Code Champ, Code Master)

User registration requests must have a User ID and Username

The score must be 0, and the badges must be empty initially after the registration

Updation through PUT requests is only allowed for Score

Badges must be awarded based on the score:

1 <= Score < 30 -> Code Ninja

30 <= Score < 60 -> Code Champ

60 <= Score <= 100 -> Code Master

A user can only have a maximum of three unique badges

{Code Ninja, Code Champ, Code Master} -> Valid

{Code Ninja} -> Valid

{Code Ninja, Code Champ, Code Master, Code Ninja} -> Invalid

User retrieval must be sorted based on the score (Ascending)

Sorting should have the time complexity of O(nlogn)

Include basic JUnit test cases to verify the operations


Validation and Error Handling
Add basic validation for all fields (Ex. Score > 0)

Handle common errors and** return appropriate HTTP codes** (Ex. 404, User not found)


Endpoints
GET /users - Retrieve a list of all registered users

GET /users/{userId} - Retrieve the details of a specific user

POST /users - Register a new user to the contest

PUT /users/{userId} - Update the score of a specific user

DELETE /users/{userId} - Deregister a specific user from the contest


Publishing and Documentation
Write meaningful commit messages (optional)

Include a descriptive README.MD for your application codebase

Create and add a public Postman Collection in the README.MD


Additional Notes
Implement the solution using a** layered approach** - Ex. Entity, Controller, Service, Repository

User API Documentation
Base URL
http://localhost:8081/coderhack/api/v1

Endpoints
1. Create a User
Endpoint:

POST /users

Request Body:


{

  "userId": "string",  

  "username": "string"

}

Response:


{

  "userId": "test123",

  "username": "test_user",

  "score": 0,

  "badges": []

}

Response Code: 200

2. Retrieve a User by ID
Endpoint:

GET /users/{userId}

Response:


{

  "userId": "test123",

  "username": "test_user",

  "score": 0,

  "badges": []

}

Response Code: 200

3. Update User Score
Endpoint:

PUT /users/{userId}

Request Body:


{

  "score": 10

}

Response:


{

  "userId": "test123",

  "username": "test_user",

  "score": 10,

  "badges": ["CODE_NINJA"]

}

Response Code: 200

Validation:

Only score field is allowed to be updated. Attempting to update other fields should return 400 Bad Request.

If score is not a number, it should return 400 Bad Request instead of 200.

4. Badge Awarding Logic
Badges are awarded based on score:

CODE_NINJA: score >= 1

CODE_CHAMP: score >= 30

CODE_MASTER: score >= 60

Max 3 badges allowed per user

5. Retrieve All Users (Sorted by Score)
Endpoint:

GET /users

Response:


[

  {

    "userId": "user1",

    "score": 10

  },

  {

    "userId": "user2",

    "score": 20

  }

]

Response Code: 200

The users should be returned sorted by score in ascending order.
6. Delete a User
Endpoint:

DELETE /users/{userId}

Response Code: 204 (No Content)
