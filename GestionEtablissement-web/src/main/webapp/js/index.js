var pathsite = document.location.origin; // Recuperation du début de l'URL*

function test() {

  alert(pathsite);
}

function loadstudent() {
    url = pathsite +'/GestionEtablissement-web/studentapi?id=' + $( "#select" ).val();;
    fetch(url)
        .then(function (response) {
            $("#nom").val('');
            $("#prenom").val('');
            $("#email").val('');
            $("#mdp").val('');
            $("#adresse").val('');
            $("#telephone").val('');
            $("#datenaissance").val('');
            $("#moyenne").val('');
            return response.json();
        })
        .then(function (data) {
            $("#nom").val(data.firstname);
            $("#prenom").val(data.lastname);
            $("#email").val(data.mailAddress);
            $("#emaildisabled").val(data.mailAddress);
            $("#mdp").val(data.password);
            $("#adresse").val(data.address);
            $("#telephone").val(data.phoneNumber);
            $("#datenaissance").val(data.dateOfBirth);
            $("#moyenne").val(data.average);
            $("#idmodifier").val(data.id);
            $("#idsupprimer").val(data.id);
        });
}

