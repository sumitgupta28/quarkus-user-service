package com.quakus.demo.exception;


import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class UserServiceExceptionMapper implements ExceptionMapper<UserServiceException> {
    @Override
    public Response toResponse(UserServiceException userServiceException) {
        com.quakus.demo.rs.model.ServiceResponse serviceResponse = new com.quakus.demo.rs.model.ServiceResponse(String.valueOf(userServiceException.getHttpStatusCode()), userServiceException.getErrorMessage());
        return Response.status(userServiceException.getHttpStatusCode()).entity(serviceResponse).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).build();
    }
}
