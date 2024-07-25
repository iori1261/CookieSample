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
 * Servlet implementation class CookieCreateServlet
 */
@WebServlet("/CookieCreateServlet")
public class CookieCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 会員名(membername)を取得
        String memberName = request.getParameter("membername");
        // 会員入会日(memberdate)を取得
        String memberDate = request.getParameter("memberdate");

        // クッキーの作成
        // 会員名のクッキー（名前、値）
        Cookie cookMemberName = new Cookie("MemberName", memberName);
        // 有効期限として30秒を設定
        cookMemberName.setMaxAge(30);
        // クッキーを追加
        response.addCookie(cookMemberName);

        // 会員入会日のクッキー
        Cookie cookMemberDate = new Cookie("MemberDate", memberDate);
        // 有効期限として30秒を設定
        cookMemberDate.setMaxAge(30);
        // クッキーを追加
        response.addCookie(cookMemberDate);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>クッキー情報の見本1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>その2：クッキーの生成</h2>");
        out.println("ようこそ、" + memberName);
        out.println("<p>入力した内容</p>");
        out.println("会員名: " + memberName);
        out.println("会員入会日: " + memberDate);
        out.println("<br><br>");

        out.println("<form action=\"CookieGetServlet\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"呼び出し\">");
        out.println("</form>");
        out.println("<br>");
        out.println("<a href=\"startCookieSample.html\">会員入会日</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
