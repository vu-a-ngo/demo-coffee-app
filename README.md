Task #1: For task 1 of the assignment, please look at the HLD.puml

Task #2: 
- The docker-compose.yaml file will set up Postgres DB and Redis
- For the implementation, I'd like to propose some notes:
Note:
For simplicity's sake, we can make certain assumptions about the data models and relationships between
the models in this implementation. For example:
1. Shop's location should contain only country, city and street address in String.
2. A user or a shop only has (at most) 1 telephone number and 1 email address. Of course, we can achieve array mapping between DB columns and POJOs by utilizing Hibernate's customized UserType, or the hibernate-types library written by Vlad Mihalcea.

Moreover, I'd also omit vault config from the app configuration.