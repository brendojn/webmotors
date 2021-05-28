#language:pt

Funcionalidade: Pesquisa de carros
  Eu como consumidor da webmotors
  Desejo pesquisar veículos com bom custo benefício
  Para possivelmente realizar a aquisição

  Esquema do Cenario: Realizar aplicação de filtros por ano
    Dado que acesso o site da webmotors
    E preencho a "<marca>" e "<modelo>" no formulário de pesquisa
    Quando preencho o "ano" com o "<valor>"
    Entao deverá aparecer na descrição dos itens o "<valor>"

    Exemplos:
      | marca     | modelo | valor          |
      | honda     | city   | DE 2016 A 2017 |
      | chevrolet | prisma | DE 2009 A 2021 |
      | fiat      | uno    | DE 2017 A 2020 |
      | hyundai   | tucson | DE 2020 A 2020 |
      | honda     | civic  | DE 2021 A 2021 |

