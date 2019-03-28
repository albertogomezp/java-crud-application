function callJqueryAjax(action){
  //var action = $('#name').val();
  $.ajax(
    {
      url     : '/Competidor_(1)/adminCompetidor',
      method     : 'POST',
      data     : {action: action},
      success    : function(resultText){ $('#wrapper').html(resultText); },
      error : function(jqXHR, exception){
        console.log('Error occured!!');
      }
    }
    );
  };
  function quitarCompetidor(param){
    var id = param;
    var action ="eliminar";
    $.ajax({
      url     : '/Competidor_(1)/adminCompetidor',
      method     : 'POST',
      data: {"action": action, "id": id},
      success    : function(resultText){  $('#wrapper').html(resultText);   },
      error : function(jqXHR, exception){
        console.log('Error occured!!');
      }
    });
    action ="mostrar";
    callJqueryAjax(action);
  };
  $("#form1").submit(function(e) {
    var txt;
    var r = confirm("Press a button!");
    if (r == true) {
      txt = "You pressed OK!";
    } else {
      txt = "You pressed Cancel!";
    }
    e.preventDefault(); // avoid to execute the actual submit of the form.
    
    var form = $(this);
    var url = form.attr('adminCompetidor?action=editar');
    
    $.ajax(
      {
        type: "POST",
        url: url,
        data: form.serialize(), // serializes the form's elements.
        success: function(data)
        {
          alert(data); // show response from the php script.
        }
      }
      );    
    });
//	 var idb;
//	 function getidb(){
//	 idb = document.getElementById('buscarid').value;
//	 console.log(idb);
//	 return idb;
//	 };
//    function AbrirModalbusqueda() {
//      idb = getidb();
//      var element = document.getElementById("tr"+idb);
//      element.classList.add("bg-dark");
//      element.classList.add("text-light");
//    };
    function AbrirModal(x) {
      console.log(x);
	  var modal1 = document.getElementById("exampleModal");
      var element = document.getElementById("tr"+x);
	  modal1.classList.add("show");
      element.classList.add("bg-dark");
      element.classList.add("text-light");
      console.log(modal1);
      document.getElementById("idr").value = document.getElementById("id"+x).innerHTML;
      document.getElementById("nombrer").value = document.getElementById("nombre"+x).innerHTML;
      document.getElementById("apellidosr").value = document.getElementById("apellidos"+x).innerHTML;
      document.getElementById("paisr").value = document.getElementById("pais"+x).innerHTML;
      document.getElementById("categoriar").value = document.getElementById("categoria"+x).innerHTML;
      document.getElementById("rankingr").value = document.getElementById("ranking"+x).innerHTML;
     //idb =  getidb();
      element.classList.remove("bg-dark");
      element.classList.remove("text-light");
    };
    