package controller;

import com.google.gson.Gson;
import model.Account;
import model.QueryModel;
import model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AccountServlet")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);
        int ownerID = 27;
        try{
            QueryModel q = new QueryModel();
            ArrayList<Account> accounts = q.getSessionID(ownerID);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            if(!accounts.isEmpty()){
                String jsonData = gson.toJson(accounts);
                out.print(jsonData);
            }
            response.setStatus(200);
        }
        catch(Exception e){
            response.setStatus(500);
            e.printStackTrace();
        }
    }
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}
