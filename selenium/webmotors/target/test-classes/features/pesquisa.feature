Feature: Pesquisa de carros
  Eu como consumidor da webmotors
  Desejo pesquisar veículos com bom custo benefício
  Para possivelmente realizar a aquisição

  Scenario Template: Realizar aplicação de filtros pr ano
    Given que acesso o site da webmotors
    And preencho a "<marca>" e "<modelo>" no formulário de pesquisa
    When preencho o "ano" com o "<valor>"
    Then deverá aparecer na descrição dos itens o "<valor>"

    Examples:
      | marca     | modelo | valor          |
      | honda     | city   | DE 2016 A 2017 |
      | chevrolet | prisma | DE 2009 A 2021 |
      | fiat      | uno    | DE 2017 A 2020 |
      | hyundai   | tucson | DE 2020 A 2020 |
      | honda     | civic  | DE 2021 A 2021 |

