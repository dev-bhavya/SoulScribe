# SoulScribe - Journaling App

---

## Overview

SoulScribe is a Java and Spring Boot based journaling application that allows users to write down their thoughts, feelings, experiences, and reflections. It provides a platform for users to engage in personal writing activities such as stream-of-consciousness entries, gratitude documentation, goal setting, or simply recording notable life events.
 
Users can register with unique usernames and passwords, create, edit, and delete journal entries, and update their credentials. 

The app employs MongoDB to securely store user data and journal entries, with passwords encrypted to ensure user credentials remain safe. Role-based authentication is implemented for both users and administrators.

---

## Features

- **User Registration**: Users can register with a unique username and password to access the app's features.

- **Journal Creation**: Registered users can create journals by providing their credentials in the request.

- **Journal Editing and Deletion**: Users have the ability to edit and delete their journal entries.

- **Credential Management**: Users can update their usernames and passwords as needed.

- **Password Encryption**: User passwords are encrypted before storage in the database to ensure security.

- **Role-Based Authentication**: The app supports role-based authentication for both users and administrators.

---

[//]: # (## Endpoints)

[//]: # ()
[//]: # (- **User Registration**: `/public/create-user` - Endpoint to register a new user with a unique username and password.)

[//]: # ()
[//]: # (- **Journal Creation**: `/journal` - Endpoint to create a new journal entry.)

[//]: # ()
[//]: # (- **Journal Editing and Deletion**: Endpoints to edit and delete existing journal entries.)

[//]: # ()
[//]: # (- **Credential Management**: Endpoints to update user credentials &#40;username and password&#41;.)

[//]: # ()
[//]: # (---)

## Technologies Used

- **Java**: Programming language used for backend development.

- **Spring Boot**: Framework used for building the application.

- **MongoDB Atlas**: NoSQL database used for storing user data and journal entries.

- **Spring Security**: Framework used for role-based authentication.

[//]: # (---)

[//]: # ()
[//]: # (## Installation and Setup)

[//]: # ()
[//]: # (1. Clone the repository: `git clone https://github.com/dev-bhavya/journalApp.git`)

[//]: # (2. Navigate to the project directory: `cd journalApp`)

[//]: # (3. Install dependencies: `mvn install`)

[//]: # (4. Configure MongoDB Atlas connection settings in `application.properties`.)

[//]: # (5. Run the application: `mvn spring-boot:run`)

---

## Contributing

Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests to help improve SoulScribe.

After cloning edit the application.properties file to connect to MongoDB database for testing your locally run application.

---

## Contact

For any inquiries or support, please contact [Bhavya Mittal](mailto:devsbhavya@gmail.com).

---

Thank you for using SoulScribe! Happy journaling! 📝✨
