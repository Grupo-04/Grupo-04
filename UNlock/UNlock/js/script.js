var contador = 0;

function aumentarZIndex() {
    if (contador >= 0 && contador < 3) {
        contador++;
    }
    elems = document.getElementsByClassName('cards');
    for (var i = 0; i < elems.length; i++) {
        if (i == contador) {
            elems[i].style.display = 'flex';
        } else {
            elems[i].style.display = 'none';
        }
    }
}

function diminuirZIndex() {
    if (contador > 0 && contador <= 3) {
        contador--;
    }
    elems = document.getElementsByClassName('cards');
    for (var i = 0; i < elems.length; i++) {
        if (i == contador) {
            elems[i].style.display = 'flex';
        } else {
            elems[i].style.display = 'none';
        }
    }
}