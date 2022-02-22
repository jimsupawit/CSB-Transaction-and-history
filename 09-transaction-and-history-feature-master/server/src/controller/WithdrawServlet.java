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
import java.util.ArrayList;

@WebServlet(name = "WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        setAccessControlHeaders(response);
        try{
            QueryModel q = new QueryModel();
            ArrayList<Double> allWithdraw = new ArrayList<Double>();
            String accid = request.getParameter("accid");
            if(accid==null){
                response.setStatus(400);
                return;
            }
            Double getAmountWithdrawJan = q.getAmountWithdrawJan(accid);
            Double getAmountWithdrawFeb = q.getAmountWithdrawFeb(accid);
            Double getAmountWithdrawMarch = q.getAmountWithdrawMarch(accid);
            Double getAmountWithdrawApril = q.getAmountWithdrawApril(accid);
            Double getAmountWithdrawMay = q.getAmountWithdrawMay(accid);
            Double getAmountWithdrawJune = q.getAmountWithdrawJune(accid);
            Double getAmountWithdrawJuly = q.getAmountWithdrawJuly(accid);
            Double getAmountWithdrawAugust = q.getAmountWithdrawAugust(accid);
            Double getAmountWithdrawSeptember = q.getAmountWithdrawSeptember(accid);
            Double getAmountWithdrawOctober = q.getAmountWithdrawOctober(accid);
            Double getAmountWithdrawNovember = q.getAmountWithdrawNovember(accid);
            Double getAmountWithdrawDecember = q.getAmountWithdrawDecember(accid);


            allWithdraw.add(getAmountWithdrawJan);
            allWithdraw.add(getAmountWithdrawFeb);
            allWithdraw.add(getAmountWithdrawMarch);
            allWithdraw.add(getAmountWithdrawApril);
            allWithdraw.add(getAmountWithdrawMay);
            allWithdraw.add(getAmountWithdrawJune);
            allWithdraw.add(getAmountWithdrawJuly);
            allWithdraw.add(getAmountWithdrawAugust);
            allWithdraw.add(getAmountWithdrawSeptember);
            allWithdraw.add(getAmountWithdrawOctober);
            allWithdraw.add(getAmountWithdrawNovember);
            allWithdraw.add(getAmountWithdrawDecember);
            MoneyWithdraw moneyWithdraw = new MoneyWithdraw(allWithdraw);

            Gson gson = new Gson();
            PrintWriter out = response.getWriter();
            String jsonData = gson.toJson(moneyWithdraw);
            out.print(jsonData);
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
class MoneyWithdraw{
    ArrayList<Double> MoneyWithdraw = new ArrayList<>();
    MoneyWithdraw(ArrayList<Double> allwithdraw){
        MoneyWithdraw = allwithdraw;
    }
}

