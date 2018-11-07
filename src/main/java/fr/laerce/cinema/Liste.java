package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

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

    FilmsDonnees fd = new FilmsDonnees();

    // sort ?
    String sort = request.getParameter("sort");
    if (sort == null) {
      Collections.sort(fd.lesFilms, new FilmComparator());
    } else if ("note".equals(sort)) {
      Collections.sort(fd.lesFilms, new Comparator<Film>() {
        @Override
        public int compare(Film o1, Film o2) {
          return Double.compare(o1.note, o2.note);
        }
      });
    } else if ("notedesc".equals(sort)) {
      Collections.sort(fd.lesFilms, (Film o1, Film o2) -> Double.compare(o2.note, o1.note));
    }

    // boucler sur les films

    for (Film film : fd.lesFilms) {
      out.println("  <li style='height:60px;width:200px'>");
      out.println("<a href='detail?id=" + film.id + "'>"
              + film.titre + " (" + film.note +") </a>");
      out.println("  </li>");
    }

    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");

  }
}
