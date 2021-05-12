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
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body onload="loadstudent()">



<div class="container">
    <h2 class="text-center"><a href="mainmenu.jsp">Gestion Etablissement</a></h2>
	<div class="row justify-content-center">
		<div class="col-12 col-md-8 col-lg-6 pb-5">
                        <div class="card border-primary rounded-0">
                            <div class="card-header p-0">
                                <div class="bg-info text-white text-center py-2">
                                    <h3> Gestion d'un etudiant</h3>
                                </div>
                            </div>
                            <% if (request.getAttribute("message") != null) {%>
                                <p> ${message} </p>
                            <%}%>
                            <form action="updatestudent" method="POST">
                            <div class="card-body p-3">
                                <div class="form-group">
                                    <div class="input-group mb-2">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                        </div>
                                        <select name="select" id="select" class="form-control" onchange="loadstudent()">
                                            <c:forEach items="${person}" var="student">
                                            <option value='<c:out value="${student.id}"/>'><c:out value="${student.lastname}"/> <c:out value="${student.firstname}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value='<c:out value="${nom}"/>' required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom" value='<c:out value="${prenom}"/>' required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-envelope text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control"  placeholder="Adresse e-mail" value='<c:out value="${email}"/>' id="emaildisabled" disabled="disabled">
                                            <input type="hidden" value='<c:out value="${email}"/>' id="email" name="email" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-key text-info"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="mdp" name="mdp" placeholder="Mot de passe" value='<c:out value="${mdp}"/>' required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-map-marker text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" value='<c:out value="${adresse}"/>' required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-phone text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="telephone" name="telephone" placeholder="Telephone" value='<c:out value="${telephone}"/>' required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-birthday-cake text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="datenaissance" name="datenaissance" placeholder="Date de naissance" value='<c:out value="${datenaissance}"/>' required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fa fa-share text-info"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="moyenne" name="moyenne" placeholder="Moyenne" value='<c:out value="${moyenne}"/>' required>
                                        </div>
                                    </div>

                                <div class="text-center">
                                    <input type="hidden" id="idmodifier" name="idmodifier" value=""/>
                                    <input type="submit" value="Modifier" class="btn btn-info btn-block rounded-0 py-2">
                                </div>
                            </form>
                                <BR>
                                <form action="deletestudent" method="POST">
                                    <div class="text-center">
                                        <input type="hidden" id="idsupprimer" name="idsupprimer" value=""/>
                                        <input type="submit" value="Supprimer" class="btn btn-info btn-block rounded-0 py-2">
                                    </div>
                                </form>
                            </div>
                        </div>
                </div>
	</div>
</div>

</body>
</html>