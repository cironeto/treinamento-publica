var dados = []

var indiceClienteSelecionado

window.onload = function(){
    if(localStorage.getItem("vetor") != null){
        dados = JSON.parse(localStorage.getItem("vetor"))

        listar()
    }
}

function salvarLocalStorage(){
    localStorage.setItem("vetor", JSON.stringify(dados))
}

function cadastrar(){
    var nome = document.getElementById("nome")
    var cidade = document.getElementById("cidade")
    
    ocultarAlerta()

    if(nome.value == ""){
        alerta.innerText = "favor preencha o Nome"
        alerta.classList.add("alert", "alert-danger")
        nome.focus()
    }else if(cidade.value == ""){
        alerta.innerText ="favor preencha a Cidade"
        alerta.classList.add("alert", "alert-danger")
        cidade.focus()
    }else{
        alerta.innerText = "cadastro realizado"
        alerta.classList.add("alert", "alert-success")

        dados.push({
            "nome": nome.value,
            "cidade": cidade.value
        })

        nome.value = ""
        cidade.value = ""

        nome.focus()

        salvarLocalStorage()

        listar()
    }
}

function alterar(){
    var nome = document.getElementById("nome")
    var cidade = document.getElementById("cidade")
    
    ocultarAlerta()

    if(nome.value == ""){
        alerta.innerText = "favor preencha o Nome"
        alerta.classList.add("alert", "alert-danger")
        nome.focus()
    }else if(cidade.value == ""){
        alerta.innerText ="favor preencha a Cidade"
        alerta.classList.add("alert", "alert-danger")
        cidade.focus()
    }else{
        alerta.innerText = "cadastro atualizado"
        alerta.classList.add("alert", "alert-success")

        dados[indiceClienteSelecionado] = {
            "nome": nome.value,
            "cidade": cidade.value
        }

        resetarDados()

        nome.focus()

        salvarLocalStorage()

        listar()
    }
}

function listar(){
    var tabela = document.getElementById("tabela")

    tabela.innerHTML = ""

    for(var i = 0; i < dados.length; i++){
        var linha = tabela.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaCidade = linha.insertCell(2)
        var colunaSelecionar = linha.insertCell(3)

        colunaNumero.innerHTML = i + 1
        colunaNome.innerHTML = dados[i].nome
        colunaCidade.innerHTML = dados[i].cidade
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionar(${i})">Selecionar</button>`


    }
}

function selecionar(indice){
    document.getElementById("nome").value = dados[indice].nome
    document.getElementById("cidade").value = dados[indice].cidade

    indiceClienteSelecionado = indice

    document.getElementById("btnCadastrar").style.display = "none"
    document.getElementById("btnAlterar").style.display = "inline-block"
    document.getElementById("btnRemover").style.display = "inline-block"
    document.getElementById("btnCancelar").style.display = "inline-block"
    
}

function remover(){
    dados.splice(indiceClienteSelecionado, 1)
    salvarLocalStorage()

    listar()

    resetarDados()
}

function ocultarAlerta(){
    var alerta = document.getElementById("alerta")

    alerta.classList.remove("alert", "alert-danger", "alert-success")

    alerta.innerText = ""
}

function resetarDados(){
    document.getElementById("nome").value = ""
    document.getElementById("cidade").value = ""
    var alerta = document.getElementById("alerta");

    document.getElementById("btnCadastrar").style.display = "inline-block"
    document.getElementById("btnAlterar").style.display = "none"
    document.getElementById("btnRemover").style.display = "none"
    document.getElementById("btnCancelar").style.display = "none"

    ocultarAlerta()
}

