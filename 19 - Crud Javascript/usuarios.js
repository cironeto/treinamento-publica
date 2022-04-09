var indiceUsuarioSelecionado

function listarUsuarios() {
    escondeContainersCruds()

    resetarCamposUsuarios()

    document.getElementById("crudUsuariosContainer").style.display = "inline"

    var tabelaUsuarios = document.getElementById("tabelaUsuarios")

    tabelaUsuarios.innerHTML = ""

    for (var i = 0; i < usuarios.length; i++) {
        var linha = tabelaUsuarios.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaNivel = linha.insertCell(2)
        var colunaSelecionar = linha.insertCell(3)

        colunaNumero.innerHTML = i + 1
        colunaNome.innerHTML = usuarios[i].nome
        colunaNivel.innerHTML = usuarios[i].nivel
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionarUsuario(${i})">Selecionar</button>`

    }
}

function cadastrarUsuario() {
    var alertaCrudUsuario = document.getElementById("alertaCrudUsuario")

    var nome = document.getElementById("nomeUsuario")
    var senha = document.getElementById("senhaUsuario")
    var nivel = document.getElementById("nivelUsuario")

    if (nome.value == "") {
        alertaCrudUsuario.innerText = "favor preencha o nome"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nome.focus()
    } else if (senha.value == "") {
        alertaCrudUsuario.innerText = "favor preencha a senha"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        senha.focus()
    } else if (nivel.value == "") {
        alertaCrudUsuario.innerText = "favor preencha o nível"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nivel.focus()
    } else if (nivel.value == "admin") {
        alertaCrudUsuario.innerText = "Impossível cadastrar mais admin"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nivel.focus()
    } else {
        alertaCrudUsuario.innerText = "cadastro realizado"
        alertaCrudUsuario.classList.add("alert", "alert-success")

        usuarios.push({
            "nome": nome.value,
            "senha": senha.value,
            "nivel": nivel.value
        })

        nome.value = ""
        senha.value = ""
        nivel.value = ""

        nome.focus()

        salvarUsuariosLocalStorage()

        listarUsuarios()

        ocultarAlertaUsuario()
    }
}

function alterarUsuario() {
    var nome = document.getElementById("nomeUsuario")
    var senha = document.getElementById("senhaUsuario")
    var nivel = document.getElementById("nivelUsuario")

    if (nome.value == "") {
        alertaCrudUsuario.innerText = "favor preencha o nome"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nome.focus()
    } else if (senha.value == "") {
        alertaCrudUsuario.innerText = "favor preencha a senha"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        senha.focus()
    } else if (nivel.value == "") {
        alertaCrudUsuario.innerText = "favor preencha o nível"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nivel.focus()
    } else if (nivel.value == "admin") {
        alertaCrudUsuario.innerText = "Impossível cadastrar mais admin"
        alertaCrudUsuario.classList.add("alert", "alert-danger")
        nivel.focus()
    } else {
        alertaCrudUsuario.innerText = "cadastro atualizado"
        alertaCrudUsuario.classList.add("alert", "alert-success")

        usuarios[indiceUsuarioSelecionado] = {
            "nome": nome.value,
            "senha": senha.value,
            "nivel": nivel.value
        }

        resetarCamposUsuarios()

        nome.focus()

        salvarUsuariosLocalStorage()

        listarUsuarios()

        ocultarAlertaUsuario()
    }
}

function removerUsuario() {
    usuarios.splice(indiceUsuarioSelecionado, 1)

    salvarUsuariosLocalStorage()

    listarUsuarios()

    ocultarAlertaUsuario()

    resetarCamposUsuarios()
}

function selecionarUsuario(indice) {
    document.getElementById("nomeUsuario").value = usuarios[indice].nome
    document.getElementById("senhaUsuario").value = usuarios[indice].senha
    document.getElementById("nivelUsuario").value = usuarios[indice].nivel

    indiceUsuarioSelecionado = indice

    document.getElementById("btnCadastrarUsuario").style.display = "none"
    document.getElementById("btnAlterarUsuario").style.display = "inline-block"
    document.getElementById("btnRemoverUsuario").style.display = "inline-block"
    document.getElementById("btnCancelarUsuario").style.display = "inline-block"

}

function ocultarAlertaUsuario() {
    alertaCrudUsuario.classList.remove("alert", "alert-danger", "alert-success")
    alertaCrudUsuario.innerText = ""
}

function resetarCamposUsuarios() {
    document.getElementById("nomeUsuario").value = ""
    document.getElementById("senhaUsuario").value = ""
    document.getElementById("nivelUsuario").value = ""

    document.getElementById("btnCadastrarUsuario").style.display = "inline-block"
    document.getElementById("btnAlterarUsuario").style.display = "none"
    document.getElementById("btnRemoverUsuario").style.display = "none"
    document.getElementById("btnCancelarUsuario").style.display = "none"
}