alert("Usuário admin: ciro / senha: 123 \nUsuário gerente: amanda / senha: 123 \nUsuário vendedor: neto / senha: 123")


window.onload = function () {
    if (localStorage.getItem("usuarios") != null) {
        usuarios = JSON.parse(localStorage.getItem("usuarios"))
    }
    if (localStorage.getItem("marcas") != null) {
        marcas = JSON.parse(localStorage.getItem("marcas"))
    }
    if (localStorage.getItem("produtos") != null) {
        produtos = JSON.parse(localStorage.getItem("produtos"))
    }
    if (localStorage.getItem("vendas") != null) {
        vendas = JSON.parse(localStorage.getItem("vendas"))
    }
}

function salvarUsuariosLocalStorage() {
    localStorage.setItem("usuarios", JSON.stringify(usuarios))
}

function salvarMarcasLocalStorage() {
    localStorage.setItem("marcas", JSON.stringify(marcas))
}

function salvarProdutosLocalStorage() {
    localStorage.setItem("produtos", JSON.stringify(produtos))
}

function salvarVendasLocalStorage() {
    localStorage.setItem("vendas", JSON.stringify(vendas))
}

var usuarios = [
    {
        "nome": "ciro",
        "senha": "123",
        "nivel": "admin"
    },
    {
        "nome": "amanda",
        "senha": "123",
        "nivel": "gerente"
    },
    {
        "nome": "neto",
        "senha": "123",
        "nivel": "vendedor"
    },
    {
        "nome": "luiz",
        "senha": "123",
        "nivel": "vendedor"
    }
]

var marcas = [
    {
        "nome": "Acer"
    },
    {
        "nome": "Samsung"
    },
    {
        "nome": "Apple"
    }
]

var produtos = [
    {
        "nome": "Notebook",
        "preço": 3000,
        "marca": "Acer"
    },
    {
        "nome": "Smartphone",
        "preço": 2000,
        "marca": "Samsung"
    },
    {
        "nome": "Smartwatch",
        "preço": 1000,
        "marca": "Apple"
    }
]

var vendas = []


// ------------- UTIL -------------
function escondeContainersCruds() {
    document.getElementById("crudUsuariosContainer").style.display = "none"
    document.getElementById("crudMarcasContainer").style.display = "none"
    document.getElementById("crudProdutosContainer").style.display = "none"
    document.getElementById("crudVendedoresContainer").style.display = "none"
    document.getElementById("crudVendasContainer").style.display = "none"
    document.getElementById("secaoEstatistica").style.display = "none"
}

function listarMarcasEmProdutos() {
    let lista = document.getElementById("marcaProduto")
    lista.innerHTML += `<option value="" disabled selected hidden>marca</option>`
    for (let i = 0; i < marcas.length; i++) {
        lista.innerHTML += `<option>${marcas[i].nome}</option>`
    }
}

function limpaMarcasEmProdutos() {
    let lista = document.getElementById("marcaProduto")
    lista.innerHTML = ""
}

var vendedores = []
function listarVendedoresEmVendas() {
    let lista = document.getElementById("listaVendedores")
    lista.innerHTML += `<option value="" disabled selected hidden>vendedor</option>`
    for (let i = 0; i < usuarios.length; i++) {        
        lista.innerHTML += `<option>${usuarios[i].nome}</option>`
    }
}

function limparVendedoresEmVendas() {
    vendedores = []
    let lista = document.getElementById("listaVendedores")
    lista.innerHTML = ""
}

function listarProdutosEmVendas() {
    let lista = document.getElementById("listaProdutos")
    for (let i = 0; i < produtos.length; i++) {
        lista.innerHTML += `<option value="" disabled selected hidden>produtos</option>`
        lista.innerHTML += `<option>${produtos[i].nome}</option>`
    }
}

function limparProdutosEmVendas() {
    let lista = document.getElementById("listaProdutos")
    lista.innerHTML = ""
}

function listarVendedoresEmEstatisticas() {
    let lista = document.getElementById("listaVendedoresEstatisticas")
    lista.innerHTML += `<option value="" disabled selected hidden>selecione um vendedor</option>`
    for (let i = 0; i < usuarios.length; i++) {
        lista.innerHTML += `<option>${usuarios[i].nome}</option>`
    }
}