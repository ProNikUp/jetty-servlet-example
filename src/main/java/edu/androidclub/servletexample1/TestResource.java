package edu.androidclub.servletexample1;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestResource {

    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TokenResponse auth(UserCredentials creds) {
        TokenResponse response = new TokenResponse();
        response.setToken(creds.getLogin() + creds.getPassword());

        return response;
    }

    public static class TokenResponse {
        private String token;

        public TokenResponse() {
        }

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "TokenResponse{" +
                    "token='" + token + '\'' +
                    '}';
        }
    }

    public static class UserCredentials {

        private String login;

        private String password;

        public UserCredentials() {
        }

        public UserCredentials(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserCredentials{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

}
