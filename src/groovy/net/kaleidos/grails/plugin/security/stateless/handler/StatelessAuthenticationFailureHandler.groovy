package net.kaleidos.grails.plugin.security.stateless.handler

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Handles authentication failure when BearerToken authentication is enabled.
 */

class StatelessAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * Sends the proper response code and headers, as defined by RFC6750.
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        String headerValue

        //response code is determined by authentication failure reason
        if( e instanceof AuthenticationCredentialsNotFoundException ) {
            //no credentials were provided.  Add no additional information
            headerValue = 'Bearer'
        } else {
            //The user supplied credentials, but they did not match an account,
            // or there was an underlying authentication issue.
            headerValue = 'Bearer error="invalid_token"'
        }

        log.debug "Sending status code 401 and header WWW-Authenticate: ${headerValue}"
        response.status = 401
        response.addHeader( 'WWW-Authenticate', headerValue )
    }
}
