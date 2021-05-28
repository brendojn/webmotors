#language:pt
Funcionalidade: Cadastro
  Eu como consumidor da webmotors
  Desejo realizar o cadastro
  Para gerenciar de forma mais clara os meus interesses em revender ou comprar automóveis

  Cenario de Fundo:
    Dado que acesso a página de login

  Esquema do Cenario: Tentativa de realizar cadastro
    Quando realizo o cadastro com "<nome>", "<email>" e "<senha>"
    Entao devo obter a mensagem "<mensagem>"

    Exemplos:
      | nome            | email            | senha  | mensagem                                |
      | f f             | brendo@gmail.com | 123456 | Ops! Precisamos do seu nome completo    |
      | Brendo Oliveira | brendoxulambs    | 123456 | E-mail inválido                         |
      | Brendo Oliveira | brendo@gmail.com | xpto   | Senha deve conter ao menos 5 caracteres |
      | d dddd          | brendo@gmail.com | 123456 | Ops! Precisamos do seu nome completo    |
