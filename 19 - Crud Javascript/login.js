var indiceUsuario = -1

function login() {
    var usernameDigitado = document.getElementById("usernameDigitado")
    var senhaDigitada = document.getElementById("senhaDigitada")

    var alerta = document.getElementById("alertaLogin")

    if (usernameDigitado.value == "") {
        alerta.innerText = "favor preencha o usuername"
        alerta.classList.add("alert", "alert-danger")
        usernameDigitado.focus()
    } else if (senhaDigitada.value == "") {
        alerta.innerText = "favor preencha a senha"
        alerta.classList.add("alert", "alert-danger")
        senhaDigitada.focus()
    } else {

        for (var i = 0; i < usuarios.length; i++) {
            if (usernameDigitado.value == usuarios[i].nome) {
                indiceUsuario = i
            }
        }

        if (indiceUsuario == -1) {
            alerta.innerText = "usuario não encontrado"
            alerta.classList.add("alert", "alert-danger")
        }

        if (senhaDigitada.value == usuarios[indiceUsuario].senha) {
            document.getElementById("loginContainer").style.display = "none"

            switch (usuarios[indiceUsuario].nivel) {
                case "admin":
                    document.getElementById("secaoAdmin").style.display = "inline"
                    break
                case "gerente":
                    document.getElementById("secaoGerente").style.display = "inline"
                    break
                case "vendedor":
                    document.getElementById("secaoVendedor").style.display = "inline"
                    break
            }


        } else {
            alerta.innerText = "senha incorreta"
            alerta.classList.add("alert", "alert-danger")
        }
    }
}

function logout() {
    document.getElementById("loginContainer").style.display = "inline"
    document.getElementById("secaoAdmin").style.display = "none"
    document.getElementById("secaoGerente").style.display = "none"
    document.getElementById("secaoVendedor").style.display = "none"
    document.getElementById("crudUsuariosContainer").style.display = "none"
    document.getElementById("crudMarcasContainer").style.display = "none"
    document.getElementById("crudProdutosContainer").style.display = "none"
    document.getElementById("crudVendedoresContainer").style.display = "none"
    document.getElementById("crudVendasContainer").style.display = "none"
    document.getElementById("secaoEstatistica").style.display = "none"

    document.getElementById("usernameDigitado").value = ""
    document.getElementById("senhaDigitada").value = ""

    document.getElementById("alertaLogin").classList.remove("alert", "alert-danger", "alert-success")
    document.getElementById("alertaLogin").innerText = ""
}