#language:pt

Funcionalidade: Compras
  Eu como consumidor da webmotors
  Desejo pesquisar veículos com bom custo benefício
  Para efetivar a aquisição do veículo

  Cenario de Fundo:
    Dado que acesso o site da webmotors

  Esquema do Cenario: Conferência de preços entre pesquisa/compra
    E preencho a "<marca>" e "<modelo>" no formulário de pesquisa
    Quando seleciono um veículo
    Entao o valor que consta na página de pesquisa deverá ser igual da página de compra

    Exemplos:
      | marca     | modelo   |
      | nissan    | frontier |
      | toyota    | hilux    |
      | ford      | ranger   |
      | chevrolet | s10      |
      | fiat      | toro     |

