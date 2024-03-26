
const tbody = document.querySelector('#tbody')
tbody.addEventListener('click',function (ev) {
    if (ev.target.closest('img')){
    const opciones = 'width=600,height=400,toolbar=no,location=no,menubar=no,status=no,resizable=yes,scrollbars=yes';
    const ruta = ev.target.src;
    window.open(ruta,'popuWindows',opciones);
    }
})