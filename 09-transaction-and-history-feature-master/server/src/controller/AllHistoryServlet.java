package controller;

import com.google.gson.Gson;
import model.Account;
import model.Amount;
import model.QueryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;

@WebServlet(name = "AllHistoryServlet")
public class AllHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);
        try{
            QueryModel q = new QueryModel();
            ArrayList<Double> allmonth = new ArrayList<Double>();

            String accid = request.getParameter("accid");
            if(accid ==null){
                response.setStatus(400);
                return;
            }

            Double getAmountDepositJan = q.getAmountDepositJan(accid);
            Double getAmountDepositFeb = q.getAmountDepositFeb(accid);
            Double getAmountDepositApril = q.getAmountDepositApril(accid);
            Double getAmountDepositAugust = q.getAmountDepositAugust(accid);
            Double getAmountDepositJune = q.getAmountDepositJune(accid);
            Double getAmountDepositJuly = q.getAmountDepositJuly(accid);
            Double getAmountDepositMarch = q.getAmountDepositMarch(accid);
            Double getAmountDepositMay = q.getAmountDepositMay(accid);
            Double getAmountDepositOctober = q.getAmountDepositOctober(accid);
            Double getAmountDepositDecember = q.getAmountDepositDecember(accid);
            Double getAmountDepositSeptember = q.getAmountDepositSeptember(accid);
            Double getAmountDepositNovember = q.getAmountDepositNovember(accid);

            allmonth.add(getAmountDepositJan);
            allmonth.add(getAmountDepositFeb);
            allmonth.add(getAmountDepositMarch);
            allmonth.add(getAmountDepositApril);
            allmonth.add(getAmountDepositMay);
            allmonth.add(getAmountDepositJune);
            allmonth.add(getAmountDepositJuly);
            allmonth.add(getAmountDepositAugust);
            allmonth.add(getAmountDepositSeptember);
            allmonth.add(getAmountDepositOctober);
            allmonth.add(getAmountDepositNovember);
            allmonth.add(getAmountDepositDecember);
            Money money = new Money(allmonth);

            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            String jsonData = gson.toJson(money);
            out.print(jsonData);
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
class Money{
        ArrayList<Double> Money = new ArrayList<>();
        Money(ArrayList<Double> allmonth){
            Money = allmonth;
        }
    }