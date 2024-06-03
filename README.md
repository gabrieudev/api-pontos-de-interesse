# Challenge: API for Points of Interest (POIs)

![Java](https://img.shields.io/badge/Java-8%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/joão-santos-1115a5304/)
![GPL License](https://img.shields.io/badge/License-GPL-blue) [![LinkedIn](https://img.shields.io/badge/Type-Challenge-purple)](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md)

This is my solution for the backend challenge **API for Points of Interest (POIs)**. 

Please select your preferred language:

- [English](README.md)
- [Português (Brasil)](README.pt-br.md)

Check the [challenge](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md) for more details about the problem.

## Table of Contents

- Introduction
- Features
- Technologies
- Getting Started
- Configuration
- Endpoints
- Contributions
- Contact

## Introduction

The main problem in the challenge is to create an HTTP GET route that returns points of interest within a radius X in meters, based on the provided coordinates.

## Features

- Complete CRUD for points of interest
- Search for nearby points of interest
- Integration with the H2 database

## Technologies

- ![Java](https://img.shields.io/badge/Java-8%2B-orange): Programming language.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework used for building production-ready applications.
- ![H2](https://img.shields.io/badge/H2-Database-blue): In-memory database.

## Getting Started

Follow these steps to run the project on your machine:

1. Clone the repository: `git clone https://github.com/gabrieudev/points-of-interest.git`
2. Navigate to the project directory: `cd <path>`
3. Update the database configurations in the `application.properties` file.
4. Build the project: `./mvnw clean install` (for Windows: `mvnw.cmd clean install`)
5. Run the application: `./mvnw spring-boot:run` (for Windows: `mvnw.cmd spring-boot:run`)

## Configuration

- Database configuration: Update the `application.properties` file with your H2 database information.

## Endpoints

- `POST /points`: Registers a new point of interest.
- `GET /points`: Retrieves all registered points of interest.
- `GET /points/{id}`: Retrieves a point of interest by its ID.
- `GET /points/{x}/{y}/{dMax}`: Retrieves all points of interest within the maximum distance informed, using the X and Y coordinates as the reference point.
- `PUT /points`: Updates an existing point of interest.
- `DELETE /points/{id}`: Deletes a point of interest by its ID.

Access the complete documentation at the `/swagger-ui.html` endpoint.

## Contributions

Contributions are very welcome! If you want to contribute, fork the repository and create a pull request.

## Contact

If you have any suggestions or questions, please contact me on [LinkedIn](https://www.linkedin.com/in/gabrieudev/).

---

**License:** This project is licensed under the terms of the [GNU General Public License (GPL)](LICENSE).