# Members Rest API
A restful API for adding, showing, updating, deleting and listing members.

## Service Architecture
The API consists of 5 endpoints with base url "/api":
1. create members: POST "/members"
2. list members: GET "/members"
3. get members: GET "/members/:id"
4. update members: PUT "/members/:id"
5. delete members: DELETE "/members/:id"

For creating and updating a member, data is sent in request body.

For getting, updating, and deleting; the "id" of member is received as path parameter.

HTTP Accept and Content-Type headers to be used to support different Media-Types: JSON and XML.


## Implementation Strategy
1. Implement the domain entity "Member".
2. Implement CRUD repository for "Member" entity.
3. Implement service layer as abstraction for repository.
4. Implement REST controller to expose CRUD endpoints.
5. Add XML support to API via Accept and Content-Type headers. 
6. Implement unified exception handling for API errors.

## Testing Strategy
1. Unit test for service layer.
2. Unit test for controller. (not included)
3. Integration test for controller. (not included)