function mostraEstatisticas() {
    // listarVendedoresEmEstatisticas()
    escondeContainersCruds()
    listaCards()
    document.getElementById("secaoEstatistica").style.display = "inline"

}


function calculaTotalVendasPorVendedor(nomeVendedor) {
    var totalVendido = 0
    for (let i = 0; i < vendas.length; i++) {
        if (vendas[i].vendedor == nomeVendedor) {
            totalVendido += vendas[i].total
        }
    }
    return totalVendido
}

function consultarVendas() {
    document.getElementById("cardsVendas").style.display = "inline"

    var vendedorSelecionado = document.getElementById("listaVendedoresEstatisticas").value
    var divCards = document.getElementById("cardsVendas")

    divCards.innerHTML =
        `<div class="card border-secondary" id="divCard" onclick="()">
        <div class="card-header" id="nomeVendedorCard">Vendedor: ${vendedorSelecionado}</div>
        <div class="card-body text-secondary">
            <h5 class="card-title">Total de vendas</h5>
            <h2 id="totalVendasCard">R$ ${calculaTotalVendasPorVendedor(vendedorSelecionado)}</h2>
        </div>
    </div>`

    listarVendasPorVendedor()
}

var cards
function listaCards() {
    cards = document.getElementById("cards")

    cards.innerHTML = ""

    for (var i = 0; i < usuarios.length; i++) {
        cards.innerHTML +=
            `<button class="cardsEstatisticas" value="${i}" onClick="selecionaValueBotao(this.value); listarVendasPorVendedor()">
        <div class="card border-secondary">
            <div class="card-header">${usuarios[i].nome}</div>
            <div class="card-body text-secondary">
                <h5 class="card-title">Total de vendas</h5>
                <h2 id="totalVendasCard">R$ ${calculaTotalVendasPorVendedor(usuarios[i].nome)}</h2>
            </div>
            </div>
         </button>`
    }
}

var cardSelecionado
function selecionaValueBotao(value) {
    cardSelecionado = value
}

function listarVendasPorVendedor() {
    var vendedorSelecionado = usuarios[cardSelecionado].nome

    document.getElementById("tabelaVendaPorVendedor").style.display = "inline-block"

    var tabelaVendasPorVendedor = document.getElementById("tabelaVendasPorVendedor")

    tabelaVendasPorVendedor.innerHTML = ""

    for (var i = 0; i < vendas.length; i++) {
        if (vendas[i].vendedor == vendedorSelecionado) {
            var linha = tabelaVendasPorVendedor.insertRow(-1)
            var colunaNumero = linha.insertCell(0)
            var colunaVendedor = linha.insertCell(1)
            var colunaProduto = linha.insertCell(2)
            var colunaQuantidade = linha.insertCell(3)
            var colunaValor = linha.insertCell(4)
            var colunaTotal = linha.insertCell(5)

            colunaNumero.innerHTML = i + 1
            colunaVendedor.innerHTML = vendas[i].vendedor
            colunaProduto.innerHTML = vendas[i].produto
            colunaQuantidade.innerHTML = vendas[i].quantidade
            colunaValor.innerHTML = vendas[i].valor
            colunaTotal.innerHTML = vendas[i].total
        }

    }
}




