package controller;

import model.QueryModel;
import model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;

@WebServlet(name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);
        try{
            QueryModel q = new QueryModel();

            String Num = request.getParameter("num");
            if(Num == null){
                response.setStatus(400);
                return;
            }
            int num = Integer.parseInt(request.getParameter("num"));
            ArrayList<Transaction> transactions = q.getTransactionHistory(num);

            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            if(!transactions.isEmpty()){
                String jsonData = gson.toJson(transactions);
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
