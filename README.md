# RestAssured Assignment

This project contains a couple of RestAssured tests written in Java using Maven. One test verifies the GET API `https://reqres.in/api/users?page=2` returns HTTP 200 and that the `page` field in the response body equals `2`. A second test calls `https://reqres.in/api/unknown/2` and checks several fields of the returned JSON.

## Running the test

Ensure Maven is installed, then execute:

```bash
mvn test
```

The test will perform a request to the API and validate the response.
