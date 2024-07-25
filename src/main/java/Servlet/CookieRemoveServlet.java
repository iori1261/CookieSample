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
 * Servlet implementation class CookieRemoveServlet
 */
@WebServlet("/CookieRemoveServlet")
public class CookieRemoveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 上書き用のクッキー作成
        Cookie cookMemberName = new Cookie("MemberName", "");
        cookMemberName.setMaxAge(0);
        // クッキー情報を上書き
        response.addCookie(cookMemberName);

        Cookie cookMemberDate = new Cookie("MemberDate", "");
        cookMemberDate.setMaxAge(0);
        // クッキー情報を上書き
        response.addCookie(cookMemberDate);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>クッキー情報の見本３</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>３つのクッキーの削除</h2>");
        out.println("クッキーを削除しました。");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<form action=\"CookieGetServlet\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"前のサーブレット「その２」取得を呼び出し\">");
        out.println("</form>");
        out.println("<br>");
        out.println("<form action=\"CookieRemoveServlet\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"もう一度サーブレット「その３」クッキー削除を呼び出し\">");
        out.println("</form>");
        out.println("<br>");
        out.println("<a href=\"startCookieSample.html\">トップへ戻る</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
