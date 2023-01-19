package com.company;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.xml.ws.spi.http.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Server {
    public void start(){

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/users", new UsersHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

        privite UserRepository usersRepo;
        public Server(UserRepository ur){
            this.usersRepo = ur;
        }


    }
    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            ArrayList<User> users = userRepo.getAll();

            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
