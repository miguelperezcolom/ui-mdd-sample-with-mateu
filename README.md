# Getting Started

This project showcases how Mateu helps building complex backoffice UIs.

## Projects

### claims-platform

A domain microservice with its own entities and exposing a REST api.

http://localhost:8081/swagger-ui/index.html

### claims-ui

A library project defining the UI for the claims domain.

This UI works as a micro frontend which can be used from any Mateu UI.

Accesses the `claims-platform` entities using the `claims-platform` REST api.

Just use the `ClaimsMenu` class in your Mateu UI menu.

### claims-ui-dev

A Mateu UI project to develop the `claims-ui` micro frontend in isolation.

http://localhost:8082/

### bowie

The backoffice project. 

It composes the `claims-ui` micro frontend at build time.

It also contains some entities to showcase CRUD creation when we have direct access to the entities. 

http://localhost:8080/


## Disclaimer

Maven 3.6.3 must be used
