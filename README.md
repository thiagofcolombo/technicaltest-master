# Teste desenvolvedor Java

O nosso portal de fornecedores precisa decidir quem são os melhores colocados após coletar os precos dos itens das cotações
- Cada cotação pode ter diversos itens diferentes
- Cada item da cotação define o código da cotação, código do item e a quantidade desejada a ser comprada
- Cada atualização corresponde a um item de uma cotação onde o preço de venda foi definido por um fornecedor
- Caso um fornecedor não responder todos os itens de uma cotação, ele estará desqualificado para aquela cotação e não deverá ser apresentado no resultado final
- Os parâmetros não possuem uma ordem específica

**Parâmetros:**
 - cotacoes: Lista de Item da cotação
 - atualizacoes: lista de atualizações

**Resultado:**
 - retornar uma lista de ResultadoCotacao
 - onde cada resultado contenha uma lista de fornecedores melhores qualificados, ordenados pelo total que seria pago se a compra for feita somente com este fornecedor
 - caso o fornecedor empate em valor, a ordem será feita pelo código do fornecedor

**Exemplo:**

 se o input de itens de cotação for:
 
     ItemCotacao(COTA,ITE1,50)
     ItemCotacao(COTA,ITE2,10)
     ItemCotacao(COTB,ITE3,500)
 e o input de atualizacoes for:
 
     Atualizacao(COTA,FORN1,ITE1,5)
     Atualizacao(COTA,FORN1,ITE2,40)
     Atualizacao(COTB,FORN1,ITE3,0.4)
     Atualizacao(COTA,FORN2,ITE1,4)
     Atualizacao(COTA,FORN2,ITE2,39)
     Atualizacao(COTB,FORN2,ITE3,0.5)
     Atualizacao(COTA,FORN3,ITE1,6)
     Atualizacao(COTA,FORN3,ITE2,41)

 o resultado apresentado deve ser
 
     ResultadoCotacao(COTA,
         Fornecedor(FORN2,590)
         Fornecedor(FORN1,650)
         Fornecedor(FORN3,710))
     ResultadoCotacao(COTB,
         Fornecedor(FORN1,200)
         Fornecedor(FORN2,250))