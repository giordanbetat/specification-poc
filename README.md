# POC Specification JPA

## Tecnologias Utilizadas:

- Spring Boot

- Java 11

- JPA

- H2

- Gradle

## POST:

- URL: `http://localhost:8080/v1/universities`

`{
"name": "Test1",
"address": "Rua 1",
"students": [
{
"studentName": "Test Name",
"studentAddress": "Rua 2",
"phones": [
{
"type": "Pessoal",
"phone": "51543544786"
}
]
}
]
}`

## GET:

- URL: `http://localhost:8080/v1/universities`

- Filters: name, address, studentName, studentAddress
