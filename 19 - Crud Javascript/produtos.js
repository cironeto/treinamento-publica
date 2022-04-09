var indiceProdutoSelecionado

function listarProdutos() {
    escondeContainersCruds()

    resetarCamposProduto()

    limpaMarcasEmProdutos()

    listarMarcasEmProdutos()

    document.getElementById("crudProdutosContainer").style.display = "inline"

    var tabelaProdutos = document.getElementById("tabelaProdutos")

    tabelaProdutos.innerHTML = ""

    for (var i = 0; i < produtos.length; i++) {
        var linha = tabelaProdutos.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaPreco = linha.insertCell(2)
        var colunaMarca = linha.insertCell(3)
        var colunaSelecionar = linha.insertCell(4)

        colunaNumero.innerHTML = i + 1
        colunaNome.innerHTML = produtos[i].nome
        colunaPreco.innerHTML = produtos[i].preço
        colunaMarca.innerHTML = produtos[i].marca
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionarProduto(${i})">Selecionar</button>`

    }
}

function cadastrarProduto() {
    var alertaCrudProdutos = document.getElementById("alertaCrudProdutos")

    var nomeProduto = document.getElementById("nomeProduto")
    var valorProduto = document.getElementById("valorProduto")
    var marcaProduto = document.getElementById("marcaProduto")

    if (nomeProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha o nome"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        nomeProduto.focus()
    } else if (valorProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha o valor"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        valorProduto.focus()
    } else if (marcaProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha a marca"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        marcaProduto.focus()
    } else {
        alertaCrudProdutos.innerText = "cadastro realizado"
        alertaCrudProdutos.classList.add("alert", "alert-success")

        produtos.push({
            "nome": nomeProduto.value,
            "preço": valorProduto.value,
            "marca": marcaProduto.value
        })

        nomeProduto.value = ""
        valorProduto.value = ""
        marcaProduto.value = ""

        nomeProduto.focus()

        salvarProdutosLocalStorage()

        listarProdutos()

        ocultarAlertaProduto()
    }
}

function alterarProduto() {
    var nomeProduto = document.getElementById("nomeProduto")
    var valorProduto = document.getElementById("valorProduto")
    var marcaProduto = document.getElementById("marcaProduto")

    if (nomeProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha o nome"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        nomeProduto.focus()
    } else if (valorProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha o valor"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        valorProduto.focus()
    } else if (marcaProduto.value == "") {
        alertaCrudProdutos.innerText = "favor preencha o valor"
        alertaCrudProdutos.classList.add("alert", "alert-danger")
        marcaProduto.focus()
    } else {
        alertaCrudProdutos.innerText = "cadastro realizado"
        alertaCrudProdutos.classList.add("alert", "alert-success")

        produtos[indiceProdutoSelecionado] = {
            "nome": nomeProduto.value,
            "preço": valorProduto.value,
            "marca": marcaProduto.value
        }

        resetarCamposProduto()

        nomeProduto.focus()

        salvarProdutosLocalStorage()

        listarProdutos()

        ocultarAlertaProduto()
    }
}

function removerProduto() {
    produtos.splice(indiceProdutoSelecionado, 1)

    salvarProdutosLocalStorage()

    listarProdutos()

    resetarCamposProduto()
}

function selecionarProduto(indice) {
    document.getElementById("nomeProduto").value = produtos[indice].nome
    document.getElementById("valorProduto").value = produtos[indice].preço
    document.getElementById("marcaProduto").value = produtos[indice].marca

    indiceProdutoSelecionado = indice

    document.getElementById("btnCadastrarProduto").style.display = "none"
    document.getElementById("btnAlterarProduto").style.display = "inline-block"
    document.getElementById("btnRemoverProduto").style.display = "inline-block"
    document.getElementById("btnCancelarProduto").style.display = "inline-block"

}

function resetarCamposProduto() {
    document.getElementById("nomeProduto").value = ""
    document.getElementById("valorProduto").value = ""
    document.getElementById("marcaProduto").value = ""

    document.getElementById("btnCadastrarProduto").style.display = "inline-block"
    document.getElementById("btnAlterarProduto").style.display = "none"
    document.getElementById("btnRemoverProduto").style.display = "none"
    document.getElementById("btnCancelarProduto").style.display = "none"
}

function ocultarAlertaProduto() {
    alertaCrudProdutos.classList.remove("alert", "alert-danger", "alert-success")
    alertaCrudProdutos.innerText = ""
}