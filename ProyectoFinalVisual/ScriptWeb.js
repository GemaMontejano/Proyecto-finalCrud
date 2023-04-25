window.addEventListener("load", () => {
    const element = document.getElementById("boton")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Blythe = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9091/api/Blythe/search/${Blythe}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);
        let munecas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            let mj=JSON.stringify(m).replace(/"/g, "&quot;")
            munecas += `<div class="card w-25"> <img src="${m.imagen}" alt="Result 1">
        <h3>${m.nombre}</h3>

        <p>-Fecha de lanzamiento:<h4>${m.lanzamiento}</h4>
        <p>-Edición:<h4>${m.edicion}</h4>
        <p>-Tipo de molde:<h4>${m.molde}</h4>
        <p>-Color del cabello:<h4>${m.cabello}</h4>
        <p>-Color de piel:<h4>${m.piel}</h4>
        <p>-Precio en €:<h4>${m.precio}</h4>
        


        <input type="hidden" id="nombre">
        <a href="#" onclick="addFavorito(\'${mj}\')"><i class="fa-regular fa-heart"></i>Añadir a favoritos</a>
    </div>
`
        }
        let contenedor = document.getElementById("resultado")
        contenedor.innerHTML = munecas
    }
    )
}
)







