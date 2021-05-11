<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
                    <form>
                        <div class="card border-primary rounded-0">
                            <div class="card-header p-0">
                                <div class="bg-info text-white text-center py-2">
                                    <h3> Menu</h3>
                                </div>
                            </div>
                            <div class="card-body p-3">
                                <div class="text-center">
                                    <input type="submit" value="Creer un etudiant" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="creeretudiant.jsp">
                                </div>
                                <div class="text-center">
                                    <input type="submit" value="Gerer les etudiants" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="managestudent" method="GET">
                                </div>
                                <div class="text-center">
                                    <input type="submit" value="Gerer les cours" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="gerercours.jsp">
                                </div>
                                <div class="text-center">
                                    <input type="submit" value="Statistiques" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="statistiques.jsp">
                                </div>
                                <div class="text-center">
                                    <input type="submit" value="Gerer les notes" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="gerernotes.jsp">
                                </div>
                                <div class="text-center">
                                    <input type="submit" value="Liste des etudiants" class="btn btn-outline-info btn-block rounded-0 py-2" formaction="liststudent" method="GET">
                                </div>
                                <BR>
                                <div class="text-center">
                                    <input type="submit" value="Deconnexion" class="btn btn-info btn-block rounded-0 py-2" formaction="index.jsp">
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
	</div>
</div>
</body>
</html>