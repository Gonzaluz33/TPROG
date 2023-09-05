const keywords = ["Tiempo Completo", "Medio Tiempo", "Remoto", "Freelance", "Temporal", "Permanente", "Computación", "Administración", "Logística", "Contabilidad"];
const mainContentData = [
    { image: 'src/img/example_1.png', text: 'Tu primer contenido aquí.' },
    { image: 'src/img/example_2.png', text: 'Tu segundo contenido aquí.' },
    // ... más datos
];

window.addEventListener('DOMContentLoaded', () => {
    cargarKeywords(keywords);
    cargarContenidoPrincipal();
});

function cargarKeywords(keywords){
    const headerDiv = document.createElement("div");
    headerDiv.className = "border border-dark mb-3 bg-dark-subtle";
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
    });

}
function cargarContenidoPrincipal() {
mainContentData.forEach(data => {
    const contentDiv = `
        <div class="d-flex p-3 border border-dark align-items-center mb-2">
            <div style="width: 33%;">
                <img class="w-75" src="${data.image}" alt="">
            </div>
            <div class="w-75">
                <p>${data.text}</p>
            </div>
        </div>
    `;

    $('#mainContent').append(contentDiv);
});
}

