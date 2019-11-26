# Teste desenvolvedor Java

## tarefa
 - Fazer fork do projeto e implementar a classe br.com.solutiontrue.DefinidorDeVencedor
 - Depois de implementar colocar o link do fork no formulário de respostas

## explicação
O nosso portal de fornecedores precisa decidir quem são os melhores colocados após coletar os precos dos itens das cotações
- Cada cotação pode ter diversos itens diferentes
- Cada item da cotação define o código da cotação, código do item e a quantidade desejada a ser comprada
- Cada atualização corresponde a um item de uma cotação onde o preço de venda foi definido por um fornecedor
- Caso um fornecedor não responder todos os itens de uma cotação, ele estará desqualificado para aquela cotação e não deverá ser apresentado no resultado final
- Os parâmetros não possuem uma ordem específica

**Parâmetros:**
 - cotacoes: Lista de Item da cotação (formato: CODIGO_COTACAO,CODIGO_ITEM,QUANTIDADE)
 - atualizacoes: lista de atualizações (formato: CODIGO_COTACAO,CODIGO_FORNECEDOR,CODIGO_ITEM,PRECO)

**Resultado:**
 - retornar uma lista de resultados (formato: CODIGO_COTACAO:FORNECEDOR_VENCEDOR=VALOR_TOTAL,FORNECEDOR_SEGUNDO=VALOR_TOTAL, FORNECEDOR_TERCEIRO=VALOR_TOTAL, etc...)
 - onde cada resultado contenha uma lista de fornecedores melhores qualificados, ordenados pelo total que seria pago se a compra for feita somente com este fornecedor
 - o total que seria pago deve ser arredondado em duas casas, item por item, antes de ser somado no total do fornecedor (arredondamento HALF_UP)
 - caso o fornecedor empate em valor, a ordem será feita pelo código do fornecedor

**Exemplo:**

 se o input de itens de cotação for:
 
     COTA,ITE1,50
     COTA,ITE2,10
     COTB,ITE3,500
 e o input de atualizacoes for:
 
     COTA,FORN1,ITE1,5
     COTA,FORN1,ITE2,40
     COTB,FORN1,ITE3,0.4
     COTA,FORN2,ITE1,4
     COTA,FORN2,ITE2,39
     COTB,FORN2,ITE3,0.5
     COTA,FORN3,ITE1,6
     COTA,FORN3,ITE2,41

 o resultado apresentado deve ser
 
     COTA:FORN2=590,FORN1=650,FORN3=710
     COTB:FORN1=200,FORN2=250