window.addEventListener("load", () => {
    const element = document.getElementById("aniversario")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Blythe = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9091/api/Blythe/search/aniversario${Blythe}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);
        let munecas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            munecas += createCard(m)
        }
        let contenedor = document.getElementById("resultado")
        contenedor.innerHTML = munecas
    }
    )
}
)

window.addEventListener("load", () => {
    const element = document.getElementById("rubio")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Blythe = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9091/api/Blythe/search/rubio${Blythe}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);
        let munecas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            munecas += createCard(m)
        }
        let contenedor = document.getElementById("resultado")
        contenedor.innerHTML = munecas
    }
    )
}
)

window.addEventListener("load", () => {
    const element = document.getElementById("anyo")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Blythe = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9091/api/Blythe/search/2023${Blythe}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);
        let munecas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            munecas += createCard(m)
        }
        let contenedor = document.getElementById("resultado")
        contenedor.innerHTML = munecas
    }
    )
}
)

window.addEventListener("load", () => {
    const element = document.getElementById("todas")
    element.addEventListener("click", async (event) => {
        event.preventDefault();
        const input = document.getElementById("buscador");//variable donde vamos a guardar la informacion
        const Blythe = input.value.trim();//eliminamos los espacios blancos
        const apiUrl = `http://localhost:9091/api/Blythe${Blythe}`;//llamamos a la url
        let respuesta = await fetch(apiUrl)
        console.log(respuesta)
        let res = await respuesta.json()
        console.log(res);
        let munecas = "<div class='d-flex flex-wrap'>";
        for (let i = 0; i < res.length; i++) {
            let m = res[i];
            munecas +=createCard(m)
        }
        let contenedor = document.getElementById("resultado")
        contenedor.innerHTML = munecas
    }
    )
}
)

function createCard(m){
    let mj=JSON.stringify(m).replace(/"/g, "&quot;")

    return `<div class="card w-25"> <img src="${m.imagen}" alt="Result 1">
    <h3>${m.nombre}</h3>

    <p>-Fecha de lanzamiento:<p>${m.lanzamiento}</p>
    <p>-Edición:<p>${m.edicion}</p>
    <p>-Tipo de molde:<p>${m.molde}</p>
    <p>-Color del cabello:<p>${m.cabello}</p>
    <p>-Color de piel:<p>${m.piel}</p>
    <p>-Precio en €:<p>${m.precio}</p>
    


    <input type="hidden" id="nombre">
    <a href="#"  onclick="addFavorito(\'${mj}\')"><i class="fa-regular fa-heart"></i>  Añadir a favoritos</a>
</div>
`
}