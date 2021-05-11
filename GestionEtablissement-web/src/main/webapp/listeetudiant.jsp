<%@ page pageEncoding="UTF-8" %>
<% if (session.getAttribute("email") == null) {
    response.sendRedirect(request.getContextPath() + "/index.jsp");
}%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Creation d'un etudiant</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <h2 class="text-center"><a href="mainmenu.jsp">Gestion Etablissement</a></h2>
	<div class="row justify-content-center">
		<div class="col-12 col-md-8 col-lg-12 pb-5">
                    <form>
                        <div class="card border-primary rounded-0">
                            <div class="card-header p-0">
                                <div class="bg-info text-white text-center py-2">
                                    <h3> Liste des etudiants</h3>
                                </div>
                            </div>
                            <div class="card-body p-3">

                                <table class="table">
                                    <thead>
                                      <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Prenom</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Adresse</th>
                                        <th scope="col">Téléphone</th>
                                        <th scope="col">Modifier</th>
                                        <th scope="col">Supprimer</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                      <c:forEach items="${person}" var="student">
                                      <tr>
                                        <th scope="row"></th>
                                        <td><c:out value="${student.lastname}"/></td>
                                        <td><c:out value="${student.firstname}"/></td>
                                        <td><c:out value="${student.mailAddress}"/></td>
                                        <td><c:out value="${student.address}"/></td>
                                        <td><c:out value="${student.phoneNumber}"/></td>
                                        <td>
                                            <form action="updatestudentpage" method="POST">
                                                <input type="submit" value="Modifier" class="btn btn-primary">
                                                <input type="hidden" id="identifiant" name="identifiant" value='<c:out value="${student.id}"/>' />
                                            </form>
                                        </td>
                                        <td>
                                            <form action="deletestudent" method="POST">
                                                <input type="submit" value="Supprimer" class="btn btn-danger">
                                                <input type="hidden" id="idsupprimer" name="idsupprimer" value='<c:out value="${student.id}"/>' />
                                            </form>
                                        </td>
                                      </tr>
                                      </c:forEach>
                                    </tbody>
                                  </table>
                                <div class="text-center">
                                    <input type="submit" value="Retour" class="btn btn-info btn-block rounded-0 py-2" formaction="mainmenu.jsp">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
	</div>
</div>
</body>
</html>