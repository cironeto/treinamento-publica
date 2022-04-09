var indiceMarcaSelecionado

function listarMarcas() {
    escondeContainersCruds()

    resetarCamposMarcas()

    document.getElementById("crudMarcasContainer").style.display = "inline"

    var tabelaMarcas = document.getElementById("tabelaMarcas")

    tabelaMarcas.innerHTML = ""

    for (var i = 0; i < marcas.length; i++) {
        var linha = tabelaMarcas.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaSelecionar = linha.insertCell(2)

        colunaNumero.innerHTML = i + 1
        colunaNome.innerHTML = marcas[i].nome
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionarMarca(${i})">Selecionar</button>`

    }
}

function cadastrarMarca() {
    var alertaCrudMarcas = document.getElementById("alertaCrudMarcas")

    var nomeMarca = document.getElementById("nomeMarca")

    if (nomeMarca.value == "") {
        alertaCrudMarcas.innerText = "favor preencha o nome"
        alertaCrudMarcas.classList.add("alert", "alert-danger")
        nome.focus()
    } else {
        alertaCrudMarcas.innerText = "cadastro realizado"
        alertaCrudMarcas.classList.add("alert", "alert-success")

        marcas.push({
            "nome": nomeMarca.value
        })

        nomeMarca.value = ""

        nomeMarca.focus()

        salvarMarcasLocalStorage()

        listarMarcas()

        ocultarAlertaMarca()
    }
}

function alterarMarca() {
    let existeProdutoCadastrado = false

    for (let i = 0; i < produtos.length; i++) {
        if (marcas[indiceMarcaSelecionado].nome == produtos[i].marca) {
            existeProdutoCadastrado = true
        }
    }

    if (existeProdutoCadastrado) {
        alertaCrudMarcas.innerText = "não pode ser alterada, existe um produto cadastrado com essa marca"
        alertaCrudMarcas.classList.add("alert", "alert-danger")
    } else {
        var nomeMarca = document.getElementById("nomeMarca")

        if (nomeMarca.value == "") {
            alertaCrudMarcas.innerText = "favor preencha o nome"
            alertaCrudMarcas.classList.add("alert", "alert-danger")
            nomeMarca.focus()
        } else {
            alertaCrudMarcas.innerText = "cadastro atualizado"
            alertaCrudMarcas.classList.add("alert", "alert-success")

            marcas[indiceMarcaSelecionado] = {
                "nome": nomeMarca.value
            }

            resetarCamposMarcas()

            nomeMarca.focus()

            salvarMarcasLocalStorage()

            listarMarcas()

            ocultarAlertaMarca()
        }
    }
}

function removerMarca() {
    let existeProdutoCadastrado = false

    for (let i = 0; i < produtos.length; i++) {
        if (marcas[indiceMarcaSelecionado].nome == produtos[i].marca) {
            existeProdutoCadastrado = true
        }
    }

    if (existeProdutoCadastrado) {
        alertaCrudMarcas.innerText = "não pode ser removida, existe um produto cadastrado com essa marca"
        alertaCrudMarcas.classList.add("alert", "alert-danger")
    } else {
        marcas.splice(indiceMarcaSelecionado, 1)

        salvarMarcasLocalStorage()

        listarMarcas()

        resetarCamposMarcas()
    }

}

function selecionarMarca(indice) {
    document.getElementById("nomeMarca").value = marcas[indice].nome

    indiceMarcaSelecionado = indice

    document.getElementById("btnCadastrarMarca").style.display = "none"
    document.getElementById("btnAlterarMarca").style.display = "inline-block"
    document.getElementById("btnRemoverMarca").style.display = "inline-block"
    document.getElementById("btnCancelarMarca").style.display = "inline-block"
}

function resetarCamposMarcas() {
    document.getElementById("nomeMarca").value = ""

    document.getElementById("btnCadastrarMarca").style.display = "inline-block"
    document.getElementById("btnAlterarMarca").style.display = "none"
    document.getElementById("btnRemoverMarca").style.display = "none"
    document.getElementById("btnCancelarMarca").style.display = "none"

    ocultarAlertaMarca()
}

function ocultarAlertaMarca() {
    alertaCrudMarcas.classList.remove("alert", "alert-danger", "alert-success")
    alertaCrudMarcas.innerText = ""
}