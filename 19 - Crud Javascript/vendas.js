var indiceVendaSelecionado


function listarVendas() {
    let lista = document.getElementById("listaVendedores")
    if (usuarios[indiceUsuario].nivel == "vendedor") {
        limparVendedoresEmVendas()
        lista.innerHTML += `<option value="" disabled selected hidden>vendedor</option>`
        lista.innerHTML += `<option>${usuarios[indiceUsuario].nome}</option>`
    } else {
        limparVendedoresEmVendas()
        listarVendedoresEmVendas()
    }

    limparProdutosEmVendas()
    listarProdutosEmVendas()

    escondeContainersCruds()

    resetarCamposVenda()

    document.getElementById("crudVendasContainer").style.display = "inline"

    var tabelaVendas = document.getElementById("tabelaVendas")

    tabelaVendas.innerHTML = ""

    for (var i = 0; i < vendas.length; i++) {
        var linha = tabelaVendas.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaVendedor = linha.insertCell(1)
        var colunaProduto = linha.insertCell(2)
        var colunaQuantidade = linha.insertCell(3)
        var colunaValor = linha.insertCell(4)
        var colunaTotal = linha.insertCell(5)
        var colunaSelecionar = linha.insertCell(6)

        colunaNumero.innerHTML = i + 1
        colunaVendedor.innerHTML = vendas[i].vendedor
        colunaProduto.innerHTML = vendas[i].produto
        colunaQuantidade.innerHTML = vendas[i].quantidade
        colunaValor.innerHTML = vendas[i].valor
        colunaTotal.innerHTML = vendas[i].total
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionarVenda(${i})">Selecionar</button>`
    }
}

function cadastrarVenda() {
    var alertaVendas = document.getElementById("alertaVendas")

    var vendedor = document.getElementById("listaVendedores")
    var produto = document.getElementById("listaProdutos")
    var valor = document.getElementById("valorProdutoVenda")
    var quantidade = document.getElementById("quantidadeVenda")

    if (vendedor.value == "") {
        alertaVendas.innerText = "favor preencha o vendedor"
        alertaVendas.classList.add("alert", "alert-danger")
        nomeVendedor.focus()
    } else if (produto.value == "") {
        alertaVendas.innerText = "favor preencha o produto"
        alertaVendas.classList.add("alert", "alert-danger")
        produto.focus()
    } else if (quantidade.value == "") {
        alertaVendas.innerText = "favor preencha a quantidade"
        alertaVendas.classList.add("alert", "alert-danger")
        quantidade.focus()
    } else if (valor.value == "") {
        alertaVendas.innerText = "favor preencha o valor"
        alertaVendas.classList.add("alert", "alert-danger")
        valor.focus()
    } else {
        alertaVendas.innerText = "venda realizada"
        alertaVendas.classList.add("alert", "alert-success")

        vendas.push({
            "vendedor": vendedor.value,
            "produto": produto.value,
            "quantidade": quantidade.value,
            "valor": valor.value,
            "total": valor.value * quantidade.value
        })

        resetarCamposVenda()

        vendedor.focus()

        listarVendas()

        salvarVendasLocalStorage()



        ocultarAlertaVenda()

    }
}

function alterarVenda() {
    var alertaVendas = document.getElementById("alertaVendas")

    if (usuarios[indiceUsuario].nivel == "vendedor") {
        alertaVendas.innerText = "Ação não autorizada para nivel: vendedor"
        alertaVendas.classList.add("alert", "alert-danger")
    } else {
        alertaVendas = document.getElementById("alertaVendas")

        var vendedor = document.getElementById("listaVendedores")
        var produto = document.getElementById("listaProdutos")
        var valor = document.getElementById("valorProdutoVenda")
        var quantidade = document.getElementById("quantidadeVenda")

        if (vendedor.value == "") {
            alertaVendas.innerText = "favor preencha o vendedor"
            alertaVendas.classList.add("alert", "alert-danger")
            nomeVendedor.focus()
        } else if (produto.value == "") {
            alertaVendas.innerText = "favor preencha o produto"
            alertaVendas.classList.add("alert", "alert-danger")
            produto.focus()
        } else if (quantidade.value == "") {
            alertaVendas.innerText = "favor preencha a quantidade"
            alertaVendas.classList.add("alert", "alert-danger")
            quantidade.focus()
        } else if (valor.value == "") {
            alertaVendas.innerText = "favor preencha o valor"
            alertaVendas.classList.add("alert", "alert-danger")
            valor.focus()
        } else {
            alertaVendas.innerText = "venda realizada"
            alertaVendas.classList.add("alert", "alert-success")

            vendas[indiceVendaSelecionado] = {
                "vendedor": vendedor.value,
                "produto": produto.value,
                "quantidade": quantidade.value,
                "valor": valor.value,
                "total": valor.value * quantidade.value
            }

            vendedor.focus()

            salvarVendasLocalStorage()

            listarVendas()

            resetarCamposVenda()

            ocultarAlertaVenda()
        }
    }

}

function removerVenda() {
    var alertaVendas = document.getElementById("alertaVendas")

    if (usuarios[indiceUsuario].nivel == "vendedor") {
        alertaVendas.innerText = "Ação não autorizada para nivel: vendedor"
        alertaVendas.classList.add("alert", "alert-danger")
    } else {
        vendas.splice(indiceVendaSelecionado, 1)

        salvarVendasLocalStorage()

        listarVendas()

        resetarCamposVenda()
    }
}

function ocultarAlertaVenda() {
    alertaVendas.classList.remove("alert", "alert-danger", "alert-success")
    alertaVendas.innerText = ""
}

function resetarCamposVenda() {
    document.getElementById("listaVendedores").value = ""
    document.getElementById("listaProdutos").value = ""
    document.getElementById("valorProdutoVenda").value = ""
    document.getElementById("quantidadeVenda").value = ""

    document.getElementById("btnCadastrarVenda").style.display = "inline-block"
    document.getElementById("btnAlterarVenda").style.display = "none"
    document.getElementById("btnRemoverVenda").style.display = "none"
    document.getElementById("btnCancelarVenda").style.display = "none"
}

function selecionarVenda(indice) {
    document.getElementById("listaVendedores").value = vendas[indice].vendedor
    document.getElementById("listaProdutos").value = vendas[indice].produto
    document.getElementById("valorProdutoVenda").value = vendas[indice].valor
    document.getElementById("quantidadeVenda").value = vendas[indice].quantidade

    indiceVendaSelecionado = indice

    document.getElementById("btnCadastrarVenda").style.display = "none"
    document.getElementById("btnAlterarVenda").style.display = "inline-block"
    document.getElementById("btnRemoverVenda").style.display = "inline-block"
    document.getElementById("btnCancelarVenda").style.display = "inline-block"

}