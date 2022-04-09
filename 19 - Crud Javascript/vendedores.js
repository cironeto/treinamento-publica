var indiceVendedorSelecionado

function listarVendedores() {
    escondeContainersCruds()

    resetarCamposVendedor()

    document.getElementById("crudVendedoresContainer").style.display = "inline"

    var tabelaVendedores = document.getElementById("tabelaVendedores")

    tabelaVendedores.innerHTML = ""

    for (var i = 0; i < usuarios.length; i++) {
        if (usuarios[i].nivel == "vendedor") {
            var linha = tabelaVendedores.insertRow(-1)
            var colunaNumero = linha.insertCell(0)
            var colunaNome = linha.insertCell(1)
            var colunaSelecionar = linha.insertCell(2)

            colunaNumero.innerHTML = i + 1
            colunaNome.innerHTML = usuarios[i].nome
            colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionarVendedor(${i})">Selecionar</button>`
        }

    }
}

function cadastrarVendedor() {
    var alertaCrudVendedor = document.getElementById("alertaCrudVendedor")

    var nomeVendedor = document.getElementById("nomeVendedor")
    var senhaVendedor = document.getElementById("senhaVendedor")

    if (nomeVendedor.value == "") {
        alertaCrudVendedor.innerText = "favor preencha o nome"
        alertaCrudVendedor.classList.add("alert", "alert-danger")
        nomeVendedor.focus()
    } else if (senhaVendedor.value == "") {
        alertaCrudVendedor.innerText = "favor preencha a senha"
        alertaCrudVendedor.classList.add("alert", "alert-danger")
        senhaVendedor.focus()
    } else {
        alertaCrudVendedor.innerText = "cadastro realizado"
        alertaCrudVendedor.classList.add("alert", "alert-success")

        usuarios.push({
            "nome": nomeVendedor.value,
            "senha": senhaVendedor.value,
            "nivel": "vendedor"
        })

        nomeVendedor.value = ""
        senhaVendedor.value = ""

        nomeVendedor.focus()

        listarVendedores()

        salvarUsuariosLocalStorage()

        ocultarAlertaVendedor()
    }
}

function alterarVendedor() {
    var alertaCrudVendedor = document.getElementById("alertaCrudVendedor")

    var nomeVendedor = document.getElementById("nomeVendedor")
    var senhaVendedor = document.getElementById("senhaVendedor")

    if (nomeVendedor.value == "") {
        alertaCrudVendedor.innerText = "favor preencha o nome"
        alertaCrudVendedor.classList.add("alert", "alert-danger")
        nomeVendedor.focus()
    } else if (senhaVendedor.value == "") {
        alertaCrudVendedor.innerText = "favor preencha a senha"
        alertaCrudVendedor.classList.add("alert", "alert-danger")
        senhaVendedor.focus()
    } else {
        alertaCrudVendedor.innerText = "cadastro realizado"
        alertaCrudVendedor.classList.add("alert", "alert-success")

        usuarios[indiceVendedorSelecionado] = {
            "nome": nomeVendedor.value,
            "senha": senhaVendedor.value,
            "nivel": "vendedor"
        }

        nomeVendedor.value = ""
        senhaVendedor.value = ""

        nomeVendedor.focus()

        listarVendedores()

        salvarUsuariosLocalStorage()

        ocultarAlertaVendedor()
    }
}

function removerVendedor() {
    usuarios.splice(indiceVendedorSelecionado, 1)

    listarVendedores()

    salvarUsuariosLocalStorage()

    resetarCamposVendedor()
}

function selecionarVendedor(indice) {
    document.getElementById("nomeVendedor").value = usuarios[indice].nome
    document.getElementById("senhaVendedor").value = usuarios[indice].senha

    indiceVendedorSelecionado = indice

    document.getElementById("btnCadastrarVendedor").style.display = "none"
    document.getElementById("btnAlterarVendedor").style.display = "inline-block"
    document.getElementById("btnRemoverVendedor").style.display = "inline-block"
    document.getElementById("btnCancelarVendedor").style.display = "inline-block"

}

function ocultarAlertaVendedor() {
    alertaCrudVendedor.classList.remove("alert", "alert-danger", "alert-success")
    alertaCrudVendedor.innerText = ""
}

function resetarCamposVendedor() {
    document.getElementById("nomeVendedor").value = ""
    document.getElementById("senhaVendedor").value = ""

    document.getElementById("btnCadastrarVendedor").style.display = "inline-block"
    document.getElementById("btnAlterarVendedor").style.display = "none"
    document.getElementById("btnRemoverVendedor").style.display = "none"
    document.getElementById("btnCancelarVendedor").style.display = "none"
}