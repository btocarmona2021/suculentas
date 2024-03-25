const file = document.querySelector('#imageup');
const vistaPrevia = document.querySelector('#vistaprevia');

file.addEventListener('change',function (ev) {
    const imagenup = ev.target.files;
    const imagenes = [...imagenup]
    imagenes.forEach((foto)=>{
        const lectura = new FileReader();
        lectura.onload = function (ev) {
            vistaPrevia.src = ev.target.result;
        }
        lectura.readAsDataURL(foto);
    })
})