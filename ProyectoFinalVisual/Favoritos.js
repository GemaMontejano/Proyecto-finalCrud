function addFavorito(muneca){
  muneca=JSON.parse(muneca)
  console.log(muneca)
  let favoritas=localStorage.getItem("favoritas")
  console.log(favoritas)
  if(favoritas===null){
    favoritas=[]
  }else{
    favoritas=JSON.parse(favoritas)
  }
  favoritas.push(muneca)
  localStorage.setItem("favoritas",JSON.stringify(favoritas))
}


/*Funcion Cargar y Mostrar datos*/
document.getElementById("boton-cargar").addEventListener("click", function(e) {
        /*Obtener datos almacenados*/
        var favoritas = localStorage.getItem("favoritas");
        if (favoritas!=null){
          favoritas=JSON.parse(favoritas)
          let munecas = "<div class='d-flex flex-wrap'>";

          for (let m of favoritas){
            munecas += `<div class="card w-25"> <img src="${m.imagen}" alt="Result 1">
            <h3>${m.nombre}</h3>
    
            <p>-Fecha de lanzamiento:<h4>${m.lanzamiento}</h4>
            <p>-Edición:<h4>${m.edicion}</h4>
            <p>-Tipo de molde:<h4>${m.molde}</h4>
            <p>-Color del cabello:<h4>${m.cabello}</h4>
            <p>-Color de piel:<h4>${m.piel}</h4>
            <p>-Precio en €:<h4>${m.precio}</h4>
            
            <input type="hidden" id="nombre">
        </div>
    `
          }
        munecas+="</div>"
        /*Mostrar datos almacenados*/      
        document.getElementById("favoritas").innerHTML = munecas;
        }
    });   
    
    



