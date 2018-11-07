<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Le cinema de Tomcat</h2>
<p><a href="liste"> Liste des films triés sur le titre</a> </p>
<p><a href="liste?sort=note"> Liste des films triés sur leur note</a> </p>
<p><a href="liste?sort=notedesc"> Liste des films triés sur leur note décroissante</a> </p>
<form role="search" action="search">
    <div class="search-control">
        <input type="search" id="site-search" name="q"
               placeholder="Search the site..."
               aria-label="Search through site content">
        <button>Search</button>
    </div>
</form>
</body>
</html>
