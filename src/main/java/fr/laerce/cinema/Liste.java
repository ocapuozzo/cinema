package fr.laerce.cinema;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by fred on 03/02/2016.
 */
@WebServlet(name = "Affiche")
public class Liste extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        for (Film film : fd.lesFilms) {
          out.println("  <li>");
          out.println(film.titre);
          out.println("  </li>");
        }

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

    }
}
