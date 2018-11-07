package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;

/**
 * Created by fred on 03/02/2016.
 */
public class Liste extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

  }

  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Liste des films</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Les films</h1>");
    out.println("<ul>");

    // boucler sur les films
    FilmsDonnees fd = new FilmsDonnees();
    Collections.sort(fd.lesFilms, new FilmComparator());
    for (Film film : fd.lesFilms) {
      out.println("  <li style='height:60px;width:200px'>");
      out.println("<a href='detail?id="+film.id+"'>" + film.titre + "</a>");
     // +  "<img style='margin-left:20px;height:40px;width:40px' src='affiche?id="+film.id+"'/>");
      out.println("  </li>");
    }

    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");

  }
}
