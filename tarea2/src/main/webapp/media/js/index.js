const keywords = ["Tiempo Completo", "Medio Tiempo", "Remoto", "Freelance", "Temporal", "Permanente", "Computación", "Administración", "Logística", "Contabilidad"];
const mainContentData = [
    {
        image: 'https://tinyurl.com/45nsf34m', 
        nombreOferta: 'Desarrollador Frontend', 
        descripcion: ' Unete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.',
        departamento: 'Montevideo', 
        ciudad: 'Montevideo',
        keywords: ["Tiempo Completo", "Medio Tiempo" ,"Remoto", "Freelance", "Temporal", "Permanente"]
    },
    { 
        image: 'https://tinyurl.com/4n2vpurk', 
        nombreOferta: 'Analista de Marketing Digital', 
        descripcion: 'Únete a nuestro equipo de marketing y trabaja en estrategias digitales innovadoras.',
        departamento: 'Flores', 
        ciudad: 'Flores',
        keywords: []
    }
    // ... más datos
];

window.addEventListener('DOMContentLoaded', () => {
    cargarKeywords(keywords);
    cargarContenidoPrincipal();
});


function cargarKeywords(keywords){
    /*const headerDiv = document.createElement("div");
    headerDiv.className = "border border-dark mb-3 bg-dark-subtle text-center";
    headerDiv.innerHTML = '<h4>Keywords</h4>';
    $("#keywordList").append(headerDiv);
    const ulElement = document.createElement("ul");
    ulElement.className = "list-unstyled";

    keywords.forEach(keyword => {
        const liElement = document.createElement("li");
        const aElement = document.createElement("a");
        aElement.innerHTML = keyword;
        aElement.setAttribute("href", "#");
        aElement.style.color = "inherit";
        aElement.style.textDecoration = "none";
        liElement.appendChild(aElement);
        liElement.className = "";
        ulElement.appendChild(liElement);
        $("#keywordList").append(ulElement);
        liElement.classList.add("p-2");
    });*/
}

function cargarContenidoPrincipal() {
mainContentData.forEach(data => {
    const etiquetasHTML = data.keywords.map(item => `#${item.replace(/\s+/g, '')}` )
    const keywords = etiquetasHTML.map(etiqueta => `<b>${etiqueta}</b>`).join('');
    const contentDiv = `
       <div class="d-flex p-2 border border-dark align-items-center mb-2">
                  <div style="width: 25%;">
                    <img class="w-75" src="${data.image}" alt="">
                  </div>
                  <div class="w-75">
                    <div class="d-flex flex-column">
                        <h3> ${data.nombreOferta}</h3>
                        <div>
                            <p>
                               ${data.descripcion}
                            </p>
                        </div>
                        <div class="d-flex flex-column mb-2">
                            <b>Departamento:  ${data.departamento}</b>
                            <b>Ciudad:  ${data.ciudad}</b>
                        </div>
                        <div class="d-flex gap-1 justify-content-start">
                            ${keywords}
                        </div>
                        <div class="d-flex justify-content-end">
                            <a href="/tarea2/consultaOferta" class="text-dark">Ver más</a>
                        </div>
                    </div>
                  </div>
                </div>
    `;
    $('#mainContent').append(contentDiv);
});
}

