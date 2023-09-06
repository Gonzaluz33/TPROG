 // Cambiar el formulario de registro según el tipo de usuario (Postulante o Empresa)
 document.getElementById('registerAs').addEventListener('change', function() {
    const value = this.value;
    if (value === 'postulante') {
        $("#imageRegister").attr("src", "src/img/register_postulante.webp");
        document.getElementById('postulanteForm').style.display = 'block';
        document.getElementById('empresaForm').style.display = 'none';
    } else {
        
        $("#imageRegister").attr("src", "src/img/register_empresa.jpg");
        document.getElementById('postulanteForm').style.display = 'none';
        document.getElementById('empresaForm').style.display = 'block';
    }
});



// Validación de formulario de registro testeo

const submitButtonPostulante = document.getElementById("submitButtonPostulante");
submitButtonPostulante.addEventListener("click", function(event) {
    handleSubmit(event, 'postulante');
});
const submitButtonEmpresa = document.getElementById("submitButtonEmpresa");
submitButtonEmpresa.addEventListener("click", function(event) {
    handleSubmit(event, 'empresa');
});
function handleSubmit(event, formType) {
    event.preventDefault();

    let userData = {};

    if (formType === 'postulante') {
        // Captura los datos del formulario de postulantes
        userData.nombre = document.getElementById("nombre").value;
        userData.apellido = document.getElementById("apellido").value;
        userData.fechaNacimiento = document.getElementById("fechaNacimiento").value;
        userData.nacionalidad = document.getElementById("nacionalidad").value;
        userData.email = document.getElementById("email").value;
    } else if (formType === 'empresa') {
        // Captura los datos del formulario de empresas
        userData.nombre = document.getElementById("nombre").value;
        userData.apellido = document.getElementById("apellido").value;
        userData.email = document.getElementById("email").value;
        userData.nomEmpresa = document.getElementById("nomEmpresa").value;
        userData.descripcion = document.getElementById("desc").value;
        userData.linkWeb = document.getElementById("linkWeb").value;
    }

    fetch("https://jsonplaceholder.typicode.com/users", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        console.log("Success:", data);
        alert("Datos enviados correctamente: " + JSON.stringify(data));
    })
    .catch((error) => {
        console.error("Error:", error);
        alert("Ocurrió un error al enviar los datos.");
    });
}