package fr.laerce.cinema;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fred on 03/02/2016.
 */
public class Detail extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

  }

  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
    Integer id = Integer.parseInt( request.getParameter("id"));
    FilmsDonnees fd = new FilmsDonnees();
    Film film = fd.getById(id);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Detail du film</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Film : "+film.titre+"</h1>");
    out.println("<ul>");

    out.println("  <li>");
    out.println(film.id);
    out.println("  </li>");
    out.println("  <li>");
    out.println(film.titre);
    out.println("  </li>");
    out.println("  <li>");
    out.println(film.afficheNom);
    out.println("  </li>");
    out.println("</ul>");
    out.println("<img style='margin-left:20px;height:300px;width:300px' src='affiche?id="+film.id+"'/>");
    out.println("</body>");
    out.println("</html>");
  }
}
