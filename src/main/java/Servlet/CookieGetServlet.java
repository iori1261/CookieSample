package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieGetServlet
 */
@WebServlet("/CookieGetServlet")
public class CookieGetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberName = "";
        String memberDate = "";

        Cookie[] cookies = request.getCookies();
        // cookies が null の場合があるのでチェック
        if (cookies != null) {
            for (Cookie cook : cookies) {
                if (cook.getName().equals("MemberName")) {
                    // クッキーの名前が MemberName であれば値を取得
                    memberName = cook.getValue();
                }
                if (cook.getName().equals("MemberDate")) {
                    // クッキーの名前が MemberDate であれば値を取得
                    memberDate = cook.getValue();
                }
            }
        }
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>クッキー情報の見本</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>その 2 クッキーの取得</h2>");
        out.println("<hr>");
        out.println("ようこそ、" + memberName + "さん");
        out.println("<br>");
        out.println("その 1 から取得した内容:");
        out.println("<br>");
        out.println("会員名: " + memberName);
        out.println("<br>");
        out.println("会員入会日: " + memberDate);
        out.println("<br><br>");
        out.println("<form action=\"CookieGetServlet\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"もう一度サーブレット『その 2』取得を呼び出します\">");
        out.println("</form>");
        out.println("<br>");
        out.println("<form action=\"CookieRemoveServlet\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"サーブレット『その 3』クッキー削除を呼び出します\">");
        out.println("</form>");
        out.println("<br>");
        out.println("<a href=\"startCookieSample.html\">入力へ戻す</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
