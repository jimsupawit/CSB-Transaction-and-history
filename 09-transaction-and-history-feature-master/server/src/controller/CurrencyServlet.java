package controller;

import com.google.gson.Gson;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CurrencyServlet")
public class CurrencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);
        try{
            QueryModel q = new QueryModel();
            String account_id = request.getParameter("account_id");
            if(account_id==null){
                response.setStatus(400);
                return;
            }
            String getCurrency = q.getCurrency(account_id);
            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            if(!getCurrency.isEmpty()){
                NameCurrency currency = new NameCurrency(getCurrency);
                String jsonData = gson.toJson(currency);
                out.print(jsonData);
            }
            response.setStatus(200);

        }catch (Exception e){
            response.setStatus(500);
            e.printStackTrace();
        }
    }
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}
class NameCurrency{
    String currency;
    NameCurrency(String getCurrency){
        currency = getCurrency;
    }
}
