const botaoAbrir = document.querySelector("#abrir-modal");
const botaoFechar = document.querySelector("#fechar-modal");
const modal = document.querySelector("#modal-ticket");

botaoAbrir.addEventListener("click", () => {modal.classList.add("aberto")});
botaoFechar.addEventListener("click", () => {modal.classList.remove("aberto")});
modal.addEventListener("click", (evento) => {
    if(evento.target === modal){
        modal.classList.remove("aberto");
    }
})