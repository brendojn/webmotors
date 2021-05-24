Feature: Compras
  Eu como consumidor da webmotors
  Desejo pesquisar veículos com bom custo benefício
  Para efetivar a aquisição do veículo

  Scenario Template: Conferência de preços entre pesquisa/compra
    Given que acesso o site da webmotors
    And preencho a "<marca>" e "<modelo>" no formulário de pesquisa
    When seleciono um veículo
    Then o valor que consta na página de pesquisa deverá ser igual da página de compra

    Examples:
      | marca     | modelo   |
      | nissan    | frontier |
      | toyota    | hilux    |
      | ford      | ranger   |
      | chevrolet | s10      |
      | fiat      | toro     |

