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
		<div class="col-12 col-md-8 col-lg-6 pb-5">
            <div class="card border-primary rounded-0">
                <div class="card-header p-0">
                    <div class="bg-info text-white text-center py-2">
                        <h3> Gerer un cours</h3>
                    </div>
                </div>
                <div class="card-body p-3">
                    <!-- CREATION COURS -->
                    <% if (request.getAttribute("message") != null) {%>
                        <p> ${message} </p>
                    <%}%>
                    <form action="addcourse" method="POST">
                        <p>Creer un cours</p>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                </div>
                                <input type="text" class="form-control" id="theme" name="theme" placeholder="Thème du cours" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                </div>
                                <input type="text" class="form-control" id="nbheures" name="nbheures" placeholder="Nombre d'heures" required>
                            </div>
                        </div>
                        <div class="text-center">
                            <input type="submit" value="Creer" class="btn btn-info btn-block rounded-0 py-2">
                        </div>
                    </form>
                    <!-- END CREATION COURS -->
                    <BR>
                    <!-- ASSOCIER COURS A ETUDIANT -->
                    <form action="associatecourse" method="POST">
                        <p>Associer un etudiant à un cours</p>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-user text-info"></i></div>
                                </div>
                                <select name="selectstudent" id="selectstudent" class="form-control">
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
                                <select name="selectcourse" id="selectcourse" class="form-control">
                                    <c:forEach items="${course}" var="cours">
                                        <option value='<c:out value="${cours.id}"/>'><c:out value="${cours.courseSubject}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="text-center">
                            <input type="submit" value="Associer" class="btn btn-info btn-block rounded-0 py-2">
                        </div>
                    </form>
                    <!-- ASSOCIER COURS A ETUDIANT -->
                </div>
            </div>
        </div>
	</div>
</div>
</body>
</html>