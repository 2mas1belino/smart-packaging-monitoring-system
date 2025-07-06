package pt.ipleiria.estg.dei.ei.dae.daeproject.exceptions.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger logger =
            Logger.getLogger(GenericExceptionMapper.class.getCanonicalName());

    @Override
    public Response toResponse(Exception e) {
        String errorMsg = e.getMessage();
        logger.severe("INTERNAL SERVER ERROR: " + errorMsg);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMsg)
                .build();
    }
}
